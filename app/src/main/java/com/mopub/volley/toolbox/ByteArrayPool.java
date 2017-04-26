package com.mopub.volley.toolbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ByteArrayPool {
   protected static final Comparator BUF_COMPARATOR = new Comparator() {
      public final int compare(byte[] var1, byte[] var2) {
         return var1.length - var2.length;
      }
   };
   private List mBuffersByLastUse = new LinkedList();
   private List mBuffersBySize = new ArrayList(64);
   private int mCurrentSize = 0;
   private final int mSizeLimit;

   public ByteArrayPool(int var1) {
      this.mSizeLimit = var1;
   }

   private void trim() {
      synchronized(this){}

      while(true) {
         boolean var3 = false;

         try {
            var3 = true;
            if(this.mCurrentSize <= this.mSizeLimit) {
               var3 = false;
               return;
            }

            byte[] var1 = (byte[])this.mBuffersByLastUse.remove(0);
            this.mBuffersBySize.remove(var1);
            this.mCurrentSize -= var1.length;
            var3 = false;
         } finally {
            if(var3) {
               ;
            }
         }
      }
   }

   public byte[] getBuf(int var1) {
      synchronized(this){}
      int var2 = 0;

      byte[] var3;
      while(true) {
         boolean var5 = false;

         try {
            var5 = true;
            if(var2 >= this.mBuffersBySize.size()) {
               var3 = new byte[var1];
               var5 = false;
               break;
            }

            var3 = (byte[])this.mBuffersBySize.get(var2);
            if(var3.length >= var1) {
               this.mCurrentSize -= var3.length;
               this.mBuffersBySize.remove(var2);
               this.mBuffersByLastUse.remove(var3);
               var5 = false;
               break;
            }

            var5 = false;
         } finally {
            if(var5) {
               ;
            }
         }

         ++var2;
      }

      return var3;
   }

   public void returnBuf(byte[] param1) {
      // $FF: Couldn't be decompiled
   }
}
