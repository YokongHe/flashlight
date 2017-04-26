package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class W {
   public static List a(JSONObject var0, String var1) {
      JSONArray var3 = var0.optJSONArray(var1);
      if(var3 == null) {
         return null;
      } else {
         ArrayList var4 = new ArrayList(var3.length());

         for(int var2 = 0; var2 < var3.length(); ++var2) {
            var4.add(var3.getString(var2));
         }

         return Collections.unmodifiableList(var4);
      }
   }

   public static void a(Context var0, String var1, com.google.android.gms.internal.bt var2, String var3, boolean var4, List var5) {
      String var6;
      if(var4) {
         var6 = "1";
      } else {
         var6 = "0";
      }

      String var9;
      for(Iterator var8 = var5.iterator(); var8.hasNext(); (new com.google.android.gms.internal.bH(var0, var1, var9)).e()) {
         String var7 = ((String)var8.next()).replaceAll("@gw_adlocid@", var3).replaceAll("@gw_adnetrefresh@", var6).replaceAll("@gw_qdata@", var2.o.f).replaceAll("@gw_sdkver@", var1).replaceAll("@gw_sessid@", com.google.android.gms.internal.bw.a).replaceAll("@gw_seqnum@", var2.i);
         var9 = var7;
         if(var2.l != null) {
            var9 = var7.replaceAll("@gw_adnetid@", var2.l.b).replaceAll("@gw_allocid@", var2.l.d);
         }
      }

   }
}
