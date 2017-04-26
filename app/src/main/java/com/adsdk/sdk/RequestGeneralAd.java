package com.adsdk.sdk;

import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.RequestAd;
import com.adsdk.sdk.customevents.CustomEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class RequestGeneralAd extends RequestAd {
   private static final int RELOAD_AFTER_NO_AD = 20;

   public RequestGeneralAd() {
   }

   public RequestGeneralAd(InputStream var1) {
      this.is = var1;
      StringBuilder var3 = new StringBuilder("Parse is null");
      boolean var2;
      if(this.is == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      Log.d(var3.append(var2).toString());
   }

   private String convertStreamToString(InputStream var1) {
      try {
         String var3 = (new Scanner(var1)).useDelimiter("\\A").next();
         return var3;
      } catch (NoSuchElementException var2) {
         return "";
      }
   }

   private String getAttribute(Document var1, String var2, String var3) {
      Element var4 = (Element)var1.getElementsByTagName(var2).item(0);
      if(var4 != null) {
         String var5 = var4.getAttribute(var3);
         if(var5.length() != 0) {
            return var5;
         }
      }

      return null;
   }

   private List getCustomEvents(Header[] var1) {
      ArrayList var3 = new ArrayList();
      if(var1 == null) {
         return var3;
      } else {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            if(var1[var2].getName().startsWith("X-CustomEvent")) {
               String var4 = var1[var2].getValue();

               try {
                  JSONObject var6 = new JSONObject(var4);
                  var3.add(new CustomEvent(var6.getString("class"), var6.getString("parameter"), var6.getString("pixel")));
               } catch (JSONException var5) {
                  Log.e("Cannot parse json with custom event: " + var1[var2].getName());
               }
            }
         }

         return var3;
      }
   }

   private int getInteger(String var1) {
      if(var1 == null) {
         return 0;
      } else {
         try {
            int var2 = Integer.parseInt(var1);
            return var2;
         } catch (NumberFormatException var3) {
            return 0;
         }
      }
   }

   private String getValue(Document var1, String var2) {
      Element var3 = (Element)var1.getElementsByTagName(var2).item(0);
      if(var3 != null) {
         NodeList var4 = var3.getChildNodes();
         if(var4.getLength() > 0) {
            return var4.item(0).getNodeValue();
         }
      }

      return null;
   }

   private boolean getValueAsBoolean(Document var1, String var2) {
      return "yes".equalsIgnoreCase(this.getValue(var1, var2));
   }

   private int getValueAsInt(Document var1, String var2) {
      return this.getInteger(this.getValue(var1, var2));
   }

   AdResponse parse(InputStream param1, Header[] param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   AdResponse parseTestString() {
      return this.parse(this.is, (Header[])null, false);
   }
}
