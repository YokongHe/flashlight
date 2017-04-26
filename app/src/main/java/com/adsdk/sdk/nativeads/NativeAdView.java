package com.adsdk.sdk.nativeads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.adsdk.sdk.nativeads.NativeAd;
import com.adsdk.sdk.nativeads.NativeAd$Tracker;
import com.adsdk.sdk.nativeads.NativeAdListener;
import com.adsdk.sdk.nativeads.NativeAdView$LoadUrlTask;
import com.adsdk.sdk.nativeads.NativeViewBinder;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.methods.HttpGet;

@SuppressLint({"ViewConstructor"})
public class NativeAdView extends FrameLayout {
   private View adView;
   private Context context;
   private Handler handler;
   private boolean impressionReported;
   private NativeAdListener listener;
   private NativeAd nativeAd;
   private View overlayView;
   private List trackers;

   public NativeAdView(Context var1, NativeAd var2, NativeViewBinder var3, NativeAdListener var4) {
      super(var1);
      if(var2 != null && var3 != null) {
         this.context = var1;
         this.adView = inflate(var1, var3.getAdLayoutId(), (ViewGroup)null);
         this.overlayView = new View(var1);
         this.trackers = var2.getTrackers();
         this.handler = new Handler();
         this.listener = var4;
         this.fillAdView(var2, var3);
         var2.prepareImpression(this.adView);
         this.overlayView.setOnClickListener(this.createOnNativeAdClickListener(var2));
         this.addView(this.adView);
         this.overlayView.setLayoutParams(new LayoutParams(this.adView.getWidth(), this.adView.getHeight()));
         this.addView(this.overlayView);
      }
   }

   // $FF: synthetic method
   static Context access$0(NativeAdView var0) {
      return var0.context;
   }

   private OnClickListener createOnNativeAdClickListener(final NativeAd var1) {
      return new OnClickListener() {
         public void onClick(View var1x) {
            NativeAdView.this.notifyAdClicked();
            var1.handleClick();
            NativeAdView.this.adView.performClick();
            if(var1.getClickUrl() != null && !var1.getClickUrl().equals("")) {
               (new NativeAdView$LoadUrlTask(NativeAdView.this)).execute(new String[]{var1.getClickUrl()});
            }

         }
      };
   }

   private void notifyAdClicked() {
      if(this.listener != null) {
         this.handler.post(new Runnable() {
            public void run() {
               NativeAdView.this.listener.adClicked();
            }
         });
      }

   }

   private void notifyImpression() {
      if(this.listener != null) {
         this.handler.post(new Runnable() {
            public void run() {
               NativeAdView.this.listener.impression();
            }
         });
      }

   }

   private void trackImpression(final String var1) {
      (new AsyncTask() {
         protected Void doInBackground(Void... var1x) {
            try {
               AndroidHttpClient var4 = AndroidHttpClient.newInstance(System.getProperty("http.agent"));
               HttpGet var2 = new HttpGet();
               var2.setHeader("User-Agent", System.getProperty("http.agent"));
               var2.setURI(new URI(var1));
               var4.execute(var2);
               var4.close();
            } catch (Exception var3) {
               var3.printStackTrace();
            }

            return null;
         }
      }).execute(new Void[0]);
   }

   protected void dispatchDraw(Canvas var1) {
      this.overlayView.setLayoutParams(new LayoutParams(this.adView.getWidth(), this.adView.getHeight()));
      if(!this.impressionReported) {
         this.impressionReported = true;
         if(this.nativeAd != null) {
            this.nativeAd.handleImpression();
         }

         this.notifyImpression();
         Iterator var2 = this.trackers.iterator();

         while(var2.hasNext()) {
            NativeAd$Tracker var3 = (NativeAd$Tracker)var2.next();
            if(var3.type.equals("impression")) {
               this.trackImpression(var3.url);
            }
         }
      }

      super.dispatchDraw(var1);
   }

   public void fillAdView(NativeAd param1, NativeViewBinder param2) {
      // $FF: Couldn't be decompiled
   }
}
