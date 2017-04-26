package com.mopub.common;

import com.mopub.common.DiskLruCache;
import com.mopub.common.DiskLruCache$Editor;
import com.mopub.common.DiskLruCacheUtil;
import java.io.Closeable;
import java.io.InputStream;

public final class DiskLruCache$Snapshot implements Closeable {
   private final InputStream[] ins;
   private final String key;
   private final long[] lengths;
   private final long sequenceNumber;
   // $FF: synthetic field
   final DiskLruCache this$0;

   private DiskLruCache$Snapshot(DiskLruCache var1, String var2, long var3, InputStream[] var5, long[] var6) {
      this.this$0 = var1;
      this.key = var2;
      this.sequenceNumber = var3;
      this.ins = var5;
      this.lengths = var6;
   }

   // $FF: synthetic method
   DiskLruCache$Snapshot(DiskLruCache var1, String var2, long var3, InputStream[] var5, long[] var6, DiskLruCache$Snapshot var7) {
      this(var1, var2, var3, var5, var6);
   }

   public final void close() {
      InputStream[] var3 = this.ins;
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         DiskLruCacheUtil.closeQuietly(var3[var1]);
      }

   }

   public final DiskLruCache$Editor edit() {
      return DiskLruCache.access$5(this.this$0, this.key, this.sequenceNumber);
   }

   public final InputStream getInputStream(int var1) {
      return this.ins[var1];
   }

   public final long getLength(int var1) {
      return this.lengths[var1];
   }

   public final String getString(int var1) {
      return DiskLruCache.access$6(this.getInputStream(var1));
   }
}
