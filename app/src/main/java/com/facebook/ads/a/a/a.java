package com.facebook.ads.a.a;

import android.content.Context;
import android.net.Uri;
import com.facebook.ads.a.b$a;
import java.util.Map;

public abstract class a {
   public abstract b$a a();

   protected void a(Context var1, Uri var2) {
      String var3 = var2.getQueryParameter("native_click_report_url");
      if(!com.facebook.ads.a.ag.a(var3)) {
         (new com.facebook.ads.a.ad()).execute(new String[]{var3});
         com.facebook.ads.a.p.a(var1, "Click logged");
      }
   }

   public abstract void a(Map var1);
}
