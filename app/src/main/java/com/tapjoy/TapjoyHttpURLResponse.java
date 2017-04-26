package com.tapjoy;

import java.util.List;
import java.util.Map;

public class TapjoyHttpURLResponse {
   public int contentLength;
   public Map headerFields;
   public String redirectURL;
   public String response;
   public int statusCode;

   public String getHeaderFieldAsString(String var1) {
      if(this.headerFields != null) {
         List var2 = (List)this.headerFields.get(var1);
         if(var2 != null && var2.get(0) != null) {
            return (String)var2.get(0);
         }
      }

      return "";
   }
}
