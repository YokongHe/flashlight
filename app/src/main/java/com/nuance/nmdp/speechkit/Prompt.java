package com.nuance.nmdp.speechkit;

public final class Prompt {
   private final .E a;
   private final com.nuance.nmdp.speechkit.x b;

   Prompt(.E var1, com.nuance.nmdp.speechkit.x var2) {
      this.a = var1;
      this.b = var2;
   }

   public static Prompt vibration(int var0) {
      return var0 <= 0?null:new Prompt(new .bI(var0), (com.nuance.nmdp.speechkit.x)null);
   }

   final .E a() {
      return this.a;
   }

   public final void release() {
      .y.a(new Runnable() {
         // $FF: synthetic field
         private Prompt a = Prompt.this;

         public final void run() {
            if(this.a.b != null) {
               this.a.b.a(this.a);
            }

         }
      });
   }
}
