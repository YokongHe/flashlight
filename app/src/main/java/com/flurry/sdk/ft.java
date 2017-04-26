package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.fn$f$a;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.fp;
import com.flurry.sdk.fs;
import com.flurry.sdk.ft$a;
import com.flurry.sdk.ft$c;
import com.flurry.sdk.ft$d;
import com.flurry.sdk.fu;
import com.flurry.sdk.fw;
import com.flurry.sdk.fx;
import com.flurry.sdk.fz;
import com.flurry.sdk.ge;
import com.flurry.sdk.gy;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ft {
   private static final ft a = new ft();
   private static final fn b;

   static {
      b = fn.a(fn$v.g);
   }

   public static ft a() {
      return a;
   }

   private void a(String var1, StringBuilder var2) {
      for(int var4 = 0; var4 < var1.length(); ++var4) {
         char var3 = var1.charAt(var4);
         switch(var3) {
         case '\b':
            var2.append("\\b");
            continue;
         case '\t':
            var2.append("\\t");
            continue;
         case '\n':
            var2.append("\\n");
            continue;
         case '\f':
            var2.append("\\f");
            continue;
         case '\r':
            var2.append("\\r");
            continue;
         case '\"':
            var2.append("\\\"");
            continue;
         case '/':
            var2.append("\\/");
            continue;
         case '\\':
            var2.append("\\\\");
            continue;
         }

         if((var3 < 0 || var3 > 31) && (var3 < 127 || var3 > 159) && (var3 < 8192 || var3 > 8447)) {
            var2.append(var3);
         } else {
            Integer.toHexString(var3);
            var2.append("\\u");

            for(int var5 = 0; var5 < 4 - var2.length(); ++var5) {
               var2.append('0');
            }

            var2.append(var1.toUpperCase());
         }
      }

   }

   protected int a(int var1, Object var2, fn var3) {
      return var1 * 31 + this.b(var2, var3);
   }

   public int a(fn var1, Object var2) {
      Integer var3 = var1.e(this.b(var2));
      if(var3 != null) {
         return var3.intValue();
      } else {
         throw new fp(var1, var2);
      }
   }

   public int a(Object var1, Object var2, fn var3) {
      return this.a(var1, var2, var3, false);
   }

   protected int a(Object var1, Object var2, fn var3, boolean var4) {
      if(var1 == var2) {
         return 0;
      } else {
         int var5;
         switch(null.a[var3.a().ordinal()]) {
         case 1:
            Iterator var14 = var3.b().iterator();

            while(var14.hasNext()) {
               fn$f var7 = (fn$f)var14.next();
               if(var7.f() != fn$f$a.c) {
                  var5 = var7.b();
                  String var8 = var7.a();
                  var5 = this.a(this.a(var1, var8, var5), this.a(var2, var8, var5), var7.c(), var4);
                  if(var5 != 0) {
                     if(var7.f() == fn$f$a.b) {
                        return -var5;
                     }

                     return var5;
                  }
               }
            }

            return 0;
         case 2:
            return var3.c(var1.toString()) - var3.c(var2.toString());
         case 3:
            Collection var10 = (Collection)var1;
            Collection var13 = (Collection)var2;
            Iterator var12 = var10.iterator();
            Iterator var15 = var13.iterator();
            var3 = var3.i();

            while(var12.hasNext() && var15.hasNext()) {
               var5 = this.a(var12.next(), var15.next(), var3, var4);
               if(var5 != 0) {
                  return var5;
               }
            }

            return var12.hasNext()?1:(var15.hasNext()?-1:0);
         case 4:
            if(var4) {
               if(((Map)var1).equals(var2)) {
                  return 0;
               }

               return 1;
            }

            throw new fk("Can\'t compare maps!");
         case 5:
            var5 = this.a(var3, var1);
            int var6 = this.a(var3, var2);
            if(var5 == var6) {
               return this.a(var1, var2, (fn)var3.k().get(var5), var4);
            }

            return var5 - var6;
         case 6:
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         default:
            return ((Comparable)var1).compareTo(var2);
         case 7:
            gy var9;
            if(var1 instanceof gy) {
               var9 = (gy)var1;
            } else {
               var9 = new gy(var1.toString());
            }

            gy var11;
            if(var2 instanceof gy) {
               var11 = (gy)var2;
            } else {
               var11 = new gy(var2.toString());
            }

            return var9.a(var11);
         case 14:
            return 0;
         }
      }
   }

   public ge a(fn var1) {
      return new fu(var1, var1, this);
   }

   protected Object a(Object var1, fn var2) {
      return null;
   }

   public Object a(Object var1, String var2, int var3) {
      return ((fz)var1).a(var3);
   }

   public Object a(Object var1, byte[] var2, fn var3) {
      fx var4 = (fx)this.c(var1, var3);
      System.arraycopy(var2, 0, var4.b(), 0, var3.l());
      return var4;
   }

   public String a(Object var1) {
      StringBuilder var2 = new StringBuilder();
      this.a(var1, var2);
      return var2.toString();
   }

   public void a(Object var1, String var2, int var3, Object var4) {
      ((fz)var1).a(var3, var4);
   }

   protected void a(Object var1, String var2, int var3, Object var4, Object var5) {
      this.a(var1, var2, var3, var4);
   }

   protected void a(Object var1, StringBuilder var2) {
      int var3 = 0;
      if(this.d(var1)) {
         var2.append("{");
         fn var13 = this.e(var1);
         Iterator var14 = var13.b().iterator();
         var3 = 0;

         while(var14.hasNext()) {
            fn$f var8 = (fn$f)var14.next();
            this.a((Object)var8.a(), (StringBuilder)var2);
            var2.append(": ");
            this.a(this.a(var1, var8.a(), var8.b()), var2);
            ++var3;
            if(var3 < var13.b().size()) {
               var2.append(", ");
            }
         }

         var2.append("}");
      } else if(var1 instanceof Collection) {
         Collection var11 = (Collection)var1;
         var2.append("[");
         long var4 = (long)(var11.size() - 1);

         for(Iterator var12 = var11.iterator(); var12.hasNext(); ++var3) {
            this.a(var12.next(), var2);
            if((long)var3 < var4) {
               var2.append(", ");
            }
         }

         var2.append("]");
      } else if(var1 instanceof Map) {
         var2.append("{");
         Map var10 = (Map)var1;
         Iterator var6 = var10.entrySet().iterator();
         var3 = 0;

         while(var6.hasNext()) {
            Entry var7 = (Entry)var6.next();
            this.a(var7.getKey(), var2);
            var2.append(": ");
            this.a(var7.getValue(), var2);
            ++var3;
            if(var3 < var10.size()) {
               var2.append(", ");
            }
         }

         var2.append("}");
      } else if(!(var1 instanceof CharSequence) && !(var1 instanceof fw)) {
         if(!(var1 instanceof ByteBuffer)) {
            var2.append(var1);
         } else {
            var2.append("{\"bytes\": \"");
            ByteBuffer var9 = (ByteBuffer)var1;

            for(var3 = var9.position(); var3 < var9.limit(); ++var3) {
               var2.append((char)var9.get(var3));
            }

            var2.append("\"}");
         }
      } else {
         var2.append("\"");
         this.a(var1.toString(), var2);
         var2.append("\"");
      }
   }

   public int b(Object var1, fn var2) {
      int var4 = 0;
      if(var1 != null) {
         int var3 = 1;
         switch(null.a[var2.a().ordinal()]) {
         case 1:
            Iterator var8 = var2.b().iterator();
            var3 = 1;

            while(true) {
               var4 = var3;
               if(!var8.hasNext()) {
                  return var4;
               }

               fn$f var5 = (fn$f)var8.next();
               if(var5.f() != fn$f$a.c) {
                  var3 = this.a(var3, this.a(var1, var5.a(), var5.b()), var5.c());
               }
            }
         case 2:
            return var2.c(var1.toString());
         case 3:
            Collection var6 = (Collection)var1;
            var2 = var2.i();

            for(Iterator var7 = var6.iterator(); var7.hasNext(); var3 = this.a(var3, var7.next(), var2)) {
               ;
            }

            return var3;
         case 4:
         case 6:
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         default:
            return var1.hashCode();
         case 5:
            return this.b(var1, (fn)var2.k().get(this.a(var2, var1)));
         case 7:
            if(!(var1 instanceof gy)) {
               var1 = new gy(var1.toString());
            }

            return var1.hashCode();
         case 14:
         }
      }

      return var4;
   }

   public Object b(fn var1, Object var2) {
      Object var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = var2;
         Iterator var12;
         switch(null.a[var1.a().ordinal()]) {
         case 1:
            fz var10 = (fz)var2;
            fz var16 = (fz)this.d((Object)null, var1);
            Iterator var6 = var1.b().iterator();

            while(var6.hasNext()) {
               fn$f var15 = (fn$f)var6.next();
               var16.a(var15.b(), this.b(var15.c(), var10.a(var15.b())));
            }

            return var16;
         case 2:
            break;
         case 3:
            List var14 = (List)var2;
            ft$a var9 = new ft$a(var14.size(), var1);
            var12 = var14.iterator();

            while(var12.hasNext()) {
               Object var13 = var12.next();
               var9.add(this.b(var1.i(), var13));
            }

            return var9;
         case 4:
            Map var11 = (Map)var2;
            HashMap var8 = new HashMap(var11.size());
            var12 = var11.entrySet().iterator();

            while(var12.hasNext()) {
               Entry var4 = (Entry)var12.next();
               var8.put((CharSequence)this.b(b, var4.getKey()), this.b(var1.j(), var4.getValue()));
            }

            return var8;
         case 5:
            return this.b((fn)var1.k().get(this.a(var1, var2)), var2);
         case 6:
            return this.a((Object)null, (byte[])((fx)var2).b(), var1);
         case 7:
            var3 = var2;
            if(!(var2 instanceof String)) {
               if(var2 instanceof gy) {
                  return new gy((gy)var2);
               }

               return new gy(var2.toString());
            }
            break;
         case 8:
            ByteBuffer var5 = (ByteBuffer)var2;
            byte[] var7 = new byte[var5.capacity()];
            var5.rewind();
            var5.get(var7);
            var5.rewind();
            return ByteBuffer.wrap(var7);
         case 9:
            return new Integer(((Integer)var2).intValue());
         case 10:
            return new Long(((Long)var2).longValue());
         case 11:
            return new Float(((Float)var2).floatValue());
         case 12:
            return new Double(((Double)var2).doubleValue());
         case 13:
            return new Boolean(((Boolean)var2).booleanValue());
         case 14:
            return null;
         default:
            throw new fk("Deep copy failed for schema \"" + var1 + "\" and value \"" + var2 + "\"");
         }
      }

      return var3;
   }

   protected Object b(Object var1, String var2, int var3, Object var4) {
      return this.a(var1, var2, var3);
   }

   protected String b(Object var1) {
      if(var1 == null) {
         return fn$v.n.a();
      } else if(this.d(var1)) {
         return this.e(var1).g();
      } else if(this.f(var1)) {
         return this.g(var1).g();
      } else if(this.c(var1)) {
         return fn$v.c.a();
      } else if(this.h(var1)) {
         return fn$v.d.a();
      } else if(this.i(var1)) {
         return this.j(var1).g();
      } else if(this.k(var1)) {
         return fn$v.g.a();
      } else if(this.l(var1)) {
         return fn$v.h.a();
      } else if(var1 instanceof Integer) {
         return fn$v.i.a();
      } else if(var1 instanceof Long) {
         return fn$v.j.a();
      } else if(var1 instanceof Float) {
         return fn$v.k.a();
      } else if(var1 instanceof Double) {
         return fn$v.l.a();
      } else if(var1 instanceof Boolean) {
         return fn$v.m.a();
      } else {
         throw new fk("Unknown datum type: " + var1);
      }
   }

   public Object c(Object var1, fn var2) {
      return var1 instanceof fx && ((fx)var1).b().length == var2.l()?var1:new ft$c(var2);
   }

   protected boolean c(Object var1) {
      return var1 instanceof Collection;
   }

   public Object d(Object var1, fn var2) {
      if(var1 instanceof fz) {
         fz var3 = (fz)var1;
         if(var3.a() == var2) {
            return var3;
         }
      }

      return new ft$d(var2);
   }

   protected boolean d(Object var1) {
      return var1 instanceof fz;
   }

   protected fn e(Object var1) {
      return ((fs)var1).a();
   }

   protected boolean f(Object var1) {
      return var1 instanceof fw;
   }

   protected fn g(Object var1) {
      return ((fs)var1).a();
   }

   protected boolean h(Object var1) {
      return var1 instanceof Map;
   }

   protected boolean i(Object var1) {
      return var1 instanceof fx;
   }

   protected fn j(Object var1) {
      return ((fs)var1).a();
   }

   protected boolean k(Object var1) {
      return var1 instanceof CharSequence;
   }

   protected boolean l(Object var1) {
      return var1 instanceof ByteBuffer;
   }
}
