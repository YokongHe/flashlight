package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.Base64;
import com.adsdk.sdk.mraid.Base64$Coder;

class Base64$Encoder extends Base64$Coder {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private static final byte[] ENCODE;
   private static final byte[] ENCODE_WEBSAFE;
   public static final int LINE_GROUPS = 19;
   private final byte[] alphabet;
   private int count;
   public final boolean do_cr;
   public final boolean do_newline;
   public final boolean do_padding;
   private final byte[] tail;
   int tailLen;

   static {
      boolean var0;
      if(!Base64.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
      ENCODE = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)43, (byte)47};
      ENCODE_WEBSAFE = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)45, (byte)95};
   }

   public Base64$Encoder(int var1, byte[] var2) {
      boolean var4 = true;
      super();
      this.output = var2;
      boolean var3;
      if((var1 & 1) == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.do_padding = var3;
      if((var1 & 2) == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.do_newline = var3;
      if((var1 & 4) != 0) {
         var3 = var4;
      } else {
         var3 = false;
      }

      this.do_cr = var3;
      if((var1 & 8) == 0) {
         var2 = ENCODE;
      } else {
         var2 = ENCODE_WEBSAFE;
      }

      this.alphabet = var2;
      this.tail = new byte[2];
      this.tailLen = 0;
      byte var5;
      if(this.do_newline) {
         var5 = 19;
      } else {
         var5 = -1;
      }

      this.count = var5;
   }

   public int maxOutputSize(int var1) {
      return var1 * 8 / 5 + 10;
   }

   public boolean process(byte[] var1, int var2, int var3, boolean var4) {
      byte var5;
      int var6;
      byte var7;
      byte var8;
      int var9;
      byte[] var10;
      byte[] var11;
      label119: {
         var10 = this.alphabet;
         var11 = this.output;
         var5 = 0;
         var6 = this.count;
         var9 = var3 + var2;
         byte var13;
         switch(this.tailLen) {
         case 0:
            var7 = -1;
            var3 = var2;
            var2 = var7;
            break label119;
         case 1:
            if(var2 + 2 <= var9) {
               var7 = this.tail[0];
               var3 = var2 + 1;
               var13 = var1[var2];
               var8 = var1[var3];
               this.tailLen = 0;
               var2 = (var7 & 255) << 16 | (var13 & 255) << 8 | var8 & 255;
               ++var3;
               break label119;
            }
            break;
         case 2:
            if(var2 + 1 <= var9) {
               var7 = this.tail[0];
               var8 = this.tail[1];
               var3 = var2 + 1;
               var13 = var1[var2];
               this.tailLen = 0;
               var2 = (var7 & 255) << 16 | (var8 & 255) << 8 | var13 & 255;
               break label119;
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
         var5 = 4;
         var11[3] = var10[var2 & 63];
         --var6;
         if(var6 == 0) {
            byte var14 = var5;
            if(this.do_cr) {
               var14 = 5;
               var11[4] = 13;
            }

            var15 = var14 + 1;
            var11[var14] = 10;
            var6 = 19;
            var2 = var15;
         } else {
            var2 = 4;
         }
      } else {
         var2 = var5;
      }

      while(var3 + 3 <= var9) {
         var15 = (var1[var3] & 255) << 16 | (var1[var3 + 1] & 255) << 8 | var1[var3 + 2] & 255;
         var11[var2] = var10[var15 >> 18 & 63];
         var11[var2 + 1] = var10[var15 >> 12 & 63];
         var11[var2 + 2] = var10[var15 >> 6 & 63];
         var11[var2 + 3] = var10[var15 & 63];
         var3 += 3;
         var2 += 4;
         --var6;
         if(var6 == 0) {
            if(this.do_cr) {
               var15 = var2 + 1;
               var11[var2] = 13;
               var2 = var15;
            }

            var15 = var2 + 1;
            var11[var2] = 10;
            var6 = 19;
            var2 = var15;
         }
      }

      int var16;
      if(var4) {
         int var17;
         if(var3 - this.tailLen == var9 - 1) {
            if(this.tailLen > 0) {
               var1 = this.tail;
               var5 = 1;
               var7 = var1[0];
            } else {
               var7 = var1[var3];
               ++var3;
               var5 = 0;
            }

            var17 = (var7 & 255) << 4;
            this.tailLen -= var5;
            var16 = var2 + 1;
            var11[var2] = var10[var17 >> 6 & 63];
            var15 = var16 + 1;
            var11[var16] = var10[var17 & 63];
            var2 = var15;
            if(this.do_padding) {
               var17 = var15 + 1;
               var11[var15] = 61;
               var2 = var17 + 1;
               var11[var17] = 61;
            }

            var15 = var2;
            var17 = var3;
            if(this.do_newline) {
               var15 = var2;
               if(this.do_cr) {
                  var11[var2] = 13;
                  var15 = var2 + 1;
               }

               var2 = var15 + 1;
               var11[var15] = 10;
               var15 = var2;
               var17 = var3;
            }
         } else if(var3 - this.tailLen == var9 - 2) {
            if(this.tailLen > 1) {
               byte[] var12 = this.tail;
               var15 = 1;
               var7 = var12[0];
            } else {
               var7 = var1[var3];
               ++var3;
               var15 = 0;
            }

            if(this.tailLen > 0) {
               var8 = this.tail[var15];
               ++var15;
            } else {
               var8 = var1[var3];
               ++var3;
            }

            var17 = (var8 & 255) << 2 | (var7 & 255) << 10;
            this.tailLen -= var15;
            var15 = var2 + 1;
            var11[var2] = var10[var17 >> 12 & 63];
            var16 = var15 + 1;
            var11[var15] = var10[var17 >> 6 & 63];
            var2 = var16 + 1;
            var11[var16] = var10[var17 & 63];
            if(this.do_padding) {
               var15 = var2 + 1;
               var11[var2] = 61;
               var2 = var15;
            }

            var15 = var2;
            var17 = var3;
            if(this.do_newline) {
               var15 = var2;
               if(this.do_cr) {
                  var11[var2] = 13;
                  var15 = var2 + 1;
               }

               var2 = var15 + 1;
               var11[var15] = 10;
               var17 = var3;
               var15 = var2;
            }
         } else {
            var17 = var3;
            var15 = var2;
            if(this.do_newline) {
               var17 = var3;
               var15 = var2;
               if(var2 > 0) {
                  var17 = var3;
                  var15 = var2;
                  if(var6 != 19) {
                     if(this.do_cr) {
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

         if(!$assertionsDisabled && this.tailLen != 0) {
            throw new AssertionError();
         }

         var16 = var15;
         if(!$assertionsDisabled) {
            var16 = var15;
            if(var17 != var9) {
               throw new AssertionError();
            }
         }
      } else if(var3 == var9 - 1) {
         var10 = this.tail;
         var15 = this.tailLen;
         this.tailLen = var15 + 1;
         var10[var15] = var1[var3];
         var16 = var2;
      } else {
         var16 = var2;
         if(var3 == var9 - 2) {
            var10 = this.tail;
            var15 = this.tailLen;
            this.tailLen = var15 + 1;
            var10[var15] = var1[var3];
            var10 = this.tail;
            var15 = this.tailLen;
            this.tailLen = var15 + 1;
            var10[var15] = var1[var3 + 1];
            var16 = var2;
         }
      }

      this.op = var16;
      this.count = var6;
      return true;
   }
}
