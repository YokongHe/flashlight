package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class P {
   public final String a;
   public final String b;
   public final List c;
   public final String d;
   public final List e;
   public final String f;

   public P(JSONObject var1) {
      Object var4 = null;
      super();
      this.b = var1.getString("id");
      JSONArray var3 = var1.getJSONArray("adapters");
      ArrayList var5 = new ArrayList(var3.length());

      for(int var2 = 0; var2 < var3.length(); ++var2) {
         var5.add(var3.getString(var2));
      }

      this.c = Collections.unmodifiableList(var5);
      this.d = var1.optString("allocation_id", (String)null);
      this.e = com.google.android.gms.internal.W.a(var1, "imp_urls");
      JSONObject var7 = var1.optJSONObject("ad");
      String var8;
      if(var7 != null) {
         var8 = var7.toString();
      } else {
         var8 = null;
      }

      this.a = var8;
      var7 = var1.optJSONObject("data");
      String var6 = (String)var4;
      if(var7 != null) {
         var6 = var7.toString();
      }

      this.f = var6;
   }
}
