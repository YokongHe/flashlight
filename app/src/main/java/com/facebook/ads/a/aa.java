package com.facebook.ads.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.NativeAd$Image;
import com.facebook.ads.NativeAd$Rating;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aa implements com.facebook.ads.a.e {
   private static final String a = com.facebook.ads.a.aa.class.getSimpleName();
   private final Uri b;
   private final String c;
   private final String d;
   private final String e;
   private final String f;
   private final NativeAd$Image g;
   private final NativeAd$Image h;
   private final NativeAd$Rating i;
   private final String j;
   private final String k;
   private final com.facebook.ads.a.g l;
   private final Collection m;
   private final boolean n;
   private final NativeAd$Image o;
   private final String p;
   private boolean q;
   private boolean r;

   private aa(Uri var1, String var2, String var3, String var4, String var5, NativeAd$Image var6, NativeAd$Image var7, NativeAd$Rating var8, String var9, String var10, com.facebook.ads.a.g var11, Collection var12, boolean var13, NativeAd$Image var14, String var15) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
      this.h = var7;
      this.i = var8;
      this.j = var9;
      this.k = var10;
      this.l = var11;
      this.m = var12;
      this.n = var13;
      this.o = var14;
      this.p = var15;
   }

   public static com.facebook.ads.a.aa a(JSONObject var0) {
      com.facebook.ads.a.aa var16;
      if(var0 == null) {
         var16 = null;
      } else {
         Uri var3 = Uri.parse(var0.optString("fbad_command"));
         String var4 = var0.optString("title");
         String var5 = var0.optString("body");
         String var6 = var0.optString("call_to_action");
         String var7 = var0.optString("social_context");
         NativeAd$Image var8 = NativeAd$Image.fromJSONObject(var0.optJSONObject("icon"));
         NativeAd$Image var9 = NativeAd$Image.fromJSONObject(var0.optJSONObject("image"));
         NativeAd$Rating var10 = NativeAd$Rating.fromJSONObject(var0.optJSONObject("star_rating"));
         String var11 = var0.optString("impression_report_url");
         String var12 = var0.optString("click_report_url");
         boolean var1 = var0.optBoolean("manual_imp");
         NativeAd$Image var2 = null;
         JSONObject var13 = var0.optJSONObject("ad_choices_icon");
         if(var13 != null) {
            var2 = NativeAd$Image.fromJSONObject(var13);
         }

         String var18 = var0.optString("ad_choices_link_url");
         com.facebook.ads.a.g var14 = com.facebook.ads.a.g.a(var0.optString("invalidation_behavior"));

         JSONArray var17;
         try {
            var17 = new JSONArray(var0.optString("detection_strings"));
         } catch (JSONException var15) {
            var15.printStackTrace();
            var17 = null;
         }

         com.facebook.ads.a.aa var19 = new com.facebook.ads.a.aa(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var14, com.facebook.ads.a.h.a(var17), var1, var2, var18);
         var16 = var19;
         if(!var19.n()) {
            return null;
         }
      }

      return var16;
   }

   private Map m() {
      return Collections.singletonMap("mil", String.valueOf(true));
   }

   private boolean n() {
      return this.c != null && this.c.length() > 0 && this.e != null && this.e.length() > 0 && this.g != null && this.h != null;
   }

   public com.facebook.ads.a.g a() {
      return this.l;
   }

   public void a(Context var1, Map var2, boolean var3) {
      if(!this.r) {
         HashMap var4 = new HashMap();
         if(var2 != null) {
            var4.put("touch", com.facebook.ads.a.p.a(var2));
         }

         if(var3) {
            var4.putAll(this.m());
         }

         (new com.facebook.ads.a.ad(var4)).execute(new String[]{this.k});
         this.r = true;
         com.facebook.ads.a.p.a(var1, "Click logged");
      }

      com.facebook.ads.a.a.a var6 = com.facebook.ads.a.a.b.a(var1, this.b);
      if(var6 != null) {
         try {
            var6.a((Map)null);
         } catch (Exception var5) {
            Log.e(a, "Error executing action", var5);
            return;
         }
      }

   }

   public void a(boolean var1) {
      if(!this.q) {
         Map var2;
         if(var1) {
            var2 = this.m();
         } else {
            var2 = null;
         }

         (new com.facebook.ads.a.ad(var2)).execute(new String[]{this.j});
         this.q = true;
      }

   }

   public Collection b() {
      return this.m;
   }

   public NativeAd$Image c() {
      return this.g;
   }

   public NativeAd$Image d() {
      return this.h;
   }

   public String e() {
      return this.c;
   }

   public String f() {
      return this.d;
   }

   public String g() {
      return this.e;
   }

   public String h() {
      return this.f;
   }

   public NativeAd$Rating i() {
      return this.i;
   }

   public boolean j() {
      return this.n;
   }

   public NativeAd$Image k() {
      return this.o;
   }

   public String l() {
      return this.p;
   }
}
