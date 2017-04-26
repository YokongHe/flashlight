package com.mopub.volley.toolbox;

import com.mopub.volley.toolbox.ByteArrayPool;
import java.io.ByteArrayOutputStream;

public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {
   private static final int DEFAULT_SIZE = 256;
   private final ByteArrayPool mPool;

   public PoolingByteArrayOutputStream(ByteArrayPool var1) {
      this(var1, 256);
   }

   public PoolingByteArrayOutputStream(ByteArrayPool var1, int var2) {
      this.mPool = var1;
      this.buf = this.mPool.getBuf(Math.max(var2, 256));
   }

   private void expand(int var1) {
      if(this.count + var1 > this.buf.length) {
         byte[] var2 = this.mPool.getBuf((this.count + var1) * 2);
         System.arraycopy(this.buf, 0, var2, 0, this.count);
         this.mPool.returnBuf(this.buf);
         this.buf = var2;
      }
   }

   public void close() {
      this.mPool.returnBuf(this.buf);
      this.buf = null;
      super.close();
   }

   public void finalize() {
      this.mPool.returnBuf(this.buf);
   }

   public void write(int var1) {
      synchronized(this){}

      try {
         this.expand(1);
         super.write(var1);
      } finally {
         ;
      }

   }

   public void write(byte[] var1, int var2, int var3) {
      synchronized(this){}

      try {
         this.expand(var3);
         super.write(var1, var2, var3);
      } finally {
         ;
      }

   }
}
