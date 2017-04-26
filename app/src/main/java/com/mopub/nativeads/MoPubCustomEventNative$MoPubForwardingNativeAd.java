package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.BaseForwardingNativeAd;
import com.mopub.nativeads.CustomEventNative$CustomEventNativeListener;
import com.mopub.nativeads.CustomEventNative$ImageListener;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.NativeResponse$Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MoPubCustomEventNative$MoPubForwardingNativeAd extends BaseForwardingNativeAd {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$mopub$nativeads$NativeResponse$Parameter;
   private final Context mContext;
   private final CustomEventNative$CustomEventNativeListener mCustomEventNativeListener;
   private final JSONObject mJsonObject;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$mopub$nativeads$NativeResponse$Parameter() {
      int[] var0 = $SWITCH_TABLE$com$mopub$nativeads$NativeResponse$Parameter;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[NativeResponse$Parameter.values().length];

         try {
            var0[NativeResponse$Parameter.CALL_TO_ACTION.ordinal()] = 9;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            var0[NativeResponse$Parameter.CLICK_DESTINATION.ordinal()] = 7;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            var0[NativeResponse$Parameter.CLICK_TRACKER.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            var0[NativeResponse$Parameter.FALLBACK.ordinal()] = 8;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            var0[NativeResponse$Parameter.ICON_IMAGE.ordinal()] = 6;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            var0[NativeResponse$Parameter.IMPRESSION_TRACKER.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[NativeResponse$Parameter.MAIN_IMAGE.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[NativeResponse$Parameter.STAR_RATING.ordinal()] = 10;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[NativeResponse$Parameter.TEXT.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[NativeResponse$Parameter.TITLE.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$mopub$nativeads$NativeResponse$Parameter = var0;
         return var0;
      }
   }

   MoPubCustomEventNative$MoPubForwardingNativeAd(Context var1, JSONObject var2, CustomEventNative$CustomEventNativeListener var3) {
      this.mJsonObject = var2;
      this.mContext = var1;
      this.mCustomEventNativeListener = var3;
   }

   private void addImpressionTrackers(Object var1) {
      if(!(var1 instanceof JSONArray)) {
         throw new ClassCastException("Expected impression trackers of type JSONArray.");
      } else {
         JSONArray var5 = (JSONArray)var1;

         for(int var2 = 0; var2 < var5.length(); ++var2) {
            try {
               this.addImpressionTracker(var5.getString(var2));
            } catch (JSONException var4) {
               MoPubLog.d("Unable to parse impression trackers.");
            }
         }

      }
   }

   private void addInstanceVariable(NativeResponse$Parameter param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean containsRequiredKeys(JSONObject var1) {
      HashSet var2 = new HashSet();
      Iterator var3 = var1.keys();

      while(var3.hasNext()) {
         var2.add((String)var3.next());
      }

      return var2.containsAll(NativeResponse$Parameter.requiredKeys);
   }

   private boolean isImageKey(String var1) {
      return var1 != null && var1.toLowerCase(Locale.US).endsWith("image");
   }

   List getAllImageUrls() {
      ArrayList var1 = new ArrayList();
      if(this.getMainImageUrl() != null) {
         var1.add(this.getMainImageUrl());
      }

      if(this.getIconImageUrl() != null) {
         var1.add(this.getIconImageUrl());
      }

      var1.addAll(this.getExtrasImageUrls());
      return var1;
   }

   List getExtrasImageUrls() {
      ArrayList var1 = new ArrayList(this.getExtras().size());
      Iterator var2 = this.getExtras().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(this.isImageKey((String)var3.getKey()) && var3.getValue() instanceof String) {
            var1.add((String)var3.getValue());
         }
      }

      return var1;
   }

   void loadAd() {
      if(!this.containsRequiredKeys(this.mJsonObject)) {
         throw new IllegalArgumentException("JSONObject did not contain required keys.");
      } else {
         Iterator var2 = this.mJsonObject.keys();

         while(var2.hasNext()) {
            String var1 = (String)var2.next();
            NativeResponse$Parameter var3 = NativeResponse$Parameter.from(var1);
            if(var3 != null) {
               try {
                  this.addInstanceVariable(var3, this.mJsonObject.opt(var1));
               } catch (ClassCastException var4) {
                  throw new IllegalArgumentException("JSONObject key (" + var1 + ") contained unexpected value.");
               }
            } else {
               this.addExtra(var1, this.mJsonObject.opt(var1));
            }
         }

         preCacheImages(this.mContext, this.getAllImageUrls(), new CustomEventNative$ImageListener() {
            public void onImagesCached() {
               MoPubCustomEventNative$MoPubForwardingNativeAd.this.mCustomEventNativeListener.onNativeAdLoaded(MoPubCustomEventNative$MoPubForwardingNativeAd.this);
            }

            public void onImagesFailedToCache(NativeErrorCode var1) {
               MoPubCustomEventNative$MoPubForwardingNativeAd.this.mCustomEventNativeListener.onNativeAdFailed(var1);
            }
         });
      }
   }
}
