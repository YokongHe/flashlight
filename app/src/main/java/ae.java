import java.io.UnsupportedEncodingException;

public abstract class ae {
   private static String[] a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

   private static String a(byte var0) {
      byte var1 = (byte)((byte)((byte)(var0 & 240) >>> 4) & 15);
      var0 = (byte)(var0 & 15);
      return a[var1] + a[var0];
   }

   public static String b(byte[] var0) {
      if(var0 == null) {
         return "";
      } else {
         StringBuffer var2 = new StringBuffer();

         for(int var1 = 0; var1 < 16; ++var1) {
            var2.append(a(var0[var1]));
            if(var1 == 3 || var1 == 5 || var1 == 7 || var1 == 9) {
               var2.append("-");
            }
         }

         return var2.toString().toLowerCase();
      }
   }

   private static String[] c(byte[] var0) {
      int var2 = var0.length / 8;
      int var1 = var2;
      if(var0.length % 8 != 0) {
         var1 = var2 + 1;
      }

      String[] var6 = new String[var1];

      String var5;
      try {
         var5 = new String(var0, "ISO-8859-1");
      } catch (UnsupportedEncodingException var9) {
         var5 = new String(var0);
      }

      var2 = 0;

      for(int var3 = 0; var2 < var1; ++var2) {
         char[] var7 = new char[41];

         int var4;
         for(var4 = 0; var4 < var7.length; ++var4) {
            var7[var4] = 32;
         }

         for(var4 = 0; var4 < 8 && var3 < var0.length; ++var4) {
            String var8 = a(var0[var3]);
            var7[var4 * 3] = var8.charAt(0);
            var7[var4 * 3 + 1] = var8.charAt(1);
            var7[(var4 << 1) + 26] = var5.charAt(var3);
            ++var3;
         }

         var6[var2] = new String(var7);
      }

      return var6;
   }

   public abstract void a(Object var1);

   public abstract void a(Object var1, Throwable var2);

   public final void a(byte[] var1) {
      if(this.a()) {
         this.a((Object)"Buffer dump:");
         String[] var3 = c(var1);

         for(int var2 = 0; var2 < var3.length; ++var2) {
            this.a((Object)var3[var2]);
         }
      }

   }

   public abstract boolean a();

   public abstract void b(Object var1);

   public abstract boolean b();

   public abstract void c(Object var1);

   public abstract boolean c();

   public abstract void d(Object var1);

   public abstract boolean d();

   public abstract void e(Object var1);

   public abstract boolean e();

   public abstract void f();

   public abstract void g();
}
