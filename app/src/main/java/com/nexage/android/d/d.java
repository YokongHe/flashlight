package com.nexage.android.d;

import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
   int a;
   int b;
   com.nexage.android.d.a[] c;
   private String d;
   private String e;
   private String f;
   private String g;
   private int h;
   private int i;
   private int j;
   private int k;

   static com.nexage.android.d.d a(String var0) {
      JSONObject var3 = new JSONObject(var0);
      com.nexage.android.d.d var5 = new com.nexage.android.d.d();
      var5.d = var3.getString("name");
      var5.e = var3.getString("version");
      var5.f = var3.getString("generatedDate");
      var5.g = var3.getString("dcn");
      var5.h = var3.getInt("ttl");
      var5.j = var3.getInt("cacheSize");
      var5.k = var3.getInt("timeout");
      var5.a = var3.getInt("reportBatchSize");
      var5.b = var3.getInt("reportFrequency");
      var5.e = var3.getString("version");
      var5.i = 10;
      JSONArray var6 = var3.getJSONArray("positions");
      int var2 = var6.length();
      var5.c = new com.nexage.android.d.a[var2];

      for(int var1 = 0; var1 < var2; ++var1) {
         JSONObject var4 = var6.getJSONObject(var1);
         var5.c[var1] = com.nexage.android.d.a.a(var4);
      }

      return var5;
   }

   final int a() {
      return this.h;
   }

   final int b() {
      return this.i;
   }

   final String c() {
      return this.g;
   }

   public final String toString() {
      StringBuilder var2 = (new StringBuilder("Rule{name=\'")).append(this.d).append('\'').append(", version=\'").append(this.e).append('\'').append(", generatedDate=\'").append(this.f).append('\'').append(", dcn=\'").append(this.g).append('\'').append(", ttl=").append(this.h).append(", positions=");
      List var1;
      if(this.c == null) {
         var1 = null;
      } else {
         var1 = Arrays.asList(this.c);
      }

      return var2.append(var1).append('}').toString();
   }
}
