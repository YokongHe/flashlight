import android.content.Context;
import android.os.Vibrator;

public final class bI implements E {
   private boolean a = false;
   private final int b;
   private Vibrator c;

   public bI(int var1) {
      this.b = var1;
      this.c = null;
   }

   // $FF: synthetic method
   static Vibrator a(bI var0) {
      var0.c = null;
      return null;
   }

   public final void a() {
      if(this.c != null) {
         this.c.cancel();
         this.c = null;
      }
   }

   public final void a(Object var1, final B var2, final Object var3) {
      this.c = (Vibrator)((Context)var1).getSystemService("vibrator");
      if(this.c == null) {
         com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to get vibrator service");
         var2.a(var3);
      } else if(this.a) {
         com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Can\'t start disposed vibration prompt.");
         var2.a(var3);
      } else {
         try {
            com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)("Starting vibration (" + this.b + " ms)"));
            this.c.vibrate((long)this.b);
         } catch (Throwable var4) {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Unable to vibrate", var4);
            var2.a(var3);
            return;
         }

         y.a(new Runnable() {
            // $FF: synthetic field
            private B a = var2;
            // $FF: synthetic field
            private Object b = var3;
            // $FF: synthetic field
            private bI c = bI.this;

            public final void run() {
               com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this.c, (String)"Vibration finished");
               this.a.c(this.b);
               bI.a(this.c);
            }
         }, this.b);
      }
   }

   public final void b() {
      this.a = true;
      if(this.c != null) {
         this.c.cancel();
         this.c = null;
      }

   }

   public final boolean c() {
      return this.a;
   }
}
