package org.a.a.k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class a {
   public static final Pattern a = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
   public static final Pattern b = Pattern.compile("^([-+]?(\\.[0-9]+|[0-9_]+(\\.[0-9_]*)?)([eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
   public static final Pattern c = Pattern.compile("^(?:[-+]?0b[0-1_]+|[-+]?0[0-7_]+|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x[0-9a-fA-F_]+|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
   public static final Pattern d = Pattern.compile("^(?:<<)$");
   public static final Pattern e = Pattern.compile("^(?:~|null|Null|NULL| )$");
   public static final Pattern f = Pattern.compile("^$");
   public static final Pattern g = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
   public static final Pattern h = Pattern.compile("^(?:=)$");
   public static final Pattern i = Pattern.compile("^(?:!|&|\\*)$");
   protected Map j;

   public a() {
      this(true);
   }

   private a(boolean var1) {
      this.j = new HashMap();
      this.a(org.a.a.g.i.k, a, "yYnNtTfFoO");
      this.a(org.a.a.g.i.h, c, "-+0123456789");
      this.a(org.a.a.g.i.i, b, "-+0123456789.");
      this.a(org.a.a.g.i.c, d, "<");
      this.a(org.a.a.g.i.l, e, "~nN\u0000");
      this.a(org.a.a.g.i.l, f, (String)null);
      this.a(org.a.a.g.i.j, g, "0123456789");
      this.a(org.a.a.g.i.b, h, "=");
      this.a(org.a.a.g.i.a, i, "!&*");
   }

   private void a(org.a.a.g.i var1, Pattern var2, String var3) {
      if(var3 == null) {
         List var6 = (List)this.j.get((Object)null);
         Object var9 = var6;
         if(var6 == null) {
            var9 = new ArrayList();
            this.j.put((Object)null, var9);
         }

         ((List)var9).add(new org.a.a.k.b(var1, var2));
      } else {
         char[] var8 = var3.toCharArray();
         int var5 = var8.length;

         for(int var4 = 0; var4 < var5; ++var4) {
            Character var10 = Character.valueOf(var8[var4]);
            if(var10.charValue() == 0) {
               var10 = null;
            }

            List var7 = (List)this.j.get(var10);
            Object var11 = var7;
            if(var7 == null) {
               var11 = new ArrayList();
               this.j.put(var10, var11);
            }

            ((List)var11).add(new org.a.a.k.b(var1, var2));
         }
      }

   }

   public final org.a.a.g.i a(org.a.a.g.e var1, String var2, boolean var3) {
      if(var1 == org.a.a.g.e.a && var3) {
         List var4;
         if(var2.length() == 0) {
            var4 = (List)this.j.get(Character.valueOf('\u0000'));
         } else {
            var4 = (List)this.j.get(Character.valueOf(var2.charAt(0)));
         }

         org.a.a.k.b var5;
         org.a.a.g.i var6;
         Iterator var7;
         if(var4 != null) {
            var7 = var4.iterator();

            while(var7.hasNext()) {
               var5 = (org.a.a.k.b)var7.next();
               var6 = var5.a();
               if(var5.b().matcher(var2).matches()) {
                  return var6;
               }
            }
         }

         if(this.j.containsKey((Object)null)) {
            var7 = ((List)this.j.get((Object)null)).iterator();

            while(var7.hasNext()) {
               var5 = (org.a.a.k.b)var7.next();
               var6 = var5.a();
               if(var5.b().matcher(var2).matches()) {
                  return var6;
               }
            }
         }
      }

      switch(null.a[var1.ordinal()]) {
      case 1:
         return org.a.a.g.i.m;
      case 2:
         return org.a.a.g.i.n;
      default:
         return org.a.a.g.i.o;
      }
   }
}
