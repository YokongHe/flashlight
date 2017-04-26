package com.inmobi.monetization.internal.carb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.carb.CARB$CarbCallback;
import com.inmobi.monetization.internal.carb.CarbInfo;
import com.inmobi.monetization.internal.carb.CarbInitializer;
import com.inmobi.monetization.internal.configs.PkInitilaizer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class CARB {
   public static final String LOGGING_TAG = "[InMobi]-[CARB]-4.5.2";
   private static CARB g = new CARB();
   private static SharedPreferences j;
   private static AtomicBoolean k = new AtomicBoolean(false);
   private static Thread l;
   private static AtomicBoolean m = new AtomicBoolean(false);
   private static Thread n;
   private static String o = "";
   private static String p = "";
   private static String q = "";
   byte[] a;
   byte[] b;
   String c = "";
   String d = "";
   String e = "";
   CARB$CarbCallback f = null;
   private String h = "carb_last_req_time";
   private String i = "carbpreference";
   private final int r = 8;
   private final int s = 16;
   private byte[] t;
   private byte[] u;
   private byte[] v;
   private byte[] w;
   private ArrayList x = new ArrayList();

   private CARB() {
      CarbInitializer.initialize();
      j = InternalSDKUtil.getContext().getSharedPreferences(this.i, 0);
   }

   private String a(String var1, byte[] var2, byte[] var3, byte[] var4, String var5, String var6) {
      var1 = EncryptionUtils.SeMeGe(var1, var2, var3, var4, var5, var6);
      StringBuilder var7 = new StringBuilder();
      var7.append("sm=");
      var7.append(var1);
      var7.append("&sn=");
      var7.append(this.e);
      var1 = var7.toString();
      Log.internal("[InMobi]-[CARB]-4.5.2", var1);
      return var1;
   }

   // $FF: synthetic method
   static void a(CARB var0, ArrayList var1, String var2, int var3) {
      var0.a(var1, var2, var3);
   }

   private void a(final ArrayList var1, final String var2, final int var3) {
      synchronized(this){}

      try {
         if(m.compareAndSet(false, true)) {
            m.set(true);
            Thread var6 = new Thread(new Runnable() {
               int a = 1;

               private int a(String param1) {
                  // $FF: Couldn't be decompiled
               }

               private String a(ArrayList var1x, String var2x, int var3x) {
                  StringBuffer var6 = new StringBuffer();
                  var6.append("req_id=");
                  var6.append(CARB.getURLEncoded(var2x));
                  JSONArray var9 = new JSONArray();
                  int var5 = var1x.size();

                  for(int var4 = 0; var4 < var5; ++var4) {
                     var9.put(((CarbInfo)var1x.get(var4)).getInmId());
                  }

                  var6.append("&p_a_apps=");
                  var6.append(CARB.getURLEncoded(var9.toString()));
                  var6.append("&i_till=");
                  var6.append(var3x);
                  Map var7 = CarbInitializer.getConfigParams().getDeviceIdMaskMap();
                  String var8 = UID.getInstance().getJSON(var7);
                  var6.append("&u-id-map=");
                  var6.append(CARB.getURLEncoded(var8));
                  return var6.toString();
               }

               public void run() {
                  CARB.this.d();
                  CARB.this.v = EncryptionUtils.keag();
                  CARB.this.d = PkInitilaizer.getConfigParams().getModulus();
                  CARB.this.e = PkInitilaizer.getConfigParams().getVersion();
                  if(!CARB.this.c.equals("") && !CARB.this.d.equals("") && !CARB.this.e.equals("")) {
                     String var4 = this.a(var1, var2, var3);
                     Log.internal("[InMobi]-[CARB]-4.5.2", "PostBody Before encryption: " + var4);
                     var4 = CARB.this.a(var4, CARB.this.v, CARB.this.w, CARB.this.b, CARB.this.d, CARB.this.c);
                     if(var4 == null) {
                        Log.internal("[InMobi]-[CARB]-4.5.2", "POST message cannot be encrypted");
                        CARB.this.e();
                     } else {
                        int var1x = this.a(var4);
                        Log.internal("[InMobi]-[CARB]-4.5.2", "Post Response to CARB server: " + var1x);
                        if(200 == var1x) {
                           if(CARB.this.f != null) {
                              CARB.this.f.postSuccess();
                           }

                           CARB.this.f();
                        } else {
                           if(CARB.this.f != null) {
                              CARB.this.f.postFailed();
                           }

                           var1x = CarbInitializer.getConfigParams().getRetryCount();
                           long var2x = CarbInitializer.getConfigParams().getRetryInterval();
                           if(this.a <= var1x) {
                              try {
                                 Thread.sleep((long)this.a * var2x * 1000L);
                              } catch (InterruptedException var5) {
                                 ;
                              }

                              Log.internal("[InMobi]-[CARB]-4.5.2", "POSt to carb failed. Retrying count: " + this.a);
                              ++this.a;
                              if(Looper.myLooper() == null) {
                                 Looper.prepare();
                              }

                              (new Handler()).postDelayed(this, 0L);
                              Looper.loop();
                              Looper.myLooper().quit();
                           } else {
                              this.a = 0;
                              CARB.this.f();
                           }
                        }
                     }
                  } else {
                     Log.internal("[InMobi]-[CARB]-4.5.2", "Exception retreiving Carb info due to key problem");
                     CARB.this.f();
                  }
               }
            });
            n = var6;
            var6.start();
         }
      } finally {
         ;
      }

   }

   // $FF: synthetic method
   static boolean a(CARB var0, String var1) {
      return var0.a(var1);
   }

   private boolean a(String var1) {
      PackageManager var2 = InternalSDKUtil.getContext().getPackageManager();

      try {
         var2.getPackageInfo(var1, 1);
         return true;
      } catch (NameNotFoundException var3) {
         return false;
      }
   }

   private void b() {
      synchronized(this){}

      try {
         this.x.clear();
         if(k.compareAndSet(false, true)) {
            Thread var1 = new Thread(new Runnable() {
               int a = 1;

               private int a(String param1) {
                  // $FF: Couldn't be decompiled
               }

               private void a() {
                  CARB.this.c();
                  CARB.this.t = EncryptionUtils.keag();
                  CARB.this.c = PkInitilaizer.getConfigParams().getExponent();
                  CARB.this.d = PkInitilaizer.getConfigParams().getModulus();
                  CARB.this.e = PkInitilaizer.getConfigParams().getVersion();
                  if(!CARB.this.c.equals("") && !CARB.this.d.equals("") && !CARB.this.e.equals("")) {
                     String var4 = this.b();
                     Log.internal("[InMobi]-[CARB]-4.5.2", "Unencrypted postbody :" + var4);
                     var4 = CARB.this.a(var4, CARB.this.t, CARB.this.u, CARB.this.a, CARB.this.d, CARB.this.c);
                     if(var4 == null) {
                        CARB.this.e();
                        return;
                     }

                     if(this.a(var4) != 200) {
                        int var1 = CarbInitializer.getConfigParams().getRetryCount();
                        long var2 = CarbInitializer.getConfigParams().getRetryInterval();
                        if(this.a <= var1) {
                           try {
                              Thread.sleep((long)this.a * var2 * 1000L);
                           } catch (InterruptedException var5) {
                              ;
                           }

                           Log.internal("[InMobi]-[CARB]-4.5.2", "Get carb info Failed. Retrying count: " + this.a);
                           ++this.a;
                           if(Looper.myLooper() == null) {
                              Looper.prepare();
                           }

                           (new Handler()).postDelayed(this, 0L);
                           Looper.loop();
                           Looper.myLooper().quit();
                           return;
                        }

                        this.a = 0;
                        Editor var6 = CARB.j.edit();
                        var6.putLong(CARB.this.h, System.currentTimeMillis());
                        var6.commit();
                        CARB.this.f();
                        return;
                     }
                  } else {
                     Log.internal("[InMobi]-[CARB]-4.5.2", "Exception retreiving Carb info due to key problem");
                     CARB.this.e();
                  }

               }

               private String b() {
                  StringBuffer var3 = new StringBuffer();
                  CARB.fillCarbInfo();
                  var3.append("mk-siteid=");
                  var3.append(CARB.getURLEncoded(InMobi.getAppId()));
                  String var1 = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.5.2") + "-20141120";
                  var3.append("&mk-version=");
                  var3.append(CARB.getURLEncoded(var1));
                  Map var5 = CarbInitializer.getConfigParams().getDeviceIdMaskMap();
                  var1 = UID.getInstance().getJSON(var5);
                  var3.append("&u-id-map=");
                  var3.append(CARB.getURLEncoded(var1));
                  var3.append("&u-appbid=");
                  var3.append(CARB.getURLEncoded(CARB.o));
                  var3.append("&u-appver=");
                  var3.append(CARB.getURLEncoded(CARB.p));
                  var3.append("&h-user-agent=");
                  var3.append(CARB.getURLEncoded(DeviceInfo.getPhoneDefaultUserAgent()));
                  var3.append("&d-localization=");
                  var3.append(CARB.getURLEncoded(DeviceInfo.getLocalization()));
                  var3.append("&d-nettype=");
                  var3.append(CARB.getURLEncoded(DeviceInfo.getNetworkType()));
                  WifiInfo var6 = null;

                  label17: {
                     WifiInfo var2;
                     try {
                        var2 = IceDataCollector.getConnectedWifiInfo(InternalSDKUtil.getContext());
                     } catch (Exception var4) {
                        Log.internal("[InMobi]-4.5.2", "No wifi permissions set, unable to send wifi data");
                        break label17;
                     }

                     var6 = var2;
                  }

                  if(var6 != null) {
                     var3.append("&c-ap-bssid=");
                     var3.append(Long.toString(var6.bssid));
                  }

                  return var3.toString();
               }

               public void run() {
                  this.a();
               }
            });
            l = var1;
            var1.start();
         }
      } finally {
         ;
      }

   }

   private void c() {
      try {
         this.a = new byte[8];
         SecureRandom var1 = new SecureRandom();
         var1.nextBytes(this.a);
         this.u = new byte[16];
         var1.nextBytes(this.u);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   private void d() {
      try {
         this.b = new byte[8];
         SecureRandom var1 = new SecureRandom();
         var1.nextBytes(this.b);
         this.w = new byte[16];
         var1.nextBytes(this.w);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   private void e() {
      if(k != null) {
         k.set(false);
      }

   }

   private void f() {
      if(m != null) {
         m.set(false);
      }

   }

   public static void fillCarbInfo() {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static ArrayList g(CARB var0) {
      return var0.x;
   }

   public static String getAppBid() {
      return o;
   }

   public static String getAppDisplayName() {
      return q;
   }

   public static String getAppVer() {
      return p;
   }

   public static Object getCountryISO(Context var0) {
      TelephonyManager var1 = (TelephonyManager)var0.getSystemService("phone");
      return var1.getNetworkCountryIso().equals("")?var0.getResources().getConfiguration().locale.getISO3Country():var1.getNetworkCountryIso();
   }

   public static CARB getInstance() {
      return g;
   }

   public static String getURLDecoded(String var0, String var1) {
      try {
         var0 = URLDecoder.decode(var0, var1);
         return var0;
      } catch (Exception var2) {
         return "";
      }
   }

   public static String getURLEncoded(String var0) {
      try {
         var0 = URLEncoder.encode(var0, "UTF-8");
         return var0;
      } catch (Exception var1) {
         return "";
      }
   }

   public static void setAppBId(String var0) {
      o = var0;
   }

   public static void setAppDisplayName(String var0) {
      q = var0;
   }

   public static void setAppVer(String var0) {
      p = var0;
   }

   public void setCallBack(CARB$CarbCallback var1) {
      this.f = var1;
   }

   public void startCarb() {
      // $FF: Couldn't be decompiled
   }
}
