package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Prompt;

abstract class s extends .a implements com.nuance.nmdp.speechkit.j {
   private com.nuance.nmdp.speechkit.p b;
   private final com.nuance.nmdp.speechkit.x c;
   private float d;
   private Runnable e;
   private String f;
   private final Object g;

   public s(com.nuance.nmdp.speechkit.x var1, final String var2, final int var3, final String var4, String var5, Object var6) {
      super(var6);
      this.c = var1;
      this.d = 0.0F;
      this.g = new Object();
      this.f = var5;
      this.e = new Runnable() {
         // $FF: synthetic field
         private String a = var2;
         // $FF: synthetic field
         private int b = var3;
         // $FF: synthetic field
         private String c = var4;
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.s d = s.this;

         public final void run() {
            // $FF: Couldn't be decompiled
         }
      };
   }

   // $FF: synthetic method
   static float a(com.nuance.nmdp.speechkit.s var0, float var1) {
      var0.d = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object c(com.nuance.nmdp.speechkit.s var0) {
      return var0.g;
   }

   protected abstract com.nuance.nmdp.speechkit.p a(.cO var1, String var2, boolean var3, boolean var4, String var5, String var6, .d var7);

   protected final void a() {
      if(this.e != null) {
         .y.a(this.e);
         this.e = null;
      }

   }

   public void cancel() {
      this.c.e();
      .y.a(new Runnable() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.s a = s.this;

         public final void run() {
            this.a.b.f();
         }
      });
   }

   public float getAudioLevel() {
      Object var2 = this.g;
      synchronized(var2) {
         float var1 = this.d;
         return var1;
      }
   }

   public void setPrompt(final int var1, final Prompt var2) {
      this.c.e();
      .y.a(new Runnable() {
         // $FF: synthetic field
         private int a = var1;
         // $FF: synthetic field
         private Prompt b = var2;
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.s c = s.this;

         public final void run() {
            this.c.b.a(this.a, this.b);
         }
      });
   }

   public void start() {
      this.c.e();
      .y.a(new Runnable() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.s a = s.this;

         public final void run() {
            this.a.b.d();
         }
      });
   }

   public void stopRecording() {
      this.c.e();
      .y.a(new Runnable() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.s a = s.this;

         public final void run() {
            this.a.b.e();
         }
      });
   }
}
