package com.amazon.device.ads;

import com.amazon.device.ads.AdProperties$AdType;
import com.amazon.device.ads.Log;
import org.json.JSONArray;
import org.json.JSONException;

public class AdProperties {
   private static final String LOG_TAG = "AdProperties";
   private AdProperties$AdType adType_;
   private boolean canExpand_ = false;
   private boolean canPlayAudio_ = false;
   private boolean canPlayVideo_ = false;

   protected AdProperties() {
   }

   AdProperties(JSONArray var1) {
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.length(); ++var2) {
            try {
               switch(var1.getInt(var2)) {
               case 1001:
               case 1002:
                  this.canPlayAudio_ = true;
                  break;
               case 1003:
               case 1004:
                  this.canExpand_ = true;
               case 1005:
               case 1006:
               case 1009:
               case 1010:
               case 1011:
               case 1012:
               case 1013:
               case 1015:
               default:
                  break;
               case 1007:
                  this.adType_ = AdProperties$AdType.IMAGE_BANNER;
                  break;
               case 1008:
                  this.adType_ = AdProperties$AdType.INTERSTITIAL;
                  break;
               case 1014:
                  this.canPlayVideo_ = true;
                  break;
               case 1016:
                  this.adType_ = AdProperties$AdType.MRAID_1;
                  break;
               case 1017:
                  this.adType_ = AdProperties$AdType.MRAID_2;
               }
            } catch (JSONException var4) {
               Log.w("AdProperties", "Unable to parse creative type: %s", new Object[]{var4.getMessage()});
            }
         }
      }

   }

   public boolean canExpand() {
      return this.canExpand_;
   }

   public boolean canPlayAudio() {
      return this.canPlayAudio_;
   }

   public boolean canPlayVideo() {
      return this.canPlayVideo_;
   }

   public AdProperties$AdType getAdType() {
      return this.adType_;
   }

   void setAdType(AdProperties$AdType var1) {
      this.adType_ = var1;
   }

   void setCanExpand(boolean var1) {
      this.canExpand_ = var1;
   }

   void setCanPlayAudio(boolean var1) {
      this.canPlayAudio_ = var1;
   }

   void setCanPlayVideo(boolean var1) {
      this.canPlayVideo_ = var1;
   }
}
