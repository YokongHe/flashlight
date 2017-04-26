package com.mopub.volley.toolbox;

import com.mopub.volley.Cache$Entry;
import com.mopub.volley.toolbox.DiskBasedCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

class DiskBasedCache$CacheHeader {
   public String etag;
   public String key;
   public Map responseHeaders;
   public long serverDate;
   public long size;
   public long softTtl;
   public long ttl;

   private DiskBasedCache$CacheHeader() {
   }

   public DiskBasedCache$CacheHeader(String var1, Cache$Entry var2) {
      this.key = var1;
      this.size = (long)var2.data.length;
      this.etag = var2.etag;
      this.serverDate = var2.serverDate;
      this.ttl = var2.ttl;
      this.softTtl = var2.softTtl;
      this.responseHeaders = var2.responseHeaders;
   }

   public static DiskBasedCache$CacheHeader readHeader(InputStream var0) {
      DiskBasedCache$CacheHeader var1 = new DiskBasedCache$CacheHeader();
      if(DiskBasedCache.readInt(var0) != 538183203) {
         throw new IOException();
      } else {
         var1.key = DiskBasedCache.readString(var0);
         var1.etag = DiskBasedCache.readString(var0);
         if(var1.etag.equals("")) {
            var1.etag = null;
         }

         var1.serverDate = DiskBasedCache.readLong(var0);
         var1.ttl = DiskBasedCache.readLong(var0);
         var1.softTtl = DiskBasedCache.readLong(var0);
         var1.responseHeaders = DiskBasedCache.readStringStringMap(var0);
         return var1;
      }
   }

   public Cache$Entry toCacheEntry(byte[] var1) {
      Cache$Entry var2 = new Cache$Entry();
      var2.data = var1;
      var2.etag = this.etag;
      var2.serverDate = this.serverDate;
      var2.ttl = this.ttl;
      var2.softTtl = this.softTtl;
      var2.responseHeaders = this.responseHeaders;
      return var2;
   }

   public boolean writeHeader(OutputStream param1) {
      // $FF: Couldn't be decompiled
   }
}
