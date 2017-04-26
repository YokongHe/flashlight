package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.Recognizer$Listener;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Sequence;

final class d extends com.nuance.nmdp.speechkit.s implements Recognizer {
   private Recognizer$Listener b;
   private final PdxValue$Sequence c;

   public d(com.nuance.nmdp.speechkit.x var1, String var2, int var3, String var4, PdxValue$Sequence var5, Recognizer$Listener var6, Object var7) {
      super(var1, var2, var3, var4, (String)null, var7);
      Object var9 = this.a;
      synchronized(var9) {
         this.b = var6;
      }

      this.c = var5;
      this.a();
   }

   protected final com.nuance.nmdp.speechkit.p a(final .cO var1, final String var2, final boolean var3, final boolean var4, final String var5, String var6, final .d var7) {
      return new com.nuance.nmdp.speechkit.c(var1, var2, var3, var4, var5, this.c, var7) {
         protected final void a(final SpeechError var1) {
            d.this.a(new Runnable() {
               // $FF: synthetic field
               private SpeechError a = var1;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(d.this.b != null) {
                     d.this.b.onError(d.this, this.a);
                  }

               }
            });
         }

         // $FF: synthetic method
         protected final void a(Object var1) {
            final Recognition var2 = (Recognition)var1;
            d.this.a(new Runnable() {
               // $FF: synthetic field
               private Recognition a = var2;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(d.this.b != null) {
                     d.this.b.onResults(d.this, this.a);
                  }

               }
            });
         }

         protected final void b() {
            d.this.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(d.this.b != null) {
                     d.this.b.onRecordingBegin(d.this);
                  }

               }
            });
         }

         protected final void c() {
            d.this.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(d.this.b != null) {
                     d.this.b.onRecordingDone(d.this);
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
