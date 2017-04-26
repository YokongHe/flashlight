package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hj$b;
import com.flurry.sdk.hm;
import com.flurry.sdk.ii;
import com.flurry.sdk.is;
import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.jc;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;
import com.flurry.sdk.kb;
import com.flurry.sdk.sh;
import java.util.Date;

public abstract class lz extends jg {
   protected final Class q;

   protected lz(sh var1) {
      Class var2;
      if(var1 == null) {
         var2 = null;
      } else {
         var2 = var1.p();
      }

      this.q = var2;
   }

   protected lz(Class var1) {
      this.q = var1;
   }

   protected static final double b(String var0) {
      return "2.2250738585072012e-308".equals(var0)?2.2250738585072014E-308D:Double.parseDouble(var0);
   }

   protected final double A(hj var1, iz var2) {
      double var3 = 0.0D;
      hm var5 = var1.e();
      if(var5 != hm.i && var5 != hm.j) {
         if(var5 == hm.h) {
            String var7 = var1.k().trim();
            if(var7.length() != 0) {
               switch(var7.charAt(0)) {
               case '-':
                  if("-Infinity".equals(var7) || "-INF".equals(var7)) {
                     return Double.NEGATIVE_INFINITY;
                  }
                  break;
               case 'I':
                  if(!"Infinity".equals(var7) && !"INF".equals(var7)) {
                     break;
                  }

                  return Double.POSITIVE_INFINITY;
               case 'N':
                  if("NaN".equals(var7)) {
                     return Double.NaN;
                  }
               }

               try {
                  var3 = b(var7);
                  return var3;
               } catch (IllegalArgumentException var6) {
                  throw var2.b(this.q, "not a valid double value");
               }
            }
         } else if(var5 != hm.m) {
            throw var2.a(this.q, var5);
         }
      } else {
         var3 = var1.x();
      }

      return var3;
   }

   protected Date B(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 == hm.i) {
         return new Date(var1.u());
      } else if(var3 == hm.m) {
         return (Date)this.b();
      } else if(var3 == hm.h) {
         try {
            String var5 = var1.k().trim();
            if(var5.length() == 0) {
               return (Date)this.c();
            } else {
               Date var6 = var2.a(var5);
               return var6;
            }
         } catch (IllegalArgumentException var4) {
            throw var2.b(this.q, "not a valid representation (error: " + var4.getMessage() + ")");
         }
      } else {
         throw var2.a(this.q, var3);
      }
   }

   protected jg a(iy var1, jc var2, sh var3, is var4) {
      return var2.a(var1, var3, var4);
   }

   public Object a(hj var1, iz var2, jy var3) {
      return var3.d(var1, var2);
   }

   protected void a(hj var1, iz var2, Object var3, String var4) {
      Object var5 = var3;
      if(var3 == null) {
         var5 = this.f();
      }

      if(!var2.a(var1, this, var5, var4)) {
         this.a(var2, var5, var4);
         var1.d();
      }
   }

   protected void a(iz var1, Object var2, String var3) {
      if(var1.a(iy$a.k)) {
         throw var1.a(var2, var3);
      }
   }

   protected boolean a(jg var1) {
      return var1 != null && var1.getClass().getAnnotation(kb.class) != null;
   }

   public Class f() {
      return this.q;
   }

   protected final boolean n(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 != hm.k) {
         if(var3 == hm.l) {
            return false;
         }

         if(var3 == hm.m) {
            return false;
         }

         if(var3 == hm.i) {
            if(var1.q() != hj$b.a) {
               return this.p(var1, var2);
            }

            if(var1.t() == 0) {
               return false;
            }
         } else {
            if(var3 != hm.h) {
               throw var2.a(this.q, var3);
            }

            String var4 = var1.k().trim();
            if(!"true".equals(var4)) {
               if(!"false".equals(var4) && var4.length() != 0) {
                  throw var2.b(this.q, "only \"true\" or \"false\" recognized");
               }

               return Boolean.FALSE.booleanValue();
            }
         }
      }

      return true;
   }

   protected final Boolean o(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 == hm.k) {
         return Boolean.TRUE;
      } else if(var3 == hm.l) {
         return Boolean.FALSE;
      } else if(var3 == hm.i) {
         return var1.q() == hj$b.a?(var1.t() == 0?Boolean.FALSE:Boolean.TRUE):Boolean.valueOf(this.p(var1, var2));
      } else if(var3 == hm.m) {
         return (Boolean)this.b();
      } else if(var3 == hm.h) {
         String var4 = var1.k().trim();
         if("true".equals(var4)) {
            return Boolean.TRUE;
         } else if("false".equals(var4)) {
            return Boolean.FALSE;
         } else if(var4.length() == 0) {
            return (Boolean)this.c();
         } else {
            throw var2.b(this.q, "only \"true\" or \"false\" recognized");
         }
      } else {
         throw var2.a(this.q, var3);
      }
   }

   protected final boolean p(hj var1, iz var2) {
      if(var1.q() == hj$b.b) {
         Boolean var4;
         if(var1.u() == 0L) {
            var4 = Boolean.FALSE;
         } else {
            var4 = Boolean.TRUE;
         }

         return var4.booleanValue();
      } else {
         String var3 = var1.k();
         return !"0.0".equals(var3) && !"0".equals(var3)?Boolean.TRUE.booleanValue():Boolean.FALSE.booleanValue();
      }
   }

   protected Byte q(hj var1, iz var2) {
      hm var4 = var1.e();
      if(var4 != hm.i && var4 != hm.j) {
         if(var4 == hm.h) {
            String var6 = var1.k().trim();

            int var3;
            try {
               if(var6.length() == 0) {
                  return (Byte)this.c();
               }

               var3 = ii.a(var6);
            } catch (IllegalArgumentException var5) {
               throw var2.b(this.q, "not a valid Byte value");
            }

            if(var3 >= -128 && var3 <= 127) {
               return Byte.valueOf((byte)var3);
            } else {
               throw var2.b(this.q, "overflow, value can not be represented as 8-bit value");
            }
         } else if(var4 == hm.m) {
            return (Byte)this.b();
         } else {
            throw var2.a(this.q, var4);
         }
      } else {
         return Byte.valueOf(var1.r());
      }
   }

   protected Short r(hj var1, iz var2) {
      hm var4 = var1.e();
      if(var4 != hm.i && var4 != hm.j) {
         if(var4 == hm.h) {
            String var6 = var1.k().trim();

            int var3;
            try {
               if(var6.length() == 0) {
                  return (Short)this.c();
               }

               var3 = ii.a(var6);
            } catch (IllegalArgumentException var5) {
               throw var2.b(this.q, "not a valid Short value");
            }

            if(var3 >= -32768 && var3 <= 32767) {
               return Short.valueOf((short)var3);
            } else {
               throw var2.b(this.q, "overflow, value can not be represented as 16-bit value");
            }
         } else if(var4 == hm.m) {
            return (Short)this.b();
         } else {
            throw var2.a(this.q, var4);
         }
      } else {
         return Short.valueOf(var1.s());
      }
   }

   protected final short s(hj var1, iz var2) {
      int var3 = this.t(var1, var2);
      if(var3 >= -32768 && var3 <= 32767) {
         return (short)var3;
      } else {
         throw var2.b(this.q, "overflow, value can not be represented as 16-bit value");
      }
   }

   protected final int t(hj param1, iz param2) {
      // $FF: Couldn't be decompiled
   }

   protected final Integer u(hj param1, iz param2) {
      // $FF: Couldn't be decompiled
   }

   protected final Long v(hj var1, iz var2) {
      hm var5 = var1.e();
      if(var5 != hm.i && var5 != hm.j) {
         if(var5 == hm.h) {
            String var7 = var1.k().trim();
            if(var7.length() == 0) {
               return (Long)this.c();
            } else {
               long var3;
               try {
                  var3 = ii.b(var7);
               } catch (IllegalArgumentException var6) {
                  throw var2.b(this.q, "not a valid Long value");
               }

               return Long.valueOf(var3);
            }
         } else if(var5 == hm.m) {
            return (Long)this.b();
         } else {
            throw var2.a(this.q, var5);
         }
      } else {
         return Long.valueOf(var1.u());
      }
   }

   protected final long w(hj var1, iz var2) {
      long var3 = 0L;
      hm var5 = var1.e();
      if(var5 != hm.i && var5 != hm.j) {
         if(var5 == hm.h) {
            String var7 = var1.k().trim();
            if(var7.length() != 0) {
               try {
                  var3 = ii.b(var7);
                  return var3;
               } catch (IllegalArgumentException var6) {
                  throw var2.b(this.q, "not a valid long value");
               }
            }
         } else if(var5 != hm.m) {
            throw var2.a(this.q, var5);
         }
      } else {
         var3 = var1.u();
      }

      return var3;
   }

   protected final Float x(hj var1, iz var2) {
      hm var4 = var1.e();
      if(var4 != hm.i && var4 != hm.j) {
         if(var4 == hm.h) {
            String var6 = var1.k().trim();
            if(var6.length() == 0) {
               return (Float)this.c();
            } else {
               switch(var6.charAt(0)) {
               case '-':
                  if("-Infinity".equals(var6) || "-INF".equals(var6)) {
                     return Float.valueOf(Float.NEGATIVE_INFINITY);
                  }
                  break;
               case 'I':
                  if(!"Infinity".equals(var6) && !"INF".equals(var6)) {
                     break;
                  }

                  return Float.valueOf(Float.POSITIVE_INFINITY);
               case 'N':
                  if("NaN".equals(var6)) {
                     return Float.valueOf(Float.NaN);
                  }
               }

               float var3;
               try {
                  var3 = Float.parseFloat(var6);
               } catch (IllegalArgumentException var5) {
                  throw var2.b(this.q, "not a valid Float value");
               }

               return Float.valueOf(var3);
            }
         } else if(var4 == hm.m) {
            return (Float)this.b();
         } else {
            throw var2.a(this.q, var4);
         }
      } else {
         return Float.valueOf(var1.w());
      }
   }

   protected final float y(hj var1, iz var2) {
      float var3 = 0.0F;
      hm var4 = var1.e();
      if(var4 != hm.i && var4 != hm.j) {
         if(var4 == hm.h) {
            String var6 = var1.k().trim();
            if(var6.length() != 0) {
               switch(var6.charAt(0)) {
               case '-':
                  if("-Infinity".equals(var6) || "-INF".equals(var6)) {
                     return Float.NEGATIVE_INFINITY;
                  }
                  break;
               case 'I':
                  if(!"Infinity".equals(var6) && !"INF".equals(var6)) {
                     break;
                  }

                  return Float.POSITIVE_INFINITY;
               case 'N':
                  if("NaN".equals(var6)) {
                     return Float.NaN;
                  }
               }

               try {
                  var3 = Float.parseFloat(var6);
                  return var3;
               } catch (IllegalArgumentException var5) {
                  throw var2.b(this.q, "not a valid float value");
               }
            }
         } else if(var4 != hm.m) {
            throw var2.a(this.q, var4);
         }
      } else {
         var3 = var1.w();
      }

      return var3;
   }

   protected final Double z(hj var1, iz var2) {
      hm var5 = var1.e();
      if(var5 != hm.i && var5 != hm.j) {
         if(var5 == hm.h) {
            String var7 = var1.k().trim();
            if(var7.length() == 0) {
               return (Double)this.c();
            } else {
               switch(var7.charAt(0)) {
               case '-':
                  if("-Infinity".equals(var7) || "-INF".equals(var7)) {
                     return Double.valueOf(Double.NEGATIVE_INFINITY);
                  }
                  break;
               case 'I':
                  if("Infinity".equals(var7) || "INF".equals(var7)) {
                     return Double.valueOf(Double.POSITIVE_INFINITY);
                  }
                  break;
               case 'N':
                  if("NaN".equals(var7)) {
                     return Double.valueOf(Double.NaN);
                  }
               }

               double var3;
               try {
                  var3 = b(var7);
               } catch (IllegalArgumentException var6) {
                  throw var2.b(this.q, "not a valid Double value");
               }

               return Double.valueOf(var3);
            }
         } else if(var5 == hm.m) {
            return (Double)this.b();
         } else {
            throw var2.a(this.q, var5);
         }
      } else {
         return Double.valueOf(var1.x());
      }
   }
}
