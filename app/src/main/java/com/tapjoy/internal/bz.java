package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class bz implements Closeable {
   private final Writer a;
   private final List b = new ArrayList();
   private String c;
   private String d;
   private boolean e;

   public bz(Writer var1) {
      this.b.add(com.tapjoy.internal.bw.f);
      this.d = ":";
      if(var1 == null) {
         throw new NullPointerException("out == null");
      } else {
         this.a = var1;
      }
   }

   private com.tapjoy.internal.bz a(com.tapjoy.internal.bw var1, com.tapjoy.internal.bw var2, String var3) {
      com.tapjoy.internal.bw var4 = this.f();
      if(var4 != var2 && var4 != var1) {
         throw new IllegalStateException("Nesting problem: " + this.b);
      } else {
         this.b.remove(this.b.size() - 1);
         if(var4 == var2) {
            this.h();
         }

         this.a.write(var3);
         return this;
      }
   }

   private com.tapjoy.internal.bz a(com.tapjoy.internal.bw var1, String var2) {
      this.a(true);
      this.b.add(var1);
      this.a.write(var2);
      return this;
   }

   private com.tapjoy.internal.bz a(Collection var1) {
      if(var1 == null) {
         return this.g();
      } else {
         this.a();
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            this.a(var2.next());
         }

         this.b();
         return this;
      }
   }

   private com.tapjoy.internal.bz a(Object[] var1) {
      if(var1 == null) {
         return this.g();
      } else {
         this.a();
         int var3 = var1.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            this.a(var1[var2]);
         }

         this.b();
         return this;
      }
   }

   private void a(com.tapjoy.internal.bw var1) {
      this.b.set(this.b.size() - 1, var1);
   }

   private void a(boolean var1) {
      switch(null.a[this.f().ordinal()]) {
      case 1:
         if(!this.e && !var1) {
            throw new IllegalStateException("JSON must start with an array or an object.");
         }

         this.a(com.tapjoy.internal.bw.g);
         return;
      case 2:
         this.a(com.tapjoy.internal.bw.b);
         this.h();
         return;
      case 3:
         this.a.append(',');
         this.h();
         return;
      case 4:
         this.a.append(this.d);
         this.a(com.tapjoy.internal.bw.e);
         return;
      case 5:
         throw new IllegalStateException("JSON must have only one top-level value.");
      default:
         throw new IllegalStateException("Nesting problem: " + this.b);
      }
   }

   private void c(String var1) {
      this.a.write("\"");
      int var3 = var1.length();

      for(int var2 = 0; var2 < var3; ++var2) {
         char var4 = var1.charAt(var2);
         switch(var4) {
         case '\b':
            this.a.write("\\b");
            continue;
         case '\t':
            this.a.write("\\t");
            continue;
         case '\n':
            this.a.write("\\n");
            continue;
         case '\f':
            this.a.write("\\f");
            continue;
         case '\r':
            this.a.write("\\r");
            continue;
         case '\"':
         case '\\':
            this.a.write(92);
            break;
         case '\u2028':
         case '\u2029':
            this.a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(var4)}));
            continue;
         default:
            if(var4 <= 31) {
               this.a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(var4)}));
               continue;
            }
         }

         this.a.write(var4);
      }

      this.a.write("\"");
   }

   private com.tapjoy.internal.bw f() {
      return (com.tapjoy.internal.bw)this.b.get(this.b.size() - 1);
   }

   private com.tapjoy.internal.bz g() {
      this.a(false);
      this.a.write("null");
      return this;
   }

   private void h() {
      if(this.c != null) {
         this.a.write("\n");

         for(int var1 = 1; var1 < this.b.size(); ++var1) {
            this.a.write(this.c);
         }
      }

   }

   public final com.tapjoy.internal.bz a() {
      return this.a(com.tapjoy.internal.bw.a, "[");
   }

   public final com.tapjoy.internal.bz a(double var1) {
      if(this.e || !Double.isNaN(var1) && !Double.isInfinite(var1)) {
         this.a(false);
         this.a.append(Double.toString(var1));
         return this;
      } else {
         throw new IllegalArgumentException("Numeric values must be finite, but was " + var1);
      }
   }

   public final com.tapjoy.internal.bz a(long var1) {
      this.a(false);
      this.a.write(Long.toString(var1));
      return this;
   }

   public final com.tapjoy.internal.bz a(com.tapjoy.internal.br var1) {
      this.a(false);
      var1.a(this.a);
      return this;
   }

   public final com.tapjoy.internal.bz a(Object var1) {
      com.tapjoy.internal.bz var4;
      if(var1 == null) {
         var4 = this.g();
      } else {
         if(!(var1 instanceof com.tapjoy.internal.bx)) {
            if(var1 instanceof Boolean) {
               boolean var3 = ((Boolean)var1).booleanValue();
               this.a(false);
               Writer var9 = this.a;
               String var7;
               if(var3) {
                  var7 = "true";
               } else {
                  var7 = "false";
               }

               var9.write(var7);
               return this;
            }

            if(var1 instanceof Number) {
               if(var1 instanceof Long) {
                  return this.a(((Number)var1).longValue());
               }

               if(var1 instanceof Double) {
                  return this.a(((Number)var1).doubleValue());
               }

               Number var6 = (Number)var1;
               if(var6 == null) {
                  return this.g();
               }

               String var8 = var6.toString();
               if(this.e || !var8.equals("-Infinity") && !var8.equals("Infinity") && !var8.equals("NaN")) {
                  this.a(false);
                  this.a.append(var8);
                  return this;
               }

               throw new IllegalArgumentException("Numeric values must be finite, but was " + var6);
            }

            if(var1 instanceof String) {
               return this.b((String)var1);
            }

            if(var1 instanceof com.tapjoy.internal.br) {
               return this.a((com.tapjoy.internal.br)var1);
            }

            if(var1 instanceof Collection) {
               return this.a((Collection)var1);
            }

            if(var1 instanceof Map) {
               return this.a((Map)var1);
            }

            if(var1 instanceof Date) {
               Date var5 = (Date)var1;
               if(var5 == null) {
                  return this.g();
               }

               return this.b(com.tapjoy.internal.aa.a(var5));
            }

            if(var1 instanceof Object[]) {
               return this.a((Object[])var1);
            }

            throw new IllegalArgumentException("Unknown type: " + var1.getClass().getName());
         }

         int var2 = this.b.size();
         var4 = this;
         if(this.b.size() != var2) {
            throw new IllegalStateException(var1.getClass().getName() + ".writeToJson(JsonWriter) wrote incomplete value");
         }
      }

      return var4;
   }

   public final com.tapjoy.internal.bz a(String var1) {
      if(var1 == null) {
         throw new NullPointerException("name == null");
      } else {
         com.tapjoy.internal.bw var2 = this.f();
         if(var2 == com.tapjoy.internal.bw.e) {
            this.a.write(44);
         } else if(var2 != com.tapjoy.internal.bw.c) {
            throw new IllegalStateException("Nesting problem: " + this.b);
         }

         this.h();
         this.a(com.tapjoy.internal.bw.d);
         this.c(var1);
         return this;
      }
   }

   public final com.tapjoy.internal.bz a(Map var1) {
      if(var1 == null) {
         return this.g();
      } else {
         this.c();
         Iterator var3 = var1.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var2 = (Entry)var3.next();
            this.a(String.valueOf(var2.getKey()));
            this.a(var2.getValue());
         }

         this.d();
         return this;
      }
   }

   public final com.tapjoy.internal.bz b() {
      return this.a(com.tapjoy.internal.bw.a, com.tapjoy.internal.bw.b, "]");
   }

   public final com.tapjoy.internal.bz b(String var1) {
      if(var1 == null) {
         return this.g();
      } else {
         this.a(false);
         this.c(var1);
         return this;
      }
   }

   public final com.tapjoy.internal.bz c() {
      return this.a(com.tapjoy.internal.bw.c, "{");
   }

   public final void close() {
      this.a.close();
      if(this.f() != com.tapjoy.internal.bw.g) {
         throw new IOException("Incomplete document");
      }
   }

   public final com.tapjoy.internal.bz d() {
      return this.a(com.tapjoy.internal.bw.c, com.tapjoy.internal.bw.e, "}");
   }

   public final void e() {
      this.a.flush();
   }
}
