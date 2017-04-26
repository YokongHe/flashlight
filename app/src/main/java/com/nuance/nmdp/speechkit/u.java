package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericCommand;
import com.nuance.nmdp.speechkit.GenericCommand$Listener;
import com.nuance.nmdp.speechkit.GenericResult;
import com.nuance.nmdp.speechkit.SpeechError;
import java.util.List;

final class u extends com.nuance.nmdp.speechkit.b implements GenericCommand {
   private GenericCommand$Listener b;
   private SpeechError c = null;

   public u(com.nuance.nmdp.speechkit.x var1, GenericCommand$Listener var2, Object var3) {
      super(var1, var1.m(), var3);
      Object var5 = this.a;
      synchronized(var5) {
         this.b = var2;
      }

      this.a();
   }

   protected final com.nuance.nmdp.speechkit.a a(final .cO var1, final String var2, List var3) {
      return new com.nuance.nmdp.speechkit.t(var1, var2) {
         protected final void a(SpeechError var1) {
            u.this.c = var1;
         }

         // $FF: synthetic method
         protected final void a(Object var1) {
            final GenericResult var2 = (GenericResult)var1;
            u.this.a(new Runnable() {
               // $FF: synthetic field
               private GenericResult a = var2;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(u.this.b != null) {
                     u.this.b.onComplete(u.this, this.a, u.this.c);
                  }

               }
            });
         }
      };
   }
}
