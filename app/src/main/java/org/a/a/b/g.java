package org.a.a.b;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

public final class g extends org.a.a.b.a {
   // $FF: synthetic field
   final e a;

   protected g(e var1) {
      this.a = var1;
   }

   private Object a(Class var1, org.a.a.g.g var2) {
      Object var8;
      if(var1 == String.class) {
         var8 = ((d)this.a.b.get(org.a.a.g.i.m)).a(var2);
         return var8;
      } else if(var1 != Boolean.class && var1 != Boolean.TYPE) {
         if(var1 != Character.class && var1 != Character.TYPE) {
            if(Date.class.isAssignableFrom(var1)) {
               Date var11 = (Date)((d)this.a.b.get(org.a.a.g.i.j)).a(var2);
               var8 = var11;
               if(var1 != Date.class) {
                  try {
                     var8 = var1.getConstructor(new Class[]{Long.TYPE}).newInstance(new Object[]{Long.valueOf(var11.getTime())});
                     return var8;
                  } catch (Exception var4) {
                     throw new org.a.a.c.c("Cannot construct: \'" + var1 + "\'");
                  }
               } else {
                  return var8;
               }
            } else if(var1 != Float.class && var1 != Double.class && var1 != Float.TYPE && var1 != Double.TYPE && var1 != BigDecimal.class) {
               if(var1 != Byte.class && var1 != Short.class && var1 != Integer.class && var1 != Long.class && var1 != BigInteger.class && var1 != Byte.TYPE && var1 != Short.TYPE && var1 != Integer.TYPE && var1 != Long.TYPE) {
                  if(Enum.class.isAssignableFrom(var1)) {
                     String var9 = var2.b();

                     try {
                        Enum var10 = Enum.valueOf(var1, var9);
                        return var10;
                     } catch (Exception var5) {
                        throw new org.a.a.c.c("Unable to find enum value \'" + var9 + "\' for enum class: " + var1.getName());
                     }
                  } else if(Calendar.class.isAssignableFrom(var1)) {
                     org.a.a.b.x var7 = new org.a.a.b.x();
                     var7.a(var2);
                     return var7.a();
                  } else {
                     throw new org.a.a.c.c("Unsupported class: " + var1);
                  }
               } else {
                  var8 = ((d)this.a.b.get(org.a.a.g.i.h)).a(var2);
                  if(var1 != Byte.class && var1 != Byte.TYPE) {
                     if(var1 != Short.class && var1 != Short.TYPE) {
                        if(var1 != Integer.class && var1 != Integer.TYPE) {
                           if(var1 != Long.class && var1 != Long.TYPE) {
                              return new BigInteger(var8.toString());
                           } else {
                              return new Long(var8.toString());
                           }
                        } else {
                           return Integer.valueOf(Integer.parseInt(var8.toString()));
                        }
                     } else {
                        return new Short(var8.toString());
                     }
                  } else {
                     return new Byte(var8.toString());
                  }
               }
            } else if(var1 == BigDecimal.class) {
               return new BigDecimal(var2.b());
            } else {
               Object var3 = ((d)this.a.b.get(org.a.a.g.i.i)).a(var2);
               if(var1 != Float.class) {
                  var8 = var3;
                  if(var1 != Float.TYPE) {
                     return var8;
                  }
               }

               return new Float(((Double)var3).doubleValue());
            }
         } else {
            String var6 = (String)((d)this.a.b.get(org.a.a.g.i.m)).a(var2);
            if(var6.length() == 0) {
               return null;
            } else if(var6.length() != 1) {
               throw new org.a.a.c.c("Invalid node Character: \'" + var6 + "\'; length: " + var6.length());
            } else {
               return Character.valueOf(var6.charAt(0));
            }
         }
      } else {
         return ((d)this.a.b.get(org.a.a.g.i.k)).a(var2);
      }
   }

   public final Object a(org.a.a.g.d var1) {
      org.a.a.g.g var7 = (org.a.a.g.g)var1;
      Class var6 = var7.g();
      if(!var6.isPrimitive() && var6 != String.class && !Number.class.isAssignableFrom(var6) && var6 != Boolean.class && !Date.class.isAssignableFrom(var6) && var6 != Character.class && var6 != BigInteger.class && var6 != BigDecimal.class && !Enum.class.isAssignableFrom(var6) && !org.a.a.g.i.g.equals(var7.d()) && !Calendar.class.isAssignableFrom(var6)) {
         Constructor[] var8 = var6.getConstructors();
         int var4 = var8.length;
         int var3 = 0;
         Constructor var11 = null;

         int var2;
         Constructor var5;
         for(var2 = 0; var3 < var4; ++var3) {
            var5 = var8[var3];
            if(var5.getParameterTypes().length == 1) {
               ++var2;
               var11 = var5;
            }
         }

         if(var11 == null) {
            throw new org.a.a.c.c("No single argument constructor found for " + var6);
         } else {
            Object var12;
            if(var2 == 1) {
               Object var14 = this.a(var11.getParameterTypes()[0], var7);
               var5 = var11;
               var12 = var14;
            } else {
               e var13 = this.a;
               var12 = var7.b();

               try {
                  var5 = var6.getConstructor(new Class[]{String.class});
               } catch (Exception var10) {
                  throw new org.a.a.b.j((String)null, (org.a.a.c.a)null, "Can\'t construct a java object for scalar " + var7.d() + "; No String constructor found. Exception=" + var10.getMessage(), var7.f(), var10);
               }
            }

            try {
               var12 = var5.newInstance(new Object[]{var12});
               return var12;
            } catch (Exception var9) {
               throw new org.a.a.b.j((String)null, (org.a.a.c.a)null, "Can\'t construct a java object for scalar " + var7.d() + "; exception=" + var9.getMessage(), var7.f(), var9);
            }
         }
      } else {
         return this.a(var6, var7);
      }
   }
}
