package com.facebook.ads.a.a;

import android.content.Context;
import android.net.Uri;

public class b {
   public static com.facebook.ads.a.a.a a(Context var0, Uri var1) {
      String var2 = var1.getAuthority();
      String var3 = var1.getQueryParameter("video_url");
      return (com.facebook.ads.a.a.a)("store".equals(var2)?(var3 != null?new com.facebook.ads.a.a.e(var0, var1):new com.facebook.ads.a.a.c(var0, var1)):("open_link".equals(var2)?new com.facebook.ads.a.a.d(var0, var1):null));
   }
}
