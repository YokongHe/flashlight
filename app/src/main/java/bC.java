public class bC {
   private static final ae a = bh.a(bC.class);

   public static bB a(byte[] var0) {
      short var1 = (short)(((var0[1] & 255) << 8) + (var0[0] & 255));
      byte[] var2 = new byte[var0.length - 2];
      System.arraycopy(var0, 2, var2, 0, var2.length);
      switch(var1) {
      case 29185:
         return new bJ(var2);
      case 29186:
         return new bG(var2);
      case 29187:
      case 29188:
      default:
         a.e("PDXMessageFactory.createMessage() Unknown command: " + var1 + ". ");
         return null;
      case 29189:
         return new bK(var2);
      }
   }
}
