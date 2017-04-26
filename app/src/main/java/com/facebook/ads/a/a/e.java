package com.facebook.ads.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.VideoAdActivity;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class e extends com.facebook.ads.a.a.c {
   private static final String a = com.facebook.ads.a.a.e.class.getSimpleName();
   private final Context b;
   private final Uri c;

   public e(Context var1, Uri var2) {
      super(var1, var2);
      this.b = var1;
      this.c = var2;
   }

   private static void a(Map var0, Intent var1) {
      Iterator var3 = var0.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var2 = (Entry)var3.next();
         var1.putExtra((String)var2.getKey(), (String)var2.getValue());
      }

   }

   public void a(Map var1) {
      this.a(this.b, this.c);
      String var2 = this.c.getQueryParameter("video_url");
      Intent var3 = new Intent(this.b, VideoAdActivity.class);
      var3.putExtra("adUri", this.c.toString());
      var3.putExtra("adVideoPath", var2);
      var3.putExtra("adMarketUri", this.b().toString());
      a(var1, var3);
      var3.addFlags(268435456);

      try {
         this.b.startActivity(var3);
      } catch (Exception var4) {
         Log.d(a, "Failed to start video", var4);
      }
   }
}
