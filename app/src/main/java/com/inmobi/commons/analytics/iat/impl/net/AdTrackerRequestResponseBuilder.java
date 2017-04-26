package com.inmobi.commons.analytics.iat.impl.net;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.inmobi.commons.analytics.iat.impl.AdTrackerConstants$StatusCode;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class AdTrackerRequestResponseBuilder {
   private static String a = null;
   private static long b = 0L;

   protected static String formHttpRequest(String var0, String var1, int var2, boolean var3, String var4) {
      LinkedList var9 = new LinkedList();
      String var10 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
      if(var0 != null && !var0.trim().equals("")) {
         var9.add(new BasicNameValuePair("mk-siteid", var0));
      }

      Map var12 = AdTrackerInitializer.getConfigParams().getDeviceIdMaskMap();
      var12 = UID.getInstance().getMapForEncryption(var12);
      if(UID.getInstance().isLimitAdTrackingEnabled()) {
         var9.add(new BasicNameValuePair("u-id-adt", "1"));
      } else {
         var9.add(new BasicNameValuePair("u-id-adt", "0"));
      }

      var9.add(new BasicNameValuePair("u-id-map", (String)var12.get("u-id-map")));
      var9.add(new BasicNameValuePair("u-id-key", (String)var12.get("u-id-key")));
      var9.add(new BasicNameValuePair("u-key-ver", (String)var12.get("u-key-ver")));
      if(var1 != null && !var1.trim().equals("")) {
         var9.add(new BasicNameValuePair("goalName", var1));
      }

      if(var3) {
         var9.add(new BasicNameValuePair("lp", "1"));
      } else {
         var9.add(new BasicNameValuePair("lp", "0"));
      }

      var9.add(new BasicNameValuePair("src", "and"));
      if(var2 > 0) {
         var9.add(new BasicNameValuePair("goalCount", Integer.toString(var2)));
      }

      var0 = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.5.2") + "-20141120";
      var9.add(new BasicNameValuePair("mk-version", var0));
      var9.add(new BasicNameValuePair("mk-rel-version", var0));
      var9.add(new BasicNameValuePair("osV", String.valueOf(VERSION.SDK_INT)));
      var1 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rlc");
      var0 = var1;
      if(var1 == null) {
         var0 = "0";
      }

      var9.add(new BasicNameValuePair("rlc", var0));

      try {
         var0 = InternalSDKUtil.getContext().getPackageManager().getPackageInfo(InternalSDKUtil.getContext().getPackageName(), 0).versionName;
      } catch (NameNotFoundException var11) {
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Cant get appversion", var11);
         var0 = null;
      }

      if(var0 != null && !var0.trim().equals("")) {
         var9.add(new BasicNameValuePair("u-appver", var0));
      }

      if(var4 != null && !var4.trim().equals("")) {
         var9.add(new BasicNameValuePair("iat_ids", var4));
      }

      if(var10 != null) {
         var2 = FileOperations.getIntPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rfs");
         long var5 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t1");
         long var7 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t2");
         var9.add(new BasicNameValuePair("rfs", Integer.toString(var2)));
         var9.add(new BasicNameValuePair("rd", Long.toString(var7 - var5)));
      }

      if(1 == AdTrackerNetworkInterface.isUnstableNetwork()) {
         var9.add(new BasicNameValuePair("nus", Integer.toString(AdTrackerNetworkInterface.isUnstableNetwork())));
      }

      var9.add(new BasicNameValuePair("ts", Long.toString(System.currentTimeMillis())));
      return URLEncodedUtils.format(var9, "utf-8");
   }

   public static String getWebViewRequestParam() {
      return a;
   }

   public static AdTrackerConstants$StatusCode reportGoalOverHttp(String param0, Goal param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public static void saveWebviewRequestParam(String var0, Goal var1) {
      a = formHttpRequest(var0, var1.name, var1.count, var1.isDuplicate, (String)null);
   }

   public static boolean serverReachable(String var0) {
      int var1;
      try {
         var1 = (new DefaultHttpClient()).execute(new HttpGet(var0)).getStatusLine().getStatusCode();
      } catch (Exception var2) {
         Log.debug("[InMobi]-[AdTracker]-4.5.2", "Server not reachable..Logging events");
         return false;
      }

      if(var1 == 200) {
         return true;
      } else {
         return false;
      }
   }
}
