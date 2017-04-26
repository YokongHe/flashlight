package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericRecognition;
import com.nuance.nmdp.speechkit.NluRecognizer;
import com.nuance.nmdp.speechkit.NluRecognizer$Listener;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;

final class n extends com.nuance.nmdp.speechkit.s implements NluRecognizer {
   private NluRecognizer$Listener b;
   private final PdxValue$Dictionary c;

   public n(com.nuance.nmdp.speechkit.x var1, String var2, int var3, String var4, String var5, PdxValue$Dictionary var6, NluRecognizer$Listener var7, Object var8) {
      super(var1, var2, var3, var4, var5, var8);
      Object var10 = this.a;
      synchronized(var10) {
         this.b = var7;
      }

      this.c = var6;
      this.a();
   }

   protected final com.nuance.nmdp.speechkit.p a(final .cO var1, final String var2, final boolean var3, final boolean var4, final String var5, final String var6, final .d var7) {
      return new com.nuance.nmdp.speechkit.m(var1, var2, var3, var4, var5, var6, this.c, var7) {
         protected final void a(final SpeechError var1) {
            n.this.a(new Runnable() {
               // $FF: synthetic field
               private SpeechError a = var1;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(n.this.b != null) {
                     n.this.b.onError(n.this, this.a);
                  }

               }
            });
         }

         // $FF: synthetic method
         protected final void a(Object var1) {
            final GenericRecognition var2 = (GenericRecognition)var1;
            n.this.a(new Runnable() {
               // $FF: synthetic field
               private GenericRecognition a = var2;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(n.this.b != null) {
                     n.this.b.onResults(n.this, this.a);
                  }

               }
            });
         }

         protected final void b() {
            n.this.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(n.this.b != null) {
                     n.this.b.onRecordingBegin(n.this);
                  }

               }
            });
         }

         protected final void c() {
            n.this.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(n.this.b != null) {
                     n.this.b.onRecordingDone(n.this);
                  }

               }
            });
         }
      };
   }

   public final void setListener(NluRecognizer$Listener var1) {
      com.nuance.nmdp.speechkit.x.a((Object)var1, (String)"listener");
      Object var2 = this.a;
      synchronized(var2) {
         this.b = var1;
      }
   }
}
