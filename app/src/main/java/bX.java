import android.os.Build;
import android.os.Build.VERSION;

public final class bX {
   public static final int a;
   public static final boolean b;
   public static final boolean c;
   private static boolean d;
   private static boolean e;
   private static final boolean f;

   static {
      boolean var2 = false;
      a = Integer.parseInt(VERSION.SDK);

      String var3;
      try {
         var3 = (String)Build.class.getField("MANUFACTURER").get((Object)null);
      } catch (Exception var5) {
         var3 = "";
      }

      String var4 = Build.MODEL;
      boolean var1;
      if(!var3.equalsIgnoreCase("samsung") || !var4.equalsIgnoreCase("SGH-T959") && !var4.equalsIgnoreCase("SAMSUNG-SGH-I897") && !var4.equalsIgnoreCase("SGH-I897") && !var4.equalsIgnoreCase("GT-I9000")) {
         var1 = false;
      } else {
         var1 = true;
      }

      d = var1;
      if(var3.equalsIgnoreCase("htc") && (var4.equalsIgnoreCase("PC36100") || var4.equalsIgnoreCase("ADR6300") || var4.equalsIgnoreCase("HTC Glacier") || var4.equalsIgnoreCase("T-Mobile myTouch 4G") || var4.equalsIgnoreCase("T-Mobile G2"))) {
         var1 = true;
      } else {
         var1 = false;
      }

      b = var1;
      e = var4.equalsIgnoreCase("Motorola_i1");
      if(var3.equalsIgnoreCase("Motorola") && var4.equalsIgnoreCase("MB860")) {
         var1 = true;
      } else {
         var1 = false;
      }

      f = var1;
      if(var3.equalsIgnoreCase("samsung")) {
         int var0 = a;
      }

      label40: {
         if(!d) {
            var1 = var2;
            if(!e) {
               break label40;
            }
         }

         var1 = true;
      }

      c = var1;
      var1 = d;
      var1 = f;
   }
}
