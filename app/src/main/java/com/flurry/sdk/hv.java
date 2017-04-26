package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.hi;
import com.flurry.sdk.hj;
import com.flurry.sdk.hj$a;
import com.flurry.sdk.hm;
import com.flurry.sdk.sj;

public abstract class hv extends hj {
   protected hv() {
   }

   protected hv(int var1) {
      super(var1);
   }

   protected static final String c(int var0) {
      char var1 = (char)var0;
      return Character.isISOControl(var1)?"(CTRL-CHAR, code " + var0 + ")":(var0 > 255?"\'" + var1 + "\' (code " + var0 + " / 0x" + Integer.toHexString(var0) + ")":"\'" + var1 + "\' (code " + var0 + ")");
   }

   protected abstract void H();

   protected void R() {
      throw this.a("Unexpected end-of-String in base64 content");
   }

   protected void S() {
      this.c(" in " + this.b);
   }

   protected void T() {
      this.c(" in a value");
   }

   protected final void U() {
      throw new RuntimeException("Internal error: this code path should never get executed");
   }

   protected char a(char var1) {
      if(!this.a(hj$a.f) && (var1 != 39 || !this.a(hj$a.d))) {
         this.d("Unrecognized character escape " + c(var1));
         return var1;
      } else {
         return var1;
      }
   }

   protected void a(ha var1, char var2, int var3, String var4) {
      String var6;
      if(var2 <= 32) {
         var6 = "Illegal white space character (code 0x" + Integer.toHexString(var2) + ") as character #" + (var3 + 1) + " of 4-char base64 unit: can only used between units";
      } else if(var1.a(var2)) {
         var6 = "Unexpected padding character (\'" + var1.b() + "\') as character #" + (var3 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if(Character.isDefined(var2) && !Character.isISOControl(var2)) {
         var6 = "Illegal character \'" + var2 + "\' (code 0x" + Integer.toHexString(var2) + ") in base64 content";
      } else {
         var6 = "Illegal character (code 0x" + Integer.toHexString(var2) + ") in base64 content";
      }

      String var5 = var6;
      if(var4 != null) {
         var5 = var6 + ": " + var4;
      }

      throw this.a(var5);
   }

   protected void a(String var1, sj var2, ha var3) {
      int var7 = var1.length();
      int var5 = 0;

      while(var5 < var7) {
         while(true) {
            int var6 = var5 + 1;
            char var4 = var1.charAt(var5);
            if(var6 >= var7) {
               return;
            }

            if(var4 > 32) {
               int var8 = var3.b(var4);
               if(var8 < 0) {
                  this.a(var3, var4, 0, (String)null);
               }

               if(var6 >= var7) {
                  this.R();
               }

               var5 = var6 + 1;
               var4 = var1.charAt(var6);
               var6 = var3.b(var4);
               if(var6 < 0) {
                  this.a(var3, var4, 1, (String)null);
               }

               var8 = var8 << 6 | var6;
               if(var5 >= var7) {
                  if(!var3.a()) {
                     var2.a(var8 >> 4);
                     return;
                  }

                  this.R();
               }

               var6 = var5 + 1;
               var4 = var1.charAt(var5);
               var5 = var3.b(var4);
               if(var5 < 0) {
                  if(var5 != -2) {
                     this.a(var3, var4, 2, (String)null);
                  }

                  if(var6 >= var7) {
                     this.R();
                  }

                  var5 = var6 + 1;
                  var4 = var1.charAt(var6);
                  if(!var3.a(var4)) {
                     this.a(var3, var4, 3, "expected padding character \'" + var3.b() + "\'");
                  }

                  var2.a(var8 >> 4);
               } else {
                  var8 = var8 << 6 | var5;
                  if(var6 >= var7) {
                     if(!var3.a()) {
                        var2.b(var8 >> 2);
                        return;
                     }

                     this.R();
                  }

                  var5 = var6 + 1;
                  var4 = var1.charAt(var6);
                  var6 = var3.b(var4);
                  if(var6 < 0) {
                     if(var6 != -2) {
                        this.a(var3, var4, 3, (String)null);
                     }

                     var2.b(var8 >> 2);
                  } else {
                     var2.c(var8 << 6 | var6);
                  }
               }
            } else {
               var5 = var6;
            }
         }
      }

   }

   protected final void a(String var1, Throwable var2) {
      throw this.b(var1, var2);
   }

   protected final hi b(String var1, Throwable var2) {
      return new hi(var1, this.i(), var2);
   }

   public abstract hm b();

   protected void b(int var1) {
      char var2 = (char)var1;
      this.d("Illegal character (" + c(var2) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
   }

   protected void b(int var1, String var2) {
      String var4 = "Unexpected character (" + c(var1) + ")";
      String var3 = var4;
      if(var2 != null) {
         var3 = var4 + ": " + var2;
      }

      this.d(var3);
   }

   protected void c(int var1, String var2) {
      if(!this.a(hj$a.e) || var1 >= 32) {
         char var3 = (char)var1;
         this.d("Illegal unquoted character (" + c(var3) + "): has to be escaped using backslash to be included in " + var2);
      }

   }

   protected void c(String var1) {
      this.d("Unexpected end-of-input" + var1);
   }

   public hj d() {
      if(this.b != hm.b && this.b != hm.d) {
         return this;
      } else {
         int var1 = 1;

         while(true) {
            hm var3 = this.b();
            if(var3 == null) {
               this.H();
               return this;
            }

            switch(null.a[var3.ordinal()]) {
            case 1:
            case 2:
               ++var1;
               break;
            case 3:
            case 4:
               int var2 = var1 - 1;
               var1 = var2;
               if(var2 == 0) {
                  return this;
               }
            }
         }
      }
   }

   protected final void d(String var1) {
      throw this.a(var1);
   }

   public abstract String k();
}
