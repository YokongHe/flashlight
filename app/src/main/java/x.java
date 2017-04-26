public final class x {
   public static final boolean a;

   static {
      boolean var0;
      if(!x.class.getName().endsWith("Config")) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
   }

   public static String a() {
      return "1.0.0.0";
   }

   public static String b() {
      return "1.6.0.0B06";
   }
}
