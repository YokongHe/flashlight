package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.Recognizer$Listener;
import com.nuance.nmdp.speechkit.SpeechError;

final class r extends com.nuance.nmdp.speechkit.s implements Recognizer {
   private Recognizer$Listener b;

   public r(com.nuance.nmdp.speechkit.x var1, String var2, int var3, String var4, Recognizer$Listener var5, Object var6) {
      super(var1, var2, var3, var4, (String)null, var6);
      Object var8 = this.a;
      synchronized(var8) {
         this.b = var5;
      }

      this.a();
   }

   protected final com.nuance.nmdp.speechkit.p a(final .cO var1, final String var2, final boolean var3, final boolean var4, final String var5, String var6, final .d var7) {
      return new com.nuance.nmdp.speechkit.q(var1, var2, var3, var4, var5, var7) {
         protected final void a(final SpeechError var1) {
            r.this.a(new Runnable() {
               // $FF: synthetic field
               private SpeechError a = var1;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(r.this.b != null) {
                     r.this.b.onError(r.this, this.a);
                  }

               }
            });
         }

         // $FF: synthetic method
         protected final void a(Object var1) {
            final Recognition var2 = (Recognition)var1;
            r.this.a(new Runnable() {
               // $FF: synthetic field
               private Recognition a = var2;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(r.this.b != null) {
                     r.this.b.onResults(r.this, this.a);
                  }

               }
            });
         }

         protected final void b() {
            r.this.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(r.this.b != null) {
                     r.this.b.onRecordingBegin(r.this);
                  }

               }
            });
         }

         protected final void c() {
            r.this.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(r.this.b != null) {
                     r.this.b.onRecordingDone(r.this);
                  }

               }
            });
         }
      };
   }

   public final void setListener(Recognizer$Listener var1) {
      com.nuance.nmdp.speechkit.x.a((Object)var1, (String)"listener");
      Object var2 = this.a;
      synchronized(var2) {
         this.b = var1;
      }
   }
}
