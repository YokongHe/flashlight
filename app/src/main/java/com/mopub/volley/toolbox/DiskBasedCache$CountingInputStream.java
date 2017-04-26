package com.mopub.volley.toolbox;

import java.io.FilterInputStream;
import java.io.InputStream;

class DiskBasedCache$CountingInputStream extends FilterInputStream {
   private int bytesRead;

   private DiskBasedCache$CountingInputStream(InputStream var1) {
      super(var1);
      this.bytesRead = 0;
   }

   // $FF: synthetic method
   DiskBasedCache$CountingInputStream(InputStream var1, Object var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int access$100(DiskBasedCache$CountingInputStream var0) {
      return var0.bytesRead;
   }

   public int read() {
      int var1 = super.read();
      if(var1 != -1) {
         ++this.bytesRead;
      }

      return var1;
   }

   public int read(byte[] var1, int var2, int var3) {
      var2 = super.read(var1, var2, var3);
      if(var2 != -1) {
         this.bytesRead += var2;
      }

      return var2;
   }
}
