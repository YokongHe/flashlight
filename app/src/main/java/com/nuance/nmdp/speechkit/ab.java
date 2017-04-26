package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.Vocalizer$Listener;

final class ab extends .a implements Vocalizer {
   private com.nuance.nmdp.speechkit.aa b;
   private Vocalizer$Listener c;
   private final com.nuance.nmdp.speechkit.x d;

   public ab(com.nuance.nmdp.speechkit.x var1, final String var2, final String var3, Vocalizer$Listener var4, Object var5) {
      super(var5);
      this.c = var4;
      this.d = var1;
      .y.a(new Runnable() {
         // $FF: synthetic field
         private String a = var2;
         // $FF: synthetic field
         private String b = var3;
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.ab c = ab.this;

         public final void run() {
            this.c.b = new com.nuance.nmdp.speechkit.aa(this.c.d.c(), this.a, this.b, com.nuance.nmdp.speechkit.ab.b(this.c));
         }
      });
   }

   private Vocalizer$Listener a() {
      Object var1 = this.a;
      synchronized(var1) {
         Vocalizer$Listener var2 = this.c;
         return var2;
      }
   }

   // $FF: synthetic method
   static Vocalizer$Listener b(final com.nuance.nmdp.speechkit.ab var0) {
      return new Vocalizer$Listener() {
         public final void onSpeakingBegin(Vocalizer var1, final String var2, final Object var3) {
            var0.a(new Runnable() {
               // $FF: synthetic field
               private String a = var2;
               // $FF: synthetic field
               private Object b = var3;
               // $FF: synthetic field
               private <undefinedtype> c = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  var0.a().onSpeakingBegin(var0, this.a, this.b);
               }
            });
         }

         public final void onSpeakingDone(Vocalizer var1, final String var2, final SpeechError var3, final Object var4) {
            var0.a(new Runnable() {
               // $FF: synthetic field
               private String a = var2;
               // $FF: synthetic field
               private SpeechError b = var3;
               // $FF: synthetic field
               private Object c = var4;
               // $FF: synthetic field
               private <undefinedtype> d = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  var0.a().onSpeakingDone(var0, this.a, this.b, this.c);
               }
            });
         }
      };
   }

   public final void cancel() {
      this.d.e();
      .y.a(new Runnable() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.ab a = ab.this;

         public final void run() {
            this.a.b.cancel();
         }
      });
   }

   public final void setLanguage(final String var1) {
      this.d.e();
      com.nuance.nmdp.speechkit.x.a(var1, "language");
      .y.a(new Runnable() {
         // $FF: synthetic field
         private String a = var1;
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.ab b = ab.this;

         public final void run() {
            this.b.b.setLanguage(this.a);
         }
      });
   }

   public final void setListener(Vocalizer$Listener var1) {
      com.nuance.nmdp.speechkit.x.a((Object)var1, (String)"listener");
      Object var2 = this.a;
      synchronized(var2) {
         this.c = var1;
      }
   }

   public final void setVoice(final String var1) {
      this.d.e();
      com.nuance.nmdp.speechkit.x.a(var1, "voice");
      .y.a(new Runnable() {
         // $FF: synthetic field
         private String a = var1;
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.ab b = ab.this;

         public final void run() {
            this.b.b.setVoice(this.a);
         }
      });
   }

   public final void speakMarkupString(final String var1, final Object var2) {
      this.d.e();
      com.nuance.nmdp.speechkit.x.a((Object)var1, (String)"text");
      .y.a(new Runnable() {
         // $FF: synthetic field
         private String a = var1;
         // $FF: synthetic field
         private Object b = var2;
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.ab c = ab.this;

         public final void run() {
            this.c.b.speakMarkupString(this.a, this.b);
         }
      });
   }

   public final void speakString(final String var1, final Object var2) {
      this.d.e();
      com.nuance.nmdp.speechkit.x.a((Object)var1, (String)"text");
      .y.a(new Runnable() {
         // $FF: synthetic field
         private String a = var1;
         // $FF: synthetic field
         private Object b = var2;
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.ab c = ab.this;

         public final void run() {
            this.c.b.speakString(this.a, this.b);
         }
      });
   }
}
