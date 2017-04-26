package com.tapjoy.internal;

import android.util.Log;
import com.tapjoy.internal.ex;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

class ej extends HashMap {
   private static final String a = ej.class.getName();
   private int b = 0;

   public final ej a(String var1, String var2) {
      this.put(var1, var2);
      return this;
   }

   public final void a() {
      this.b = 255;
   }

   public final ej b(String var1, String var2) {
      if(var2 != null && !var2.isEmpty()) {
         this.put(var1, var2.toLowerCase(Locale.US));
         return this;
      } else {
         this.put(var1, var2);
         return this;
      }
   }

   public final String b() {
      StringBuilder var3 = new StringBuilder();
      Iterator var4 = this.keySet().iterator();

      while(var4.hasNext()) {
         String var1 = (String)var4.next();
         String var2 = (String)this.get(var1);
         if(var2 != null && !var2.isEmpty()) {
            if(var3.length() > 0) {
               var3.append("&");
            }

            var3.append(var1);
            var1 = var2;
            if(this.b != 0) {
               var1 = var2;
               if(var2.length() > this.b) {
                  var1 = var2.substring(0, this.b);
               }
            }

            var3.append("=");
            var3.append(ex.a(var1));
         }
      }

      return var3.toString();
   }

   public final UrlEncodedFormEntity c() {
      ArrayList var3 = new ArrayList();
      Iterator var4 = this.keySet().iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         String var2 = (String)this.get(var5);
         if(!var2.isEmpty()) {
            String var1 = var2;
            if(this.b != 0) {
               var1 = var2;
               if(var2.length() > this.b) {
                  var1 = var2.substring(0, this.b);
               }
            }

            var3.add(new BasicNameValuePair(var5, var1));
         }
      }

      try {
         UrlEncodedFormEntity var7 = new UrlEncodedFormEntity(var3, "UTF-8");
         return var7;
      } catch (UnsupportedEncodingException var6) {
         Log.e(a, "Failed url encoding", var6);
         return null;
      }
   }
}
