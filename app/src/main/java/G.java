public final class G {
   private final ay a;
   private final B b;
   private final bn c;
   private db d;
   private final Object e;
   private boolean f;
   private boolean g;
   private boolean h;
   private boolean i;
   private Object j;
   private final Object k;

   public G(bn param1, Object param2, Object param3, B param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static Object a(G var0) {
      return var0.j;
   }

   // $FF: synthetic method
   static boolean b(G var0) {
      var0.h = true;
      return true;
   }

   // $FF: synthetic method
   static boolean c(G var0) {
      return var0.i;
   }

   // $FF: synthetic method
   static boolean d(G var0) {
      var0.i = false;
      return false;
   }

   // $FF: synthetic method
   static Object e(G var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static B f(G var0) {
      return var0.b;
   }

   public final void a() {
      if(!this.f) {
         if(this.d != null) {
            this.f = true;

            try {
               com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)"Starting audio player");
               this.d.a();
               return;
            } catch (Throwable var2) {
               com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting player", var2);
            }
         }
      } else {
         com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Player already started");
      }

      this.b.a(this.e);
   }

   public final void b() {
      // $FF: Couldn't be decompiled
   }

   public final db c() {
      return this.d;
   }
}
