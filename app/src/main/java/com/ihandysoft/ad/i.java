package com.ihandysoft.ad;

public enum i {
   a((Class)null),
   b((Class)null),
   c((Class)null),
   d((Class)null),
   e(com.ihandysoft.ad.a.c.class, 9),
   f(com.ihandysoft.ad.a.h.class),
   g((Class)null),
   h((Class)null),
   i(com.ihandysoft.ad.a.j.class, 10),
   j(com.ihandysoft.ad.a.l.class),
   k(com.ihandysoft.ad.a.d.class),
   l(com.ihandysoft.ad.a.g.class, 10),
   m(com.ihandysoft.ad.a.e.class, 9),
   n((Class)null),
   o((Class)null),
   p((Class)null),
   q((Class)null),
   r((Class)null),
   s(com.ihandysoft.ad.a.i.class),
   t(com.ihandysoft.ad.a.m.class),
   u(com.ihandysoft.ad.a.f.class),
   v(com.ihandysoft.ad.a.k.class),
   w(com.ihandysoft.ad.a.n.class);

   private static com.ihandysoft.ad.i[] z;
   private Class x;
   private int y = 4;

   static {
      z = values();
   }

   private i(Class var3) {
      this.x = var3;
   }

   private i(Class var3, int var4) {
      this.x = var3;
      this.y = var4;
   }

   public static com.ihandysoft.ad.i a(Object var0) {
      int var1;
      com.ihandysoft.ad.i var8;
      if(!(var0 instanceof String)) {
         if(var0 instanceof Integer) {
            Integer var9 = (Integer)var0;

            try {
               var1 = var9.intValue();
               var8 = z[var1];
               return var8;
            } catch (Exception var7) {
               return null;
            }
         } else {
            return null;
         }
      } else {
         String var4 = (String)var0;
         if(var4 != null) {
            com.ihandysoft.ad.i[] var5 = values();
            int var2 = var5.length;

            for(var1 = 0; var1 < var2; ++var1) {
               com.ihandysoft.ad.i var3 = var5[var1];
               var8 = var3;
               if(var4.equalsIgnoreCase(var3.name())) {
                  return var8;
               }
            }
         }

         try {
            var1 = Integer.parseInt(var4);
            var8 = z[var1];
         } catch (Exception var6) {
            return null;
         }

         return var8;
      }
   }

   public final Class a() {
      return this.x;
   }

   public final int b() {
      return this.y;
   }
}
