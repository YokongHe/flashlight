package com.millennialmedia.a.a.b.a;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.Map.Entry;

public final class p {
   public static final com.millennialmedia.a.a.s A;
   public static final com.millennialmedia.a.a.t B;
   public static final com.millennialmedia.a.a.s C;
   public static final com.millennialmedia.a.a.t D;
   public static final com.millennialmedia.a.a.s E;
   public static final com.millennialmedia.a.a.t F;
   public static final com.millennialmedia.a.a.s G;
   public static final com.millennialmedia.a.a.t H;
   public static final com.millennialmedia.a.a.s I;
   public static final com.millennialmedia.a.a.t J;
   public static final com.millennialmedia.a.a.t K;
   public static final com.millennialmedia.a.a.s L;
   public static final com.millennialmedia.a.a.t M;
   public static final com.millennialmedia.a.a.s N;
   public static final com.millennialmedia.a.a.t O;
   public static final com.millennialmedia.a.a.s P;
   public static final com.millennialmedia.a.a.t Q;
   public static final com.millennialmedia.a.a.t R;
   public static final com.millennialmedia.a.a.s a = new com.millennialmedia.a.a.s() {
      // $FF: synthetic method
      public final Object a(com.millennialmedia.a.a.d.a var1) {
         if(var1.f() == com.millennialmedia.a.a.d.b.i) {
            var1.j();
            return null;
         } else {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
         }
      }

      // $FF: synthetic method
      public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
         Class var3 = (Class)var2;
         if(var3 == null) {
            var1.f();
         } else {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + var3.getName() + ". Forgot to register a type adapter?");
         }
      }
   };
   public static final com.millennialmedia.a.a.t b;
   public static final com.millennialmedia.a.a.s c;
   public static final com.millennialmedia.a.a.t d;
   public static final com.millennialmedia.a.a.s e;
   public static final com.millennialmedia.a.a.s f;
   public static final com.millennialmedia.a.a.t g;
   public static final com.millennialmedia.a.a.s h;
   public static final com.millennialmedia.a.a.t i;
   public static final com.millennialmedia.a.a.s j;
   public static final com.millennialmedia.a.a.t k;
   public static final com.millennialmedia.a.a.s l;
   public static final com.millennialmedia.a.a.t m;
   public static final com.millennialmedia.a.a.s n;
   public static final com.millennialmedia.a.a.s o;
   public static final com.millennialmedia.a.a.s p;
   public static final com.millennialmedia.a.a.s q;
   public static final com.millennialmedia.a.a.t r;
   public static final com.millennialmedia.a.a.s s;
   public static final com.millennialmedia.a.a.t t;
   public static final com.millennialmedia.a.a.s u;
   public static final com.millennialmedia.a.a.s v;
   public static final com.millennialmedia.a.a.s w;
   public static final com.millennialmedia.a.a.t x;
   public static final com.millennialmedia.a.a.s y;
   public static final com.millennialmedia.a.a.t z;

   static {
      b = a(Class.class, a);
      c = new com.millennialmedia.a.a.s() {
         private static BitSet b(com.millennialmedia.a.a.d.a var0) {
            if(var0.f() == com.millennialmedia.a.a.d.b.i) {
               var0.j();
               return null;
            } else {
               BitSet var5 = new BitSet();
               var0.a();
               com.millennialmedia.a.a.d.b var4 = var0.f();

               for(int var1 = 0; var4 != com.millennialmedia.a.a.d.b.b; var4 = var0.f()) {
                  boolean var3;
                  switch(null.a[var4.ordinal()]) {
                  case 1:
                     if(var0.m() != 0) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }
                     break;
                  case 2:
                     var3 = var0.i();
                     break;
                  case 3:
                     String var7 = var0.h();

                     int var2;
                     try {
                        var2 = Integer.parseInt(var7);
                     } catch (NumberFormatException var6) {
                        throw new com.millennialmedia.a.a.q("Error: Expecting: bitset number value (1, 0), Found: " + var7);
                     }

                     if(var2 != 0) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }
                     break;
                  default:
                     throw new com.millennialmedia.a.a.q("Invalid bitset value type: " + var4);
                  }

                  if(var3) {
                     var5.set(var1);
                  }

                  ++var1;
               }

               var0.b();
               return var5;
            }
         }

         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            return b(var1);
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            BitSet var5 = (BitSet)var2;
            if(var5 == null) {
               var1.f();
            } else {
               var1.b();

               for(int var3 = 0; var3 < var5.length(); ++var3) {
                  byte var4;
                  if(var5.get(var3)) {
                     var4 = 1;
                  } else {
                     var4 = 0;
                  }

                  var1.a((long)var4);
               }

               var1.c();
            }
         }
      };
      d = a(BitSet.class, c);
      e = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return var1.f() == com.millennialmedia.a.a.d.b.f?Boolean.valueOf(Boolean.parseBoolean(var1.h())):Boolean.valueOf(var1.i());
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            Boolean var3 = (Boolean)var2;
            if(var3 == null) {
               var1.f();
            } else {
               var1.a(var3.booleanValue());
            }
         }
      };
      f = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return Boolean.valueOf(var1.h());
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            Boolean var3 = (Boolean)var2;
            String var4;
            if(var3 == null) {
               var4 = "null";
            } else {
               var4 = var3.toString();
            }

            var1.b(var4);
         }
      };
      g = a(Boolean.TYPE, Boolean.class, e);
      h = new com.millennialmedia.a.a.s() {
         private static Number b(com.millennialmedia.a.a.d.a var0) {
            if(var0.f() == com.millennialmedia.a.a.d.b.i) {
               var0.j();
               return null;
            } else {
               byte var1;
               try {
                  var1 = (byte)var0.m();
               } catch (NumberFormatException var2) {
                  throw new com.millennialmedia.a.a.q(var2);
               }

               return Byte.valueOf(var1);
            }
         }

         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            return b(var1);
         }
      };
      i = a(Byte.TYPE, Byte.class, h);
      j = new com.millennialmedia.a.a.s() {
         private static Number b(com.millennialmedia.a.a.d.a var0) {
            if(var0.f() == com.millennialmedia.a.a.d.b.i) {
               var0.j();
               return null;
            } else {
               short var1;
               try {
                  var1 = (short)var0.m();
               } catch (NumberFormatException var2) {
                  throw new com.millennialmedia.a.a.q(var2);
               }

               return Short.valueOf(var1);
            }
         }

         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            return b(var1);
         }
      };
      k = a(Short.TYPE, Short.class, j);
      l = new com.millennialmedia.a.a.s() {
         private static Number b(com.millennialmedia.a.a.d.a var0) {
            if(var0.f() == com.millennialmedia.a.a.d.b.i) {
               var0.j();
               return null;
            } else {
               int var1;
               try {
                  var1 = var0.m();
               } catch (NumberFormatException var2) {
                  throw new com.millennialmedia.a.a.q(var2);
               }

               return Integer.valueOf(var1);
            }
         }

         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            return b(var1);
         }
      };
      m = a(Integer.TYPE, Integer.class, l);
      n = new com.millennialmedia.a.a.s() {
         private static Number b(com.millennialmedia.a.a.d.a var0) {
            if(var0.f() == com.millennialmedia.a.a.d.b.i) {
               var0.j();
               return null;
            } else {
               long var1;
               try {
                  var1 = var0.l();
               } catch (NumberFormatException var3) {
                  throw new com.millennialmedia.a.a.q(var3);
               }

               return Long.valueOf(var1);
            }
         }

         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            return b(var1);
         }
      };
      o = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return Float.valueOf((float)var1.k());
            }
         }
      };
      p = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return Double.valueOf(var1.k());
            }
         }
      };
      q = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            com.millennialmedia.a.a.d.b var2 = var1.f();
            switch(null.a[var2.ordinal()]) {
            case 1:
               return new com.millennialmedia.a.a.b.i(var1.h());
            case 2:
            case 3:
            default:
               throw new com.millennialmedia.a.a.q("Expecting number, got: " + var2);
            case 4:
               var1.j();
               return null;
            }
         }
      };
      r = a(Number.class, q);
      s = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               String var2 = var1.h();
               if(var2.length() != 1) {
                  throw new com.millennialmedia.a.a.q("Expecting character, got: " + var2);
               } else {
                  return Character.valueOf(var2.charAt(0));
               }
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            Character var3 = (Character)var2;
            String var4;
            if(var3 == null) {
               var4 = null;
            } else {
               var4 = String.valueOf(var3);
            }

            var1.b(var4);
         }
      };
      t = a(Character.TYPE, Character.class, s);
      u = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            com.millennialmedia.a.a.d.b var2 = var1.f();
            if(var2 == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return var2 == com.millennialmedia.a.a.d.b.h?Boolean.toString(var1.i()):var1.h();
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            var1.b((String)var2);
         }
      };
      v = new com.millennialmedia.a.a.s() {
         private static BigDecimal b(com.millennialmedia.a.a.d.a var0) {
            if(var0.f() == com.millennialmedia.a.a.d.b.i) {
               var0.j();
               return null;
            } else {
               try {
                  BigDecimal var2 = new BigDecimal(var0.h());
                  return var2;
               } catch (NumberFormatException var1) {
                  throw new com.millennialmedia.a.a.q(var1);
               }
            }
         }

         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            return b(var1);
         }
      };
      w = new com.millennialmedia.a.a.s() {
         private static BigInteger b(com.millennialmedia.a.a.d.a var0) {
            if(var0.f() == com.millennialmedia.a.a.d.b.i) {
               var0.j();
               return null;
            } else {
               try {
                  BigInteger var2 = new BigInteger(var0.h());
                  return var2;
               } catch (NumberFormatException var1) {
                  throw new com.millennialmedia.a.a.q(var1);
               }
            }
         }

         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            return b(var1);
         }
      };
      x = a(String.class, u);
      y = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return new StringBuilder(var1.h());
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            StringBuilder var3 = (StringBuilder)var2;
            String var4;
            if(var3 == null) {
               var4 = null;
            } else {
               var4 = var3.toString();
            }

            var1.b(var4);
         }
      };
      z = a(StringBuilder.class, y);
      A = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return new StringBuffer(var1.h());
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            StringBuffer var3 = (StringBuffer)var2;
            String var4;
            if(var3 == null) {
               var4 = null;
            } else {
               var4 = var3.toString();
            }

            var1.b(var4);
         }
      };
      B = a(StringBuffer.class, A);
      C = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
            } else {
               String var2 = var1.h();
               if(!"null".equals(var2)) {
                  return new URL(var2);
               }
            }

            return null;
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            URL var3 = (URL)var2;
            String var4;
            if(var3 == null) {
               var4 = null;
            } else {
               var4 = var3.toExternalForm();
            }

            var1.b(var4);
         }
      };
      D = a(URL.class, C);
      E = new com.millennialmedia.a.a.s() {
         private static URI b(com.millennialmedia.a.a.d.a var0) {
            if(var0.f() == com.millennialmedia.a.a.d.b.i) {
               var0.j();
            } else {
               try {
                  String var2 = var0.h();
                  if(!"null".equals(var2)) {
                     URI var3 = new URI(var2);
                     return var3;
                  }
               } catch (URISyntaxException var1) {
                  throw new com.millennialmedia.a.a.k(var1);
               }
            }

            return null;
         }

         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            return b(var1);
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            URI var3 = (URI)var2;
            String var4;
            if(var3 == null) {
               var4 = null;
            } else {
               var4 = var3.toASCIIString();
            }

            var1.b(var4);
         }
      };
      F = a(URI.class, E);
      G = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return InetAddress.getByName(var1.h());
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            InetAddress var3 = (InetAddress)var2;
            String var4;
            if(var3 == null) {
               var4 = null;
            } else {
               var4 = var3.getHostAddress();
            }

            var1.b(var4);
         }
      };
      H = b(InetAddress.class, G);
      I = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return UUID.fromString(var1.h());
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            UUID var3 = (UUID)var2;
            String var4;
            if(var3 == null) {
               var4 = null;
            } else {
               var4 = var3.toString();
            }

            var1.b(var4);
         }
      };
      J = a(UUID.class, I);
      K = new com.millennialmedia.a.a.t() {
         public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
            return var2.a() != Timestamp.class?null:new com.millennialmedia.a.a.s() {
               // $FF: synthetic field
               final com.millennialmedia.a.a.s a;

               {
                  this.a = var2;
               }

               // $FF: synthetic method
               public final Object a(com.millennialmedia.a.a.d.a var1) {
                  Date var2 = (Date)this.a.a(var1);
                  return var2 != null?new Timestamp(var2.getTime()):null;
               }
            };
         }
      };
      L = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            int var3 = 0;
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               var1.c();
               int var4 = 0;
               int var5 = 0;
               int var6 = 0;
               int var7 = 0;
               int var8 = 0;

               while(var1.f() != com.millennialmedia.a.a.d.b.d) {
                  String var9 = var1.g();
                  int var2 = var1.m();
                  if("year".equals(var9)) {
                     var8 = var2;
                  } else if("month".equals(var9)) {
                     var7 = var2;
                  } else if("dayOfMonth".equals(var9)) {
                     var6 = var2;
                  } else if("hourOfDay".equals(var9)) {
                     var5 = var2;
                  } else if("minute".equals(var9)) {
                     var4 = var2;
                  } else if("second".equals(var9)) {
                     var3 = var2;
                  }
               }

               var1.d();
               return new GregorianCalendar(var8, var7, var6, var5, var4, var3);
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            Calendar var3 = (Calendar)var2;
            if(var3 == null) {
               var1.f();
            } else {
               var1.d();
               var1.a("year");
               var1.a((long)var3.get(1));
               var1.a("month");
               var1.a((long)var3.get(2));
               var1.a("dayOfMonth");
               var1.a((long)var3.get(5));
               var1.a("hourOfDay");
               var1.a((long)var3.get(11));
               var1.a("minute");
               var1.a((long)var3.get(12));
               var1.a("second");
               var1.a((long)var3.get(13));
               var1.e();
            }
         }
      };
      M = new com.millennialmedia.a.a.t() {
         // $FF: synthetic field
         final Class a;
         // $FF: synthetic field
         final Class b;
         // $FF: synthetic field
         final com.millennialmedia.a.a.s c;

         {
            this.a = var1;
            this.b = var2;
            this.c = var3;
         }

         public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
            Class var3 = var2.a();
            return var3 != this.a && var3 != this.b?null:this.c;
         }

         public final String toString() {
            return "Factory[type=" + this.a.getName() + "+" + this.b.getName() + ",adapter=" + this.c + "]";
         }
      };
      N = new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               StringTokenizer var3 = new StringTokenizer(var1.h(), "_");
               String var4;
               if(var3.hasMoreElements()) {
                  var4 = var3.nextToken();
               } else {
                  var4 = null;
               }

               String var2;
               if(var3.hasMoreElements()) {
                  var2 = var3.nextToken();
               } else {
                  var2 = null;
               }

               String var5;
               if(var3.hasMoreElements()) {
                  var5 = var3.nextToken();
               } else {
                  var5 = null;
               }

               return var2 == null && var5 == null?new Locale(var4):(var5 == null?new Locale(var4, var2):new Locale(var4, var2, var5));
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            Locale var3 = (Locale)var2;
            String var4;
            if(var3 == null) {
               var4 = null;
            } else {
               var4 = var3.toString();
            }

            var1.b(var4);
         }
      };
      O = a(Locale.class, N);
      P = new com.millennialmedia.a.a.s() {
         private void a(com.millennialmedia.a.a.d.c var1, com.millennialmedia.a.a.j var2) {
            if(var2 != null && !var2.j()) {
               if(var2.i()) {
                  com.millennialmedia.a.a.o var5 = var2.m();
                  if(var5.o()) {
                     var1.a(var5.a());
                  } else if(var5.n()) {
                     var1.a(var5.f());
                  } else {
                     var1.b(var5.b());
                  }
               } else {
                  Iterator var4;
                  if(var2.g()) {
                     var1.b();
                     var4 = var2.l().iterator();

                     while(var4.hasNext()) {
                        this.a(var1, (com.millennialmedia.a.a.j)var4.next());
                     }

                     var1.c();
                  } else if(!var2.h()) {
                     throw new IllegalArgumentException("Couldn\'t write " + var2.getClass());
                  } else {
                     var1.d();
                     var4 = var2.k().n().iterator();

                     while(var4.hasNext()) {
                        Entry var3 = (Entry)var4.next();
                        var1.a((String)var3.getKey());
                        this.a(var1, (com.millennialmedia.a.a.j)var3.getValue());
                     }

                     var1.e();
                  }
               }
            } else {
               var1.f();
            }
         }

         private com.millennialmedia.a.a.j b(com.millennialmedia.a.a.d.a var1) {
            switch(null.a[var1.f().ordinal()]) {
            case 1:
               return new com.millennialmedia.a.a.o(new com.millennialmedia.a.a.b.i(var1.h()));
            case 2:
               return new com.millennialmedia.a.a.o(Boolean.valueOf(var1.i()));
            case 3:
               return new com.millennialmedia.a.a.o(var1.h());
            case 4:
               var1.j();
               return com.millennialmedia.a.a.l.a;
            case 5:
               com.millennialmedia.a.a.h var3 = new com.millennialmedia.a.a.h();
               var1.a();

               while(var1.e()) {
                  var3.a(this.b(var1));
               }

               var1.b();
               return var3;
            case 6:
               com.millennialmedia.a.a.m var2 = new com.millennialmedia.a.a.m();
               var1.c();

               while(var1.e()) {
                  var2.a(var1.g(), this.b(var1));
               }

               var1.d();
               return var2;
            default:
               throw new IllegalArgumentException();
            }
         }

         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            return this.b(var1);
         }
      };
      Q = b(com.millennialmedia.a.a.j.class, P);
      R = new com.millennialmedia.a.a.t() {
         public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
            Class var4 = var2.a();
            if(Enum.class.isAssignableFrom(var4) && var4 != Enum.class) {
               Class var3 = var4;
               if(!var4.isEnum()) {
                  var3 = var4.getSuperclass();
               }

               return new com.millennialmedia.a.a.b.a.q(var3);
            } else {
               return null;
            }
         }
      };
   }

   public static com.millennialmedia.a.a.t a(final Class var0, final com.millennialmedia.a.a.s var1) {
      return new com.millennialmedia.a.a.t() {
         public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1x, com.millennialmedia.a.a.c.a var2) {
            return var2.a() == var0?var1:null;
         }

         public final String toString() {
            return "Factory[type=" + var0.getName() + ",adapter=" + var1 + "]";
         }
      };
   }

   public static com.millennialmedia.a.a.t a(final Class var0, final Class var1, final com.millennialmedia.a.a.s var2) {
      return new com.millennialmedia.a.a.t() {
         public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1x, com.millennialmedia.a.a.c.a var2x) {
            Class var3 = var2x.a();
            return var3 != var0 && var3 != var1?null:var2;
         }

         public final String toString() {
            return "Factory[type=" + var1.getName() + "+" + var0.getName() + ",adapter=" + var2 + "]";
         }
      };
   }

   private static com.millennialmedia.a.a.t b(final Class var0, final com.millennialmedia.a.a.s var1) {
      return new com.millennialmedia.a.a.t() {
         public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1x, com.millennialmedia.a.a.c.a var2) {
            return var0.isAssignableFrom(var2.a())?var1:null;
         }

         public final String toString() {
            return "Factory[typeHierarchy=" + var0.getName() + ",adapter=" + var1 + "]";
         }
      };
   }
}
