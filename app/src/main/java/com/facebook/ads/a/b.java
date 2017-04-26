package com.facebook.ads.a;

import com.facebook.ads.a.b$a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
   private String a;
   private Map b;
   private int c;

   public b(String var1, Map var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public static com.facebook.ads.a.b a(long var0, b$a var2) {
      long var3 = System.currentTimeMillis();
      HashMap var5 = new HashMap();
      var5.put("Time", String.valueOf(var3 - var0));
      var5.put("AdAction", String.valueOf(var2.f));
      return new com.facebook.ads.a.b("bounceback", var5, (int)(var3 / 1000L));
   }

   public static com.facebook.ads.a.b a(Exception var0) {
      HashMap var1 = new HashMap();
      var1.put("ex", var0.getClass().getSimpleName());
      var1.put("ex_msg", var0.getMessage());
      return new com.facebook.ads.a.b("error", var1, (int)(System.currentTimeMillis() / 1000L));
   }

   public JSONObject a() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("name", this.a);
         var1.put("data", new JSONObject(this.b));
         var1.put("time", this.c);
         return var1;
      } catch (JSONException var3) {
         var3.printStackTrace();
         return var1;
      }
   }
}
