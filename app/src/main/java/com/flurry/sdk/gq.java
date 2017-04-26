package com.flurry.sdk;

import com.flurry.sdk.gq$a;
import com.flurry.sdk.gq$d;
import com.flurry.sdk.gq$f;
import com.flurry.sdk.gq$g;
import com.flurry.sdk.gq$i;
import com.flurry.sdk.gq$j;
import com.flurry.sdk.gq$k;
import com.flurry.sdk.gq$l;
import com.flurry.sdk.gq$m;
import com.flurry.sdk.gq$o;
import java.util.List;
import java.util.Map;

public abstract class gq {
   public static final gq c = new gq$o("null");
   public static final gq d = new gq$o("boolean");
   public static final gq e = new gq$o("int");
   public static final gq f = new gq$o("long");
   public static final gq g = new gq$o("float");
   public static final gq h = new gq$o("double");
   public static final gq i = new gq$o("string");
   public static final gq j = new gq$o("bytes");
   public static final gq k = new gq$o("fixed");
   public static final gq l = new gq$o("enum");
   public static final gq m = new gq$o("union");
   public static final gq n = new gq$o("array-start");
   public static final gq o = new gq$o("array-end");
   public static final gq p = new gq$o("map-start");
   public static final gq q = new gq$o("map-end");
   public static final gq r = new gq$o("item-end");
   public static final gq s = new gq$o("field-action");
   public static final gq t = new gq$g(false, null);
   public static final gq u = new gq$g(true, null);
   public static final gq v = new gq$g(true, null);
   public static final gq w = new gq$g(true, null);
   public static final gq x = new gq$g(true, null);
   public static final gq y = new gq$o("map-key-marker");
   public final gq$i a;
   public final gq[] b;

   protected gq(gq$i var1) {
      this(var1, (gq[])null);
   }

   protected gq(gq$i var1, gq[] var2) {
      this.b = var2;
      this.a = var1;
   }

   protected static int a(gq[] var0, int var1) {
      byte var3 = 0;
      int var2 = var1;

      for(var1 = var3; var2 < var0.length; ++var2) {
         if(var0[var2] instanceof gq$m) {
            var1 += ((gq$m)var0[var2]).a();
         } else {
            ++var1;
         }
      }

      return var1;
   }

   static gq a(gq var0, gq var1) {
      return new gq$k(var0, var1, null);
   }

   static gq a(gq var0, gq... var1) {
      return new gq$j(var0, var1, null);
   }

   static gq a(String var0) {
      return new gq$d(var0, null);
   }

   static gq a(gq... var0) {
      return new gq$l(var0, null);
   }

   static gq a(gq[] var0, String[] var1) {
      return new gq$a(var0, var1, null);
   }

   static void a(gq[] var0, int var1, gq[] var2, int var3, Map var4, Map var5) {
      int var6 = var3;

      for(var3 = var1; var3 < var0.length; var6 = var1) {
         gq var8 = var0[var3].a(var4, var5);
         if(var8 instanceof gq$m) {
            gq[] var7 = var8.b;
            List var9 = (List)var5.get(var8);
            if(var9 == null) {
               System.arraycopy(var7, 0, var2, var6, var7.length);
            } else {
               var9.add(new gq$f(var2, var6));
            }

            var1 = var6 + var7.length;
         } else {
            var2[var6] = var8;
            var1 = var6 + 1;
         }

         ++var3;
      }

   }

   static gq b(gq... var0) {
      return new gq$m(var0, null);
   }

   public int a() {
      return 1;
   }

   public gq a(Map var1, Map var2) {
      return this;
   }
}
