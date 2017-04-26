package com.mopub.common;

import com.mopub.common.DiskLruCache;
import com.mopub.common.DiskLruCache$Entry;
import com.mopub.common.DiskLruCacheUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public final class DiskLruCache$Editor {
   private boolean committed;
   private final DiskLruCache$Entry entry;
   private boolean hasErrors;
   // $FF: synthetic field
   final DiskLruCache this$0;
   private final boolean[] written;

   private DiskLruCache$Editor(DiskLruCache var1, DiskLruCache$Entry var2) {
      this.this$0 = var1;
      this.entry = var2;
      boolean[] var3;
      if(DiskLruCache$Entry.access$0(var2)) {
         var3 = null;
      } else {
         var3 = new boolean[DiskLruCache.access$7(var1)];
      }

      this.written = var3;
   }

   // $FF: synthetic method
   DiskLruCache$Editor(DiskLruCache var1, DiskLruCache$Entry var2, DiskLruCache$Editor var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static void access$0(DiskLruCache$Editor var0, boolean var1) {
      var0.hasErrors = var1;
   }

   // $FF: synthetic method
   static DiskLruCache$Entry access$2(DiskLruCache$Editor var0) {
      return var0.entry;
   }

   // $FF: synthetic method
   static boolean[] access$3(DiskLruCache$Editor var0) {
      return var0.written;
   }

   public final void abort() {
      DiskLruCache.access$10(this.this$0, this, false);
   }

   public final void abortUnlessCommitted() {
      if(!this.committed) {
         try {
            this.abort();
         } catch (IOException var2) {
            return;
         }
      }

   }

   public final void commit() {
      if(this.hasErrors) {
         DiskLruCache.access$10(this.this$0, this, false);
         this.this$0.remove(DiskLruCache$Entry.access$2(this.entry));
      } else {
         DiskLruCache.access$10(this.this$0, this, true);
      }

      this.committed = true;
   }

   public final String getString(int var1) {
      InputStream var2 = this.newInputStream(var1);
      return var2 != null?DiskLruCache.access$6(var2):null;
   }

   public final InputStream newInputStream(int var1) {
      DiskLruCache var2 = this.this$0;
      synchronized(var2) {
         if(DiskLruCache$Entry.access$1(this.entry) != this) {
            throw new IllegalStateException();
         } else if(!DiskLruCache$Entry.access$0(this.entry)) {
            return null;
         } else {
            FileInputStream var3;
            try {
               var3 = new FileInputStream(this.entry.getCleanFile(var1));
            } catch (FileNotFoundException var4) {
               return null;
            }

            return var3;
         }
      }
   }

   public final OutputStream newOutputStream(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final void set(int var1, String var2) {
      OutputStreamWriter var3;
      try {
         var3 = new OutputStreamWriter(this.newOutputStream(var1), DiskLruCacheUtil.UTF_8);
      } finally {
         ;
      }

      try {
         var3.write(var2);
      } finally {
         DiskLruCacheUtil.closeQuietly(var3);
         throw var2;
      }

   }
}
