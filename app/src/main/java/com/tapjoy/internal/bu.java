package com.tapjoy.internal;

import com.tapjoy.internal.bt$a;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public final class bu extends com.tapjoy.internal.bt {
   public static final bt$a a = new bt$a() {
      public final com.tapjoy.internal.bt a(Reader var1) {
         return new com.tapjoy.internal.bu(var1);
      }

      public final com.tapjoy.internal.bt a(String var1) {
         return new com.tapjoy.internal.bu(new StringReader(var1));
      }
   };
   private final com.tapjoy.internal.cp b = new com.tapjoy.internal.cp();
   private final Reader c;
   private boolean d = false;
   private final char[] e = new char[1024];
   private int f = 0;
   private int g = 0;
   private int h = 1;
   private int i = 1;
   private final List j = new ArrayList();
   private com.tapjoy.internal.by k;
   private String l;
   private String m;
   private int n;
   private int o;
   private boolean p;

   public bu(Reader var1) {
      this.a(com.tapjoy.internal.bw.f);
      this.p = false;
      if(var1 == null) {
         throw new NullPointerException("in == null");
      } else {
         this.c = var1;
      }
   }

   private void A() {
      if(!this.d) {
         throw this.d("Use JsonReader.setLenient(true) to accept malformed JSON");
      }
   }

   private void B() {
      while(this.f < this.g || this.a((int)1)) {
         char[] var2 = this.e;
         int var1 = this.f;
         this.f = var1 + 1;
         char var3 = var2[var1];
         if(var3 == 13 || var3 == 10) {
            break;
         }
      }

   }

   private com.tapjoy.internal.by a(boolean var1) {
      com.tapjoy.internal.by var2;
      if(var1) {
         this.b(com.tapjoy.internal.bw.b);
      } else {
         switch(this.z()) {
         case 44:
            break;
         case 59:
            this.A();
            break;
         case 93:
            this.v();
            var2 = com.tapjoy.internal.by.b;
            this.k = var2;
            return var2;
         default:
            throw this.d("Unterminated array");
         }
      }

      switch(this.z()) {
      case 93:
         if(var1) {
            this.v();
            var2 = com.tapjoy.internal.by.b;
            this.k = var2;
            return var2;
         }
      case 44:
      case 59:
         this.A();
         --this.f;
         this.m = "null";
         var2 = com.tapjoy.internal.by.i;
         this.k = var2;
         return var2;
      default:
         --this.f;
         return this.w();
      }
   }

   private String a(char var1) {
      StringBuilder var5 = null;

      do {
         int var3 = this.f;

         StringBuilder var10;
         while(this.f < this.g) {
            char[] var6 = this.e;
            int var4 = this.f;
            this.f = var4 + 1;
            char var7 = var6[var4];
            if(var7 == var1) {
               if(this.p) {
                  return "skipped!";
               }

               if(var5 == null) {
                  return this.b.a(this.e, var3, this.f - var3 - 1);
               }

               var5.append(this.e, var3, this.f - var3 - 1);
               return var5.toString();
            }

            if(var7 == 92) {
               var10 = var5;
               if(var5 == null) {
                  var10 = new StringBuilder();
               }

               var10.append(this.e, var3, this.f - var3 - 1);
               if(this.f == this.g && !this.a((int)1)) {
                  throw this.d("Unterminated escape sequence");
               }

               char[] var8 = this.e;
               var3 = this.f;
               this.f = var3 + 1;
               char var2 = var8[var3];
               switch(var2) {
               case 'b':
                  var2 = 8;
                  break;
               case 'f':
                  var2 = 12;
                  break;
               case 'n':
                  var2 = 10;
                  break;
               case 'r':
                  var2 = 13;
                  break;
               case 't':
                  var2 = 9;
                  break;
               case 'u':
                  if(this.f + 4 > this.g && !this.a((int)4)) {
                     throw this.d("Unterminated escape sequence");
                  }

                  String var9 = this.b.a(this.e, this.f, 4);
                  this.f += 4;
                  var2 = (char)Integer.parseInt(var9, 16);
               }

               var10.append(var2);
               var3 = this.f;
               var5 = var10;
            }
         }

         var10 = var5;
         if(var5 == null) {
            var10 = new StringBuilder();
         }

         var10.append(this.e, var3, this.f - var3);
         var5 = var10;
      } while(this.a((int)1));

      throw this.d("Unterminated string");
   }

   private void a(com.tapjoy.internal.bw var1) {
      this.j.add(var1);
   }

   private void a(com.tapjoy.internal.by var1) {
      this.l();
      if(this.k != var1) {
         throw new IllegalStateException("Expected " + var1 + " but was " + this.l());
      } else {
         this.u();
      }
   }

   private boolean a(int var1) {
      boolean var4 = false;

      int var2;
      for(var2 = 0; var2 < this.f; ++var2) {
         if(this.e[var2] == 10) {
            ++this.h;
            this.i = 1;
         } else {
            ++this.i;
         }
      }

      if(this.g != this.f) {
         this.g -= this.f;
         System.arraycopy(this.e, this.f, this.e, 0, this.g);
      } else {
         this.g = 0;
      }

      this.f = 0;

      boolean var3;
      while(true) {
         var2 = this.c.read(this.e, this.g, this.e.length - this.g);
         var3 = var4;
         if(var2 == -1) {
            break;
         }

         this.g += var2;
         if(this.h == 1 && this.i == 1 && this.g > 0 && this.e[0] == '\ufeff') {
            ++this.f;
            --this.i;
         }

         if(this.g >= var1) {
            var3 = true;
            break;
         }
      }

      return var3;
   }

   private com.tapjoy.internal.by b(boolean var1) {
      com.tapjoy.internal.by var3;
      if(var1) {
         switch(this.z()) {
         case 125:
            this.v();
            var3 = com.tapjoy.internal.by.d;
            this.k = var3;
            return var3;
         default:
            --this.f;
         }
      } else {
         switch(this.z()) {
         case 44:
         case 59:
            break;
         case 125:
            this.v();
            var3 = com.tapjoy.internal.by.d;
            this.k = var3;
            return var3;
         default:
            throw this.d("Unterminated object");
         }
      }

      int var2 = this.z();
      switch(var2) {
      case 39:
         this.A();
      case 34:
         this.l = this.a((char)var2);
         break;
      default:
         this.A();
         --this.f;
         this.l = this.c(false);
         if(this.l.length() == 0) {
            throw this.d("Expected name");
         }
      }

      this.b(com.tapjoy.internal.bw.d);
      var3 = com.tapjoy.internal.by.e;
      this.k = var3;
      return var3;
   }

   private void b(com.tapjoy.internal.bw var1) {
      this.j.set(this.j.size() - 1, var1);
   }

   private String c(boolean var1) {
      Object var6 = null;
      this.n = -1;
      this.o = 0;
      int var2 = 0;
      StringBuilder var4 = null;

      int var3;
      StringBuilder var5;
      label47:
      while(true) {
         if(this.f + var2 < this.g) {
            var5 = var4;
            var3 = var2;
            switch(this.e[this.f + var2]) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
               break label47;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
               this.A();
               var3 = var2;
               var5 = var4;
               break label47;
            default:
               ++var2;
            }
         } else if(var2 < this.e.length) {
            if(!this.a(var2 + 1)) {
               this.e[this.g] = 0;
               var5 = var4;
               var3 = var2;
               break;
            }
         } else {
            var5 = var4;
            if(var4 == null) {
               var5 = new StringBuilder();
            }

            var5.append(this.e, this.f, var2);
            this.o += var2;
            this.f += var2;
            if(!this.a((int)1)) {
               var3 = 0;
               break;
            }

            var2 = 0;
            var4 = var5;
         }
      }

      String var7;
      if(var1 && var5 == null) {
         this.n = this.f;
         var7 = (String)var6;
      } else if(this.p) {
         var7 = "skipped!";
      } else if(var5 == null) {
         var7 = this.b.a(this.e, this.f, var3);
      } else {
         var5.append(this.e, this.f, var3);
         var7 = var5.toString();
      }

      this.o += var3;
      this.f += var3;
      return var7;
   }

   private IOException d(String var1) {
      throw new com.tapjoy.internal.ca(var1 + " at line " + this.x() + " column " + this.y());
   }

   private com.tapjoy.internal.by u() {
      this.l();
      com.tapjoy.internal.by var1 = this.k;
      this.k = null;
      this.m = null;
      this.l = null;
      return var1;
   }

   private com.tapjoy.internal.bw v() {
      return (com.tapjoy.internal.bw)this.j.remove(this.j.size() - 1);
   }

   private com.tapjoy.internal.by w() {
      int var1 = this.z();
      com.tapjoy.internal.by var7;
      switch(var1) {
      case 39:
         this.A();
      case 34:
         this.m = this.a((char)var1);
         var7 = com.tapjoy.internal.by.f;
         this.k = var7;
         return var7;
      case 91:
         this.a(com.tapjoy.internal.bw.a);
         var7 = com.tapjoy.internal.by.a;
         this.k = var7;
         return var7;
      case 123:
         this.a(com.tapjoy.internal.bw.c);
         var7 = com.tapjoy.internal.by.c;
         this.k = var7;
         return var7;
      default:
         --this.f;
         this.m = this.c(true);
         if(this.o == 0) {
            throw this.d("Expected literal value");
         } else {
            label212: {
               if(this.n != -1) {
                  if(this.o == 4 && (110 == this.e[this.n] || 78 == this.e[this.n]) && (117 == this.e[this.n + 1] || 85 == this.e[this.n + 1]) && (108 == this.e[this.n + 2] || 76 == this.e[this.n + 2]) && (108 == this.e[this.n + 3] || 76 == this.e[this.n + 3])) {
                     this.m = "null";
                     var7 = com.tapjoy.internal.by.i;
                     break label212;
                  }

                  if(this.o == 4 && (116 == this.e[this.n] || 84 == this.e[this.n]) && (114 == this.e[this.n + 1] || 82 == this.e[this.n + 1]) && (117 == this.e[this.n + 2] || 85 == this.e[this.n + 2]) && (101 == this.e[this.n + 3] || 69 == this.e[this.n + 3])) {
                     this.m = "true";
                     var7 = com.tapjoy.internal.by.h;
                     break label212;
                  }

                  if(this.o == 5 && (102 == this.e[this.n] || 70 == this.e[this.n]) && (97 == this.e[this.n + 1] || 65 == this.e[this.n + 1]) && (108 == this.e[this.n + 2] || 76 == this.e[this.n + 2]) && (115 == this.e[this.n + 3] || 83 == this.e[this.n + 3]) && (101 == this.e[this.n + 4] || 69 == this.e[this.n + 4])) {
                     this.m = "false";
                     var7 = com.tapjoy.internal.by.h;
                     break label212;
                  }

                  this.m = this.b.a(this.e, this.n, this.o);
                  char[] var12 = this.e;
                  int var5 = this.n;
                  int var6 = this.o;
                  char var8 = var12[var5];
                  int var2;
                  if(var8 == 45) {
                     var2 = var5 + 1;
                     var8 = var12[var2];
                  } else {
                     var2 = var5;
                  }

                  char var3;
                  char var9;
                  if(var8 == 48) {
                     var1 = var2 + 1;
                     var9 = var12[var1];
                  } else {
                     if(var8 < 49 || var8 > 57) {
                        var7 = com.tapjoy.internal.by.f;
                        break label212;
                     }

                     int var4 = var2 + 1;
                     var3 = var12[var4];

                     while(true) {
                        var9 = var3;
                        var1 = var4;
                        if(var3 < 48) {
                           break;
                        }

                        var9 = var3;
                        var1 = var4;
                        if(var3 > 57) {
                           break;
                        }

                        ++var4;
                        var3 = var12[var4];
                     }
                  }

                  char var11 = var9;
                  int var10 = var1;
                  if(var9 == 46) {
                     var2 = var1 + 1;
                     var8 = var12[var2];

                     while(true) {
                        var11 = var8;
                        var10 = var2;
                        if(var8 < 48) {
                           break;
                        }

                        var11 = var8;
                        var10 = var2;
                        if(var8 > 57) {
                           break;
                        }

                        ++var2;
                        var8 = var12[var2];
                     }
                  }

                  label205: {
                     if(var11 != 101) {
                        var2 = var10;
                        if(var11 != 69) {
                           break label205;
                        }
                     }

                     label107: {
                        ++var10;
                        var11 = var12[var10];
                        if(var11 != 43) {
                           var9 = var11;
                           var1 = var10;
                           if(var11 != 45) {
                              break label107;
                           }
                        }

                        var1 = var10 + 1;
                        var9 = var12[var1];
                     }

                     if(var9 < 48 || var9 > 57) {
                        var7 = com.tapjoy.internal.by.f;
                        break label212;
                     }

                     ++var1;
                     var3 = var12[var1];

                     while(true) {
                        var2 = var1;
                        if(var3 < 48) {
                           break;
                        }

                        var2 = var1;
                        if(var3 > 57) {
                           break;
                        }

                        ++var1;
                        var3 = var12[var1];
                     }
                  }

                  if(var2 == var5 + var6) {
                     var7 = com.tapjoy.internal.by.g;
                     break label212;
                  }
               }

               var7 = com.tapjoy.internal.by.f;
            }

            this.k = var7;
            if(this.k == com.tapjoy.internal.by.f) {
               this.A();
            }

            return this.k;
         }
      }
   }

   private int x() {
      int var2 = this.h;

      int var3;
      for(int var1 = 0; var1 < this.f; var2 = var3) {
         var3 = var2;
         if(this.e[var1] == 10) {
            var3 = var2 + 1;
         }

         ++var1;
      }

      return var2;
   }

   private int y() {
      int var1 = this.i;

      for(int var2 = 0; var2 < this.f; ++var2) {
         if(this.e[var2] == 10) {
            var1 = 1;
         } else {
            ++var1;
         }
      }

      return var1;
   }

   private int z() {
      while(this.f < this.g || this.a((int)1)) {
         char[] var2 = this.e;
         int var1 = this.f;
         this.f = var1 + 1;
         char var3 = var2[var1];
         switch(var3) {
         case '\t':
         case '\n':
         case '\r':
         case ' ':
            continue;
         case '#':
            this.A();
            this.B();
            continue;
         case '/':
            if(this.f != this.g || this.a((int)1)) {
               this.A();
               switch(this.e[this.f]) {
               case '*':
                  ++this.f;

                  boolean var4;
                  label43:
                  while(true) {
                     if(this.f + "*/".length() > this.g && !this.a("*/".length())) {
                        var4 = false;
                        break;
                     }

                     for(var1 = 0; var1 < "*/".length(); ++var1) {
                        if(this.e[this.f + var1] != "*/".charAt(var1)) {
                           ++this.f;
                           continue label43;
                        }
                     }

                     var4 = true;
                     break;
                  }

                  if(!var4) {
                     throw this.d("Unterminated comment");
                  }

                  this.f += 2;
                  continue;
               case '/':
                  ++this.f;
                  this.B();
                  continue;
               default:
                  return var3;
               }
            }
         }

         return var3;
      }

      throw new EOFException("End of input");
   }

   public final void close() {
      this.m = null;
      this.k = null;
      this.j.clear();
      this.j.add(com.tapjoy.internal.bw.h);
      this.c.close();
   }

   public final void g() {
      this.a(com.tapjoy.internal.by.a);
   }

   public final void h() {
      this.a(com.tapjoy.internal.by.b);
   }

   public final void i() {
      this.a(com.tapjoy.internal.by.c);
   }

   public final void j() {
      this.a(com.tapjoy.internal.by.d);
   }

   public final boolean k() {
      this.l();
      return this.k != com.tapjoy.internal.by.d && this.k != com.tapjoy.internal.by.b;
   }

   public final com.tapjoy.internal.by l() {
      com.tapjoy.internal.by var1;
      if(this.k != null) {
         var1 = this.k;
      } else {
         switch(null.a[((com.tapjoy.internal.bw)this.j.get(this.j.size() - 1)).ordinal()]) {
         case 1:
            this.b(com.tapjoy.internal.bw.g);
            com.tapjoy.internal.by var2 = this.w();
            var1 = var2;
            if(!this.d) {
               var1 = var2;
               if(this.k != com.tapjoy.internal.by.a) {
                  var1 = var2;
                  if(this.k != com.tapjoy.internal.by.c) {
                     throw new IOException("Expected JSON document to start with \'[\' or \'{\' but was " + this.k);
                  }
               }
            }
            break;
         case 2:
            return this.a(true);
         case 3:
            return this.a(false);
         case 4:
            return this.b(true);
         case 5:
            switch(this.z()) {
            case 59:
            case 60:
            default:
               throw this.d("Expected \':\'");
            case 61:
               this.A();
               if((this.f < this.g || this.a((int)1)) && this.e[this.f] == 62) {
                  ++this.f;
               }
            case 58:
               this.b(com.tapjoy.internal.bw.e);
               return this.w();
            }
         case 6:
            return this.b(false);
         case 7:
            try {
               var1 = this.w();
               if(!this.d) {
                  throw this.d("Expected EOF");
               }
               break;
            } catch (EOFException var3) {
               var1 = com.tapjoy.internal.by.j;
               this.k = var1;
               return var1;
            }
         case 8:
            throw new IllegalStateException("JsonReader is closed");
         default:
            throw new AssertionError();
         }
      }

      return var1;
   }

   public final String m() {
      this.l();
      if(this.k != com.tapjoy.internal.by.e) {
         throw new IllegalStateException("Expected a name but was " + this.l());
      } else {
         String var1 = this.l;
         this.u();
         return var1;
      }
   }

   public final String n() {
      this.l();
      if(this.k != com.tapjoy.internal.by.f && this.k != com.tapjoy.internal.by.g) {
         throw new IllegalStateException("Expected a string but was " + this.l());
      } else {
         String var1 = this.m;
         this.u();
         return var1;
      }
   }

   public final boolean o() {
      this.l();
      if(this.k != com.tapjoy.internal.by.h) {
         throw new IllegalStateException("Expected a boolean but was " + this.k);
      } else {
         boolean var1;
         if(this.m == "true") {
            var1 = true;
         } else {
            var1 = false;
         }

         this.u();
         return var1;
      }
   }

   public final void p() {
      this.l();
      if(this.k != com.tapjoy.internal.by.i) {
         throw new IllegalStateException("Expected null but was " + this.k);
      } else {
         this.u();
      }
   }

   public final double q() {
      this.l();
      if(this.k != com.tapjoy.internal.by.f && this.k != com.tapjoy.internal.by.g) {
         throw new IllegalStateException("Expected a double but was " + this.k);
      } else {
         double var1 = Double.parseDouble(this.m);
         this.u();
         return var1;
      }
   }

   public final long r() {
      this.l();
      if(this.k != com.tapjoy.internal.by.f && this.k != com.tapjoy.internal.by.g) {
         throw new IllegalStateException("Expected a long but was " + this.k);
      } else {
         long var3;
         try {
            var3 = Long.parseLong(this.m);
         } catch (NumberFormatException var8) {
            double var1 = Double.parseDouble(this.m);
            long var5 = (long)var1;
            var3 = var5;
            if((double)var5 != var1) {
               throw new NumberFormatException(this.m);
            }
         }

         this.u();
         return var3;
      }
   }

   public final int s() {
      this.l();
      if(this.k != com.tapjoy.internal.by.f && this.k != com.tapjoy.internal.by.g) {
         throw new IllegalStateException("Expected an int but was " + this.k);
      } else {
         int var3;
         try {
            var3 = Integer.parseInt(this.m);
         } catch (NumberFormatException var6) {
            double var1 = Double.parseDouble(this.m);
            int var4 = (int)var1;
            var3 = var4;
            if((double)var4 != var1) {
               throw new NumberFormatException(this.m);
            }
         }

         this.u();
         return var3;
      }
   }

   public final void t() {
      // $FF: Couldn't be decompiled
   }

   public final String toString() {
      StringBuilder var2 = (new StringBuilder()).append(this.getClass().getSimpleName()).append(" near ");
      StringBuilder var3 = new StringBuilder();
      int var1 = Math.min(this.f, 20);
      var3.append(this.e, this.f - var1, var1);
      var1 = Math.min(this.g - this.f, 20);
      var3.append(this.e, this.f, var1);
      return var2.append(var3).toString();
   }
}
