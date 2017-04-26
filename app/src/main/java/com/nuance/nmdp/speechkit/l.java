package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericCommand;
import com.nuance.nmdp.speechkit.GenericCommand$Listener;
import com.nuance.nmdp.speechkit.GenericResult;
import com.nuance.nmdp.speechkit.SpeechError;
import java.util.List;

final class l extends com.nuance.nmdp.speechkit.b implements GenericCommand {
   private GenericCommand$Listener b;
   private String c;
   private SpeechError d = null;

   l(com.nuance.nmdp.speechkit.x var1, String var2, GenericCommand$Listener var3, Object var4) {
      super(var1, var1.l(), var4);
      this.c = var2;
      Object var6 = this.a;
      synchronized(var6) {
         this.b = var3;
      }

      this.a();
   }

   protected final com.nuance.nmdp.speechkit.a a(final .cO var1, final String var2, final List var3) {
      return new com.nuance.nmdp.speechkit.k(var1, var2, this.c, var3) {
         protected final void a(SpeechError var1) {
            l.this.d = var1;
         }

         // $FF: synthetic method
         protected final void a(Object var1) {
            final GenericResult var2 = (GenericResult)var1;
            l.this.a(new Runnable() {
               // $FF: synthetic field
               private GenericResult a = var2;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(l.this.b != null) {
                     l.this.b.onComplete(l.this, this.a, l.this.d);
                  }

               }
            });
         }
      };
   }
}
