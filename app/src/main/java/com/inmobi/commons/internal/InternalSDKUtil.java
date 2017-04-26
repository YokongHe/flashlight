package com.inmobi.commons.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController$Validator;
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.CommonsConfig;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

public class InternalSDKUtil {
   public static final String ACTION_CONNECTIVITY_UPDATE = "android.net.conn.CONNECTIVITY_CHANGE";
   public static final String ACTION_RECEIVER_REFERRER = "com.android.vending.INSTALL_REFERRER";
   public static final String ACTION_SHARE_INMID = "com.inmobi.share.id";
   public static final String BASE_LOG_TAG = "[InMobi]";
   public static final String IM_PREF = "impref";
   public static final String INMOBI_SDK_RELEASE_DATE = "20141120";
   public static final String INMOBI_SDK_RELEASE_VERSION = "4.5.2";
   public static final String KEY_LTVID = "ltvid";
   public static final String LOGGING_TAG = "[InMobi]-4.5.2";
   public static final String PRODUCT_COMMONS = "commons";
   private static CommonsConfig a = new CommonsConfig();
   private static String b;
   private static Context c = null;
   private static Map d = new HashMap();
   private static CacheController$Validator e = new CacheController$Validator() {
      public final boolean validate(Map var1) {
         return InternalSDKUtil.a(var1);
      }
   };
   private static boolean f = true;

   public static Map JSONToMap(JSONObject param0) {
      // $FF: Couldn't be decompiled
   }

   private static void a() {
      d = UID.getInstance().getMapForEncryption((Map)null);
   }

   static boolean a(Map var0) {
      a();

      try {
         CommonsConfig var1 = new CommonsConfig();
         var1.setFromMap(var0);
         a = var1;
         ApiStatCollector.getLogger().setMetricConfigParams(var1.getApiStatsConfig());
         return true;
      } catch (Exception var2) {
         var2.printStackTrace();
         return false;
      }
   }

   private static byte[] a(byte[] var0, int var1, Cipher var2) {
      int var4 = var0.length;
      byte[] var5 = new byte[64];
      byte[] var7 = new byte[0];

      byte[] var6;
      for(var1 = 0; var1 < var4; var5 = var6) {
         byte[] var8 = var7;
         var6 = var5;
         if(var1 > 0) {
            var8 = var7;
            var6 = var5;
            if(var1 % 64 == 0) {
               var8 = a(var7, var2.doFinal(var5));
               int var3;
               if(var1 + 64 > var4) {
                  var3 = var4 - var1;
               } else {
                  var3 = 64;
               }

               var6 = new byte[var3];
            }
         }

         var6[var1 % 64] = var0[var1];
         ++var1;
         var7 = var8;
      }

      return a(var7, var2.doFinal(var5));
   }

   private static byte[] a(byte[] var0, byte[] var1) {
      byte[] var2 = new byte[var0.length + var1.length];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      System.arraycopy(var1, 0, var2, var0.length, var1.length);
      return var2;
   }

   public static String byteToHex(byte var0) {
      try {
         char[] var1 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
         String var3 = new String(new char[]{var1[var0 >> 4 & 15], var1[var0 & 15]});
         return var3;
      } catch (Exception var2) {
         return null;
      }
   }

   public static boolean checkNetworkAvailibility(Context var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            ConnectivityManager var3 = (ConnectivityManager)var0.getSystemService("connectivity");
            if(var3.getActiveNetworkInfo() == null) {
               return false;
            } else {
               boolean var1 = var3.getActiveNetworkInfo().isConnected();
               return var1;
            }
         } catch (Exception var2) {
            Log.internal("[InMobi]-4.5.2", "Cannot check network state", var2);
            return false;
         }
      }
   }

   public static String convertListToDelimitedString(List var0, String var1) {
      StringBuilder var3 = new StringBuilder();

      for(int var2 = 0; var2 < var0.size(); ++var2) {
         try {
            if(var3.length() > 0) {
               var3.append(var1);
            }

            var3.append(var0.get(var2));
         } catch (Exception var5) {
            Log.internal("[InMobi]-4.5.2", "Exception Converting map to deliminated string " + var0.toString(), var5);
         }
      }

      return var3.toString();
   }

   public static String encodeMapAndconvertToDelimitedString(Map var0, String var1) {
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = var0.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();

         try {
            if(var2.length() > 0) {
               var2.append(var1);
            }

            var2.append(String.format("%s=%s", new Object[]{getURLEncoded(var4), getURLEncoded(var0.get(var4).toString())}));
         } catch (Exception var5) {
            Log.internal("[InMobi]-4.5.2", "Exception Converting map to deliminated string " + var0.toString(), var5);
         }
      }

      return var2.toString();
   }

   @SuppressLint({"TrulyRandom"})
   public static String encryptRSA(String var0) {
      if(var0 != null && !"".equals(var0)) {
         try {
            BigInteger var1 = new BigInteger("C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B", 16);
            BigInteger var2 = new BigInteger("010001", 16);
            RSAPublicKey var4 = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(var1, var2));
            Cipher var5 = Cipher.getInstance("RSA/ECB/nopadding");
            var5.init(1, var4);
            var0 = new String(com.inmobi.commons.thirdparty.Base64.encode(a(var0.getBytes("UTF-8"), 1, var5), 0));
            return var0;
         } catch (Exception var3) {
            Log.debug("[InMobi]-4.5.2", "Exception in encryptRSA", var3);
            return null;
         }
      } else {
         return null;
      }
   }

   public static boolean getBooleanFromJSON(JSONObject var0, String var1, boolean var2) {
      try {
         boolean var3 = var0.getBoolean(var1);
         return var3;
      } catch (Exception var6) {
         try {
            Log.debug("[InMobi]-4.5.2", "JSON with property " + var1 + " found but has bad datatype(" + var0.get(var1).getClass() + "). Reverting to " + var2);
            return var2;
         } catch (JSONException var5) {
            return var2;
         }
      }
   }

   public static boolean getBooleanFromMap(Map var0, String var1) {
      Object var2 = var0.get(var1);
      if(var2 instanceof Boolean) {
         return ((Boolean)var2).booleanValue();
      } else {
         Log.internal("[InMobi]-4.5.2", "Key " + var1 + " has illegal value");
         throw new IllegalArgumentException();
      }
   }

   public static CommonsConfig getConfig() {
      return a;
   }

   public static String getConnectivityType(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static Context getContext() {
      return c;
   }

   public static String getDigested(String param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static Map getEncodedMap(Map var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();

         try {
            var1.put(getURLEncoded(var3), getURLEncoded(var0.get(var3).toString()));
         } catch (Exception var4) {
            Log.internal("[InMobi]-4.5.2", "Exception Map encoding " + var0.toString(), var4);
         }
      }

      return var1;
   }

   public static String getFinalRedirectedUrl(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static String getInMobiInternalVersion(String var0) {
      String[] var6 = var0.split("[.]");
      StringBuffer var3 = new StringBuffer("");

      for(int var1 = 0; var1 < var6.length; ++var1) {
         try {
            int var2 = Integer.valueOf(var6[var1]).intValue();
            var3.append("T").append((char)(var2 + 65));
         } catch (NumberFormatException var5) {
            ;
         }
      }

      return var3.equals("")?"":var3.substring(1).toString();
   }

   public static int getIntFromJSON(JSONObject var0, String var1, int var2) {
      try {
         int var3 = var0.getInt(var1);
         return var3;
      } catch (Exception var6) {
         try {
            Log.debug("[InMobi]-4.5.2", "JSON with property " + var1 + " found but has bad datatype(" + var0.get(var1).getClass() + "). Reverting to " + var2);
            return var2;
         } catch (JSONException var5) {
            return var2;
         }
      }
   }

   public static int getIntFromMap(Map var0, String var1, int var2, long var3) {
      Object var6 = var0.get(var1);
      if(var6 instanceof Integer) {
         int var5 = ((Integer)var6).intValue();
         if((long)var5 <= var3 && var5 >= var2) {
            return var5;
         }
      }

      Log.internal("[InMobi]-4.5.2", "Key " + var1 + " has illegal value");
      throw new IllegalArgumentException();
   }

   public static long getLongFromJSON(JSONObject var0, String var1, long var2) {
      try {
         long var4 = var0.getLong(var1);
         return var4;
      } catch (Exception var8) {
         try {
            Log.debug("[InMobi]-4.5.2", "JSON with property " + var1 + " found but has bad datatype(" + var0.get(var1).getClass() + "). Reverting to " + var2);
            return var2;
         } catch (JSONException var7) {
            return var2;
         }
      }
   }

   public static long getLongFromMap(Map var0, String var1, long var2, long var4) {
      Object var9 = var0.get(var1);
      long var7;
      if(var9 instanceof Long) {
         var7 = ((Long)var9).longValue();
         if(var7 <= var4 && var7 >= var2) {
            return var7;
         }
      }

      var7 = var2;
      if(var2 < -2147483648L) {
         var7 = -2147483648L;
      }

      int var6 = (int)var7;
      var2 = var4;
      if(var4 > 2147483647L) {
         var2 = 2147483647L;
      }

      return (long)getIntFromMap(var0, var1, var6, (long)((int)var2));
   }

   public static String getLtvpSessionId() {
      return getContext().getSharedPreferences("inmobiAppAnalyticsSession", 0).getString("APP_SESSION_ID", (String)null);
   }

   public static Object getObjectFromMap(Map var0, String var1) {
      Object var2 = var0.get(var1);
      if(var2 != null && var2 instanceof Map) {
         if(((Map)var2).isEmpty()) {
            Log.internal("[InMobi]-4.5.2", "Key " + var1 + " has empty object as value.");
            throw new IllegalArgumentException();
         } else {
            return var2;
         }
      } else {
         Log.internal("[InMobi]-4.5.2", "Key " + var1 + " has illegal value");
         throw new IllegalArgumentException();
      }
   }

   public static String getSavedUserAgent() {
      return b;
   }

   public static String getStringFromJSON(JSONObject var0, String var1, String var2) {
      try {
         String var3 = var0.getString(var1);
         return var3;
      } catch (Exception var5) {
         try {
            Log.debug("[InMobi]-4.5.2", "JSON with property " + var1 + " found but has bad datatype(" + var0.get(var1).getClass() + "). Reverting to " + var2);
            return var2;
         } catch (JSONException var4) {
            return var2;
         }
      }
   }

   public static String getStringFromMap(Map var0, String var1) {
      Object var2 = var0.get(var1);
      if(var2 instanceof String) {
         return (String)var2;
      } else {
         Log.internal("[InMobi]-4.5.2", "Key " + var1 + " has illegal value");
         throw new IllegalArgumentException();
      }
   }

   public static String getURLDecoded(String var0, String var1) {
      try {
         var1 = URLDecoder.decode(var0, var1);
         return var1;
      } catch (Exception var2) {
         Log.internal("[InMobi]-4.5.2", "Exception URL decoding " + var0, var2);
         return "";
      }
   }

   public static String getURLEncoded(String var0) {
      try {
         String var1 = URLEncoder.encode(var0, "UTF-8");
         return var1;
      } catch (Exception var2) {
         Log.internal("[InMobi]-4.5.2", "Exception URL encoding " + var0, var2);
         return "";
      }
   }

   public static String getUserAgent() {
      // $FF: Couldn't be decompiled
   }

   public static void initialize(Context var0) {
      if(getContext() == null) {
         if(var0 == null) {
            c.getApplicationContext();
         } else {
            c = var0.getApplicationContext();
         }
      }

      if(InMobi.getAppId() != null) {
         if(f) {
            f = false;
            a();
         }

         try {
            a(CacheController.getConfig("commons", var0, d, e).getData());
         } catch (CommonsException var1) {
            Log.internal("[InMobi]-4.5.2", "IMCommons config init: IMCommonsException caught. Reason: " + var1.toString());
         } catch (Exception var2) {
            Log.internal("[InMobi]-4.5.2", "Exception while getting commons config data.");
         }
      }
   }

   public static boolean isHexString(String var0) {
      return var0.matches("[0-9A-F]+");
   }

   public static boolean isInitializedSuccessfully() {
      return isInitializedSuccessfully(true);
   }

   public static boolean isInitializedSuccessfully(boolean var0) {
      if(getContext() != null && InMobi.getAppId() != null) {
         return true;
      } else {
         if(var0) {
            Log.debug("[InMobi]-4.5.2", "InMobi not initialized. Call InMobi.initialize before using any InMobi API");
         }

         return false;
      }
   }

   public static String mapToJSONs(Map var0) {
      if(var0 == null) {
         return null;
      } else {
         JSONObject var1 = new JSONObject();
         Iterator var2 = var0.keySet().iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();

            try {
               var1.put(var3, var0.get(var3));
            } catch (JSONException var5) {
               Log.internal("[InMobi]-4.5.2", "Unable to convert map to JSON for key " + var3);
            }
         }

         return var1.toString();
      }
   }

   public static void populate(Map var0, Map var1, boolean var2) {
      Iterator var3 = var0.keySet().iterator();

      while(true) {
         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            if(var1.get(var4) == null) {
               var1.put(var4, var0.get(var4));
            }

            Object var5 = var0.get(var4);
            Object var6 = var1.get(var4);
            if(var5 instanceof Map && var6 instanceof Map) {
               if(!var2) {
                  var1.put(var4, var5);
               } else {
                  populate((Map)var5, (Map)var6, true);
               }
            } else {
               var1.put(var4, var5);
            }
         }

         return;
      }
   }

   public static void populate(JSONObject param0, JSONObject param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public static JSONObject populateToNewJSON(JSONObject var0, JSONObject var1, boolean var2) {
      JSONObject var3 = new JSONObject();
      populate(var1, var3, false);
      populate(var0, var3, var2);
      return var3;
   }

   public static Map populateToNewMap(Map var0, Map var1, boolean var2) {
      HashMap var3 = new HashMap();
      populate((Map)var1, (Map)var3, false);
      populate((Map)var0, (Map)var3, var2);
      return var3;
   }

   public static void setContext(Context var0) {
      if(c == null) {
         c = var0.getApplicationContext();
         if(InMobi.getAppId() != null) {
            a();

            try {
               CacheController.getConfig("commons", var0, d, e);
               return;
            } catch (CommonsException var1) {
               Log.internal("commons", "Unable retrive config for commons product");
               return;
            }
         }
      }

   }

   public static String union(String var0, String var1) {
      String[] var3 = var0.split(",");

      for(int var2 = 0; var2 < var3.length; var1 = var0) {
         var0 = var1;
         if(!var1.contains(var3[var2])) {
            var0 = var1 + "," + var3[var2];
         }

         ++var2;
      }

      return var1;
   }

   public static boolean validateAppId(String var0) {
      if(var0 == null) {
         Log.debug("[InMobi]-4.5.2", "appId is null");
         return false;
      } else if(var0.matches("(x)+")) {
         Log.debug("[InMobi]-4.5.2", "appId is all xxxxxxx");
         return false;
      } else if("".equals(var0.trim())) {
         Log.debug("[InMobi]-4.5.2", "appId is all blank");
         return false;
      } else {
         return true;
      }
   }

   public static String xorWithKey(String param0, String param1) {
      // $FF: Couldn't be decompiled
   }
}
