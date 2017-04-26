package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import java.io.InputStream;
import java.io.OutputStream;

public final class v implements com.tapjoy.internal.bj {
   public static final com.tapjoy.internal.v a = new com.tapjoy.internal.v();

   public final Bitmap a(final InputStream var1) {
      try {
         Bitmap var3 = (Bitmap)com.tapjoy.internal.ae.a(new com.tapjoy.internal.bg() {
            // $FF: synthetic method
            public final Object call() {
               return var1 instanceof com.tapjoy.internal.bi?BitmapFactory.decodeStream(var1):BitmapFactory.decodeStream(new com.tapjoy.internal.bi(var1));
            }
         });
         return var3;
      } catch (OutOfMemoryError var2) {
         return null;
      }
   }

   // $FF: synthetic method
   public final void a(OutputStream var1, Object var2) {
      if(!((Bitmap)var2).compress(CompressFormat.PNG, 100, var1)) {
         throw new RuntimeException();
      }
   }

   // $FF: synthetic method
   public final Object b(InputStream var1) {
      return this.a(var1);
   }
}
