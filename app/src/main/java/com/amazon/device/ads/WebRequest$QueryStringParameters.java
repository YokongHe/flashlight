package com.amazon.device.ads;

import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.WebUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class WebRequest$QueryStringParameters {
   private final HashMap params = new HashMap();
   private String rawAppendage;

   void append(StringBuilder var1) {
      if(this.size() != 0 || !StringUtils.isNullOrEmpty(this.rawAppendage)) {
         var1.append("?");
         Iterator var3 = this.params.entrySet().iterator();
         boolean var2 = true;

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            if(var2) {
               var2 = false;
            } else {
               var1.append("&");
            }

            var1.append((String)var4.getKey());
            var1.append("=");
            var1.append((String)var4.getValue());
         }

         if(this.rawAppendage != null && !this.rawAppendage.equals("")) {
            if(this.size() != 0) {
               var1.append("&");
            }

            var1.append(this.rawAppendage);
            return;
         }
      }

   }

   String get(String var1) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("The name must not be null or empty string.");
      } else {
         return (String)this.params.get(var1);
      }
   }

   String putUnencoded(String var1, String var2) {
      var1 = WebUtils.getURLEncodedString(var1);
      this.putUrlEncoded(var1, WebUtils.getURLEncodedString(var2));
      return var1;
   }

   void putUrlEncoded(String var1, String var2) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("The name must not be null or empty string.");
      } else if(var2 == null) {
         this.params.remove(var1);
      } else {
         this.params.put(var1, var2);
      }
   }

   void putUrlEncoded(String var1, boolean var2) {
      this.putUrlEncoded(var1, Boolean.toString(var2));
   }

   void putUrlEncodedIfNotNullOrEmpty(String var1, String var2) {
      boolean var3;
      if(!StringUtils.isNullOrEmpty(var2)) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.putUrlEncodedIfTrue(var1, var2, var3);
   }

   void putUrlEncodedIfTrue(String var1, String var2, boolean var3) {
      if(var3) {
         this.putUrlEncoded(var1, var2);
      }

   }

   void setRawAppendage(String var1) {
      this.rawAppendage = var1;
   }

   int size() {
      return this.params.size();
   }
}
