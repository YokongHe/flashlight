package com.facebook.ads.a;

import android.os.AsyncTask;
import android.util.Log;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class ad extends AsyncTask {
   private static final String a = com.facebook.ads.a.ad.class.getSimpleName();
   private Map b;

   public ad() {
      this.b = null;
   }

   public ad(Map var1) {
      this.b = var1;
   }

   private String a(String var1, String var2, String var3) {
      if(!com.facebook.ads.a.ag.a(var1) && !com.facebook.ads.a.ag.a(var2) && !com.facebook.ads.a.ag.a(var3)) {
         String var4;
         if(var1.contains("?")) {
            var4 = "&";
         } else {
            var4 = "?";
         }

         return var1 + var4 + var2 + "=" + URLEncoder.encode(var3);
      } else {
         return var1;
      }
   }

   private boolean a(String var1) {
      boolean var3 = false;
      HttpClient var4 = com.facebook.ads.a.p.b();
      HttpGet var5 = new HttpGet(var1);

      int var2;
      try {
         var2 = var4.execute(var5).getStatusLine().getStatusCode();
      } catch (Exception var6) {
         Log.e(a, "Error opening url: " + var1, var6);
         com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(var6));
         return false;
      }

      if(var2 == 200) {
         var3 = true;
      }

      return var3;
   }

   private String b(String var1) {
      try {
         String var2 = this.a(var1, "analog", com.facebook.ads.a.p.a(com.facebook.ads.a.a.a()));
         return var2;
      } catch (Exception var3) {
         com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(var3));
         return var1;
      }
   }

   protected Void a(String... var1) {
      String var5 = var1[0];
      if(!com.facebook.ads.a.ag.a(var5) && !var5.equals("#")) {
         var5 = this.b(var5);
         String var3;
         if(this.b != null) {
            Iterator var4 = this.b.keySet().iterator();

            while(true) {
               var3 = var5;
               if(!var4.hasNext()) {
                  break;
               }

               var3 = (String)var4.next();
               var5 = this.a(var5, var3, (String)this.b.get(var3));
            }
         } else {
            var3 = var5;
         }

         for(int var2 = 1; var2 <= 2 && !this.a(var3); ++var2) {
            ;
         }
      }

      return null;
   }

   // $FF: synthetic method
   protected Object doInBackground(Object[] var1) {
      return this.a((String[])var1);
   }
}
