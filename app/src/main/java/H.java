public final class H {
   private final E a;
   private final Object b;
   private final Object c;
   private final B d;
   private final Object e;
   private boolean f;
   private boolean g;

   public H(E var1, Object var2, Object var3, final B var4) {
      this.a = var1;
      this.b = var3;
      this.f = false;
      this.g = false;
      this.c = var2;
      this.e = new Object();
      this.d = new B() {
         // $FF: synthetic field
         private B a = var4;
         // $FF: synthetic field
         private H b = H.this;

         public final void a(Object var1) {
            Object var2 = this.b.e;
            synchronized(var2) {
               H.b(this.b);
            }

            this.a.a(var1);
         }

         public final void b(Object var1) {
            this.a.b(var1);
         }

         public final void c(Object var1) {
            Object var2 = this.b.e;
            synchronized(var2) {
               H.b(this.b);
            }

            this.a.c(var1);
         }
      };
   }

   // $FF: synthetic method
   static boolean b(H var0) {
      var0.g = true;
      return true;
   }

   public final void a() {
      if(!this.f) {
         this.f = true;
         this.a.a(this.c, this.d, this.b);
      } else {
         com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Prompt already started");
      }
   }

   public final void b() {
      if(this.f) {
         Object var1 = this.e;
         synchronized(var1) {
            if(!this.g) {
               com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)"Stopping prompt");
               this.g = true;
               this.a.a();
            }
         }
      }

   }
}
