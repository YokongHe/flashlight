package com.amazon.device.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.AdSDKBridgeList;
import com.amazon.device.ads.AdWebViewClient$AdWebViewClientListener;
import com.amazon.device.ads.AdWebViewClient$AmazonMobileExecutor;
import com.amazon.device.ads.AdWebViewClient$DefaultExecutor;
import com.amazon.device.ads.AdWebViewClient$UrlExecutor;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.BridgeSelector;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

class AdWebViewClient extends WebViewClient {
   protected static final String AAX_REDIRECT_BETA = "aax-beta.integ.amazon.com";
   protected static final String AAX_REDIRECT_GAMMA = "aax-us-east.amazon-adsystem.com";
   protected static final String AAX_REDIRECT_PROD = "aax-us-east.amazon-adsystem.com";
   public static final String AMAZON_MOBILE = "amazonmobile";
   protected static final String CORNERSTONE_BEST_ENDPOINT_BETA = "d16g-cornerstone-bes.integ.amazon.com";
   protected static final String CORNERSTONE_BEST_ENDPOINT_PROD = "pda-bes.amazon.com";
   public static final String GEO = "geo";
   public static final String GOOGLE_STREETVIEW = "google.streetview";
   private static final String LOG_TAG = AdWebViewClient.class.getSimpleName();
   public static final String MAILTO = "mailto";
   public static final String SMS = "sms";
   public static final String TELEPHONE = "tel";
   public static final String VOICEMAIL = "voicemail";
   protected static final HashSet intentSchemes;
   protected static Set redirectHosts;
   private final AdControlAccessor adControlAccessor;
   private final AdSDKBridgeList bridgeList;
   private final Context context;
   private AdWebViewClient$AdWebViewClientListener listener;
   private CopyOnWriteArrayList resourceList = new CopyOnWriteArrayList();
   private final HashMap urlExecutors;

   static {
      HashSet var0 = new HashSet();
      intentSchemes = var0;
      var0.add("tel");
      intentSchemes.add("voicemail");
      intentSchemes.add("sms");
      intentSchemes.add("mailto");
      intentSchemes.add("geo");
      intentSchemes.add("google.streetview");
      var0 = new HashSet();
      redirectHosts = var0;
      var0.add("aax-us-east.amazon-adsystem.com");
      redirectHosts.add("aax-us-east.amazon-adsystem.com");
      redirectHosts.add("aax-beta.integ.amazon.com");
      redirectHosts.add("pda-bes.amazon.com");
      redirectHosts.add("d16g-cornerstone-bes.integ.amazon.com");
   }

   public AdWebViewClient(Context var1, AdSDKBridgeList var2, AdControlAccessor var3) {
      this.context = var1;
      this.urlExecutors = new HashMap();
      this.bridgeList = var2;
      this.adControlAccessor = var3;
      this.setupUrlExecutors();
   }

   // $FF: synthetic method
   static String access$100() {
      return LOG_TAG;
   }

   private boolean checkResources() {
      Iterator var3 = this.resourceList.iterator();

      boolean var1;
      boolean var2;
      for(var1 = false; var3.hasNext(); var1 = var2) {
         String var4 = (String)var3.next();
         Set var6 = BridgeSelector.getInstance().getBridgeFactoriesForResourceLoad(var4);
         var2 = var1;
         if(var6.size() > 0) {
            Iterator var7 = var6.iterator();

            while(true) {
               var2 = var1;
               if(!var7.hasNext()) {
                  break;
               }

               AdSDKBridge var5 = ((AdSDKBridgeFactory)var7.next()).createAdSDKBridge(this.adControlAccessor);
               if(!this.bridgeList.contains(var5)) {
                  var1 = true;
                  this.bridgeList.addBridge(var5);
               }
            }
         }
      }

      if(var1) {
         ThreadUtils.executeOnMainThread(new Runnable() {
            public void run() {
               AdWebViewClient.this.adControlAccessor.reload();
            }
         });
      }

      return var1;
   }

   static boolean isHoneycombVersion() {
      return AndroidTargetUtils.isBetweenAndroidAPIs(11, 13);
   }

   private void setupUrlExecutors() {
      this.urlExecutors.put("amazonmobile", new AdWebViewClient$AmazonMobileExecutor(this.context));
      AdWebViewClient$DefaultExecutor var1 = new AdWebViewClient$DefaultExecutor(this.context);
      Iterator var2 = intentSchemes.iterator();

      while(var2.hasNext()) {
         this.putUrlExecutor((String)var2.next(), var1);
      }

   }

   protected String getScheme(String var1) {
      return WebUtils.getScheme(var1);
   }

   protected boolean interpretScheme(String var1, String var2) {
      if(var2 != null && (!var2.equals("about") || !var1.equalsIgnoreCase("about:blank"))) {
         if(this.urlExecutors.containsKey(var2)) {
            return ((AdWebViewClient$UrlExecutor)this.urlExecutors.get(var2)).execute(var1);
         } else {
            Log.d(LOG_TAG, "Scheme %s unrecognized. Launching as intent.", new Object[]{var2});
            return WebUtils.launchActivityForIntentLink(var1, this.context);
         }
      } else {
         return false;
      }
   }

   public void onLoadResource(WebView var1, String var2) {
      this.resourceList.add(var2);
      Log.d(LOG_TAG, "Loading resource: %s", new Object[]{var2});
      this.listener.onLoadResource(var1, var2);
   }

   public void onPageFinished(WebView var1, String var2) {
      Log.d(LOG_TAG, "Page Finished %s", new Object[]{var2});
      if(!this.checkResources()) {
         if(this.listener == null) {
            Log.w(LOG_TAG, "Call to onPageFinished() ignored because listener is null.");
         } else {
            this.listener.onPageFinished(var1, var2);
         }
      }
   }

   public void onPageStarted(WebView var1, String var2, Bitmap var3) {
      super.onPageStarted(var1, var2, var3);
      this.listener.onPageStarted(var1, var2);
   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      Log.e(LOG_TAG, "Error: %s", new Object[]{var3});
      super.onReceivedError(var1, var2, var3, var4);
      this.listener.onReceivedError(var1, var2, var3, var4);
   }

   public void putUrlExecutor(String var1, AdWebViewClient$UrlExecutor var2) {
      this.urlExecutors.put(var1, var2);
   }

   public void setListener(AdWebViewClient$AdWebViewClientListener var1) {
      this.listener = var1;
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      Uri var4 = Uri.parse(var2);
      boolean var3;
      if(redirectHosts.contains(var4.getHost()) && !isHoneycombVersion()) {
         var3 = false;
      } else {
         var3 = true;
      }

      return this.interpretScheme(var2, this.getScheme(var2))?true:var3;
   }
}
