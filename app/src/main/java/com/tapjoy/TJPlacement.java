package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJAdUnitView;
import com.tapjoy.TJCacheListener;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.internal.AndroidListenerProxy;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gs;
import com.tapjoy.internal.gs$a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

public class TJPlacement {
   private Context a;
   private TJPlacementData b;
   private Map c;
   private TJPlacementListener d;
   private TJPlacementListener e;
   private boolean f;
   private boolean g;
   private gs h;
   private gc i;
   private boolean j;
   private boolean k;

   public TJPlacement(Context var1, String var2, TJPlacementListener var3) {
      Object var4 = null;
      super();
      this.f = false;
      this.g = false;
      this.h = null;
      this.i = null;
      this.j = false;
      this.a = var1;
      this.d = var3;
      TJPlacementListener var5 = (TJPlacementListener)var4;
      if(var3 != null) {
         var5 = (TJPlacementListener)AndroidListenerProxy.newProxyInstance(var3, TJPlacementListener.class);
      }

      this.e = var5;
      this.b = new TJPlacementData();
      this.b.name = var2;
      this.b.guid = UUID.randomUUID().toString();
      TJPlacementManager.put(this.b.guid, this);
      FiveRocksIntegration.addPlacementCallback(var2, this);
   }

   // $FF: synthetic method
   static void a(final TJPlacement var0, TapjoyHttpURLResponse var1) {
      TapjoyLog.i("TJPlacement", "Checking if there is content to cache for placement " + var0.b.name);
      String var3 = var1.getHeaderFieldAsString("x-tapjoy-cacheable-assets");

      try {
         if(!TJPlacementManager.canCachePlacement()) {
            TapjoyLog.i("TJPlacement", "Placement caching limit reached. No content will be cached for placement " + var0.b.name);
            var0.f();
         } else {
            JSONArray var4 = new JSONArray(var3);
            if(var4.length() > 0) {
               TapjoyLog.i("TJPlacement", "Begin caching content for placement " + var0.b.name);
               TJPlacementManager.incrementPlacementCacheCount();
               var0.j = true;
               TapjoyCache.getInstance().cacheAssetGroup(var4, new TJCacheListener() {
                  public final void onCachingComplete(int var1) {
                     var0.f();
                  }
               });
            } else {
               var0.f();
            }
         }
      } catch (JSONException var2) {
         var0.f();
      }
   }

   private boolean a(String var1) {
      ByteArrayInputStream var4 = new ByteArrayInputStream(var1.getBytes());

      try {
         gs$a var5 = (gs$a)this.h.a(URI.create(this.b.url), var4);
         this.i = var5.a;
         var5.a.a();
         if(!var5.a.b()) {
            TapjoyLog.e("TJPlacement", "Failed to load fiverocks placement");
            return false;
         } else {
            return true;
         }
      } catch (IOException var2) {
         TapjoyLog.e("TJPlacement", var2.toString());
         var2.printStackTrace();
         return false;
      } catch (com.tapjoy.internal.ch var3) {
         TapjoyLog.e("TJPlacement", var3.toString());
         var3.printStackTrace();
         return false;
      }
   }

   private void e() {
      synchronized(this){}

      try {
         this.c = TapjoyConnectCore.getGenericURLParams();
         TapjoyUtil.safePut(this.c, "event_name", this.b.name, true);
         this.c.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
         String var1 = TapjoyConnectCore.getPlacementURL() + "v1/apps/" + TapjoyConnectCore.getAppID() + "/content?";
         this.b.url = var1;
         this.b.baseURL = var1.substring(0, var1.indexOf(47, var1.indexOf("//") + 3));
         TapjoyUtil.safePut(this.c, "debug", Boolean.toString(fs.a), true);
         TapjoyUtil.safePut(this.c, "event_preload", String.valueOf(true), true);
         (new Thread() {
            public final void run() {
               TJPlacement.this.k = true;
               TapjoyLog.i("TJPlacement", "Sending content request for placement " + TJPlacement.this.b.name);
               fv var1 = fv.a();
               TJPlacement.this.h = var1.a(TJPlacement.this.b.name, TJPlacement.this.a);
               TapjoyHttpURLResponse var3 = (new TapjoyURLConnection()).getResponseFromURL(TJPlacement.this.b.url, (Map)null, (Map)null, (Map)TJPlacement.this.c);
               TJPlacement.this.b.httpStatusCode = var3.statusCode;
               TJPlacement.this.b.httpResponse = var3.response;
               String var2 = var3.getHeaderFieldAsString("X-Tapjoy-Debug");
               if(var2 != null) {
                  TapjoyLog.v("TJPlacement", "Tapjoy-Server-Debug: " + var2);
               }

               if(var3 != null && TJPlacement.this.d != null) {
                  switch(var3.statusCode) {
                  case 0:
                     TapjoyLog.i("TJPlacement", "Send request failed for placement " + TJPlacement.this.b.name);
                     TJPlacement.g(TJPlacement.this);
                     TJPlacement.this.d.onRequestFailure(TJPlacement.this, new TJError(var3.statusCode, var3.response));
                     break;
                  case 200:
                     var2 = var3.getHeaderFieldAsString("Content-Type");
                     if(!com.tapjoy.internal.cv.c(var2) && var2.contains("json")) {
                        if(TJPlacement.this.a(var3.response)) {
                           TJPlacement.this.b();
                           TJPlacement.this.f();
                        } else {
                           TapjoyLog.i("TJPlacement", "Content request delivered successfully for placement " + TJPlacement.this.b.name + ", contentAvailable: " + TJPlacement.this.f);
                           TJPlacement.this.d.onRequestSuccess(TJPlacement.this);
                        }
                     } else {
                        TJPlacement.this.b();
                        TJPlacement.a(TJPlacement.this, var3);
                     }
                     break;
                  default:
                     TapjoyLog.i("TJPlacement", "Content request delivered successfully for placement " + TJPlacement.this.b.name + ", contentAvailable: " + TJPlacement.this.f);
                     TJPlacement.this.d.onRequestSuccess(TJPlacement.this);
                  }
               }

               TJPlacement.this.k = false;
            }
         }).start();
      } finally {
         ;
      }

   }

   private void f() {
      this.g = true;
      TapjoyLog.i("TJPlacement", "Content is ready for placement " + this.b.name);
      if(this.d != null) {
         this.d.onContentReady(this);
      }

   }

   // $FF: synthetic method
   static void g(TJPlacement var0) {
      TapjoyLog.i("TJPlacement", "Tracking event " + var0.b.name + " for offline delivery");
      var0.c.remove("timestamp");
      var0.c.remove("verifier");
      TapjoyConnectCore.saveOfflineLog(var0.b.url + TapjoyUtil.convertURLParams(var0.c, false));
   }

   final TJPlacementListener a() {
      return this.e;
   }

   protected final void b() {
      this.f = true;
      TapjoyLog.i("TJPlacement", "Content request delivered successfully for placement " + this.b.name + ", contentAvailable: " + this.f);
      this.d.onRequestSuccess(this);
   }

   final boolean c() {
      return this.j;
   }

   final void d() {
      this.j = false;
   }

   public String getGUID() {
      return this.b.guid;
   }

   public TJPlacementListener getListener() {
      return this.d;
   }

   public String getName() {
      return this.b.name;
   }

   public boolean isContentAvailable() {
      return this.f;
   }

   public boolean isContentReady() {
      return this.g;
   }

   public void requestContent() {
      if(!TapjoyConnectCore.isConnected()) {
         TapjoyLog.e("TJPlacement", "Can not call requestContent for TJPlacement because Tapjoy SDK has not successfully connected.");
         if(this.d != null) {
            this.d.onRequestFailure(this, new TJError(0, "SDK not connected -- connect must be called first with a successful callback"));
         }
      } else if(this.a == null) {
         TapjoyLog.e("TJPlacement", "Can not call requestContent for TJPlacement because context is null");
         if(this.d != null) {
            this.d.onRequestFailure(this, new TJError(0, "Context is null -- TJPlacement requires a valid Context."));
            return;
         }
      } else {
         if(this.b.name != null && this.b.name.length() != 0) {
            if(this.k) {
               TapjoyLog.i("TJPlacement", "Placement " + this.getName() + " is already requesting content");
               return;
            }

            this.e();
            return;
         }

         TapjoyLog.e("TJPlacement", "Can not call send for TJPlacement because name is null or empty");
         if(this.d != null) {
            this.d.onRequestFailure(this, new TJError(0, "Invalid placement name -- TJPlacement requires a valid placement name."));
            return;
         }
      }

   }

   public void showContent() {
      TapjoyLog.i("TJPlacement", "showPlacementContent() called for placement " + this.b.name);
      if(!this.f) {
         TapjoyLog.e("TJPlacement", "No placement content available. Can not show content for non-200 placement.");
      } else if(this.d == null) {
         TapjoyLog.e("TJPlacement", "TJPlacementListener is null");
      } else if(TapjoyConnectCore.isViewOpen()) {
         TapjoyLog.w("TJPlacement", "Only one view can be presented at a time.");
      } else {
         if(this.i != null) {
            if(this.i instanceof ga) {
               TapjoyConnectCore.viewWillOpen(0);
               ((ga)this.i).e = new fq() {
                  public final void a(Context var1, String var2) {
                     TJPlacement.this.b.redirectedFromOtherContent = true;
                     Intent var3 = new Intent(var1, TJAdUnitView.class);
                     var3.putExtra("url", var2);
                     var3.putExtra("view_type", 1);
                     var3.putExtra("tjplacement", TJPlacement.this.b);
                     var3.putExtra("legacy_view", true);
                     var3.setFlags(268435456);
                     var1.startActivity(var3);
                  }
               };
               fv.a(new Runnable() {
                  public final void run() {
                     TJPlacement.this.i.a(fv.a().h());
                  }
               });
            }
         } else {
            TapjoyConnectCore.viewWillOpen(0);
            Intent var1 = new Intent(this.a, TJAdUnitView.class);
            var1.putExtra("view_type", 1);
            var1.putExtra("tjplacement", this.b);
            var1.setFlags(268435456);
            this.a.startActivity(var1);
         }

         this.f = false;
         this.g = false;
         this.j = false;
      }
   }
}
