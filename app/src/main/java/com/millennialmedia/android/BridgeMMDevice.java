package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.WindowManager;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.MMJSObject;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK$Event;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.Utils$IntentUtils;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeMMDevice extends MMJSObject {
   private static final String CALL = "call";
   private static final String COMPOSE_EMAIL = "composeEmail";
   private static final String COMPOSE_SMS = "composeSms";
   private static final String ENABLE_HARDWARE_ACCEL = "enableHardwareAcceleration";
   private static final String GET_AVAIL_SCHEMES = "getAvailableSchemes";
   private static final String GET_INFO = "getInfo";
   private static final String GET_LOCATION = "getLocation";
   private static final String GET_ORIENTATION = "getOrientation";
   private static final String IS_SCHEME_AVAIL = "isSchemeAvailable";
   private static final String OPEN_APP_STORE = "openAppStore";
   private static final String OPEN_URL = "openUrl";
   private static final String SET_MMDID = "setMMDID";
   private static final String SHOW_MAP = "showMap";
   private static final String TAG = "BridgeMMDevice";
   private static final String TWEET = "tweet";

   static JSONObject getDeviceInfo(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public MMJSResponse call(Map var1) {
      Context var3 = (Context)this.contextRef.get();
      String var2 = (String)var1.get("number");
      if(var3 != null && var2 != null) {
         MMLog.d("BridgeMMDevice", String.format("Dialing Phone: %s", new Object[]{var2}));
         Intent var4;
         if(Boolean.parseBoolean((String)var1.get("dial")) && var3.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0) {
            var4 = new Intent("android.intent.action.CALL", Uri.parse("tel:" + var2));
         } else {
            var4 = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + var2));
         }

         Utils$IntentUtils.startActivity(var3, var4);
         MMSDK$Event.intentStarted(var3, "tel", this.getAdImplId((String)var1.get("PROPERTY_EXPANDING")));
         return MMJSResponse.responseWithSuccess();
      } else {
         return null;
      }
   }

   public MMJSResponse composeEmail(Map var1) {
      Context var2 = (Context)this.contextRef.get();
      String var3 = (String)var1.get("recipient");
      String var4 = (String)var1.get("subject");
      String var5 = (String)var1.get("message");
      if(var2 != null) {
         MMLog.d("BridgeMMDevice", "Creating email");
         Intent var6 = new Intent("android.intent.action.SEND");
         var6.setType("plain/text");
         if(var3 != null) {
            var6.putExtra("android.intent.extra.EMAIL", var3.split(","));
         }

         if(var4 != null) {
            var6.putExtra("android.intent.extra.SUBJECT", var4);
         }

         if(var5 != null) {
            var6.putExtra("android.intent.extra.TEXT", var5);
         }

         Utils$IntentUtils.startActivity(var2, var6);
         MMSDK$Event.intentStarted(var2, "email", this.getAdImplId((String)var1.get("PROPERTY_EXPANDING")));
         return MMJSResponse.responseWithSuccess();
      } else {
         return null;
      }
   }

   public MMJSResponse composeSms(Map var1) {
      Context var2 = (Context)this.contextRef.get();
      String var4 = (String)var1.get("number");
      String var3 = (String)var1.get("message");
      if(var2 != null && var4 != null) {
         MMLog.d("BridgeMMDevice", String.format("Creating sms: %s", new Object[]{var4}));
         Intent var5 = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + var4));
         if(var3 != null) {
            var5.putExtra("sms_body", var3);
         }

         Utils$IntentUtils.startActivity(var2, var5);
         MMSDK$Event.intentStarted(var2, "sms", this.getAdImplId((String)var1.get("PROPERTY_EXPANDING")));
         return MMJSResponse.responseWithSuccess("SMS Sent");
      } else {
         return null;
      }
   }

   public MMJSResponse enableHardwareAcceleration(Map var1) {
      MMLog.d("BridgeMMDevice", "hardware accel call" + var1);
      String var3 = (String)var1.get("enabled");
      MMWebView var2 = (MMWebView)this.mmWebViewRef.get();
      if(var2 != null && var2 != null) {
         if(Boolean.parseBoolean(var3)) {
            var2.enableHardwareAcceleration();
         } else {
            var2.disableAllAcceleration();
         }

         return MMJSResponse.responseWithSuccess();
      } else {
         return null;
      }
   }

   MMJSResponse executeCommand(String var1, Map var2) {
      MMJSResponse var3 = null;
      if("call".equals(var1)) {
         var3 = this.call(var2);
      } else {
         if("composeEmail".equals(var1)) {
            return this.composeEmail(var2);
         }

         if("composeSms".equals(var1)) {
            return this.composeSms(var2);
         }

         if("enableHardwareAcceleration".equals(var1)) {
            return this.enableHardwareAcceleration(var2);
         }

         if("getAvailableSchemes".equals(var1)) {
            return this.getAvailableSchemes(var2);
         }

         if("getInfo".equals(var1)) {
            return this.getInfo(var2);
         }

         if("getLocation".equals(var1)) {
            return this.getLocation(var2);
         }

         if("getOrientation".equals(var1)) {
            return this.getOrientation(var2);
         }

         if("isSchemeAvailable".equals(var1)) {
            return this.isSchemeAvailable(var2);
         }

         if("openAppStore".equals(var1)) {
            return this.openAppStore(var2);
         }

         if("openUrl".equals(var1)) {
            return this.openUrl(var2);
         }

         if("setMMDID".equals(var1)) {
            return this.setMMDID(var2);
         }

         if("showMap".equals(var1)) {
            return this.showMap(var2);
         }

         if("tweet".equals(var1)) {
            return this.tweet(var2);
         }
      }

      return var3;
   }

   public MMJSResponse getAvailableSchemes(Map var1) {
      Context var4 = (Context)this.contextRef.get();
      if(var4 != null) {
         HandShake var2 = HandShake.sharedHandShake(var4);
         MMJSResponse var3 = new MMJSResponse();
         var3.result = 1;
         var3.response = var2.getSchemesJSONArray(var4);
         return var3;
      } else {
         return null;
      }
   }

   public MMJSResponse getInfo(Map var1) {
      Context var3 = (Context)this.contextRef.get();
      if(var3 != null) {
         MMJSResponse var2 = new MMJSResponse();
         var2.result = 1;
         var2.response = getDeviceInfo(var3);
         return var2;
      } else {
         return null;
      }
   }

   public MMJSResponse getLocation(Map var1) {
      if(MMRequest.location != null) {
         JSONObject var5;
         label41: {
            JSONException var2;
            label40: {
               try {
                  var5 = new JSONObject();
               } catch (JSONException var4) {
                  var2 = var4;
                  var5 = null;
                  break label40;
               }

               try {
                  var5.put("lat", Double.toString(MMRequest.location.getLatitude()));
                  var5.put("long", Double.toString(MMRequest.location.getLongitude()));
                  if(MMRequest.location.hasAccuracy()) {
                     var5.put("ha", Float.toString(MMRequest.location.getAccuracy()));
                     var5.put("va", Float.toString(MMRequest.location.getAccuracy()));
                  }

                  if(MMRequest.location.hasSpeed()) {
                     var5.put("spd", Float.toString(MMRequest.location.getSpeed()));
                  }

                  if(MMRequest.location.hasBearing()) {
                     var5.put("brg", Float.toString(MMRequest.location.getBearing()));
                  }

                  if(MMRequest.location.hasAltitude()) {
                     var5.put("alt", Double.toString(MMRequest.location.getAltitude()));
                  }

                  var5.put("tslr", Long.toString(MMRequest.location.getTime()));
                  break label41;
               } catch (JSONException var3) {
                  var2 = var3;
               }
            }

            MMLog.e("BridgeMMDevice", "Bridge getLocation json exception: ", var2);
         }

         MMJSResponse var6 = new MMJSResponse();
         var6.result = 1;
         var6.response = var5;
         return var6;
      } else {
         return MMJSResponse.responseWithError("location object has not been set");
      }
   }

   public MMJSResponse getOrientation(Map var1) {
      Context var3 = (Context)this.contextRef.get();
      if(var3 != null) {
         int var2 = var3.getResources().getConfiguration().orientation;
         if(var2 == 0) {
            var2 = ((WindowManager)var3.getSystemService("window")).getDefaultDisplay().getOrientation();
         }

         MMJSResponse var4 = new MMJSResponse();
         var4.result = 1;
         switch(var2) {
         case 2:
            var4.response = "landscape";
            break;
         default:
            var4.response = "portrait";
         }

         return var4;
      } else {
         return null;
      }
   }

   public MMJSResponse isSchemeAvailable(Map var1) {
      String var4 = (String)var1.get("scheme");
      if(!var4.contains(":")) {
         var4 = var4 + ":";
      }

      Context var2 = (Context)this.contextRef.get();
      if(var4 != null && var2 != null) {
         Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse(var4));
         if(var2.getPackageManager().queryIntentActivities(var3, 65536).size() > 0) {
            return MMJSResponse.responseWithSuccess(var4);
         }
      }

      return MMJSResponse.responseWithError(var4);
   }

   public MMJSResponse openAppStore(Map var1) {
      Context var2 = (Context)this.contextRef.get();
      String var3 = (String)var1.get("appId");
      String var4 = (String)var1.get("referrer");
      if(var2 != null && var3 != null) {
         MMLog.d("BridgeMMDevice", String.format("Opening marketplace: %s", new Object[]{var3}));
         Intent var5 = new Intent("android.intent.action.VIEW");
         if(Build.MANUFACTURER.equals("Amazon")) {
            var5.setData(Uri.parse(String.format("amzn://apps/android?p=%s", new Object[]{var3})));
         } else if(var4 != null) {
            var5.setData(Uri.parse(String.format("market://details?id=%s&referrer=%s", new Object[]{var3, URLEncoder.encode(var4)})));
         } else {
            var5.setData(Uri.parse("market://details?id=" + var3));
         }

         MMSDK$Event.intentStarted(var2, "market", this.getAdImplId((String)var1.get("PROPERTY_EXPANDING")));
         Utils$IntentUtils.startActivity(var2, var5);
         return MMJSResponse.responseWithSuccess();
      } else {
         return null;
      }
   }

   public MMJSResponse openUrl(Map var1) {
      Context var2 = (Context)this.contextRef.get();
      String var3 = (String)var1.get("url");
      if(var2 != null && var3 != null) {
         MMLog.d("BridgeMMDevice", String.format("Opening: %s", new Object[]{var3}));
         Intent var4 = new Intent("android.intent.action.VIEW", Uri.parse(var3));
         if(var4.getScheme().startsWith("http") || var4.getScheme().startsWith("https")) {
            MMSDK$Event.intentStarted(var2, "browser", this.getAdImplId((String)var1.get("PROPERTY_EXPANDING")));
         }

         Utils$IntentUtils.startActivity(var2, var4);
         return MMJSResponse.responseWithSuccess("Overlay opened");
      } else {
         return MMJSResponse.responseWithError("URL could not be opened");
      }
   }

   public MMJSResponse setMMDID(Map var1) {
      String var3 = (String)var1.get("mmdid");
      Context var2 = (Context)this.contextRef.get();
      if(var2 != null) {
         HandShake.sharedHandShake(var2).setMMdid(var2, var3);
         return MMJSResponse.responseWithSuccess("MMDID is set");
      } else {
         return null;
      }
   }

   public MMJSResponse showMap(Map var1) {
      Context var2 = (Context)this.contextRef.get();
      String var3 = (String)var1.get("location");
      if(var2 != null && var3 != null) {
         MMLog.d("BridgeMMDevice", String.format("Launching Google Maps: %s", new Object[]{var3}));
         Utils$IntentUtils.startActivity(var2, new Intent("android.intent.action.VIEW", Uri.parse("geo:" + var3)));
         MMSDK$Event.intentStarted(var2, "geo", this.getAdImplId((String)var1.get("PROPERTY_EXPANDING")));
         return MMJSResponse.responseWithSuccess("Map successfully opened");
      } else {
         return null;
      }
   }

   public MMJSResponse tweet(Map var1) {
      return null;
   }
}
