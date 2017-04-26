package com.millennialmedia.a.a;

import java.math.BigInteger;

public final class o extends j {
   private static final Class[] a;
   private Object b;

   static {
      a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
   }

   public o(Boolean var1) {
      this.a((Object)var1);
   }

   public o(Number var1) {
      this.a((Object)var1);
   }

   public o(String var1) {
      this.a((Object)var1);
   }

   private void a(Object var1) {
      boolean var4 = false;
      if(var1 instanceof Character) {
         this.b = String.valueOf(((Character)var1).charValue());
      } else {
         label32: {
            if(!(var1 instanceof Number)) {
               boolean var7;
               if(var1 instanceof String) {
                  var7 = true;
               } else {
                  Class var5 = var1.getClass();
                  Class[] var6 = a;
                  int var3 = var6.length;
                  int var2 = 0;

                  while(true) {
                     if(var2 >= var3) {
                        var7 = false;
                        break;
                     }

                     if(var6[var2].isAssignableFrom(var5)) {
                        var7 = true;
                        break;
                     }

                     ++var2;
                  }
               }

               if(!var7) {
                  break label32;
               }
            }

            var4 = true;
         }

         com.millennialmedia.a.a.b.a.a(var4);
         this.b = var1;
      }
   }

   private static boolean a(o var0) {
      if(var0.b instanceof Number) {
         Number var1 = (Number)var0.b;
         return var1 instanceof BigInteger || var1 instanceof Long || var1 instanceof Integer || var1 instanceof Short || var1 instanceof Byte;
      } else {
         return false;
      }
   }

   public final Number a() {
      return (Number)(this.b instanceof String?new b.i((String)this.b):(Number)this.b);
   }

   public final String b() {
      return this.b instanceof Number?this.a().toString():(this.b instanceof Boolean?((Boolean)this.b).toString():(String)this.b);
   }

   public final double c() {
      return this.b instanceof Number?this.a().doubleValue():Double.parseDouble(this.b());
   }

   public final long d() {
      return this.b instanceof Number?this.a().longValue():Long.parseLong(this.b());
   }

   public final int e() {
      return this.b instanceof Number?this.a().intValue():Integer.parseInt(this.b());
   }

   public final boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && this.getClass() == var1.getClass()) {
            o var6 = (o)var1;
            if(this.b == null) {
               if(var6.b != null) {
                  return false;
               } else {
                  return true;
               }
            } else if(a(this) && a(var6)) {
               if(this.a().longValue() != var6.a().longValue()) {
                  return false;
               } else {
                  return true;
               }
            } else if(this.b instanceof Number && var6.b instanceof Number) {
               double var2 = this.a().doubleValue();
               double var4 = var6.a().doubleValue();
               if(var2 == var4 || Double.isNaN(var2) && Double.isNaN(var4)) {
                  return true;
               } else {
                  return false;
               }
            } else {
               return this.b.equals(var6.b);
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public final boolean f() {
      return this.b instanceof Boolean?((Boolean)this.b).booleanValue():Boolean.parseBoolean(this.b());
   }

   public final int hashCode() {
      if(this.b == null) {
         return 31;
      } else {
         long var1;
         if(a(this)) {
            var1 = this.a().longValue();
            return (int)(var1 ^ var1 >>> 32);
         } else if(this.b instanceof Number) {
            var1 = Double.doubleToLongBits(this.a().doubleValue());
            return (int)(var1 ^ var1 >>> 32);
         } else {
            return this.b.hashCode();
         }
      }
   }

   public final boolean n() {
      return this.b instanceof Boolean;
   }

   public final boolean o() {
      return this.b instanceof Number;
   }

   public final boolean p() {
      return this.b instanceof String;
   }
}
