package com.mopub.common;

import com.mopub.common.DiskLruCache$Editor;
import com.mopub.common.DiskLruCache$Entry;
import com.mopub.common.DiskLruCache$Snapshot;
import com.mopub.common.DiskLruCacheUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable {
   static final long ANY_SEQUENCE_NUMBER = -1L;
   private static final String CLEAN = "CLEAN";
   private static final String DIRTY = "DIRTY";
   static final String JOURNAL_FILE = "journal";
   static final String JOURNAL_FILE_BACKUP = "journal.bkp";
   static final String JOURNAL_FILE_TEMP = "journal.tmp";
   static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
   static final String MAGIC = "libcore.io.DiskLruCache";
   private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
      public void write(int var1) {
      }
   };
   private static final String READ = "READ";
   private static final String REMOVE = "REMOVE";
   static final String VERSION_1 = "1";
   private final int appVersion;
   private final Callable cleanupCallable;
   private final File directory;
   final ThreadPoolExecutor executorService;
   private final File journalFile;
   private final File journalFileBackup;
   private final File journalFileTmp;
   private Writer journalWriter;
   private final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75F, true);
   private long maxSize;
   private long nextSequenceNumber = 0L;
   private int redundantOpCount;
   private long size = 0L;
   private final int valueCount;

   private DiskLruCache(File var1, int var2, int var3, long var4) {
      this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
      this.cleanupCallable = new Callable() {
         public Void call() {
            DiskLruCache var1 = DiskLruCache.this;
            synchronized(var1) {
               if(DiskLruCache.this.journalWriter == null) {
                  return null;
               } else {
                  DiskLruCache.this.trimToSize();
                  if(DiskLruCache.this.journalRebuildRequired()) {
                     DiskLruCache.this.rebuildJournal();
                     DiskLruCache.this.redundantOpCount = 0;
                  }

                  return null;
               }
            }
         }
      };
      this.directory = var1;
      this.appVersion = var2;
      this.journalFile = new File(var1, "journal");
      this.journalFileTmp = new File(var1, "journal.tmp");
      this.journalFileBackup = new File(var1, "journal.bkp");
      this.valueCount = var3;
      this.maxSize = var4;
   }

   // $FF: synthetic method
   static void access$10(DiskLruCache var0, DiskLruCache$Editor var1, boolean var2) {
      var0.completeEdit(var1, var2);
   }

   // $FF: synthetic method
   static DiskLruCache$Editor access$5(DiskLruCache var0, String var1, long var2) {
      return var0.edit(var1, var2);
   }

   // $FF: synthetic method
   static String access$6(InputStream var0) {
      return inputStreamToString(var0);
   }

   // $FF: synthetic method
   static int access$7(DiskLruCache var0) {
      return var0.valueCount;
   }

   // $FF: synthetic method
   static File access$8(DiskLruCache var0) {
      return var0.directory;
   }

   // $FF: synthetic method
   static OutputStream access$9() {
      return NULL_OUTPUT_STREAM;
   }

   private void checkNotClosed() {
      if(this.journalWriter == null) {
         throw new IllegalStateException("cache is closed");
      }
   }

   private void completeEdit(DiskLruCache$Editor param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   private static void deleteIfExists(File var0) {
      if(var0.exists() && !var0.delete()) {
         throw new IOException();
      }
   }

   private DiskLruCache$Editor edit(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   private static String inputStreamToString(InputStream var0) {
      return DiskLruCacheUtil.readFully(new InputStreamReader(var0, DiskLruCacheUtil.UTF_8));
   }

   private boolean journalRebuildRequired() {
      return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
   }

   public static DiskLruCache open(File var0, int var1, int var2, long var3) {
      if(var3 <= 0L) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else if(var2 <= 0) {
         throw new IllegalArgumentException("valueCount <= 0");
      } else {
         File var5 = new File(var0, "journal.bkp");
         if(var5.exists()) {
            File var6 = new File(var0, "journal");
            if(var6.exists()) {
               var5.delete();
            } else {
               renameTo(var5, var6, false);
            }
         }

         DiskLruCache var9 = new DiskLruCache(var0, var1, var2, var3);
         if(var9.journalFile.exists()) {
            try {
               var9.readJournal();
               var9.processJournal();
               var9.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(var9.journalFile, true), DiskLruCacheUtil.US_ASCII));
               return var9;
            } catch (IOException var7) {
               System.out.println("DiskLruCache " + var0 + " is corrupt: " + var7.getMessage() + ", removing");
               var9.delete();
            }
         }

         var0.mkdirs();
         DiskLruCache var8 = new DiskLruCache(var0, var1, var2, var3);
         var8.rebuildJournal();
         return var8;
      }
   }

   private void processJournal() {
      deleteIfExists(this.journalFileTmp);
      Iterator var2 = this.lruEntries.values().iterator();

      while(true) {
         while(var2.hasNext()) {
            DiskLruCache$Entry var3 = (DiskLruCache$Entry)var2.next();
            int var1;
            if(DiskLruCache$Entry.access$1(var3) == null) {
               for(var1 = 0; var1 < this.valueCount; ++var1) {
                  this.size += DiskLruCache$Entry.access$7(var3)[var1];
               }
            } else {
               DiskLruCache$Entry.access$5(var3, (DiskLruCache$Editor)null);

               for(var1 = 0; var1 < this.valueCount; ++var1) {
                  deleteIfExists(var3.getCleanFile(var1));
                  deleteIfExists(var3.getDirtyFile(var1));
               }

               var2.remove();
            }
         }

         return;
      }
   }

   private void readJournal() {
      // $FF: Couldn't be decompiled
   }

   private void readJournalLine(String var1) {
      int var2 = var1.indexOf(32);
      if(var2 == -1) {
         throw new IOException("unexpected journal line: " + var1);
      } else {
         int var3 = var2 + 1;
         int var4 = var1.indexOf(32, var3);
         String var5;
         if(var4 == -1) {
            var5 = var1.substring(var3);
            if(var2 == 6 && var1.startsWith("REMOVE")) {
               this.lruEntries.remove(var5);
               return;
            }
         } else {
            var5 = var1.substring(var3, var4);
         }

         DiskLruCache$Entry var7 = (DiskLruCache$Entry)this.lruEntries.get(var5);
         DiskLruCache$Entry var6 = var7;
         if(var7 == null) {
            var6 = new DiskLruCache$Entry(this, var5, (DiskLruCache$Entry)null);
            this.lruEntries.put(var5, var6);
         }

         if(var4 != -1 && var2 == 5 && var1.startsWith("CLEAN")) {
            String[] var8 = var1.substring(var4 + 1).split(" ");
            DiskLruCache$Entry.access$4(var6, true);
            DiskLruCache$Entry.access$5(var6, (DiskLruCache$Editor)null);
            DiskLruCache$Entry.access$6(var6, var8);
         } else if(var4 == -1 && var2 == 5 && var1.startsWith("DIRTY")) {
            DiskLruCache$Entry.access$5(var6, new DiskLruCache$Editor(this, var6, (DiskLruCache$Editor)null));
         } else if(var4 != -1 || var2 != 4 || !var1.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + var1);
         }
      }
   }

   private void rebuildJournal() {
      // $FF: Couldn't be decompiled
   }

   private static void renameTo(File var0, File var1, boolean var2) {
      if(var2) {
         deleteIfExists(var1);
      }

      if(!var0.renameTo(var1)) {
         throw new IOException();
      }
   }

   private void trimToSize() {
      while(this.size > this.maxSize) {
         this.remove((String)((Entry)this.lruEntries.entrySet().iterator().next()).getKey());
      }

   }

   private void validateKey(String var1) {
      if(!LEGAL_KEY_PATTERN.matcher(var1).matches()) {
         throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + var1 + "\"");
      }
   }

   public final void close() {
      // $FF: Couldn't be decompiled
   }

   public final void delete() {
      this.close();
      DiskLruCacheUtil.deleteContents(this.directory);
   }

   public final DiskLruCache$Editor edit(String var1) {
      return this.edit(var1, -1L);
   }

   public final void flush() {
      synchronized(this){}

      try {
         this.checkNotClosed();
         this.trimToSize();
         this.journalWriter.flush();
      } finally {
         ;
      }

   }

   public final DiskLruCache$Snapshot get(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final File getDirectory() {
      return this.directory;
   }

   public final long getMaxSize() {
      synchronized(this){}

      long var1;
      try {
         var1 = this.maxSize;
      } finally {
         ;
      }

      return var1;
   }

   public final boolean isClosed() {
      synchronized(this){}
      boolean var4 = false;

      Writer var2;
      try {
         var4 = true;
         var2 = this.journalWriter;
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      boolean var1;
      if(var2 == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean remove(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final void setMaxSize(long var1) {
      synchronized(this){}

      try {
         this.maxSize = var1;
         this.executorService.submit(this.cleanupCallable);
      } finally {
         ;
      }

   }

   public final long size() {
      synchronized(this){}

      long var1;
      try {
         var1 = this.size;
      } finally {
         ;
      }

      return var1;
   }
}
