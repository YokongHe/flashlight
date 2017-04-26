package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$a;
import com.flurry.sdk.fn$b;
import com.flurry.sdk.fn$c;
import com.flurry.sdk.fn$d;
import com.flurry.sdk.fn$e;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.fn$f$a;
import com.flurry.sdk.fn$g;
import com.flurry.sdk.fn$h;
import com.flurry.sdk.fn$i;
import com.flurry.sdk.fn$j;
import com.flurry.sdk.fn$k;
import com.flurry.sdk.fn$l;
import com.flurry.sdk.fn$m;
import com.flurry.sdk.fn$n;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.fn$p;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.fn$r;
import com.flurry.sdk.fn$s;
import com.flurry.sdk.fn$u;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.fn$w;
import com.flurry.sdk.fo;
import com.flurry.sdk.hd;
import com.flurry.sdk.hf;
import com.flurry.sdk.hh;
import com.flurry.sdk.hj$a;
import com.flurry.sdk.hn;
import com.flurry.sdk.jq;
import com.flurry.sdk.rq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class fn {
   static final hd a = new hd();
   static final jq b;
   static final Map e;
   private static final Set g;
   private static final Set h;
   private static final ThreadLocal i;
   private static final ThreadLocal j;
   private static ThreadLocal k;
   fn$r c;
   int d;
   private final fn$v f;

   static {
      b = new jq(a);
      a.a(hj$a.b);
      a.a((hn)b);
      HashSet var0 = new HashSet();
      g = var0;
      Collections.addAll(var0, new String[]{"doc", "fields", "items", "name", "namespace", "size", "symbols", "values", "type"});
      var0 = new HashSet();
      h = var0;
      Collections.addAll(var0, new String[]{"default", "doc", "name", "order", "type"});
      i = new ThreadLocal() {
         protected final Set a() {
            return new HashSet();
         }

         // $FF: synthetic method
         protected final Object initialValue() {
            return this.a();
         }
      };
      j = new ThreadLocal() {
         protected final Map a() {
            return new IdentityHashMap();
         }

         // $FF: synthetic method
         protected final Object initialValue() {
            return this.a();
         }
      };
      HashMap var1 = new HashMap();
      e = var1;
      var1.put("string", fn$v.g);
      e.put("bytes", fn$v.h);
      e.put("int", fn$v.i);
      e.put("long", fn$v.j);
      e.put("float", fn$v.k);
      e.put("double", fn$v.l);
      e.put("boolean", fn$v.m);
      e.put("null", fn$v.n);
      k = new ThreadLocal() {
         protected final Boolean a() {
            return Boolean.valueOf(true);
         }

         // $FF: synthetic method
         protected final Object initialValue() {
            return this.a();
         }
      };
   }

   fn(fn$v var1) {
      this.c = new fn$r(g);
      this.d = Integer.MIN_VALUE;
      this.f = var1;
   }

   public static fn a(fn$v var0) {
      switch(null.a[var0.ordinal()]) {
      case 1:
         return new fn$u();
      case 2:
         return new fn$c();
      case 3:
         return new fn$i();
      case 4:
         return new fn$k();
      case 5:
         return new fn$h();
      case 6:
         return new fn$d();
      case 7:
         return new fn$b();
      case 8:
         return new fn$p();
      default:
         throw new fk("Can\'t create a: " + var0);
      }
   }

   public static fn a(fn var0) {
      return new fn$a(var0);
   }

   public static fn a(fn var0, fn var1) {
      if(var0 != var1) {
         IdentityHashMap var2 = new IdentityHashMap(1);
         HashMap var3 = new HashMap(1);
         HashMap var4 = new HashMap(1);
         b(var1, var2, var3, var4);
         if(var3.size() != 0 || var4.size() != 0) {
            var2.clear();
            return a((fn)var0, (Map)var2, (Map)var3, (Map)var4);
         }
      }

      return var0;
   }

   private static fn a(fn var0, Map var1, Map var2, Map var3) {
      fn$m var4;
      if(var0 instanceof fn$n) {
         var4 = ((fn$n)var0).f;
      } else {
         var4 = null;
      }

      fn var10;
      label59: {
         switch(null.a[var0.a().ordinal()]) {
         case 9:
            if(var1.containsKey(var0)) {
               return (fn)var1.get(var0);
            }

            if(var2.containsKey(var4)) {
               var4 = (fn$m)var2.get(var4);
            }

            fn var12 = a(fn$m.a(var4), var0.e(), (String)null, var0.h());
            var1.put(var0, var12);
            ArrayList var6 = new ArrayList();
            Iterator var7 = var0.b().iterator();

            while(var7.hasNext()) {
               fn$f var8 = (fn$f)var7.next();
               fn var9 = a(fn$f.d(var8), var1, var2, var3);
               fn$f var13 = new fn$f(a(var4, fn$f.e(var8), var3), var9, fn$f.f(var8), fn$f.g(var8), fn$f.h(var8));
               fn$f.c(var13).putAll(fn$f.c(var8));
               var6.add(var13);
            }

            var12.c((List)var6);
            var10 = var12;
            break label59;
         case 10:
            if(var2.containsKey(var4)) {
               var10 = a((String)fn$m.a((fn$m)var2.get(var4)), (String)var0.e(), (String)null, (List)var0.c());
               break label59;
            }
            break;
         case 11:
            var10 = a(var0.i(), var1, var2, var3);
            if(var10 != var0.i()) {
               var10 = a(var10);
               break label59;
            }
            break;
         case 12:
            var10 = a(var0.j(), var1, var2, var3);
            if(var10 != var0.j()) {
               var10 = b(var10);
               break label59;
            }
            break;
         case 13:
            ArrayList var11 = new ArrayList();
            Iterator var5 = var0.k().iterator();

            while(var5.hasNext()) {
               var11.add(a((fn)var5.next(), var1, var2, var3));
            }

            var10 = b((List)var11);
            break label59;
         case 14:
            if(var2.containsKey(var4)) {
               var10 = a(fn$m.a((fn$m)var2.get(var4)), var0.e(), (String)null, var0.l());
               break label59;
            }
         }

         var10 = var0;
      }

      if(var10 != var0) {
         var10.c.putAll(var0.c);
      }

      return var10;
   }

   static fn a(hh var0, fn$o var1) {
      fn$m var2 = null;
      Object var15;
      if(var0.f()) {
         fn var33 = var1.a((Object)var0.i());
         var15 = var33;
         if(var33 == null) {
            throw new fo("Undefined name: " + var0);
         }
      } else {
         Iterator var14;
         if(!var0.c()) {
            if(!var0.b()) {
               throw new fo("Schema not yet supported: " + var0);
            }

            fn$j var32 = new fn$j(var0.p());
            var14 = var0.iterator();

            while(var14.hasNext()) {
               var32.add(a((hh)var14.next(), var1));
            }

            var15 = new fn$w(var32);
         } else {
            String var6 = a(var0, "type", "No type");
            String var3;
            String var4;
            if(!var6.equals("record") && !var6.equals("error") && !var6.equals("enum") && !var6.equals("fixed")) {
               var3 = null;
               var4 = null;
            } else {
               var4 = a(var0, "namespace");
               String var16 = a(var0, "doc");
               var3 = var4;
               if(var4 == null) {
                  var3 = var1.a();
               }

               fn$m var5 = new fn$m(a(var0, "name", "No name in schema"), var3);
               if(fn$m.c(var5) != null) {
                  var3 = var1.a();
                  var1.a(fn$m.c(var5));
                  var4 = var16;
                  var2 = var5;
               } else {
                  var3 = null;
                  var4 = var16;
                  var2 = var5;
               }
            }

            Object var21;
            Iterator var29;
            if(e.containsKey(var6)) {
               var21 = a((fn$v)e.get(var6));
            } else {
               hh var17;
               hh var27;
               if(!var6.equals("record") && !var6.equals("error")) {
                  if(var6.equals("enum")) {
                     var27 = var0.a("symbols");
                     if(var27 == null || !var27.b()) {
                        throw new fo("Enum has no symbols: " + var0);
                     }

                     fn$j var22 = new fn$j();
                     Iterator var28 = var27.iterator();

                     while(var28.hasNext()) {
                        var22.add(((hh)var28.next()).i());
                     }

                     fn$e var30 = new fn$e(var2, var4, var22);
                     if(var2 != null) {
                        var1.b(var30);
                     }

                     var21 = var30;
                  } else if(var6.equals("array")) {
                     var17 = var0.a("items");
                     if(var17 == null) {
                        throw new fo("Array has no items type: " + var0);
                     }

                     var21 = new fn$a(a(var17, var1));
                  } else if(var6.equals("map")) {
                     var17 = var0.a("values");
                     if(var17 == null) {
                        throw new fo("Map has no values type: " + var0);
                     }

                     var21 = new fn$l(a(var17, var1));
                  } else {
                     if(!var6.equals("fixed")) {
                        throw new fo("Type not supported: " + var6);
                     }

                     hh var24 = var0.a("size");
                     if(var24 == null || !var24.e()) {
                        throw new fo("Invalid or no size: " + var0);
                     }

                     fn$g var31 = new fn$g(var2, var4, var24.k());
                     if(var2 != null) {
                        var1.b(var31);
                     }

                     var21 = var31;
                  }
               } else {
                  ArrayList var7 = new ArrayList();
                  fn$s var19 = new fn$s(var2, var4, var6.equals("error"));
                  if(var2 != null) {
                     var1.b(var19);
                  }

                  var17 = var0.a("fields");
                  if(var17 == null || !var17.b()) {
                     throw new fo("Record has no fields: " + var0);
                  }

                  Iterator var8 = var17.iterator();

                  while(var8.hasNext()) {
                     hh var9 = (hh)var8.next();
                     String var10 = a(var9, "name", "No field name");
                     String var11 = a(var9, "doc");
                     var17 = var9.a("type");
                     if(var17 == null) {
                        throw new fo("No field type: " + var9);
                     }

                     if(var17.f() && var1.a((Object)var17.i()) == null) {
                        throw new fo(var17 + " is not a defined name. The type of the \"" + var10 + "\" field must be a defined name or a {\"type\": ...} expression.");
                     }

                     fn var12 = a(var17, var1);
                     fn$f$a var18 = fn$f$a.a;
                     hh var23 = var9.a("order");
                     if(var23 != null) {
                        var18 = fn$f$a.valueOf(var23.i().toUpperCase());
                     }

                     var27 = var9.a("default");
                     Object var25 = var27;
                     if(var27 != null) {
                        label222: {
                           if(!fn$v.k.equals(var12.a())) {
                              var25 = var27;
                              if(!fn$v.l.equals(var12.a())) {
                                 break label222;
                              }
                           }

                           var25 = var27;
                           if(var27.f()) {
                              var25 = new rq(Double.valueOf(var27.i()).doubleValue());
                           }
                        }
                     }

                     fn$f var20 = new fn$f(var10, var12, var11, (hh)var25, var18);
                     var29 = var9.r();

                     while(var29.hasNext()) {
                        var6 = (String)var29.next();
                        var10 = var9.a(var6).i();
                        if(!h.contains(var6) && var10 != null) {
                           var20.a(var6, var10);
                        }
                     }

                     fn$f.a(var20, a(var9));
                     var7.add(var20);
                  }

                  var19.c((List)var7);
                  var21 = var19;
               }
            }

            var29 = var0.r();

            while(var29.hasNext()) {
               String var26 = (String)var29.next();
               var6 = var0.a(var26).i();
               if(!g.contains(var26) && var6 != null) {
                  ((fn)var21).a(var26, var6);
               }
            }

            if(var3 != null) {
               var1.a(var3);
            }

            var15 = var21;
            if(var21 instanceof fn$n) {
               Set var13 = a(var0);
               var15 = var21;
               if(var13 != null) {
                  var14 = var13.iterator();

                  while(true) {
                     var15 = var21;
                     if(!var14.hasNext()) {
                        break;
                     }

                     ((fn)var21).d((String)var14.next());
                  }
               }
            }
         }
      }

      return (fn)var15;
   }

   public static fn a(String var0, String var1, String var2, int var3) {
      return new fn$g(new fn$m(var0, var2), var1, var3);
   }

   public static fn a(String var0, String var1, String var2, List var3) {
      return new fn$e(new fn$m(var0, var2), var1, new fn$j(var3));
   }

   public static fn a(String var0, String var1, String var2, boolean var3) {
      return new fn$s(new fn$m(var0, var2), var1, var3);
   }

   public static fn a(List var0) {
      fn var1 = a((String)null, (String)null, (String)null, false);
      var1.c(var0);
      return var1;
   }

   private static String a(fn$m var0, String var1, Map var2) {
      Map var3 = (Map)var2.get(var0);
      if(var3 != null) {
         String var4 = (String)var3.get(var1);
         if(var4 != null) {
            return var4;
         }
      }

      return var1;
   }

   private static String a(hh var0, String var1) {
      var0 = var0.a(var1);
      return var0 != null?var0.i():null;
   }

   private static String a(hh var0, String var1, String var2) {
      var1 = a(var0, var1);
      if(var1 == null) {
         throw new fo(var2 + ": " + var0);
      } else {
         return var1;
      }
   }

   private static Set a(hh var0) {
      hh var1 = var0.a("aliases");
      if(var1 == null) {
         return null;
      } else if(!var1.b()) {
         throw new fo("aliases not an array: " + var0);
      } else {
         LinkedHashSet var3 = new LinkedHashSet();
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            hh var2 = (hh)var4.next();
            if(!var2.f()) {
               throw new fo("alias not a string: " + var2);
            }

            var3.add(var2.i());
         }

         return var3;
      }
   }

   public static fn b(fn var0) {
      return new fn$l(var0);
   }

   public static fn b(List var0) {
      return new fn$w(new fn$j(var0));
   }

   private static void b(fn var0, Map var1, Map var2, Map var3) {
      if(var0 instanceof fn$n) {
         fn$n var4 = (fn$n)var0;
         if(var4.h != null) {
            Iterator var5 = var4.h.iterator();

            while(var5.hasNext()) {
               var2.put((fn$m)var5.next(), var4.f);
            }
         }
      }

      Iterator var10;
      switch(null.a[var0.a().ordinal()]) {
      case 9:
         if(!var1.containsKey(var0)) {
            var1.put(var0, var0);
            fn$s var14 = (fn$s)var0;

            fn$f var7;
            for(Iterator var6 = var0.b().iterator(); var6.hasNext(); b(fn$f.d(var7), var1, var2, var3)) {
               var7 = (fn$f)var6.next();
               String var9;
               Object var11;
               if(fn$f.b(var7) != null) {
                  for(Iterator var8 = fn$f.b(var7).iterator(); var8.hasNext(); ((Map)var11).put(var9, fn$f.e(var7))) {
                     var9 = (String)var8.next();
                     Map var12 = (Map)var3.get(var14.f);
                     var11 = var12;
                     if(var12 == null) {
                        fn$m var13 = var14.f;
                        var11 = new HashMap();
                        var3.put(var13, var11);
                     }
                  }
               }
            }

            if(var14.h != null && var3.containsKey(var14.f)) {
               var10 = var14.h.iterator();

               while(var10.hasNext()) {
                  var3.put((fn$m)var10.next(), var3.get(var14.f));
               }
            }
         }
      case 10:
      default:
         break;
      case 11:
         b(var0.i(), var1, var2, var3);
         return;
      case 12:
         b(var0.j(), var1, var2, var3);
         return;
      case 13:
         var10 = var0.k().iterator();

         while(var10.hasNext()) {
            b((fn)var10.next(), var1, var2, var3);
         }
      }

   }

   // $FF: synthetic method
   static fn$v d(fn var0) {
      return var0.f;
   }

   public static fn f(String var0) {
      return (new fn$q()).a(var0);
   }

   // $FF: synthetic method
   static String g(String var0) {
      return h(var0);
   }

   private static String h(String var0) {
      if(((Boolean)k.get()).booleanValue()) {
         int var3 = var0.length();
         if(var3 == 0) {
            throw new fo("Empty name");
         }

         char var1 = var0.charAt(0);
         if(!Character.isLetter(var1) && var1 != 95) {
            throw new fo("Illegal initial character: " + var0);
         }

         for(int var2 = 1; var2 < var3; ++var2) {
            var1 = var0.charAt(var2);
            if(!Character.isLetterOrDigit(var1) && var1 != 95) {
               throw new fo("Illegal character in: " + var0);
            }
         }
      }

      return var0;
   }

   // $FF: synthetic method
   static Set n() {
      return h;
   }

   // $FF: synthetic method
   static ThreadLocal o() {
      return i;
   }

   // $FF: synthetic method
   static ThreadLocal p() {
      return j;
   }

   // $FF: synthetic method
   static ThreadLocal q() {
      return k;
   }

   public fn$v a() {
      return this.f;
   }

   public String a(String var1) {
      synchronized(this){}

      try {
         var1 = (String)this.c.get(var1);
      } finally {
         ;
      }

      return var1;
   }

   public String a(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   void a(fn$o var1, hf var2) {
      if(this.c.size() == 0) {
         var2.b(this.d());
      } else {
         var2.d();
         var2.a("type", this.d());
         this.c.a(var2);
         var2.e();
      }
   }

   public void a(String var1, String var2) {
      synchronized(this){}

      try {
         this.c.a(var1, var2);
         this.d = Integer.MIN_VALUE;
      } finally {
         ;
      }

   }

   public fn$f b(String var1) {
      throw new fk("Not a record: " + this);
   }

   public List b() {
      throw new fk("Not a record: " + this);
   }

   void b(fn$o var1, hf var2) {
      throw new fk("Not a record: " + this);
   }

   public int c(String var1) {
      throw new fk("Not an enum: " + this);
   }

   public List c() {
      throw new fk("Not an enum: " + this);
   }

   public void c(List var1) {
      throw new fk("Not a record: " + this);
   }

   final boolean c(fn var1) {
      return this.d == var1.d || this.d == Integer.MIN_VALUE || var1.d == Integer.MIN_VALUE;
   }

   public String d() {
      return fn$v.a(this.f);
   }

   public void d(String var1) {
      throw new fk("Not a named type: " + this);
   }

   public Integer e(String var1) {
      throw new fk("Not a union: " + this);
   }

   public String e() {
      return null;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof fn)) {
            return false;
         }

         fn var2 = (fn)var1;
         if(this.f != var2.f) {
            return false;
         }

         if(!this.c(var2) || !this.c.equals(var2.c)) {
            return false;
         }
      }

      return true;
   }

   public String f() {
      throw new fk("Not a named type: " + this);
   }

   public String g() {
      return this.d();
   }

   public boolean h() {
      throw new fk("Not a record: " + this);
   }

   public final int hashCode() {
      if(this.d == Integer.MIN_VALUE) {
         this.d = this.m();
      }

      return this.d;
   }

   public fn i() {
      throw new fk("Not an array: " + this);
   }

   public fn j() {
      throw new fk("Not a map: " + this);
   }

   public List k() {
      throw new fk("Not a union: " + this);
   }

   public int l() {
      throw new fk("Not fixed: " + this);
   }

   int m() {
      return this.a().hashCode() + this.c.hashCode();
   }

   public String toString() {
      return this.a(false);
   }
}
