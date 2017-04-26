public final class aX extends aV {
   private int a;

   public aX(int var1) {
      super((short)192);
      this.a = var1;
   }

   public aX(byte[] var1) {
      super((short)192);
      if(var1.length == 1) {
         this.a = var1[0] & 255;
      } else if(var1.length == 2) {
         this.a = ((var1[1] & 255) << 8) + (var1[0] & 255);
      } else if(var1.length == 3) {
         this.a = ((var1[2] & 255) << 16) + ((var1[1] & 255) << 8) + (var1[0] & 255);
      } else {
         this.a = ((var1[3] & 255) << 24) + ((var1[2] & 255) << 16) + ((var1[1] & 255) << 8) + (var1[0] & 255);
      }
   }

   public final int a() {
      return this.a;
   }

   public final byte[] b() {
      byte[] var1;
      if(Math.abs(this.a) < 128) {
         var1 = new byte[]{(byte)this.a};
      } else if(Math.abs(this.a) < '耀') {
         var1 = new byte[]{(byte)this.a, (byte)(this.a >> 8)};
      } else {
         var1 = new byte[]{(byte)this.a, (byte)(this.a >> 8), (byte)(this.a >> 16), (byte)(this.a >>> 24)};
      }

      return super.a(var1);
   }
}
