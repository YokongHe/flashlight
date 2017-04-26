package com.millennialmedia.a.a.d;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a implements Closeable {
   private static final char[] a = ")]}\'\n".toCharArray();
   private final Reader b;
   private boolean c = false;
   private final char[] d = new char[1024];
   private int e = 0;
   private int f = 0;
   private int g = 0;
   private int h = 0;
   private int i = 0;
   private long j;
   private int k;
   private String l;
   private int[] m = new int[32];
   private int n = 0;

   static {
      com.millennialmedia.a.a.b.h.a = new com.millennialmedia.a.a.b.h() {
         public final void a(com.millennialmedia.a.a.d.a var1) {
            if(var1 instanceof com.millennialmedia.a.a.b.a.e) {
               ((com.millennialmedia.a.a.b.a.e)var1).o();
            } else {
               int var3 = var1.i;
               int var2 = var3;
               if(var3 == 0) {
                  var2 = var1.o();
               }

               if(var2 == 13) {
                  var1.i = 9;
               } else if(var2 == 12) {
                  var1.i = 8;
               } else if(var2 == 14) {
                  var1.i = 10;
               } else {
                  throw new IllegalStateException("Expected a name but was " + var1.f() + "  at line " + com.millennialmedia.a.a.d.a.c(var1) + " column " + var1.t());
               }
            }
         }
      };
   }

   public a(Reader var1) {
      int[] var3 = this.m;
      int var2 = this.n;
      this.n = var2 + 1;
      var3[var2] = 6;
      if(var1 == null) {
         throw new NullPointerException("in == null");
      } else {
         this.b = var1;
      }
   }

   private IOException a(String var1) {
      throw new com.millennialmedia.a.a.d.d(var1 + " at line " + (this.g + 1) + " column " + this.t());
   }

   private void a(int var1) {
      int[] var3;
      if(this.n == this.m.length) {
         var3 = new int[this.n * 2];
         System.arraycopy(this.m, 0, var3, 0, this.n);
         this.m = var3;
      }

      var3 = this.m;
      int var2 = this.n;
      this.n = var2 + 1;
      var3[var2] = var1;
   }

   private boolean a(char var1) {
      switch(var1) {
      case '#':
      case '/':
      case ';':
      case '=':
      case '\\':
         this.u();
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
         return false;
      default:
         return true;
      }
   }

   private int b(boolean var1) {
      char[] var7 = this.d;
      int var2 = this.e;
      int var3 = this.f;

      while(true) {
         while(true) {
            while(true) {
               while(true) {
                  int var4 = var3;
                  int var5 = var2;
                  if(var2 == var3) {
                     this.e = var2;
                     if(!this.b((int)1)) {
                        if(var1) {
                           throw new EOFException("End of input at line " + (this.g + 1) + " column " + this.t());
                        }

                        return -1;
                     }

                     var5 = this.e;
                     var4 = this.f;
                  }

                  var2 = var5 + 1;
                  char var8 = var7[var5];
                  if(var8 != 10) {
                     if(var8 != 32 && var8 != 13 && var8 != 9) {
                        if(var8 == 47) {
                           this.e = var2;
                           if(var2 == var4) {
                              --this.e;
                              boolean var6 = this.b((int)2);
                              ++this.e;
                              if(!var6) {
                                 return var8;
                              }
                           }

                           this.u();
                           switch(var7[this.e]) {
                           case '*':
                              ++this.e;

                              boolean var9;
                              label89:
                              while(true) {
                                 if(this.e + "*/".length() > this.f && !this.b("*/".length())) {
                                    var9 = false;
                                    break;
                                 }

                                 if(this.d[this.e] == 10) {
                                    ++this.g;
                                    this.h = this.e + 1;
                                 } else {
                                    var2 = 0;

                                    while(true) {
                                       if(var2 >= "*/".length()) {
                                          var9 = true;
                                          break label89;
                                       }

                                       if(this.d[this.e + var2] != "*/".charAt(var2)) {
                                          break;
                                       }

                                       ++var2;
                                    }
                                 }

                                 ++this.e;
                              }

                              if(!var9) {
                                 throw this.a("Unterminated comment");
                              }

                              var2 = this.e + 2;
                              var3 = this.f;
                              break;
                           case '/':
                              ++this.e;
                              this.v();
                              var2 = this.e;
                              var3 = this.f;
                              break;
                           default:
                              return var8;
                           }
                        } else {
                           if(var8 != 35) {
                              this.e = var2;
                              return var8;
                           }

                           this.e = var2;
                           this.u();
                           this.v();
                           var2 = this.e;
                           var3 = this.f;
                        }
                     } else {
                        var3 = var4;
                     }
                  } else {
                     ++this.g;
                     this.h = var2;
                     var3 = var4;
                  }
               }
            }
         }
      }
   }

   private String b(char var1) {
      char[] var6 = this.d;
      StringBuilder var7 = new StringBuilder();

      do {
         int var3 = this.e;
         int var4 = this.f;
         int var2 = var3;

         while(var2 < var4) {
            int var5 = var2 + 1;
            char var8 = var6[var2];
            if(var8 == var1) {
               this.e = var5;
               var7.append(var6, var3, var5 - var3 - 1);
               return var7.toString();
            }

            if(var8 == 92) {
               this.e = var5;
               var7.append(var6, var3, var5 - var3 - 1);
               var7.append(this.w());
               var3 = this.e;
               var4 = this.f;
               var2 = var3;
            } else {
               if(var8 == 10) {
                  ++this.g;
                  this.h = var5;
               }

               var2 = var5;
            }
         }

         var7.append(var6, var3, var2 - var3);
         this.e = var2;
      } while(this.b((int)1));

      throw this.a("Unterminated string");
   }

   private boolean b(int var1) {
      boolean var4 = false;
      char[] var5 = this.d;
      this.h -= this.e;
      if(this.f != this.e) {
         this.f -= this.e;
         System.arraycopy(var5, this.e, var5, 0, this.f);
      } else {
         this.f = 0;
      }

      this.e = 0;

      boolean var3;
      while(true) {
         int var2 = this.b.read(var5, this.f, var5.length - this.f);
         var3 = var4;
         if(var2 == -1) {
            break;
         }

         this.f += var2;
         var2 = var1;
         if(this.g == 0) {
            var2 = var1;
            if(this.h == 0) {
               var2 = var1;
               if(this.f > 0) {
                  var2 = var1;
                  if(var5[0] == '\ufeff') {
                     ++this.e;
                     ++this.h;
                     var2 = var1 + 1;
                  }
               }
            }
         }

         var1 = var2;
         if(this.f >= var2) {
            var3 = true;
            break;
         }
      }

      return var3;
   }

   // $FF: synthetic method
   static int c(com.millennialmedia.a.a.d.a var0) {
      return var0.g + 1;
   }

   private void c(char var1) {
      char[] var5 = this.d;

      do {
         int var2 = this.e;
         int var3 = this.f;

         while(var2 < var3) {
            int var4 = var2 + 1;
            char var6 = var5[var2];
            if(var6 == var1) {
               this.e = var4;
               return;
            }

            if(var6 == 92) {
               this.e = var4;
               this.w();
               var2 = this.e;
               var3 = this.f;
            } else {
               if(var6 == 10) {
                  ++this.g;
                  this.h = var4;
               }

               var2 = var4;
            }
         }

         this.e = var2;
      } while(this.b((int)1));

      throw this.a("Unterminated string");
   }

   private int o() {
      int var2 = this.m[this.n - 1];
      int var1;
      if(var2 == 1) {
         this.m[this.n - 1] = 2;
      } else if(var2 == 2) {
         switch(this.b(true)) {
         case 44:
            break;
         case 59:
            this.u();
            break;
         case 93:
            this.i = 4;
            return 4;
         default:
            throw this.a("Unterminated array");
         }
      } else {
         if(var2 == 3 || var2 == 5) {
            this.m[this.n - 1] = 4;
            if(var2 == 5) {
               switch(this.b(true)) {
               case 44:
                  break;
               case 59:
                  this.u();
                  break;
               case 125:
                  this.i = 2;
                  return 2;
               default:
                  throw this.a("Unterminated object");
               }
            }

            var1 = this.b(true);
            switch(var1) {
            case 34:
               this.i = 13;
               return 13;
            case 39:
               this.u();
               this.i = 12;
               return 12;
            case 125:
               if(var2 != 5) {
                  this.i = 2;
                  return 2;
               }

               throw this.a("Expected name");
            default:
               this.u();
               --this.e;
               if(this.a((char)var1)) {
                  this.i = 14;
                  return 14;
               }

               throw this.a("Expected name");
            }
         }

         if(var2 == 4) {
            this.m[this.n - 1] = 5;
            switch(this.b(true)) {
            case 58:
               break;
            case 59:
            case 60:
            default:
               throw this.a("Expected \':\'");
            case 61:
               this.u();
               if((this.e < this.f || this.b((int)1)) && this.d[this.e] == 62) {
                  ++this.e;
               }
            }
         } else if(var2 == 6) {
            if(this.c) {
               this.b(true);
               --this.e;
               if(this.e + a.length <= this.f || this.b(a.length)) {
                  var1 = 0;

                  while(true) {
                     if(var1 >= a.length) {
                        this.e += a.length;
                        break;
                     }

                     if(this.d[this.e + var1] != a[var1]) {
                        break;
                     }

                     ++var1;
                  }
               }
            }

            this.m[this.n - 1] = 7;
         } else if(var2 == 7) {
            if(this.b(false) == -1) {
               this.i = 17;
               return 17;
            }

            this.u();
            --this.e;
         } else if(var2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
         }
      }

      switch(this.b(true)) {
      case 34:
         if(this.n == 1) {
            this.u();
         }

         this.i = 9;
         return 9;
      case 39:
         this.u();
         this.i = 8;
         return 8;
      case 91:
         this.i = 3;
         return 3;
      case 93:
         if(var2 == 1) {
            this.i = 4;
            return 4;
         }
      case 44:
      case 59:
         if(var2 != 1 && var2 != 2) {
            throw this.a("Unexpected value");
         }

         this.u();
         --this.e;
         this.i = 7;
         return 7;
      case 123:
         this.i = 1;
         return 1;
      default:
         --this.e;
         if(this.n == 1) {
            this.u();
         }

         var1 = this.q();
         if(var1 == 0) {
            var2 = this.r();
            var1 = var2;
            if(var2 == 0) {
               if(!this.a(this.d[this.e])) {
                  throw this.a("Expected value");
               }

               this.u();
               this.i = 10;
               return 10;
            }
         }

         return var1;
      }
   }

   private int q() {
      char var1 = this.d[this.e];
      String var5;
      String var6;
      byte var7;
      if(var1 != 116 && var1 != 84) {
         if(var1 != 102 && var1 != 70) {
            if(var1 != 110 && var1 != 78) {
               return 0;
            }

            var6 = "null";
            var5 = "NULL";
            var7 = 7;
         } else {
            var6 = "false";
            var5 = "FALSE";
            var7 = 6;
         }
      } else {
         var6 = "true";
         var5 = "TRUE";
         var7 = 5;
      }

      int var3 = var6.length();

      for(int var2 = 1; var2 < var3; ++var2) {
         if(this.e + var2 >= this.f && !this.b(var2 + 1)) {
            return 0;
         }

         char var4 = this.d[this.e + var2];
         if(var4 != var6.charAt(var2) && var4 != var5.charAt(var2)) {
            return 0;
         }
      }

      if((this.e + var3 < this.f || this.b(var3 + 1)) && this.a(this.d[this.e + var3])) {
         return 0;
      } else {
         this.e += var3;
         this.i = var7;
         return var7;
      }
   }

   private int r() {
      char[] var15 = this.d;
      int var8 = this.e;
      int var6 = this.f;
      long var11 = 0L;
      boolean var2 = false;
      boolean var3 = true;
      byte var4 = 0;
      int var5 = 0;
      int var9 = var6;

      label125:
      while(true) {
         int var7 = var9;
         var6 = var8;
         if(var8 + var5 == var9) {
            if(var5 == var15.length) {
               return 0;
            }

            if(!this.b(var5 + 1)) {
               break;
            }

            var6 = this.e;
            var7 = this.f;
         }

         char var1 = var15[var6 + var5];
         byte var16;
         boolean var17;
         byte var19;
         switch(var1) {
         case '+':
            if(var4 != 5) {
               return 0;
            }

            var19 = 6;
            var17 = var2;
            var16 = var19;
            break;
         case '-':
            if(var4 == 0) {
               var16 = 1;
               var17 = true;
            } else {
               if(var4 != 5) {
                  return 0;
               }

               var19 = 6;
               var17 = var2;
               var16 = var19;
            }
            break;
         case '.':
            if(var4 != 2) {
               return 0;
            }

            var19 = 3;
            var17 = var2;
            var16 = var19;
            break;
         case 'E':
         case 'e':
            if(var4 != 2 && var4 != 4) {
               return 0;
            }

            var19 = 5;
            var17 = var2;
            var16 = var19;
            break;
         default:
            if(var1 < 48 || var1 > 57) {
               if(this.a(var1)) {
                  return 0;
               }
               break label125;
            }

            if(var4 != 1 && var4 != 0) {
               boolean var21;
               if(var4 == 2) {
                  if(var11 == 0L) {
                     return 0;
                  }

                  long var13 = 10L * var11 - (long)(var1 - 48);
                  boolean var20;
                  if(var11 <= -922337203685477580L && (var11 != -922337203685477580L || var13 >= var11)) {
                     var20 = false;
                  } else {
                     var20 = true;
                  }

                  var21 = var2;
                  var11 = var13;
                  var3 &= var20;
                  var16 = var4;
                  var17 = var21;
               } else if(var4 == 3) {
                  var19 = 4;
                  var17 = var2;
                  var16 = var19;
               } else if(var4 != 5 && var4 != 6) {
                  var21 = var2;
                  var16 = var4;
                  var17 = var21;
               } else {
                  var19 = 7;
                  var17 = var2;
                  var16 = var19;
               }
            } else {
               var11 = (long)(-(var1 - 48));
               var19 = 2;
               var17 = var2;
               var16 = var19;
            }
         }

         int var10 = var5 + 1;
         boolean var18 = var17;
         var9 = var7;
         var8 = var6;
         var4 = var16;
         var2 = var18;
         var5 = var10;
      }

      if(var4 == 2 && var3 && (var11 != Long.MIN_VALUE || var2)) {
         if(!var2) {
            var11 = -var11;
         }

         this.j = var11;
         this.e += var5;
         this.i = 15;
         return 15;
      } else if(var4 != 2 && var4 != 4 && var4 != 7) {
         return 0;
      } else {
         this.k = var5;
         this.i = 16;
         return 16;
      }
   }

   private String s() {
      StringBuilder var3 = null;
      int var1 = 0;

      int var2;
      StringBuilder var4;
      label36:
      while(true) {
         if(this.e + var1 < this.f) {
            var4 = var3;
            var2 = var1;
            switch(this.d[this.e + var1]) {
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
               break label36;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
               this.u();
               var2 = var1;
               var4 = var3;
               break label36;
            default:
               ++var1;
            }
         } else if(var1 < this.d.length) {
            var4 = var3;
            var2 = var1;
            if(this.b(var1 + 1)) {
               continue;
            }
            break;
         } else {
            var4 = var3;
            if(var3 == null) {
               var4 = new StringBuilder();
            }

            var4.append(this.d, this.e, var1);
            this.e += var1;
            if(!this.b((int)1)) {
               var2 = 0;
               break;
            }

            var1 = 0;
            var3 = var4;
         }
      }

      String var5;
      if(var4 == null) {
         var5 = new String(this.d, this.e, var2);
      } else {
         var4.append(this.d, this.e, var2);
         var5 = var4.toString();
      }

      this.e += var2;
      return var5;
   }

   private int t() {
      return this.e - this.h + 1;
   }

   private void u() {
      if(!this.c) {
         throw this.a("Use JsonReader.setLenient(true) to accept malformed JSON");
      }
   }

   private void v() {
      while(this.e < this.f || this.b((int)1)) {
         char[] var2 = this.d;
         int var1 = this.e;
         this.e = var1 + 1;
         char var3 = var2[var1];
         if(var3 == 10) {
            ++this.g;
            this.h = this.e;
         } else if(var3 != 13) {
            continue;
         }
         break;
      }

   }

   private char w() {
      if(this.e == this.f && !this.b((int)1)) {
         throw this.a("Unterminated escape sequence");
      } else {
         char[] var6 = this.d;
         int var2 = this.e;
         this.e = var2 + 1;
         char var1 = var6[var2];
         switch(var1) {
         case '\n':
            ++this.g;
            this.h = this.e;
            return var1;
         case 'b':
            return '\b';
         case 'f':
            return '\f';
         case 'n':
            return '\n';
         case 'r':
            return '\r';
         case 't':
            return '\t';
         case 'u':
            if(this.e + 4 > this.f && !this.b((int)4)) {
               throw this.a("Unterminated escape sequence");
            } else {
               int var3 = this.e;
               var1 = 0;

               for(var2 = var3; var2 < var3 + 4; ++var2) {
                  char var4 = this.d[var2];
                  char var5 = (char)(var1 << 4);
                  if(var4 >= 48 && var4 <= 57) {
                     var1 = (char)(var5 + (var4 - 48));
                  } else if(var4 >= 97 && var4 <= 102) {
                     var1 = (char)(var5 + var4 - 97 + 10);
                  } else {
                     if(var4 < 65 || var4 > 70) {
                        throw new NumberFormatException("\\u" + new String(this.d, this.e, 4));
                     }

                     var1 = (char)(var5 + var4 - 65 + 10);
                  }
               }

               this.e += 4;
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   public void a() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      if(var1 == 3) {
         this.a((int)1);
         this.i = 0;
      } else {
         throw new IllegalStateException("Expected BEGIN_ARRAY but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
      }
   }

   public final void a(boolean var1) {
      this.c = var1;
   }

   public void b() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      if(var1 == 4) {
         --this.n;
         this.i = 0;
      } else {
         throw new IllegalStateException("Expected END_ARRAY but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
      }
   }

   public void c() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      if(var1 == 1) {
         this.a((int)3);
         this.i = 0;
      } else {
         throw new IllegalStateException("Expected BEGIN_OBJECT but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
      }
   }

   public void close() {
      this.i = 0;
      this.m[0] = 8;
      this.n = 1;
      this.b.close();
   }

   public void d() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      if(var1 == 2) {
         --this.n;
         this.i = 0;
      } else {
         throw new IllegalStateException("Expected END_OBJECT but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
      }
   }

   public boolean e() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      return var1 != 2 && var1 != 4;
   }

   public com.millennialmedia.a.a.d.b f() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      switch(var1) {
      case 1:
         return com.millennialmedia.a.a.d.b.c;
      case 2:
         return com.millennialmedia.a.a.d.b.d;
      case 3:
         return com.millennialmedia.a.a.d.b.a;
      case 4:
         return com.millennialmedia.a.a.d.b.b;
      case 5:
      case 6:
         return com.millennialmedia.a.a.d.b.h;
      case 7:
         return com.millennialmedia.a.a.d.b.i;
      case 8:
      case 9:
      case 10:
      case 11:
         return com.millennialmedia.a.a.d.b.f;
      case 12:
      case 13:
      case 14:
         return com.millennialmedia.a.a.d.b.e;
      case 15:
      case 16:
         return com.millennialmedia.a.a.d.b.g;
      case 17:
         return com.millennialmedia.a.a.d.b.j;
      default:
         throw new AssertionError();
      }
   }

   public String g() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      String var3;
      if(var1 == 14) {
         var3 = this.s();
      } else if(var1 == 12) {
         var3 = this.b('\'');
      } else {
         if(var1 != 13) {
            throw new IllegalStateException("Expected a name but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
         }

         var3 = this.b('\"');
      }

      this.i = 0;
      return var3;
   }

   public String h() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      String var3;
      if(var1 == 10) {
         var3 = this.s();
      } else if(var1 == 8) {
         var3 = this.b('\'');
      } else if(var1 == 9) {
         var3 = this.b('\"');
      } else if(var1 == 11) {
         var3 = this.l;
         this.l = null;
      } else if(var1 == 15) {
         var3 = Long.toString(this.j);
      } else {
         if(var1 != 16) {
            throw new IllegalStateException("Expected a string but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
         }

         var3 = new String(this.d, this.e, this.k);
         this.e += this.k;
      }

      this.i = 0;
      return var3;
   }

   public boolean i() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      if(var1 == 5) {
         this.i = 0;
         return true;
      } else if(var1 == 6) {
         this.i = 0;
         return false;
      } else {
         throw new IllegalStateException("Expected a boolean but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
      }
   }

   public void j() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.o();
      }

      if(var1 == 7) {
         this.i = 0;
      } else {
         throw new IllegalStateException("Expected null but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
      }
   }

   public double k() {
      int var5 = this.i;
      int var4 = var5;
      if(var5 == 0) {
         var4 = this.o();
      }

      if(var4 == 15) {
         this.i = 0;
         return (double)this.j;
      } else {
         if(var4 == 16) {
            this.l = new String(this.d, this.e, this.k);
            this.e += this.k;
         } else if(var4 != 8 && var4 != 9) {
            if(var4 == 10) {
               this.l = this.s();
            } else if(var4 != 11) {
               throw new IllegalStateException("Expected a double but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
            }
         } else {
            char var1;
            if(var4 == 8) {
               var1 = 39;
            } else {
               var1 = 34;
            }

            this.l = this.b(var1);
         }

         this.i = 11;
         double var2 = Double.parseDouble(this.l);
         if(!this.c && (Double.isNaN(var2) || Double.isInfinite(var2))) {
            throw new com.millennialmedia.a.a.d.d("JSON forbids NaN and infinities: " + var2 + " at line " + (this.g + 1) + " column " + this.t());
         } else {
            this.l = null;
            this.i = 0;
            return var2;
         }
      }
   }

   public long l() {
      int var5 = this.i;
      int var4 = var5;
      if(var5 == 0) {
         var4 = this.o();
      }

      if(var4 == 15) {
         this.i = 0;
         return this.j;
      } else {
         long var6;
         if(var4 == 16) {
            this.l = new String(this.d, this.e, this.k);
            this.e += this.k;
         } else {
            if(var4 != 8 && var4 != 9) {
               throw new IllegalStateException("Expected a long but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
            }

            char var1;
            if(var4 == 8) {
               var1 = 39;
            } else {
               var1 = 34;
            }

            this.l = this.b(var1);

            try {
               var6 = Long.parseLong(this.l);
               this.i = 0;
               return var6;
            } catch (NumberFormatException var9) {
               ;
            }
         }

         this.i = 11;
         double var2 = Double.parseDouble(this.l);
         var6 = (long)var2;
         if((double)var6 != var2) {
            throw new NumberFormatException("Expected a long but was " + this.l + " at line " + (this.g + 1) + " column " + this.t());
         } else {
            this.l = null;
            this.i = 0;
            return var6;
         }
      }
   }

   public int m() {
      int var5 = this.i;
      int var4 = var5;
      if(var5 == 0) {
         var4 = this.o();
      }

      if(var4 == 15) {
         var4 = (int)this.j;
         if(this.j != (long)var4) {
            throw new NumberFormatException("Expected an int but was " + this.j + " at line " + (this.g + 1) + " column " + this.t());
         } else {
            this.i = 0;
            return var4;
         }
      } else {
         if(var4 == 16) {
            this.l = new String(this.d, this.e, this.k);
            this.e += this.k;
         } else {
            if(var4 != 8 && var4 != 9) {
               throw new IllegalStateException("Expected an int but was " + this.f() + " at line " + (this.g + 1) + " column " + this.t());
            }

            char var1;
            if(var4 == 8) {
               var1 = 39;
            } else {
               var1 = 34;
            }

            this.l = this.b(var1);

            try {
               var4 = Integer.parseInt(this.l);
               this.i = 0;
               return var4;
            } catch (NumberFormatException var7) {
               ;
            }
         }

         this.i = 11;
         double var2 = Double.parseDouble(this.l);
         var4 = (int)var2;
         if((double)var4 != var2) {
            throw new NumberFormatException("Expected an int but was " + this.l + " at line " + (this.g + 1) + " column " + this.t());
         } else {
            this.l = null;
            this.i = 0;
            return var4;
         }
      }
   }

   public void n() {
      int var2 = 0;

      int var1;
      do {
         var1 = this.i;
         int var3 = var1;
         if(var1 == 0) {
            var3 = this.o();
         }

         if(var3 == 3) {
            this.a((int)1);
            var1 = var2 + 1;
         } else if(var3 == 1) {
            this.a((int)3);
            var1 = var2 + 1;
         } else if(var3 == 4) {
            --this.n;
            var1 = var2 - 1;
         } else if(var3 == 2) {
            --this.n;
            var1 = var2 - 1;
         } else if(var3 != 14 && var3 != 10) {
            if(var3 != 8 && var3 != 12) {
               if(var3 != 9 && var3 != 13) {
                  var1 = var2;
                  if(var3 == 16) {
                     this.e += this.k;
                     var1 = var2;
                  }
               } else {
                  this.c('\"');
                  var1 = var2;
               }
            } else {
               this.c('\'');
               var1 = var2;
            }
         } else {
            label64:
            while(true) {
               var1 = 0;

               while(this.e + var1 < this.f) {
                  switch(this.d[this.e + var1]) {
                  case '#':
                  case '/':
                  case ';':
                  case '=':
                  case '\\':
                     this.u();
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
                     this.e += var1;
                     var1 = var2;
                     break label64;
                  default:
                     ++var1;
                  }
               }

               this.e += var1;
               if(!this.b((int)1)) {
                  var1 = var2;
                  break;
               }
            }
         }

         this.i = 0;
         var2 = var1;
      } while(var1 != 0);

   }

   public final boolean p() {
      return this.c;
   }

   public String toString() {
      return this.getClass().getSimpleName() + " at line " + (this.g + 1) + " column " + this.t();
   }
}
