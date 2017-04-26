import java.io.ByteArrayOutputStream;

public class aV {
   private short a;

   public aV(short var1) {
      this.a = var1;
   }

   public static int a(int var0) {
      return var0 <= 127?1:(var0 <= 255?2:(var0 <= '\uffff'?3:5));
   }

   public static int a(byte[] var0, int var1) {
      int var3 = var0[var1] & 255;
      int var2;
      if(var3 == 129) {
         var2 = var0[var1 + 1] & 255;
      } else {
         if(var3 == 130) {
            return ((var0[var1 + 1] & 255) << 8) + (var0[var1 + 2] & 255);
         }

         var2 = var3;
         if(var3 == 132) {
            return ((var0[var1 + 1] & 255) << 24) + ((var0[var1 + 2] & 255) << 16) + ((var0[var1 + 3] & 255) << 8) + (var0[var1 + 4] & 255);
         }
      }

      return var2;
   }

   public final byte[] a(byte[] var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      var2.write(this.a & 255);
      if(var1.length > '\uffff') {
         var2.write(132);
         var2.write(var1.length >>> 24);
         var2.write(var1.length >> 16 & 255);
         var2.write(var1.length >> 8 & 255);
         var2.write(var1.length & 255);
      } else if(var1.length > 255) {
         var2.write(130);
         var2.write(var1.length >> 8 & 255);
         var2.write(var1.length & 255);
      } else if(var1.length > 127) {
         var2.write(129);
         var2.write(var1.length);
      } else if(var1.length >= 0) {
         var2.write(var1.length);
      }

      var2.write(var1, 0, var1.length);
      return var2.toByteArray();
   }

   public final short c() {
      return this.a;
   }
}
