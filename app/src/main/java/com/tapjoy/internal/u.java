package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;

public final class u extends ContentHandler {
   public static final com.tapjoy.internal.u a = new com.tapjoy.internal.u();

   public static Bitmap a(URLConnection var0) {
      InputStream var4 = var0.getInputStream();

      Bitmap var1;
      try {
         var1 = com.tapjoy.internal.v.a.a(var4);
      } finally {
         var4.close();
      }

      return var1;
   }

   // $FF: synthetic method
   public final Object getContent(URLConnection var1) {
      return a(var1);
   }
}
