public class ax {
   private static final ae a = bh.a(ax.class);

   public static String a(String var0) {
      if(a.a()) {
         a.a((Object)("Escaping XML reserved tokens (&, <, >, \" and \') of: " + var0));
      }

      int var1 = 0;
      StringBuffer var3 = new StringBuffer(var0);

      while(var1 < var3.length()) {
         char var2 = var3.charAt(var1);
         if(var2 == 38) {
            ++var1;
            var3.insert(var1, "amp;");
            var1 += 4;
         } else if(var2 == 60) {
            var3.deleteCharAt(var1);
            var3.insert(var1, "&lt;");
            var1 += 4;
         } else if(var2 == 62) {
            var3.deleteCharAt(var1);
            var3.insert(var1, "&gt;");
            var1 += 4;
         } else if(var2 == 34) {
            var3.deleteCharAt(var1);
            var3.insert(var1, "&quot;");
            var1 += 6;
         } else if(var2 == 39) {
            var3.deleteCharAt(var1);
            var3.insert(var1, "&apos;");
            var1 += 6;
         } else {
            ++var1;
         }
      }

      var0 = var3.toString();
      if(a.a()) {
         a.a((Object)("Final output: " + var0));
      }

      return var0;
   }

   public static boolean a() {
      return false;
   }

   public static boolean a(M var0) {
      short var1 = var0.a();
      return var1 == M.d.a() || var1 == M.e.a() || var1 == M.f.a() || var1 == M.g.a();
   }

   public static boolean b() {
      return false;
   }

   public static boolean b(M var0) {
      short var1 = var0.a();
      return var1 == M.a.a() || var1 == M.c.a() || var1 == M.b.a();
   }

   public static M c(M var0) {
      M var1;
      if(var0 != M.b && var0 != M.c) {
         if(var0 != M.e && var0 != M.f && var0 != M.h && var0 != M.g) {
            var1 = var0;
         } else {
            var1 = M.d;
         }
      } else {
         var1 = M.a;
      }

      if(a.c()) {
         a.c((Object)("adjustCodecForBluetooth() " + var0.a() + " -> " + var1.a()));
      }

      return var1;
   }
}
