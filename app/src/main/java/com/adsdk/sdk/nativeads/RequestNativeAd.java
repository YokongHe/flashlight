package com.adsdk.sdk.nativeads;

import android.content.Context;
import android.os.Handler;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.customevents.CustomEvent;
import com.adsdk.sdk.customevents.CustomEventNative;
import com.adsdk.sdk.customevents.CustomEventNative$CustomEventNativeListener;
import com.adsdk.sdk.customevents.CustomEventNativeFactory;
import com.adsdk.sdk.nativeads.NativeAd;
import com.adsdk.sdk.nativeads.NativeAdListener;
import com.adsdk.sdk.nativeads.NativeAdRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestNativeAd implements CustomEventNative$CustomEventNativeListener {
   private Context context;
   private CustomEventNative customEventNative;
   private Handler handler;
   private NativeAdListener listener;
   private NativeAd nativeAd;
   private boolean reportedAvailability;
   private String requestResultJson;

   // $FF: synthetic method
   static String access$0(RequestNativeAd var0) {
      return var0.requestResultJson;
   }

   // $FF: synthetic method
   static NativeAd access$1(RequestNativeAd var0) {
      return var0.nativeAd;
   }

   // $FF: synthetic method
   static void access$2(RequestNativeAd var0, NativeAd var1) {
      var0.notifyAdLoaded(var1);
   }

   // $FF: synthetic method
   static void access$3(RequestNativeAd var0) {
      var0.notifyAdFailed();
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

   private void loadCustomEventNativeAd() {
      this.customEventNative = null;

      while(!this.nativeAd.getCustomEvents().isEmpty() && this.customEventNative == null) {
         try {
            final CustomEvent var1 = (CustomEvent)this.nativeAd.getCustomEvents().get(0);
            this.nativeAd.getCustomEvents().remove(var1);
            this.customEventNative = CustomEventNativeFactory.create(var1.getClassName());
            this.handler.post(new Runnable() {
               public void run() {
                  RequestNativeAd.this.customEventNative.createNativeAd(RequestNativeAd.this.context, RequestNativeAd.this, var1.getOptionalParameter(), var1.getPixelUrl());
               }
            });
         } catch (Exception var2) {
            this.customEventNative = null;
            Log.d("Failed to create Custom Event Native Ad.");
         }
      }

   }

   private void loadOriginalNativeAd() {
      (new Thread(new Runnable() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      })).start();
   }

   private void notifyAdFailed() {
      if(this.listener != null && !this.reportedAvailability) {
         this.handler.post(new Runnable() {
            public void run() {
               RequestNativeAd.this.listener.adFailedToLoad();
            }
         });
      }

      if(this.customEventNative != null) {
         this.customEventNative.unregisterListener();
      }

      this.reportedAvailability = true;
   }

   private void notifyAdLoaded(final NativeAd var1) {
      if(this.listener != null && !this.reportedAvailability) {
         this.handler.post(new Runnable() {
            public void run() {
               RequestNativeAd.this.listener.adLoaded(var1);
            }
         });
      }

      if(this.customEventNative != null) {
         this.customEventNative.unregisterListener();
      }

      this.reportedAvailability = true;
   }

   public void onCustomEventNativeFailed() {
      this.loadCustomEventNativeAd();
      if(this.customEventNative == null) {
         this.loadOriginalNativeAd();
      }
   }

   public void onCustomEventNativeLoaded(NativeAd var1) {
      this.notifyAdLoaded(var1);
   }

   protected NativeAd parse(InputStream param1, Header[] param2) {
      // $FF: Couldn't be decompiled
   }

   public void sendRequest(NativeAdRequest param1, Handler param2, NativeAdListener param3, Context param4) {
      // $FF: Couldn't be decompiled
   }
}
