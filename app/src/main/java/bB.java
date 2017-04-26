import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class bB extends aW {
   private static final ae a = bh.a(bB.class);
   private short b;

   public bB(short var1) {
      this.b = var1;
   }

   public bB(short var1, byte[] var2) {
      super(var2);
      this.b = var1;
   }

   public final byte[] d() {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      var1.write(this.b & 255);
      var1.write(this.b >> 8 & 255);

      try {
         var1.write(super.d());
      } catch (IOException var3) {
         a.e("PDXMessage.toByteArray() " + var3.toString() + ". ");
      }

      return var1.toByteArray();
   }

   public final short e() {
      return this.b;
   }

   public final byte[] f() {
      return super.d();
   }
}
