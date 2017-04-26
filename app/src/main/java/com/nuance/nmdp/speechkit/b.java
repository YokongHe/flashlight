package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$String;
import java.util.ArrayList;
import java.util.List;

abstract class b extends .a {
   private final String b;
   private final List c;
   private final com.nuance.nmdp.speechkit.x d;
   private com.nuance.nmdp.speechkit.a e;
   private Runnable f;

   b(com.nuance.nmdp.speechkit.x var1, String var2, Object var3) {
      super(var3);
      this.b = var2;
      this.c = new ArrayList();
      this.d = var1;
      this.f = new Runnable() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.b a = b.this;

         public final void run() {
            this.a.e = this.a.a(this.a.d.c(), this.a.b, this.a.c);
         }
      };
   }

   protected abstract com.nuance.nmdp.speechkit.a a(.cO var1, String var2, List var3);

   protected final void a() {
      if(this.f != null) {
         .y.a(this.f);
         this.f = null;
      }

   }

   public void addParam(String var1, PdxValue$Dictionary var2) {
      this.c.add(new .cS(var1, var2));
   }

   public void addParam(String var1, PdxValue$String var2) {
      this.c.add(new .cS(var1, var2));
   }

   public void cancel() {
      this.d.e();
      .y.a(new Runnable() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.b a = b.this;

         public final void run() {
            this.a.e.c();
         }
      });
   }

   public void start() {
      this.d.e();
      .y.a(new Runnable() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.b a = b.this;

         public final void run() {
            this.a.e.b();
         }
      });
   }
}
