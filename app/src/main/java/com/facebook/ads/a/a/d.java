package com.facebook.ads.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.a.b$a;
import java.util.Map;

public class d extends com.facebook.ads.a.a.a {
   private static final String a = com.facebook.ads.a.a.d.class.getSimpleName();
   private final Context b;
   private final Uri c;

   public d(Context var1, Uri var2) {
      this.b = var1;
      this.c = var2;
   }

   public b$a a() {
      return b$a.b;
   }

   public void a(Map var1) {
      this.a(this.b, this.c);
      Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse(this.c.getQueryParameter("link")));
      var3.addFlags(268435456);

      try {
         this.b.startActivity(var3);
      } catch (Exception var2) {
         Log.d(a, "Failed to open market url: " + this.c.toString(), var2);
      }
   }
}
