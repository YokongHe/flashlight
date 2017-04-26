package com.flurry.sdk;

import com.flurry.sdk.qp;
import com.flurry.sdk.qs;
import com.flurry.sdk.sh;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class qr {
   public static final sh a = new qp(Object.class);
   private static final sh[] g = new sh[0];
   protected final qs b;
   protected final sh c;
   protected final Class d;
   protected Map e;
   protected HashSet f;
   private final qr h;

   private qr(qs var1, qr var2, Class var3, sh var4) {
      this.b = var1;
      this.h = var2;
      this.d = var3;
      this.c = var4;
   }

   public qr(qs var1, sh var2) {
      this(var1, (qr)null, var2.p(), var2);
   }

   public qr(qs var1, Class var2) {
      this(var1, (qr)null, var2, (sh)null);
   }

   public qr a() {
      return new qr(this.b, this, this.d, this.c);
   }

   public sh a(String var1) {
      if(this.e == null) {
         this.c();
      }

      sh var2 = (sh)this.e.get(var1);
      if(var2 != null) {
         return var2;
      } else if(this.f != null && this.f.contains(var1)) {
         return a;
      } else if(this.h != null) {
         return this.h.a(var1);
      } else if(this.d != null && this.d.getEnclosingClass() != null && !Modifier.isStatic(this.d.getModifiers())) {
         return a;
      } else {
         String var3;
         if(this.d != null) {
            var3 = this.d.getName();
         } else if(this.c != null) {
            var3 = this.c.toString();
         } else {
            var3 = "UNKNOWN";
         }

         throw new IllegalArgumentException("Type variable \'" + var1 + "\' can not be resolved (with context of class " + var3 + ")");
      }
   }

   public sh a(Type var1) {
      return this.b.b(var1, this);
   }

   public void a(String var1, sh var2) {
      if(this.e == null || this.e.size() == 0) {
         this.e = new LinkedHashMap();
      }

      this.e.put(var1, var2);
   }

   public void b(String var1) {
      if(this.f == null) {
         this.f = new HashSet();
      }

      this.f.add(var1);
   }

   protected void b(Type var1) {
      byte var3 = 0;
      if(var1 != null) {
         int var2;
         int var4;
         TypeVariable[] var6;
         Class var10;
         if(var1 instanceof ParameterizedType) {
            ParameterizedType var9 = (ParameterizedType)var1;
            Type[] var5 = var9.getActualTypeArguments();
            if(var5 != null && var5.length > 0) {
               Class var7 = (Class)var9.getRawType();
               var6 = var7.getTypeParameters();
               if(var6.length != var5.length) {
                  throw new IllegalArgumentException("Strange parametrized type (in class " + var7.getName() + "): number of type arguments != number of type parameters (" + var5.length + " vs " + var6.length + ")");
               }

               var4 = var5.length;

               for(var2 = 0; var2 < var4; ++var2) {
                  String var15 = var6[var2].getName();
                  if(this.e == null) {
                     this.e = new LinkedHashMap();
                  } else if(this.e.containsKey(var15)) {
                     continue;
                  }

                  this.b(var15);
                  this.e.put(var15, this.b.b(var5[var2], this));
               }
            }

            var10 = (Class)var9.getRawType();
         } else {
            if(!(var1 instanceof Class)) {
               return;
            }

            Class var13 = (Class)var1;
            this.b((Type)var13.getDeclaringClass());
            TypeVariable[] var16 = var13.getTypeParameters();
            if(var16 != null && var16.length > 0) {
               var6 = null;
               sh[] var11 = var6;
               if(this.c != null) {
                  var11 = var6;
                  if(var13.isAssignableFrom(this.c.p())) {
                     var11 = this.b.b(this.c, var13);
                  }
               }

               for(var2 = 0; var2 < var16.length; ++var2) {
                  TypeVariable var8 = var16[var2];
                  String var14 = var8.getName();
                  Type var17 = var8.getBounds()[0];
                  if(var17 != null) {
                     if(this.e == null) {
                        this.e = new LinkedHashMap();
                     } else if(this.e.containsKey(var14)) {
                        continue;
                     }

                     this.b(var14);
                     if(var11 != null) {
                        this.e.put(var14, var11[var2]);
                     } else {
                        this.e.put(var14, this.b.b(var17, this));
                     }
                  }
               }
            }

            var10 = var13;
         }

         this.b(var10.getGenericSuperclass());
         Type[] var12 = var10.getGenericInterfaces();
         var4 = var12.length;

         for(var2 = var3; var2 < var4; ++var2) {
            this.b(var12[var2]);
         }
      }

   }

   public sh[] b() {
      if(this.e == null) {
         this.c();
      }

      return this.e.size() == 0?g:(sh[])this.e.values().toArray(new sh[this.e.size()]);
   }

   protected void c() {
      this.b((Type)this.d);
      if(this.c != null) {
         int var2 = this.c.h();
         if(var2 > 0) {
            if(this.e == null) {
               this.e = new LinkedHashMap();
            }

            for(int var1 = 0; var1 < var2; ++var1) {
               String var3 = this.c.a(var1);
               sh var4 = this.c.b(var1);
               this.e.put(var3, var4);
            }
         }
      }

      if(this.e == null) {
         this.e = Collections.emptyMap();
      }

   }

   public String toString() {
      if(this.e == null) {
         this.c();
      }

      StringBuilder var1 = new StringBuilder("[TypeBindings for ");
      if(this.c != null) {
         var1.append(this.c.toString());
      } else {
         var1.append(this.d.getName());
      }

      var1.append(": ").append(this.e).append("]");
      return var1.toString();
   }
}
