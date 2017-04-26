package com.nexage.android.c;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d implements Cloneable {
   public ArrayList a = new ArrayList();
   public ArrayList b = new ArrayList();
   public ArrayList c = new ArrayList();
   String d = com.nexage.android.b.c();

   final com.nexage.android.c.e a(String var1) {
      synchronized(this){}

      com.nexage.android.c.e var4;
      try {
         com.nexage.android.a.p.c("AdReport", "created new service " + var1);
         var4 = new com.nexage.android.c.e(var1);
         this.a.add(var4);
         var4.d = -1L;
      } finally {
         ;
      }

      return var4;
   }

   final String a() {
      byte var3 = 0;
      com.nexage.android.a.p.c("AdReport", "start AdReport2.toJson, reqs: " + this.a.size());
      JSONObject var4 = new JSONObject();
      JSONArray var5 = new JSONArray();
      JSONArray var6 = new JSONArray();
      JSONArray var7 = new JSONArray();
      Iterator var8 = this.a.iterator();
      int var2 = 0;
      int var1 = 0;

      while(var8.hasNext()) {
         com.nexage.android.c.e var9 = (com.nexage.android.c.e)var8.next();
         if(var9.j != null) {
            var5.put(var2, new JSONObject(var9.j));
            ++var1;
            ++var2;
         }
      }

      var8 = this.c.iterator();

      JSONObject var10;
      for(var2 = 0; var8.hasNext(); ++var2) {
         com.nexage.android.c.b var11 = (com.nexage.android.c.b)var8.next();
         var10 = new JSONObject();
         var10.put("a", var11.g);
         var10.put("ts", var11.a);
         var10.put("r", var11.b);
         var10.put("zone", var11.c);
         var10.put("tag", var11.d);
         var10.put("buyer", var11.e);
         var10.put("pru", var11.f);
         var6.put(var2, var10);
      }

      var8 = this.b.iterator();

      for(var2 = var3; var8.hasNext(); ++var2) {
         com.nexage.android.c.a var12 = (com.nexage.android.c.a)var8.next();
         var10 = new JSONObject();
         var10.put("a", var12.e);
         var10.put("ts", var12.a);
         var10.put("r", var12.b);
         var10.put("zone", var12.c);
         var10.put("tag", var12.d);
         var7.put(var2, var10);
      }

      var4.put("site", this.d);
      var4.put("req", var5);
      var4.put("display", var6);
      var4.put("click", var7);
      com.nexage.android.a.p.c("AdReport", "Report generated: reqs:" + var1 + "  displays:" + this.c.size() + "  clicks:" + this.b.size());
      return var4.toString();
   }
}
