package com.flurry.sdk;

import com.flurry.sdk.aw$b;
import com.flurry.sdk.aw$c;
import com.flurry.sdk.eo;
import com.flurry.sdk.fe;
import com.flurry.sdk.fh;
import com.flurry.sdk.fh$c;
import java.io.Closeable;
import java.io.IOException;

public class aw {
   private static final String a = com.flurry.sdk.aw.class.getSimpleName();
   private final String b;
   private final long c;
   private final boolean d;
   private fh e;

   public aw(String var1, long var2, boolean var4) {
      if(var1 != null && var1.length() != 0) {
         this.b = var1;
         this.c = var2;
         this.d = var4;
      } else {
         throw new IllegalArgumentException("The cache must have a name");
      }
   }

   // $FF: synthetic method
   static String a(com.flurry.sdk.aw var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static String e() {
      return a;
   }

   public aw$b a(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void a() {
      try {
         this.e = fh.a(com.flurry.sdk.ce.a(this.b), 1, 1, this.c);
      } catch (IOException var2) {
         eo.a(3, a, "Could not open cache: " + this.b);
      }
   }

   public aw$c b(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void b() {
      fe.a((Closeable)this.e);
   }

   public void c() {
      this.d();
      this.a();
   }

   public boolean c(String var1) {
      if(this.e != null && var1 != null) {
         try {
            boolean var2 = this.e.c(com.flurry.sdk.ce.c(var1));
            return var2;
         } catch (IOException var4) {
            eo.a(3, a, "Exception during remove for cache: " + this.b + " key: " + var1, var4);
            return false;
         }
      } else {
         return false;
      }
   }

   public void d() {
      if(this.e != null) {
         try {
            this.e.a();
         } catch (IOException var2) {
            eo.a(3, a, "Exception during delete for cache: " + this.b, var2);
         }
      }
   }

   public boolean d(String var1) {
      boolean var2 = false;
      if(this.e != null && var1 != null) {
         boolean var5 = false;

         fh$c var8;
         label54: {
            try {
               var5 = true;
               var8 = this.e.a(com.flurry.sdk.ce.c(var1));
               var5 = false;
               break label54;
            } catch (IOException var6) {
               eo.a(3, a, "Exception during exists for cache: " + this.b, var6);
               var5 = false;
            } finally {
               if(var5) {
                  fe.a((Closeable)null);
               }
            }

            fe.a((Closeable)null);
            return false;
         }

         if(var8 != null) {
            var2 = true;
         }

         fe.a((Closeable)var8);
         return var2;
      } else {
         return false;
      }
   }

   protected void finalize() {
      super.finalize();
      this.b();
   }
}
