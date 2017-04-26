package com.flurry.sdk;

import com.flurry.sdk.hc;
import com.flurry.sdk.hj;
import com.flurry.sdk.hj$a;
import com.flurry.sdk.hn;
import com.flurry.sdk.hy;
import com.flurry.sdk.ia;
import com.flurry.sdk.ie;
import com.flurry.sdk.ih;
import com.flurry.sdk.in;
import com.flurry.sdk.sa;
import com.flurry.sdk.sb;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class hr {
   protected final ie a;
   protected final InputStream b;
   protected final byte[] c;
   protected int d;
   protected boolean e = true;
   protected int f = 0;
   private int g;
   private int h;
   private final boolean i;

   public hr(ie var1, InputStream var2) {
      this.a = var1;
      this.b = var2;
      this.c = var1.e();
      this.g = 0;
      this.h = 0;
      this.d = 0;
      this.i = true;
   }

   private void a(String var1) {
      throw new CharConversionException("Unsupported UCS-4 endianness (" + var1 + ") detected");
   }

   private boolean b(int var1) {
      switch(var1) {
      case -131072:
         this.g += 4;
         this.f = 4;
         this.e = false;
         return true;
      case 65279:
         this.e = true;
         this.g += 4;
         this.f = 4;
         return true;
      case 65534:
         this.a("2143");
      case -16842752:
         this.a("3412");
      default:
         int var2 = var1 >>> 16;
         if(var2 == '\ufeff') {
            this.g += 2;
            this.f = 2;
            this.e = true;
            return true;
         } else if(var2 == '\ufffe') {
            this.g += 2;
            this.f = 2;
            this.e = false;
            return true;
         } else if(var1 >>> 8 == 15711167) {
            this.g += 3;
            this.f = 1;
            this.e = true;
            return true;
         } else {
            return false;
         }
      }
   }

   private boolean c(int var1) {
      boolean var2 = false;
      if(var1 >> 8 == 0) {
         this.e = true;
      } else if((16777215 & var1) == 0) {
         this.e = false;
      } else if((-16711681 & var1) == 0) {
         this.a("3412");
      } else {
         if((-65281 & var1) != 0) {
            return var2;
         }

         this.a("2143");
      }

      this.f = 4;
      var2 = true;
      return var2;
   }

   private boolean d(int var1) {
      boolean var2 = false;
      if(('\uff00' & var1) == 0) {
         this.e = true;
      } else {
         if((var1 & 255) != 0) {
            return var2;
         }

         this.e = false;
      }

      this.f = 2;
      var2 = true;
      return var2;
   }

   public final hc a() {
      boolean var1;
      label39: {
         boolean var2 = true;
         if(this.a(4)) {
            int var3 = this.c[this.g] << 24 | (this.c[this.g + 1] & 255) << 16 | (this.c[this.g + 2] & 255) << 8 | this.c[this.g + 3] & 255;
            if(this.b(var3)) {
               var1 = var2;
               break label39;
            }

            var1 = var2;
            if(this.c(var3)) {
               break label39;
            }

            var1 = var2;
            if(this.d(var3 >>> 16)) {
               break label39;
            }
         } else if(this.a(2) && this.d((this.c[this.g] & 255) << 8 | this.c[this.g + 1] & 255)) {
            var1 = var2;
            break label39;
         }

         var1 = false;
      }

      hc var4;
      if(!var1) {
         var4 = hc.a;
      } else {
         switch(this.f) {
         case 1:
            var4 = hc.a;
            break;
         case 2:
            if(this.e) {
               var4 = hc.b;
            } else {
               var4 = hc.c;
            }
            break;
         case 3:
         default:
            throw new RuntimeException("Internal error");
         case 4:
            if(this.e) {
               var4 = hc.d;
            } else {
               var4 = hc.e;
            }
         }
      }

      this.a.a(var4);
      return var4;
   }

   public final hj a(int var1, hn var2, sa var3, sb var4) {
      hc var7 = this.a();
      boolean var5 = hj$a.j.a(var1);
      boolean var6 = hj$a.i.a(var1);
      if(var7 == hc.a && var5) {
         var3 = var3.a(var5, var6);
         return new ia(this.a, var1, this.b, var2, var3, this.c, this.g, this.h, this.i);
      } else {
         return new hy(this.a, var1, this.b(), var2, var4.a(var5, var6));
      }
   }

   protected final boolean a(int var1) {
      int var3;
      for(int var2 = this.h - this.g; var2 < var1; var2 += var3) {
         if(this.b == null) {
            var3 = -1;
         } else {
            var3 = this.b.read(this.c, this.h, this.c.length - this.h);
         }

         if(var3 <= 0) {
            return false;
         }

         this.h += var3;
      }

      return true;
   }

   public final Reader b() {
      hc var2 = this.a.b();
      switch(null.a[var2.ordinal()]) {
      case 1:
      case 2:
         return new in(this.a, this.b, this.c, this.g, this.h, this.a.b().b());
      case 3:
      case 4:
      case 5:
         Object var1 = this.b;
         if(var1 == null) {
            var1 = new ByteArrayInputStream(this.c, this.g, this.h);
         } else if(this.g < this.h) {
            var1 = new ih(this.a, (InputStream)var1, this.c, this.g, this.h);
         }

         return new InputStreamReader((InputStream)var1, var2.a());
      default:
         throw new RuntimeException("Internal error");
      }
   }
}
