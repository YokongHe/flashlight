package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.SpeechError;
import java.util.List;

abstract class a {
   private final .cO a;
   private final String b;
   private .J c;
   private final List d;
   private boolean e;
   private final .cJ f;
   private .cI g;

   a(.cO var1, String var2, List var3) {
      this.a = var1;
      this.b = var2;
      this.d = var3;
      this.f = new .cJ() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.a a = a.this;

         public final void a(.cI var1) {
            if(this.a.g == var1) {
               if(this.a.c != null) {
                  this.a.a(this.a.c.b());
               } else {
                  this.a.a((Object)null);
               }

               com.nuance.nmdp.speechkit.a.c(this.a);
            }

         }

         public final void a(.cI var1, int var2, String var3, String var4) {
            if(this.a.g == var1) {
               this.a.a((SpeechError)(new com.nuance.nmdp.speechkit.v(var2, var3, var4)));
            }

         }
      };
      this.e = false;
   }

   // $FF: synthetic method
   static .cI c(com.nuance.nmdp.speechkit.a var0) {
      var0.g = null;
      return null;
   }

   protected abstract .J a();

   protected abstract .cI a(.cO var1, String var2, List var3, .J var4, .cJ var5);

   protected abstract void a(SpeechError var1);

   protected abstract void a(Object var1);

   public final void b() {
      if(this.a.b()) {
         if(!this.e) {
            this.c = this.a();
            this.g = this.a(this.a, this.b, this.d, this.c, this.f);
            if(this.g == null) {
               com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create command transaction");
               this.a((SpeechError)(new com.nuance.nmdp.speechkit.v(0, (String)null, (String)null)));
            } else {
               this.e = true;
               this.g.a();
            }
         }
      } else {
         com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create command transaction. Transaction runner is invalid.");
         this.a((SpeechError)(new com.nuance.nmdp.speechkit.v(0, (String)null, (String)null)));
      }
   }

   public final void c() {
      if(this.g != null) {
         this.g.p();
         this.g = null;
      }

   }
}
