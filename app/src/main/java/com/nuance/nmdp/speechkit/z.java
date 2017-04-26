package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericRecognition;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.TextRecognizer;
import com.nuance.nmdp.speechkit.TextRecognizer$Listener;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;

final class z extends com.nuance.nmdp.speechkit.s implements TextRecognizer {
   private TextRecognizer$Listener b;
   private final PdxValue$Dictionary c;

   public z(com.nuance.nmdp.speechkit.x var1, String var2, String var3, PdxValue$Dictionary var4, TextRecognizer$Listener var5, Object var6) {
      super(var1, "websearch", -1, var2, var3, var6);
      Object var8 = this.a;
      synchronized(var8) {
         this.b = var5;
      }

      this.c = var4;
      this.a();
   }

   protected final com.nuance.nmdp.speechkit.p a(final .cO var1, String var2, boolean var3, boolean var4, final String var5, final String var6, final .d var7) {
      return new com.nuance.nmdp.speechkit.y(var1, var5, var6, this.c, var7) {
         protected final void a(final SpeechError var1) {
            z.this.a(new Runnable() {
               // $FF: synthetic field
               private SpeechError a = var1;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(z.this.b != null) {
                     z.this.b.onError(z.this, this.a);
                  }

               }
            });
         }

         // $FF: synthetic method
         protected final void a(Object var1) {
            final GenericRecognition var2 = (GenericRecognition)var1;
            z.this.a(new Runnable() {
               // $FF: synthetic field
               private GenericRecognition a = var2;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(z.this.b != null) {
                     z.this.b.onResults(z.this, this.a);
                  }

               }
            });
         }

         protected final void b() {
            com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)z.this, (String)"onRecordingRegin is called for TextRecognizer for nothing.");
         }

         protected final void c() {
            com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)z.this, (String)"onRecordingDone is called for TextRecognizer for nothing.");
         }
      };
   }

   public final void setListener(TextRecognizer$Listener var1) {
      com.nuance.nmdp.speechkit.x.a((Object)var1, (String)"listener");
      Object var2 = this.a;
      synchronized(var2) {
         this.b = var1;
      }
   }
}
