package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.Vocalizer$Listener;
import com.nuance.nmdp.speechkit.aa$a;

final class aa implements Vocalizer {
   private String a;
   private String b;
   private final Vocalizer$Listener c;
   private final .cO d;
   private final .r e;
   private .cI f;
   private aa$a g;
   private SpeechError h;
   private final .z i;

   aa(.cO var1, String var2, String var3, Vocalizer$Listener var4) {
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var1;
      this.e = new .r() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.aa a = aa.this;

         public final void a(.cI var1) {
            if(this.a.h != null) {
               if(this.a.f == var1) {
                  this.a.a(aa$a.a(this.a.g), aa$a.b(this.a.g), this.a.h);
                  com.nuance.nmdp.speechkit.aa.d(this.a);
                  com.nuance.nmdp.speechkit.aa.e(this.a);
                  this.a.h = null;
               }
            } else if(this.a.f == var1) {
               this.a.c.onSpeakingDone(this.a, aa$a.a(this.a.g), (SpeechError)null, aa$a.b(this.a.g));
               if(this.a.i.f() > 0) {
                  aa$a var2 = (aa$a)this.a.i.d();
                  this.a.a(var2);
                  return;
               }

               com.nuance.nmdp.speechkit.aa.d(this.a);
               com.nuance.nmdp.speechkit.aa.e(this.a);
               return;
            }

         }

         public final void a(.cI var1, int var2, String var3, String var4) {
            if(this.a.f == var1) {
               this.a.h = new com.nuance.nmdp.speechkit.v(var2, var3, var4);
            }

         }

         public final void b(.cI var1) {
            if(this.a.f == var1) {
               this.a.c.onSpeakingBegin(this.a, aa$a.a(this.a.g), aa$a.b(this.a.g));
            }

         }
      };
      this.f = null;
      this.g = null;
      this.h = null;
      this.i = new .z();
   }

   private void a(aa$a var1) {
      if(this.d.b()) {
         this.h = null;
         this.f = this.d.a(aa$a.a(var1), aa$a.c(var1), aa$a.d(var1), aa$a.e(var1), this.e);
         if(this.f == null) {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create TTS transaction");
            this.a(aa$a.a(var1), aa$a.b(var1), new com.nuance.nmdp.speechkit.v(0, (String)null, (String)null));
         } else {
            this.g = var1;
            this.f.a();
         }
      } else {
         com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create TTS transaction. Transaction runner is invalid.");
         this.a(aa$a.a(var1), aa$a.b(var1), new com.nuance.nmdp.speechkit.v(0, (String)null, (String)null));
      }
   }

   private void a(String var1, Object var2, SpeechError var3) {
      this.c.onSpeakingDone(this, var1, var3, var2);
      int var5 = this.i.f();

      for(int var4 = 0; var4 < var5; ++var4) {
         aa$a var6 = (aa$a)this.i.a(var4);
         this.c.onSpeakingDone(this, aa$a.a(var6), var3, aa$a.b(var6));
      }

      this.i.e();
   }

   // $FF: synthetic method
   static .cI d(com.nuance.nmdp.speechkit.aa var0) {
      var0.f = null;
      return null;
   }

   // $FF: synthetic method
   static aa$a e(com.nuance.nmdp.speechkit.aa var0) {
      var0.g = null;
      return null;
   }

   public final void cancel() {
      if(this.f != null) {
         this.f.p();
      }

   }

   public final void setLanguage(String var1) {
      this.b = var1;
      this.a = null;
   }

   public final void setListener(Vocalizer$Listener var1) {
   }

   public final void setVoice(String var1) {
      this.b = null;
      this.a = var1;
   }

   public final void speakMarkupString(String var1, Object var2) {
      aa$a var3 = new aa$a(true, var1, this.a, this.b, var2);
      if(this.f == null) {
         this.a(var3);
      } else {
         this.i.a(var3);
      }
   }

   public final void speakString(String var1, Object var2) {
      aa$a var3 = new aa$a(false, var1, this.a, this.b, var2);
      if(this.f == null) {
         this.a(var3);
      } else {
         this.i.a(var3);
      }
   }
}
