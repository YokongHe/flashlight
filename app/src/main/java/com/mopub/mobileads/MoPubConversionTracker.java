package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import com.mopub.common.Constants;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubConversionTracker$ConversionUrlGenerator;
import com.mopub.network.TrackingRequest;
import com.mopub.network.TrackingRequest$Listener;
import com.mopub.volley.VolleyError;

public class MoPubConversionTracker {
   private Context mContext;
   private String mIsTrackedKey;
   private String mPackageName;
   private SharedPreferences mSharedPreferences;

   // $FF: synthetic method
   static String access$0(MoPubConversionTracker var0) {
      return var0.mPackageName;
   }

   // $FF: synthetic method
   static Context access$1(MoPubConversionTracker var0) {
      return var0.mContext;
   }

   private boolean isAlreadyTracked() {
      return this.mSharedPreferences.getBoolean(this.mIsTrackedKey, false);
   }

   public void reportAppOpen(Context var1) {
      if(var1 != null) {
         this.mContext = var1;
         this.mPackageName = this.mContext.getPackageName();
         this.mIsTrackedKey = this.mPackageName + " tracked";
         this.mSharedPreferences = SharedPreferencesHelper.getSharedPreferences(this.mContext);
         if(!this.isAlreadyTracked()) {
            TrackingRequest.makeTrackingHttpRequest((new MoPubConversionTracker$ConversionUrlGenerator(this, (MoPubConversionTracker$ConversionUrlGenerator)null)).generateUrlString(Constants.HOST), this.mContext, new TrackingRequest$Listener() {
               public void onErrorResponse(VolleyError var1) {
               }

               public void onResponse() {
                  MoPubConversionTracker.this.mSharedPreferences.edit().putBoolean(MoPubConversionTracker.this.mIsTrackedKey, true).commit();
               }
            });
         } else {
            MoPubLog.d("Conversion already tracked");
         }
      }
   }
}
