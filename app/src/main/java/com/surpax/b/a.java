package com.surpax.b;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Map;
import java.util.Random;

public final class a {
   public static String a = null;
   public static boolean b;
   public static boolean c = false;
   public static boolean d = false;
   private static com.surpax.b.a e;
   private Map f;
   private Map g;
   private int h;
   private String i;
   private String j;
   private String k;
   private String l;

   public static com.surpax.b.a a() {
      if(e == null) {
         e = new a();
      }

      return e;
   }

   public final void a(Map var1) {
      (new StringBuilder("honey comb data = ")).append(var1.toString()).toString();
      if(var1 != null && !var1.isEmpty()) {
         var1 = (Map)var1.get("Application");
         if(var1 != null && !var1.isEmpty()) {
            var1 = (Map)var1.get("HoneyComb");
            if(var1 != null && !var1.isEmpty()) {
               a = (String)var1.get("HoneyCombPackageName");
               this.f = (Map)var1.get("AlertWhenAppEnd");
               d = ((Boolean)this.f.get("ShowWhenClickHomeButton")).booleanValue();
               this.g = com.surpax.ledflashlight.c.a(var1, "IconShowConditions");
               this.h = ((Integer)((Map)var1.get("EntryIcon")).get("IconStyle")).intValue();
               var1 = (Map)var1.get("Content");
               if(var1 != null && !var1.isEmpty()) {
                  this.i = com.surpax.ledflashlight.c.b(var1, "AdTitle");
                  this.j = com.surpax.ledflashlight.c.b(var1, "AdBody");
                  this.l = com.surpax.ledflashlight.c.b(var1, "Bubble");
                  this.k = com.surpax.ledflashlight.c.b(var1, "ButtonTitle");
                  return;
               }
            }
         }
      }

   }

   public final int b() {
      return this.h;
   }

   public final String c() {
      return this.i;
   }

   public final String d() {
      return this.j;
   }

   public final String e() {
      return this.k;
   }

   public final String f() {
      return this.l;
   }

   public final boolean g() {
      if(VERSION.SDK_INT < 9) {
         return false;
      } else if(TextUtils.isEmpty(a)) {
         return false;
      } else if(this.g != null && !this.g.isEmpty()) {
         if(((Boolean)this.g.get("CanShowHoneyComb")).booleanValue()) {
            int var1 = (new Random()).nextInt(100);
            int var2 = ((Integer)this.g.get("Probability")).intValue();
            if(var1 <= var2) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }
}
