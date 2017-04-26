package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.DataUploadCommand;
import com.nuance.nmdp.speechkit.DataUploadCommand$Listener;
import com.nuance.nmdp.speechkit.DataUploadResult;
import com.nuance.nmdp.speechkit.SpeechError;
import java.util.List;

final class f extends com.nuance.nmdp.speechkit.b implements DataUploadCommand {
   private DataUploadCommand$Listener b;
   private boolean c;

   public f(com.nuance.nmdp.speechkit.x var1, DataUploadCommand$Listener var2, Object var3) {
      super(var1, var1.k(), var3);
      Object var5 = this.a;
      synchronized(var5) {
         this.b = var2;
      }

      this.c = false;
      this.a();
   }

   protected final com.nuance.nmdp.speechkit.a a(final .cO var1, final String var2, final List var3) {
      return new com.nuance.nmdp.speechkit.e(var1, var2, var3) {
         protected final void a(final SpeechError var1) {
            f.this.a(new Runnable() {
               // $FF: synthetic field
               private SpeechError a = var1;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(f.this.b != null) {
                     f.this.b.onError(f.this, this.a);
                  }

               }
            });
         }

         // $FF: synthetic method
         protected final void a(Object var1) {
            final DataUploadResult var2 = (DataUploadResult)var1;
            f.this.a(new Runnable() {
               // $FF: synthetic field
               private DataUploadResult a = var2;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(f.this.b != null) {
                     f.this.b.onResults(f.this, this.a);
                  }

               }
            });
         }
      };
   }

   final void b() {
      this.c = true;
   }

   public final void setListener(DataUploadCommand$Listener var1) {
      com.nuance.nmdp.speechkit.x.a((Object)var1, (String)"listener");
      Object var2 = this.a;
      synchronized(var2) {
         this.b = var1;
      }
   }

   public final void start() {
      if(this.c) {
         super.start();
      }

   }
}
