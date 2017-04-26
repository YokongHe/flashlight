package com.inmobi.commons.thirdparty;

import com.inmobi.commons.thirdparty.Base64;
import com.inmobi.commons.thirdparty.Base64$a;

class Base64$c extends Base64$a {
   // $FF: synthetic field
   static final boolean g;
   private static final byte[] h;
   private static final byte[] i;
   int c;
   public final boolean d;
   public final boolean e;
   public final boolean f;
   private final byte[] j;
   private int k;
   private final byte[] l;

   static {
      boolean var0;
      if(!Base64.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      g = var0;
      h = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)43, (byte)47};
      i = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)45, (byte)95};
   }

   public Base64$c(int var1, byte[] var2) {
      boolean var4 = true;
      super();
      this.a = var2;
      boolean var3;
      if((var1 & 1) == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.d = var3;
      if((var1 & 2) == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.e = var3;
      if((var1 & 4) != 0) {
         var3 = var4;
      } else {
         var3 = false;
      }

      this.f = var3;
      if((var1 & 8) == 0) {
         var2 = h;
      } else {
         var2 = i;
      }

      this.l = var2;
      this.j = new byte[2];
      this.c = 0;
      byte var5;
      if(this.e) {
         var5 = 19;
      } else {
         var5 = -1;
      }

      this.k = var5;
   }

   public boolean a(byte[] var1, int var2, int var3, boolean var4) {
      int var5;
      byte var6;
      byte var7;
      byte var8;
      int var9;
      byte[] var10;
      byte[] var11;
      label122: {
         var10 = this.l;
         var11 = this.a;
         var6 = 0;
         var5 = this.k;
         var9 = var3 + var2;
         byte var13;
         switch(this.c) {
         case 0:
            var7 = -1;
            var3 = var2;
            var2 = var7;
            break label122;
         case 1:
            if(var2 + 2 <= var9) {
               var7 = this.j[0];
               var3 = var2 + 1;
               var13 = var1[var2];
               var8 = var1[var3];
               this.c = 0;
               var2 = (var7 & 255) << 16 | (var13 & 255) << 8 | var8 & 255;
               ++var3;
               break label122;
            }
            break;
         case 2:
            if(var2 + 1 <= var9) {
               var7 = this.j[0];
               var8 = this.j[1];
               var3 = var2 + 1;
               var13 = var1[var2];
               this.c = 0;
               var2 = (var7 & 255) << 16 | (var8 & 255) << 8 | var13 & 255;
               break label122;
            }
         }

         var7 = -1;
         var3 = var2;
         var2 = var7;
      }

      int var15;
      if(var2 != -1) {
         var11[0] = var10[var2 >> 18 & 63];
         var11[1] = var10[var2 >> 12 & 63];
         var11[2] = var10[var2 >> 6 & 63];
         var6 = 4;
         var11[3] = var10[var2 & 63];
         --var5;
         if(var5 == 0) {
            byte var14 = var6;
            if(this.f) {
               var14 = 5;
               var11[4] = 13;
            }

            var15 = var14 + 1;
            var11[var14] = 10;
            var5 = 19;
            var2 = var15;
         } else {
            var2 = 4;
         }
      } else {
         var2 = var6;
      }

      while(var3 + 3 <= var9) {
         var15 = (var1[var3] & 255) << 16 | (var1[var3 + 1] & 255) << 8 | var1[var3 + 2] & 255;
         var11[var2] = var10[var15 >> 18 & 63];
         var11[var2 + 1] = var10[var15 >> 12 & 63];
         var11[var2 + 2] = var10[var15 >> 6 & 63];
         var11[var2 + 3] = var10[var15 & 63];
         var3 += 3;
         var2 += 4;
         --var5;
         if(var5 == 0) {
            if(this.f) {
               var5 = var2 + 1;
               var11[var2] = 13;
               var2 = var5;
            }

            var5 = var2 + 1;
            var11[var2] = 10;
            var6 = 19;
            var2 = var5;
            var5 = var6;
         }
      }

      int var16;
      if(var4) {
         int var17;
         if(var3 - this.c == var9 - 1) {
            if(this.c > 0) {
               var1 = this.j;
               var6 = 1;
               var7 = var1[0];
            } else {
               var7 = var1[var3];
               ++var3;
               var6 = 0;
            }

            var17 = (var7 & 255) << 4;
            this.c -= var6;
            var16 = var2 + 1;
            var11[var2] = var10[var17 >> 6 & 63];
            var15 = var16 + 1;
            var11[var16] = var10[var17 & 63];
            var2 = var15;
            if(this.d) {
               var17 = var15 + 1;
               var11[var15] = 61;
               var2 = var17 + 1;
               var11[var17] = 61;
            }

            var15 = var2;
            if(this.e) {
               var15 = var2;
               if(this.f) {
                  var11[var2] = 13;
                  var15 = var2 + 1;
               }

               var11[var15] = 10;
               ++var15;
            }

            var17 = var3;
         } else if(var3 - this.c == var9 - 2) {
            if(this.c > 1) {
               byte[] var12 = this.j;
               var15 = 1;
               var7 = var12[0];
            } else {
               var7 = var1[var3];
               ++var3;
               var15 = 0;
            }

            if(this.c > 0) {
               var8 = this.j[var15];
               ++var15;
            } else {
               var8 = var1[var3];
               ++var3;
            }

            var17 = (var8 & 255) << 2 | (var7 & 255) << 10;
            this.c -= var15;
            var15 = var2 + 1;
            var11[var2] = var10[var17 >> 12 & 63];
            var16 = var15 + 1;
            var11[var15] = var10[var17 >> 6 & 63];
            var2 = var16 + 1;
            var11[var16] = var10[var17 & 63];
            if(this.d) {
               var15 = var2 + 1;
               var11[var2] = 61;
               var2 = var15;
            }

            var15 = var2;
            if(this.e) {
               var15 = var2;
               if(this.f) {
                  var11[var2] = 13;
                  var15 = var2 + 1;
               }

               var11[var15] = 10;
               ++var15;
            }

            var17 = var3;
         } else {
            var17 = var3;
            var15 = var2;
            if(this.e) {
               var17 = var3;
               var15 = var2;
               if(var2 > 0) {
                  var17 = var3;
                  var15 = var2;
                  if(var5 != 19) {
                     if(this.f) {
                        var15 = var2 + 1;
                        var11[var2] = 13;
                        var2 = var15;
                     }

                     var15 = var2 + 1;
                     var11[var2] = 10;
                     var17 = var3;
                  }
               }
            }
         }

         if(!g && this.c != 0) {
            throw new AssertionError();
         }

         var16 = var15;
         if(!g) {
            var16 = var15;
            if(var17 != var9) {
               throw new AssertionError();
            }
         }
      } else if(var3 == var9 - 1) {
         var10 = this.j;
         var15 = this.c;
         this.c = var15 + 1;
         var10[var15] = var1[var3];
         var16 = var2;
      } else {
         var16 = var2;
         if(var3 == var9 - 2) {
            var10 = this.j;
            var15 = this.c;
            this.c = var15 + 1;
            var10[var15] = var1[var3];
            var10 = this.j;
            var15 = this.c;
            this.c = var15 + 1;
            var10[var15] = var1[var3 + 1];
            var16 = var2;
         }
      }

      this.b = var16;
      this.k = var5;
      return true;
   }
}
