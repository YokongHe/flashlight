package com.mopub.common;

import com.mopub.common.DiskLruCache;
import com.mopub.common.DiskLruCache$Editor;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class DiskLruCache$Entry {
   private DiskLruCache$Editor currentEditor;
   private final String key;
   private final long[] lengths;
   private boolean readable;
   private long sequenceNumber;
   // $FF: synthetic field
   final DiskLruCache this$0;

   private DiskLruCache$Entry(DiskLruCache var1, String var2) {
      this.this$0 = var1;
      this.key = var2;
      this.lengths = new long[DiskLruCache.access$7(var1)];
   }

   // $FF: synthetic method
   DiskLruCache$Entry(DiskLruCache var1, String var2, DiskLruCache$Entry var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static boolean access$0(DiskLruCache$Entry var0) {
      return var0.readable;
   }

   // $FF: synthetic method
   static DiskLruCache$Editor access$1(DiskLruCache$Entry var0) {
      return var0.currentEditor;
   }

   // $FF: synthetic method
   static String access$2(DiskLruCache$Entry var0) {
      return var0.key;
   }

   // $FF: synthetic method
   static void access$4(DiskLruCache$Entry var0, boolean var1) {
      var0.readable = var1;
   }

   // $FF: synthetic method
   static void access$5(DiskLruCache$Entry var0, DiskLruCache$Editor var1) {
      var0.currentEditor = var1;
   }

   // $FF: synthetic method
   static void access$6(DiskLruCache$Entry var0, String[] var1) {
      var0.setLengths(var1);
   }

   // $FF: synthetic method
   static long[] access$7(DiskLruCache$Entry var0) {
      return var0.lengths;
   }

   // $FF: synthetic method
   static long access$8(DiskLruCache$Entry var0) {
      return var0.sequenceNumber;
   }

   // $FF: synthetic method
   static void access$9(DiskLruCache$Entry var0, long var1) {
      var0.sequenceNumber = var1;
   }

   private IOException invalidLengths(String[] var1) {
      throw new IOException("unexpected journal line: " + Arrays.toString(var1));
   }

   private void setLengths(String[] var1) {
      if(var1.length != DiskLruCache.access$7(this.this$0)) {
         throw this.invalidLengths(var1);
      } else {
         int var2 = 0;

         while(true) {
            try {
               if(var2 >= var1.length) {
                  return;
               }

               this.lengths[var2] = Long.parseLong(var1[var2]);
            } catch (NumberFormatException var4) {
               throw this.invalidLengths(var1);
            }

            ++var2;
         }
      }
   }

   public final File getCleanFile(int var1) {
      return new File(DiskLruCache.access$8(this.this$0), this.key + "." + var1);
   }

   public final File getDirtyFile(int var1) {
      return new File(DiskLruCache.access$8(this.this$0), this.key + "." + var1 + ".tmp");
   }

   public final String getLengths() {
      StringBuilder var5 = new StringBuilder();
      long[] var6 = this.lengths;
      int var2 = var6.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         long var3 = var6[var1];
         var5.append(' ').append(var3);
      }

      return var5.toString();
   }
}
