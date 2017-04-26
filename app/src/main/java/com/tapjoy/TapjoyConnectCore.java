package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJViewListener;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectCore$PPAThread;
import com.tapjoy.TapjoyConnectCore$a;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.TapjoyGpsHelper;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyIntegrationException;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.internal.ApiKeyDecoded;
import com.tapjoy.internal.ApiKeyDecoded$KeyUsage;
import com.tapjoy.internal.eq;
import com.tapjoy.internal.er;
import com.tapjoy.internal.fc;
import com.tapjoy.internal.fc$c;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.gk$n;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;
import org.w3c.dom.Document;

public class TapjoyConnectCore {
   private static String A;
   private static String B;
   private static String C;
   private static int D;
   public static final float DEFAULT_CURRENCY_MULTIPLIER = 1.0F;
   private static float E;
   private static int F;
   private static String G;
   private static boolean H;
   private static String I;
   private static String J;
   private static String K;
   private static String L;
   private static String M;
   public static final int MAX_NUMBER_OF_OFFLINE_LOGS = 50;
   private static String N;
   private static String O;
   private static String P;
   private static String Q;
   private static String R;
   private static String S;
   private static String T;
   private static float U;
   private static boolean V;
   private static boolean W;
   private static boolean X;
   private static boolean Y;
   private static boolean Z;
   protected static int a;
   private static int aA;
   private static int aB;
   private static String aC;
   private static String aD;
   private static String aE;
   private static String aF;
   private static String aG;
   private static int aH;
   private static int aI;
   private static int aJ;
   private static long aK;
   private static long aL;
   private static long aM;
   private static String aN;
   private static int aO;
   private static double aP;
   private static double aQ;
   private static long aR;
   private static int aS;
   private static int aT;
   private static int aU;
   private static String aV;
   private static String aW;
   private static boolean aX;
   private static boolean aY;
   private static String aa;
   private static String ab;
   private static String ac;
   private static String ad;
   private static String ae;
   private static long ai;
   private static boolean ak;
   private static PackageManager al;
   private static Hashtable ao;
   private static String ap;
   private static boolean aq;
   private static String ar;
   private static String as;
   private static String at;
   private static String au;
   private static int av;
   private static String aw;
   private static String ax;
   private static long ay;
   private static String az;
   protected static int b;
   protected static String c;
   protected static boolean d;
   protected static String e;
   protected static String f;
   private static Context g = null;
   private static String h = null;
   private static TapjoyConnectCore i = null;
   private static TapjoyURLConnection j = null;
   private static TJConnectListener k = null;
   private static TJViewListener l = null;
   private static Vector m;
   private static String n;
   private static String o;
   private static String p;
   private static String q;
   private static String r;
   private static String s;
   private static String t;
   private static String u;
   private static String v;
   private static String w;
   private static String x;
   private static String y;
   private static String z;
   private long af;
   private Timer ag;
   private boolean ah;
   private boolean aj;
   private fc am;
   private TapjoyGpsHelper an;

   static {
      m = new Vector(Arrays.asList(TapjoyConstants.dependencyClassNames));
      n = "";
      o = "";
      q = "";
      r = "";
      s = "";
      t = "";
      u = "";
      v = "";
      w = "";
      x = "";
      y = "";
      z = "";
      A = "";
      B = "";
      C = "";
      D = 1;
      E = 1.0F;
      F = 1;
      G = "";
      H = false;
      I = "";
      J = "";
      K = "";
      L = "";
      M = "";
      N = "";
      O = "";
      P = "";
      Q = "";
      R = "native";
      S = "";
      T = "";
      U = 1.0F;
      V = false;
      W = false;
      X = false;
      Y = false;
      Z = false;
      aa = "";
      ab = "";
      ac = "";
      ad = "";
      ae = null;
      ai = 0L;
      a = 0;
      b = 0;
      c = "";
      e = "";
      f = "";
      ao = TapjoyConnectFlag.CONNECT_FLAG_DEFAULTS;
      ap = "";
      aq = false;
      aX = false;
      aY = true;
   }

   public TapjoyConnectCore(Context param1) {
      // $FF: Couldn't be decompiled
   }

   private static String a(long var0) {
      try {
         String var2 = TapjoyUtil.SHA256(z + ":" + n() + ":" + var0 + ":" + Q);
         return var2;
      } catch (Exception var3) {
         TapjoyLog.e("TapjoyConnect", "getVerifier ERROR: " + var3.toString());
         return "";
      }
   }

   private static String a(long var0, String var2) {
      try {
         var2 = TapjoyUtil.SHA256(z + ":" + n() + ":" + var0 + ":" + Q + ":" + var2);
         return var2;
      } catch (Exception var3) {
         TapjoyLog.e("TapjoyConnect", "getVerifier ERROR: " + var3.toString());
         return "";
      }
   }

   private static void a(List param0) {
      // $FF: Couldn't be decompiled
   }

   private static void a(Properties var0) {
      Enumeration var1 = var0.keys();

      while(var1.hasMoreElements()) {
         try {
            String var2 = (String)var1.nextElement();
            b(var2, (String)var0.get(var2));
         } catch (ClassCastException var3) {
            TapjoyLog.e("TapjoyConnect", "Error parsing configuration properties in tapjoy_config.txt");
         }
      }

   }

   private static boolean a(String var0, String var1) {
      FeatureInfo[] var4 = al.getSystemAvailableFeatures();
      int var3 = var4.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var4[var2].name.matches(var0)) {
            if(var1 != null && al.checkPermission(var1, g.getPackageName()) != 0) {
               return false;
            }

            return true;
         }
      }

      return false;
   }

   // $FF: synthetic method
   static Context b() {
      return g;
   }

   private static void b(String var0, String var1) {
      String var2;
      label13: {
         if(!var0.equals("TJC_OPTION_SERVICE_URL")) {
            var2 = var1;
            if(!var0.equals("TJC_OPTION_PLACEMENT_SERVICE_URL")) {
               break label13;
            }
         }

         var2 = var1;
         if(!var1.endsWith("/")) {
            var2 = var1 + "/";
         }
      }

      ao.put(var0, var2);
   }

   // $FF: synthetic method
   static boolean b(String var0) {
      Document var5 = TapjoyUtil.buildDocument(var0);
      if(var5 != null) {
         String var3 = TapjoyUtil.getNodeTrimValue(var5.getElementsByTagName("PackageNames"));
         if(var3 != null && var3.length() > 0) {
            Vector var4 = new Vector();
            int var1 = 0;

            while(true) {
               int var2 = var3.indexOf(44, var1);
               if(var2 == -1) {
                  TapjoyLog.i("TapjoyConnect", "parse: " + var3.substring(var1).trim());
                  var4.add(var3.substring(var1).trim());
                  a((List)var4);
                  break;
               }

               TapjoyLog.i("TapjoyConnect", "parse: " + var3.substring(var1, var2).trim());
               var4.add(var3.substring(var1, var2).trim());
               var1 = var2 + 1;
            }
         }

         var0 = TapjoyUtil.getNodeTrimValue(var5.getElementsByTagName("Success"));
         if(var0 == null || !var0.equals("true")) {
            return false;
         }
      }

      return true;
   }

   // $FF: synthetic method
   static long c(TapjoyConnectCore var0) {
      long var1 = var0.af + 10000L;
      var0.af = var1;
      return var1;
   }

   // $FF: synthetic method
   static String c() {
      return ae;
   }

   // $FF: synthetic method
   static boolean c(String var0) {
      return e(var0);
   }

   // $FF: synthetic method
   static long d(TapjoyConnectCore var0) {
      return var0.af;
   }

   private static boolean d(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static Map e() {
      HashMap var0 = new HashMap();
      HashMap var1 = new HashMap();
      HashMap var2 = new HashMap();
      TapjoyUtil.safePut(var2, "plugin", R, true);
      TapjoyUtil.safePut(var2, "sdk_type", S, true);
      TapjoyUtil.safePut(var2, "app_id", z, true);
      TapjoyUtil.safePut(var2, "library_version", B, true);
      TapjoyUtil.safePut(var2, "library_revision", "1defb9e", true);
      TapjoyUtil.safePut(var2, "bridge_version", C, true);
      TapjoyUtil.safePut(var2, "app_version", A, true);
      var1.putAll(var2);
      var2 = new HashMap();
      TapjoyUtil.safePut(var2, "device_name", t, true);
      TapjoyUtil.safePut(var2, "platform", I, true);
      TapjoyUtil.safePut(var2, "os_version", w, true);
      TapjoyUtil.safePut(var2, "device_manufacturer", u, true);
      TapjoyUtil.safePut(var2, "device_type", v, true);
      TapjoyUtil.safePut(var2, "screen_layout_size", "" + F, true);
      TapjoyUtil.safePut(var2, "device_location", String.valueOf(H), true);
      TapjoyUtil.safePut(var2, "store_name", P, true);
      TapjoyUtil.safePut(var2, "store_view", String.valueOf(Z), true);
      TapjoyUtil.safePut(var2, "country_code", x, true);
      TapjoyUtil.safePut(var2, "language_code", y, true);
      TapjoyUtil.safePut(var2, "carrier_name", J, true);
      TapjoyUtil.safePut(var2, "carrier_country_code", K, true);
      TapjoyUtil.safePut(var2, "mobile_network_code", M, true);
      TapjoyUtil.safePut(var2, "mobile_country_code", L, true);
      N = getConnectionType();
      TapjoyUtil.safePut(var2, "connection_type", N, true);
      O = getConnectionSubType();
      TapjoyUtil.safePut(var2, "connection_subtype", O, true);
      TapjoyUtil.safePut(var2, "screen_density", "" + D, true);
      var1.putAll(var2);
      var2 = new HashMap();
      if(k()) {
         TapjoyUtil.safePut(var2, "advertising_id", c, true);
         TapjoyUtil.safePut(var2, "ad_tracking_enabled", String.valueOf(d), true);
      }

      if(!l()) {
         TapjoyUtil.safePut(var2, "android_id", n, true);
         TapjoyUtil.safePut(var2, "udid", q, true);
         TapjoyUtil.safePut(var2, "mac_address", r, true);
      }

      TapjoyUtil.safePut(var2, "threatmetrix_session_id", p, true);
      TapjoyUtil.safePut(var2, "install_id", s, true);
      TapjoyUtil.safePut(var2, "publisher_user_id", G, true);
      TapjoyUtil.safePut(var2, "ad_id_check_disabled", e, true);
      TapjoyUtil.safePut(var2, "persistent_ids_disabled", f, true);
      if(a != 0) {
         TapjoyUtil.safePut(var2, "packaged_gps_version", Integer.toString(a), true);
      }

      if(b != 0) {
         TapjoyUtil.safePut(var2, "device_gps_version", Integer.toString(b), true);
      }

      if(o != null && o.length() != 0 && System.currentTimeMillis() - ai <= 1800000L) {
         ai = System.currentTimeMillis();
      } else {
         o = m();
      }

      TapjoyUtil.safePut(var2, "session_id", o, true);
      var1.putAll(var2);
      var2 = new HashMap();
      TapjoyUtil.safePut(var2, "app_group_id", aa, true);
      TapjoyUtil.safePut(var2, "store", ab, true);
      TapjoyUtil.safePut(var2, "analytics_api_key", ac, true);
      TapjoyUtil.safePut(var2, "managed_device_id", ad, true);
      var1.putAll(var2);
      if(TapjoyCache.getInstance() != null && TapjoyCache.getInstance().getCachedOfferIDs() != null && TapjoyCache.getInstance().getCachedOfferIDs().length() > 0) {
         TapjoyUtil.safePut(var1, "cached_ids", TapjoyCache.getInstance().getCachedOfferIDs(), true);
      }

      TapjoyUtil.safePut(var1, "display_multiplier", Float.toString(U), true);
      var0.putAll(var1);
      var1 = new HashMap();
      f();
      var2 = new HashMap();
      TapjoyUtil.safePut(var2, "analytics_id", ar, true);
      TapjoyUtil.safePut(var2, "pkg_id", as, true);
      TapjoyUtil.safePut(var2, "pkg_sign", at, true);
      TapjoyUtil.safePut(var2, "display_d", "" + aS, true);
      TapjoyUtil.safePut(var2, "display_w", "" + aT, true);
      TapjoyUtil.safePut(var2, "display_h", "" + aU, true);
      TapjoyUtil.safePut(var2, "country_sim", aV, true);
      TapjoyUtil.safePut(var2, "timezone", aW, true);
      var1.putAll(var2);
      var2 = new HashMap();
      TapjoyUtil.safePut(var2, "pkg_ver", au, true);
      TapjoyUtil.safePut(var2, "pkg_rev", "" + av, true);
      TapjoyUtil.safePut(var2, "pkg_data_ver", aw, true);
      TapjoyUtil.safePut(var2, "installer", ax, true);
      var1.putAll(var2);
      var2 = new HashMap();
      TapjoyUtil.safePut(var2, "installed", "" + ay, true);
      TapjoyUtil.safePut(var2, "referrer", az, true);
      TapjoyUtil.safePut(var2, "user_level", "" + aA, true);
      TapjoyUtil.safePut(var2, "friend_count", "" + aB, true);
      TapjoyUtil.safePut(var2, "uv1", aC, true);
      TapjoyUtil.safePut(var2, "uv2", aD, true);
      TapjoyUtil.safePut(var2, "uv3", aE, true);
      TapjoyUtil.safePut(var2, "uv4", aF, true);
      TapjoyUtil.safePut(var2, "uv5", aG, true);
      TapjoyUtil.safePut(var2, "fq7", "" + aH, true);
      TapjoyUtil.safePut(var2, "fq30", "" + aI, true);
      TapjoyUtil.safePut(var2, "session_total_count", "" + aJ, true);
      TapjoyUtil.safePut(var2, "session_total_length", "" + aK, true);
      TapjoyUtil.safePut(var2, "session_last_at", "" + aL, true);
      TapjoyUtil.safePut(var2, "session_last_length", "" + aM, true);
      TapjoyUtil.safePut(var2, "purchase_currency", aN, true);
      TapjoyUtil.safePut(var2, "purchase_total_count", "" + aO, true);
      TapjoyUtil.safePut(var2, "purchase_total_price", "" + aP, true);
      TapjoyUtil.safePut(var2, "purchase_last_price", "" + aQ, true);
      TapjoyUtil.safePut(var2, "purchase_last_at", "" + aR, true);
      var1.putAll(var2);
      var0.putAll(var1);
      return var0;
   }

   private static boolean e(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static void f() {
      gk$n var0 = fv.a(g).b(true);
      ar = var0.f().h();
      as = var0.f().B();
      at = var0.f().D();
      aS = var0.f().r();
      aT = var0.f().t();
      aU = var0.f().v();
      aV = var0.f().H();
      aW = var0.f().z();
      au = var0.h().f();
      av = var0.h().h();
      aw = var0.h().j();
      ax = var0.h().l();
      ay = var0.j().f();
      az = var0.j().h();
      aA = var0.j().N();
      aB = var0.j().P();
      aC = var0.j().R();
      aD = var0.j().T();
      aE = var0.j().V();
      aF = var0.j().X();
      aG = var0.j().Z();
      aH = var0.j().j();
      aI = var0.j().l();
      aJ = var0.j().p();
      aK = var0.j().r();
      aL = var0.j().t();
      aM = var0.j().v();
      aN = var0.j().x();
      aO = var0.j().z();
      aP = var0.j().B();
      aQ = var0.j().F();
      aR = var0.j().D();
   }

   private static boolean f(String var0) {
      Iterator var1 = al.getInstalledApplications(0).iterator();

      do {
         if(!var1.hasNext()) {
            return false;
         }
      } while(!((ApplicationInfo)var1.next()).packageName.startsWith(var0));

      return true;
   }

   private static void g() {
      TapjoyLog.i("TapjoyConnect", "Connect Flags:");
      TapjoyLog.i("TapjoyConnect", "--------------------");
      Iterator var0 = ao.entrySet().iterator();

      while(var0.hasNext()) {
         Entry var1 = (Entry)var0.next();
         TapjoyLog.i("TapjoyConnect", "key: " + (String)var1.getKey() + ", value: " + Uri.encode(var1.getValue().toString()));
      }

      TapjoyLog.i("TapjoyConnect", "hostURL: [" + getConnectFlagValue("TJC_OPTION_SERVICE_URL") + "]");
      TapjoyLog.i("TapjoyConnect", "redirectDomain: [" + T + "]");
      TapjoyLog.i("TapjoyConnect", "--------------------");
   }

   private static boolean g(String var0) {
      Intent var1 = new Intent("android.intent.action.SEND");
      var1.setType("text/plain");
      Iterator var2 = al.queryIntentActivities(var1, 0).iterator();

      do {
         if(!var2.hasNext()) {
            return false;
         }
      } while(!((ResolveInfo)var2.next()).activityInfo.packageName.startsWith(var0));

      return true;
   }

   public static String getAndroidID() {
      return n;
   }

   public static String getAppID() {
      return z;
   }

   public static String getAwardCurrencyVerifier(long var0, int var2, String var3) {
      try {
         var3 = TapjoyUtil.SHA256(z + ":" + n() + ":" + var0 + ":" + Q + ":" + var2 + ":" + var3);
         return var3;
      } catch (Exception var4) {
         TapjoyLog.e("TapjoyConnect", "getAwardCurrencyVerifier ERROR: " + var4.toString());
         return "";
      }
   }

   public static String getCarrierName() {
      return J;
   }

   public static String getConnectFlagValue(String var0) {
      String var2 = "";
      String var1 = var2;
      if(ao != null) {
         var1 = var2;
         if(ao.get(var0) != null) {
            var1 = ao.get(var0).toString();
         }
      }

      return var1;
   }

   public static String getConnectURL() {
      return "https://connect.tapjoy.com/";
   }

   public static String getConnectionSubType() {
      // $FF: Couldn't be decompiled
   }

   public static String getConnectionType() {
      // $FF: Couldn't be decompiled
   }

   public static Context getContext() {
      return g;
   }

   public static String getDeviceID() {
      return q;
   }

   public static float getDeviceScreenDensityScale() {
      return E;
   }

   public static Map getGenericURLParams() {
      Map var0 = e();
      TapjoyUtil.safePut(var0, "app_id", z, true);
      return var0;
   }

   public static String getHostURL() {
      return getConnectFlagValue("TJC_OPTION_SERVICE_URL");
   }

   public static TapjoyConnectCore getInstance() {
      return i;
   }

   public static String getMacAddress() {
      return r;
   }

   public static Map getOfflineLogs() {
      return g.getSharedPreferences("tapjoyOfflineLog", 0).getAll();
   }

   public static String getPlacementURL() {
      return getConnectFlagValue("TJC_OPTION_PLACEMENT_SERVICE_URL");
   }

   public static String getRedirectDomain() {
      return T;
   }

   public static String getSecretKey() {
      return Q;
   }

   public static String getSha1MacAddress() {
      try {
         String var0 = TapjoyUtil.SHA1(r);
         return var0;
      } catch (Exception var1) {
         TapjoyLog.e("TapjoyConnect", "Error generating sha1 of macAddress: " + var1.toString());
         return null;
      }
   }

   public static Map getTimeStampAndVerifierParams() {
      long var0 = System.currentTimeMillis() / 1000L;
      String var2 = a(var0);
      HashMap var3 = new HashMap();
      TapjoyUtil.safePut(var3, "timestamp", String.valueOf(var0), true);
      TapjoyUtil.safePut(var3, "verifier", var2, true);
      return var3;
   }

   public static Map getURLParams() {
      Map var0 = getGenericURLParams();
      var0.putAll(getTimeStampAndVerifierParams());
      return var0;
   }

   public static String getUserID() {
      return G;
   }

   private static void h() {
      // $FF: Couldn't be decompiled
   }

   private static boolean h(String var0) {
      return al.checkPermission(var0, g.getPackageName()) == 0;
   }

   private void i() {
      // $FF: Couldn't be decompiled
   }

   public static boolean isAutoSessionTrackingStarted() {
      return aX;
   }

   public static boolean isConnected() {
      return ak;
   }

   public static boolean isViewOpen() {
      return aq;
   }

   private static void j() {
      byte var1 = 0;
      Vector var3 = new Vector();
      String[] var4 = TapjoyConstants.dependencyPermissions;
      int var2 = var4.length;

      int var0;
      String var5;
      for(var0 = 0; var0 < var2; ++var0) {
         var5 = var4[var0];
         if(!h(var5)) {
            var3.add(var5);
         }
      }

      if(var3.size() != 0) {
         if(var3.size() == 1) {
            throw new TapjoyIntegrationException("Missing 1 permission in manifest: " + var3.toString());
         } else {
            throw new TapjoyIntegrationException("Missing " + var3.size() + " permissions in manifest: " + var3.toString());
         }
      } else {
         var3 = new Vector();
         var4 = TapjoyConstants.optionalPermissions;
         var2 = var4.length;

         for(var0 = var1; var0 < var2; ++var0) {
            var5 = var4[var0];
            if(!h(var5)) {
               var3.add(var5);
            }
         }

         if(var3.size() != 0) {
            if(var3.size() != 1) {
               TapjoyLog.w("TapjoyConnect", "WARNING -- " + var3.toString() + " permissions were not found in manifest. The exclusion of these permissions could cause problems.");
               return;
            }

            TapjoyLog.w("TapjoyConnect", "WARNING -- " + var3.toString() + " permission was not found in manifest. The exclusion of this permission could cause problems.");
         }

      }
   }

   private static boolean k() {
      return c != null && c.length() > 0;
   }

   private static boolean l() {
      return k() && getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS") != null && getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS").equals("true");
   }

   private static String m() {
      TapjoyLog.i("TapjoyConnect", "generating sessionID...");

      String var0;
      Exception var1;
      label19: {
         try {
            var0 = TapjoyUtil.SHA256(System.currentTimeMillis() / 1000L + z + q);
         } catch (Exception var3) {
            var1 = var3;
            var0 = null;
            break label19;
         }

         try {
            ai = System.currentTimeMillis();
            return var0;
         } catch (Exception var2) {
            var1 = var2;
         }
      }

      TapjoyLog.e("TapjoyConnect", "unable to generate session id: " + var1.toString());
      return var0;
   }

   private static String n() {
      boolean var1 = true;
      if(l()) {
         return c;
      } else {
         boolean var0;
         if(q != null && q.length() > 0) {
            var0 = true;
         } else {
            var0 = false;
         }

         if(var0) {
            return q;
         } else {
            if(r != null && r.length() > 0) {
               var0 = true;
            } else {
               var0 = false;
            }

            if(var0) {
               return r;
            } else if(k()) {
               return c;
            } else {
               if(n != null && n.length() > 0) {
                  var0 = var1;
               } else {
                  var0 = false;
               }

               if(var0) {
                  return n;
               } else {
                  Log.e("TapjoyConnect", "Error -- no valid device identifier");
                  return null;
               }
            }
         }
      }
   }

   public static void removeOfflineLog(String var0) {
      Editor var1 = g.getSharedPreferences("tapjoyOfflineLog", 0).edit();
      var1.remove(var0);
      var1.commit();
   }

   public static void requestTapjoyConnect(Context var0, String var1) {
      requestTapjoyConnect(var0, var1, (Hashtable)null, (TJConnectListener)null);
   }

   public static void requestTapjoyConnect(Context var0, String var1, Hashtable var2) {
      requestTapjoyConnect(var0, var1, var2, (TJConnectListener)null);
   }

   public static void requestTapjoyConnect(Context var0, String var1, Hashtable var2, TJConnectListener var3) {
      ApiKeyDecoded var4;
      try {
         var4 = new ApiKeyDecoded(var1);
         if(var4.getKeyUsage() != ApiKeyDecoded$KeyUsage.SDK_ANDROID) {
            throw new IllegalArgumentException("The given API key was not for Android.");
         }
      } catch (IllegalArgumentException var5) {
         throw new TapjoyIntegrationException(var5.getMessage());
      }

      h = var1;
      z = var4.getAppId();
      Q = var4.getSecretKey();
      fv.a().a(var1);
      if(var2 != null) {
         ao.putAll(var2);
      }

      k = var3;
      i = new TapjoyConnectCore(var0);
   }

   public static void saveOfflineLog(String var0) {
      SharedPreferences var2 = g.getSharedPreferences("tapjoyOfflineLog", 0);
      Editor var1 = var2.edit();
      if(getOfflineLogs().size() >= 50) {
         var1.remove((String)(new TreeMap(var2.getAll())).firstKey());
         var1.commit();
      }

      var0 = var0 + "&original_timestamp=" + System.currentTimeMillis() / 1000L;
      var0 = var0 + "&offline=true";
      var1.putString(Long.toString(System.currentTimeMillis()), var0);
      var1.commit();
   }

   public static void sendOfflineLogs() {
      (new Thread(new Runnable() {
         public final void run() {
            TapjoyURLConnection var1 = new TapjoyURLConnection();

            Entry var3;
            for(Iterator var2 = TapjoyConnectCore.getOfflineLogs().entrySet().iterator(); var2.hasNext(); TapjoyConnectCore.removeOfflineLog((String)var3.getKey())) {
               var3 = (Entry)var2.next();

               try {
                  TapjoyLog.i("TapjoyConnect", "sending offline log: " + var3.getValue());
                  var1.getResponseFromURL((String)var3.getValue() + "&" + TapjoyUtil.convertURLParams(TapjoyConnectCore.getTimeStampAndVerifierParams(), false), "");
               } catch (Exception var5) {
                  TapjoyLog.i("TapjoyConnect", "error sending offline log");
               }
            }

         }
      })).start();
   }

   public static void setAutoSessionTrackingStarted(boolean var0) {
      aX = var0;
   }

   public static void setPlugin(String var0) {
      R = var0;
   }

   public static void setSDKType(String var0) {
      S = var0;
   }

   public static void setUserID(String var0) {
      G = var0;
      TapjoyLog.i("TapjoyConnect", "URL parameters: " + getURLParams());
      (new Thread(new Runnable() {
         public final void run() {
            TapjoyLog.i("TapjoyConnect", "setUserID...");
            TapjoyHttpURLResponse var1 = TapjoyConnectCore.j.getResponseFromURL(TapjoyConnectCore.getHostURL() + "set_publisher_user_id?", TapjoyConnectCore.getURLParams());
            if(var1.response != null) {
               TapjoyConnectCore.b(var1.response);
               TapjoyLog.i("TapjoyConnect", "setUserID successful...");
            }

         }
      })).start();
   }

   public static void setViewShowing(boolean var0) {
      aq = var0;
   }

   public static void viewDidClose(int var0) {
      aq = false;
      if(l != null) {
         l.onViewDidClose(var0);
      }

   }

   public static void viewDidOpen(int var0) {
      if(l != null) {
         l.onViewDidOpen(var0);
      }

   }

   public static void viewWillClose(int var0) {
      if(l != null) {
         l.onViewWillClose(var0);
      }

   }

   public static void viewWillOpen(int var0) {
      aq = true;
      if(l != null) {
         l.onViewWillOpen(var0);
      }

   }

   public void actionComplete(String var1) {
      TapjoyLog.i("TapjoyConnect", "actionComplete: " + var1);
      Map var2 = e();
      TapjoyUtil.safePut(var2, "app_id", var1, true);
      var2.putAll(getTimeStampAndVerifierParams());
      TapjoyLog.i("TapjoyConnect", "PPA URL parameters: " + var2);
      (new Thread(new TapjoyConnectCore$PPAThread(this, var2))).start();
   }

   public void appPause() {
      this.ah = true;
   }

   public void appResume() {
      if(this.ah) {
         m();
         this.ah = false;
      }

   }

   public void callConnect() {
      this.fetchAdvertisingID();
   }

   public void completeConnectCall() {
      TapjoyLog.i("TapjoyConnect", "starting connect call...");
      String var3 = "https://connect.tapjoy.com/";
      if(getHostURL() != "https://ws.tapjoyads.com/") {
         var3 = getHostURL();
      }

      TapjoyHttpURLResponse var6 = j.getResponseFromURL(var3 + "api/connect/v3.json?", (Map)null, (Map)null, (Map)getURLParams());
      if(var6 != null && var6.statusCode == 200) {
         if(!d(var6.response)) {
            if(k != null) {
               k.onConnectFailure();
            }
         } else {
            TapjoyLog.i("TapjoyConnect", "Successfully connected to Tapjoy");
            if(aY) {
               if(VERSION.SDK_INT > 8) {
                  try {
                     this.doProfileAsync();
                  } catch (Exception var5) {
                     TapjoyLog.w("TapjoyConnect", "Error building Threatmetrix profile: " + var5.toString());
                  }
               }
            } else {
               TapjoyLog.i("TapjoyConnect", "TM disabled");
            }

            Iterator var7 = getGenericURLParams().entrySet().iterator();

            while(var7.hasNext()) {
               Entry var4 = (Entry)var7.next();
               TapjoyLog.i("TapjoyConnect", (String)var4.getKey() + ": " + (String)var4.getValue());
            }

            sendOfflineLogs();
            ak = true;
            if(k != null) {
               k.onConnectSuccess();
            }
         }

         if(ap.length() > 0) {
            Map var9 = getGenericURLParams();
            TapjoyUtil.safePut(var9, "package_names", ap, true);
            long var1 = System.currentTimeMillis() / 1000L;
            String var8 = a(var1, ap);
            TapjoyUtil.safePut(var9, "timestamp", String.valueOf(var1), true);
            TapjoyUtil.safePut(var9, "verifier", var8, true);
            var6 = (new TapjoyURLConnection()).getResponseFromURL(getHostURL() + "apps_installed?", var9);
            if(var6 != null && var6.statusCode == 200) {
               TapjoyLog.i("TapjoyConnect", "Successfully pinged sdkless api.");
            }
         }
      } else if(k != null) {
         k.onConnectFailure();
         return;
      }

   }

   public void doProfileAsync() {
      TapjoyLog.i("TapjoyConnect", "Initializing Threatmetrix: 2.5-16");
      this.am = new fc();

      try {
         this.am.a((er)(new eq() {
            public final void a() {
               try {
                  if(TapjoyConnectCore.this.am.c() == fc$c.b) {
                     TapjoyConnectCore.p = TapjoyConnectCore.this.am.b();
                  } else {
                     TapjoyLog.w("TapjoyConnect", "No Threatmetrix session ID");
                  }

                  return;
               } catch (Exception var4) {
                  TapjoyLog.w("TapjoyConnect", "Error retrieving Threatmetrix session ID: " + var4.toString());
               } finally {
                  TapjoyConnectCore.this.am.d();
               }

            }
         }));
      } catch (InterruptedException var2) {
         var2.printStackTrace();
      }

      this.am.a();
      this.am.a(g, "rrx68giz", "h.online-metrix.net", "http://content-js.tapjoy.com");
   }

   public void enablePaidAppWithActionID(String var1) {
      TapjoyLog.i("TapjoyConnect", "enablePaidAppWithActionID: " + var1);
      ae = var1;
      this.af = g.getSharedPreferences("tjcPrefrences", 0).getLong("tapjoy_elapsed_time", 0L);
      TapjoyLog.i("TapjoyConnect", "paidApp elapsed: " + this.af);
      if(this.af >= 900000L) {
         if(ae != null && ae.length() > 0) {
            TapjoyLog.i("TapjoyConnect", "Calling PPA actionComplete...");
            this.actionComplete(ae);
         }
      } else if(this.ag == null) {
         this.ag = new Timer();
         this.ag.schedule(new TapjoyConnectCore$a(this, (byte)0), 10000L, 10000L);
         return;
      }

   }

   public void fetchAdvertisingID() {
      (new Thread(new Runnable() {
         public final void run() {
            TapjoyConnectCore.this.an.loadAdvertisingId();
            if(TapjoyConnectCore.this.an.isGooglePlayServicesAvailable() && TapjoyConnectCore.this.an.isGooglePlayManifestConfigured()) {
               TapjoyConnectCore.b = TapjoyConnectCore.this.an.getDeviceGooglePlayServicesVersion();
               TapjoyConnectCore.a = TapjoyConnectCore.this.an.getPackagedGooglePlayServicesVersion();
            }

            if(TapjoyConnectCore.this.an.isAdIdAvailable()) {
               TapjoyConnectCore.d = TapjoyConnectCore.this.an.isAdTrackingEnabled();
               TapjoyConnectCore.c = TapjoyConnectCore.this.an.getAdvertisingId();
            }

            if(TapjoyConnectCore.l()) {
               TapjoyLog.i("TapjoyConnect", "Disabling persistent IDs. Do this only if you are not using Tapjoy to manage currency.");
            }

            TapjoyConnectCore.this.completeConnectCall();
         }
      })).start();
   }

   public float getCurrencyMultiplier() {
      return U;
   }

   public String getSerial() {
      String var1;
      Exception var2;
      label24: {
         try {
            Field var5 = Class.forName("android.os.Build").getDeclaredField("SERIAL");
            if(!var5.isAccessible()) {
               var5.setAccessible(true);
            }

            var1 = var5.get(Build.class).toString();
         } catch (Exception var4) {
            var2 = var4;
            var1 = null;
            break label24;
         }

         try {
            TapjoyLog.i("TapjoyConnect", "serial: " + var1);
            return var1;
         } catch (Exception var3) {
            var2 = var3;
         }
      }

      TapjoyLog.e("TapjoyConnect", var2.toString());
      return var1;
   }

   public boolean isInitialized() {
      return this.aj;
   }

   public void release() {
      i = null;
      j = null;
      TapjoyLog.i("TapjoyConnect", "Releasing core static instance.");
   }

   public void setCurrencyMultiplier(float var1) {
      TapjoyLog.i("TapjoyConnect", "setVirtualCurrencyMultiplier: " + var1);
      U = var1;
   }

   public void setTapjoyViewListener(TJViewListener var1) {
      l = var1;
   }
}
