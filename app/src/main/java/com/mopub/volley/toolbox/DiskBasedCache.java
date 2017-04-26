package com.mopub.volley.toolbox;

import android.os.SystemClock;
import com.mopub.volley.Cache;
import com.mopub.volley.Cache$Entry;
import com.mopub.volley.VolleyLog;
import com.mopub.volley.toolbox.DiskBasedCache$CacheHeader;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DiskBasedCache implements Cache {
   private static final int CACHE_MAGIC = 538183203;
   private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
   private static final float HYSTERESIS_FACTOR = 0.9F;
   private final Map mEntries;
   private final int mMaxCacheSizeInBytes;
   private final File mRootDirectory;
   private long mTotalSize;

   public DiskBasedCache(File var1) {
      this(var1, 5242880);
   }

   public DiskBasedCache(File var1, int var2) {
      this.mEntries = new LinkedHashMap(16, 0.75F, true);
      this.mTotalSize = 0L;
      this.mRootDirectory = var1;
      this.mMaxCacheSizeInBytes = var2;
   }

   private String getFilenameForKey(String var1) {
      int var2 = var1.length() / 2;
      int var3 = var1.substring(0, var2).hashCode();
      return var3 + String.valueOf(var1.substring(var2).hashCode());
   }

   private void pruneIfNeeded(int var1) {
      if(this.mTotalSize + (long)var1 >= (long)this.mMaxCacheSizeInBytes) {
         if(VolleyLog.DEBUG) {
            VolleyLog.v("Pruning old cache entries.", new Object[0]);
         }

         long var4 = this.mTotalSize;
         long var6 = SystemClock.elapsedRealtime();
         Iterator var8 = this.mEntries.entrySet().iterator();
         int var2 = 0;

         int var3;
         label29: {
            while(var8.hasNext()) {
               DiskBasedCache$CacheHeader var9 = (DiskBasedCache$CacheHeader)((Entry)var8.next()).getValue();
               if(this.getFileForKey(var9.key).delete()) {
                  this.mTotalSize -= var9.size;
               } else {
                  VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[]{var9.key, this.getFilenameForKey(var9.key)});
               }

               var8.remove();
               ++var2;
               var3 = var2;
               if((float)(this.mTotalSize + (long)var1) < (float)this.mMaxCacheSizeInBytes * 0.9F) {
                  break label29;
               }
            }

            var3 = var2;
         }

         if(VolleyLog.DEBUG) {
            VolleyLog.v("pruned %d files, %d bytes, %d ms", new Object[]{Integer.valueOf(var3), Long.valueOf(this.mTotalSize - var4), Long.valueOf(SystemClock.elapsedRealtime() - var6)});
            return;
         }
      }

   }

   private void putEntry(String var1, DiskBasedCache$CacheHeader var2) {
      if(!this.mEntries.containsKey(var1)) {
         this.mTotalSize += var2.size;
      } else {
         DiskBasedCache$CacheHeader var5 = (DiskBasedCache$CacheHeader)this.mEntries.get(var1);
         long var3 = this.mTotalSize;
         this.mTotalSize = var2.size - var5.size + var3;
      }

      this.mEntries.put(var1, var2);
   }

   private static int read(InputStream var0) {
      int var1 = var0.read();
      if(var1 == -1) {
         throw new EOFException();
      } else {
         return var1;
      }
   }

   static int readInt(InputStream var0) {
      return read(var0) << 0 | 0 | read(var0) << 8 | read(var0) << 16 | read(var0) << 24;
   }

   static long readLong(InputStream var0) {
      return 0L | ((long)read(var0) & 255L) << 0 | ((long)read(var0) & 255L) << 8 | ((long)read(var0) & 255L) << 16 | ((long)read(var0) & 255L) << 24 | ((long)read(var0) & 255L) << 32 | ((long)read(var0) & 255L) << 40 | ((long)read(var0) & 255L) << 48 | ((long)read(var0) & 255L) << 56;
   }

   static String readString(InputStream var0) {
      return new String(streamToBytes(var0, (int)readLong(var0)), "UTF-8");
   }

   static Map readStringStringMap(InputStream var0) {
      int var2 = readInt(var0);
      Object var3;
      if(var2 == 0) {
         var3 = Collections.emptyMap();
      } else {
         var3 = new HashMap(var2);
      }

      for(int var1 = 0; var1 < var2; ++var1) {
         ((Map)var3).put(readString(var0).intern(), readString(var0).intern());
      }

      return (Map)var3;
   }

   private void removeEntry(String var1) {
      DiskBasedCache$CacheHeader var2 = (DiskBasedCache$CacheHeader)this.mEntries.get(var1);
      if(var2 != null) {
         this.mTotalSize -= var2.size;
         this.mEntries.remove(var1);
      }

   }

   private static byte[] streamToBytes(InputStream var0, int var1) {
      byte[] var4 = new byte[var1];

      int var2;
      int var3;
      for(var2 = 0; var2 < var1; var2 += var3) {
         var3 = var0.read(var4, var2, var1 - var2);
         if(var3 == -1) {
            break;
         }
      }

      if(var2 != var1) {
         throw new IOException("Expected " + var1 + " bytes, read " + var2 + " bytes");
      } else {
         return var4;
      }
   }

   static void writeInt(OutputStream var0, int var1) {
      var0.write(var1 >> 0 & 255);
      var0.write(var1 >> 8 & 255);
      var0.write(var1 >> 16 & 255);
      var0.write(var1 >> 24 & 255);
   }

   static void writeLong(OutputStream var0, long var1) {
      var0.write((byte)((int)(var1 >>> 0)));
      var0.write((byte)((int)(var1 >>> 8)));
      var0.write((byte)((int)(var1 >>> 16)));
      var0.write((byte)((int)(var1 >>> 24)));
      var0.write((byte)((int)(var1 >>> 32)));
      var0.write((byte)((int)(var1 >>> 40)));
      var0.write((byte)((int)(var1 >>> 48)));
      var0.write((byte)((int)(var1 >>> 56)));
   }

   static void writeString(OutputStream var0, String var1) {
      byte[] var2 = var1.getBytes("UTF-8");
      writeLong(var0, (long)var2.length);
      var0.write(var2, 0, var2.length);
   }

   static void writeStringStringMap(Map var0, OutputStream var1) {
      if(var0 != null) {
         writeInt(var1, var0.size());
         Iterator var3 = var0.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var2 = (Entry)var3.next();
            writeString(var1, (String)var2.getKey());
            writeString(var1, (String)var2.getValue());
         }
      } else {
         writeInt(var1, 0);
      }

   }

   public void clear() {
      // $FF: Couldn't be decompiled
   }

   public Cache$Entry get(String param1) {
      // $FF: Couldn't be decompiled
   }

   public File getFileForKey(String var1) {
      return new File(this.mRootDirectory, this.getFilenameForKey(var1));
   }

   public void initialize() {
      // $FF: Couldn't be decompiled
   }

   public void invalidate(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void put(String var1, Cache$Entry var2) {
      synchronized(this){}

      try {
         this.pruneIfNeeded(var2.data.length);
         File var3 = this.getFileForKey(var1);

         try {
            FileOutputStream var4 = new FileOutputStream(var3);
            DiskBasedCache$CacheHeader var5 = new DiskBasedCache$CacheHeader(var1, var2);
            if(!var5.writeHeader(var4)) {
               var4.close();
               VolleyLog.d("Failed to write header for %s", new Object[]{var3.getAbsolutePath()});
               throw new IOException();
            }

            var4.write(var2.data);
            var4.close();
            this.putEntry(var1, var5);
         } catch (IOException var8) {
            if(!var3.delete()) {
               VolleyLog.d("Could not clean up file %s", new Object[]{var3.getAbsolutePath()});
            }
         }
      } finally {
         ;
      }

   }

   public void remove(String param1) {
      // $FF: Couldn't be decompiled
   }
}
