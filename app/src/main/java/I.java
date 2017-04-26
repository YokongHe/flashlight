public final class I {
   private static final z a = new z();
   private final A b;
   private final F c;
   private aC d;
   private final Object e;
   private final az f;
   private boolean g;
   private boolean h;
   private boolean i;
   private boolean j;
   private final Object k;
   private final Object l;

   public I(bn param1, boolean param2, boolean param3, Object param4, Object param5, F param6) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static Object b(I var0) {
      return var0.k;
   }

   // $FF: synthetic method
   static z c() {
      return null;
   }

   // $FF: synthetic method
   static boolean c(I var0) {
      var0.i = true;
      return true;
   }

   // $FF: synthetic method
   static boolean d(I var0) {
      return var0.j;
   }

   // $FF: synthetic method
   static boolean e(I var0) {
      var0.j = false;
      return false;
   }

   // $FF: synthetic method
   static aC f(I var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static Object g(I var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static F h(I var0) {
      return var0.c;
   }

   public final void a() {
      if(!this.g) {
         this.g = true;
         if(this.d != null) {
            try {
               com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)"Starting recorder");
               this.d.f();
               return;
            } catch (Throwable var3) {
               com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting recorder", var3);
            }
         }
      } else {
         com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Recorder already started");
      }

      F var1 = this.c;
      Object var2 = this.e;
      var1.a(4);
   }

   public final void a(final bd var1) {
      com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)"Capturing audio from recorder");
      if(this.b != null) {
         this.d.a(new bd() {
            // $FF: synthetic field
            private bd b = var1;

            public final void a(byte[] var1, int var2, int var3, boolean var4) {
               if(I.this.b == null) {
                  this.b.a(var1, var2, var3, var4);
               } else if(I.this.b.a()) {
                  var1 = (byte[])I.this.b.b();
                  if(!I.this.b.a()) {
                     var4 = true;
                  } else {
                     var4 = false;
                  }

                  this.b.a(var1, 0, var1.length, var4);
//                  if(var4) {
//                     y.a(new Runnable() {
//                        // $FF: synthetic field
//                        private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;
//
//                        public final void run() {
//                           I.this.b();
//                        }
//                     });
//                  }
               }

               I var5 = I.this;
               I.c();
            }
         });
      } else {
         this.d.a(var1);
      }
   }

   public final void b() {
      // $FF: Couldn't be decompiled
   }
}
