package com.millennialmedia.android;

import android.content.Context;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.CachedAd;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.HttpGetRequest;
import com.millennialmedia.android.HttpMMHeaders;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.MMSDK$Event;
import com.millennialmedia.android.VideoAd;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

class MMAdImplController$RequestAdRunnable implements Runnable {
   String adUrl;
   HttpMMHeaders mmHeaders;
   // $FF: synthetic field
   final MMAdImplController this$0;

   private MMAdImplController$RequestAdRunnable(MMAdImplController var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   MMAdImplController$RequestAdRunnable(MMAdImplController var1, Object var2) {
      this(var1);
   }

   private boolean isAdUrlBuildable() {
      // $FF: Couldn't be decompiled
   }

   private boolean isHandledHtmlResponse(HttpEntity param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean isHandledJsonResponse(HttpEntity var1) {
      MMAdImpl var2;
      if(this.this$0.adImplRef != null) {
         var2 = (MMAdImpl)this.this$0.adImplRef.get();
      } else {
         var2 = null;
      }

      if(var2 != null) {
         if(var2.isBanner()) {
            return this.failWithErrorMessage(new MMException("Millennial ad return unsupported format.", 15));
         }

         VideoAd var5;
         try {
            var5 = (VideoAd)CachedAd.parseJSON(HttpGetRequest.convertStreamToString(var1.getContent()));
         } catch (IllegalStateException var3) {
            var3.printStackTrace();
            return this.failWithInfoMessage(new MMException("Millennial ad return failed. Invalid response data.", var3));
         } catch (IOException var4) {
            var4.printStackTrace();
            return this.failWithInfoMessage(new MMException("Millennial ad return failed. " + var4, var4));
         }

         if(var5 != null && var5.isValid()) {
            MMLog.i("MMAdImplController", "Cached video ad JSON received: " + var5.getId());
            if(var5.isExpired()) {
               MMLog.i("MMAdImplController", "New ad has expiration date in the past. Not downloading ad content.");
               var5.delete(var2.getContext());
               MMSDK$Event.requestFailed(var2, new MMException(15));
            } else if(AdCache.loadNextCachedAd(var2.getContext(), var2.getCachedName()) != null) {
               MMLog.i("MMAdImplController", "Previously fetched ad exists in the playback queue. Not downloading ad content.");
               var5.delete(var2.getContext());
               MMSDK$Event.requestFailed(var2, new MMException(17));
            } else {
               AdCache.save(var2.getContext(), var5);
               if(!var5.isOnDisk(var2.getContext())) {
                  MMSDK$Event.logEvent(var5.cacheMissURL);
                  MMLog.d("MMAdImplController", "Downloading ad...");
                  MMSDK$Event.fetchStartedCaching(var2);
                  var5.downloadPriority = 3;
                  AdCache.startDownloadTask(var2.getContext(), var2.getCachedName(), var5, var2.controller);
               } else {
                  MMLog.d("MMAdImplController", "Cached ad is valid. Moving it to the front of the queue.");
                  AdCache.setNextCachedAd(var2.getContext(), var2.getCachedName(), var5.getId());
                  MMSDK$Event.fetchStartedCaching(var2);
                  MMSDK$Event.requestCompleted(var2);
               }
            }
         }
      }

      return true;
   }

   private boolean isHandledResponse(HttpResponse var1) {
      HttpEntity var2 = var1.getEntity();
      if(var2 == null) {
         this.failWithInfoMessage(new MMException("Null HTTP entity", 14));
         return false;
      } else if(var2.getContentLength() == 0L) {
         this.failWithInfoMessage(new MMException("Millennial ad return failed. Zero content length returned.", 14));
         return false;
      } else {
         this.saveMacId(var1);
         Header var3 = var2.getContentType();
         if(var3 != null && var3.getValue() != null) {
            if(var3.getValue().toLowerCase().startsWith("application/json")) {
               this.isHandledJsonResponse(var2);
            } else {
               if(!var3.getValue().toLowerCase().startsWith("text/html")) {
                  this.failWithInfoMessage(new MMException("Millennial ad return failed. Invalid (JSON/HTML expected) mime type returned.", 15));
                  return false;
               }

               var3 = var1.getFirstHeader("X-MM-Video");
               this.mmHeaders = new HttpMMHeaders(var1.getAllHeaders());
               if(var3 != null && var3.getValue().equalsIgnoreCase("true")) {
                  MMAdImpl var4 = null;
                  if(this.this$0.adImplRef != null) {
                     var4 = (MMAdImpl)this.this$0.adImplRef.get();
                  }

                  if(var4 != null) {
                     Context var5 = var4.getContext();
                     HandShake.sharedHandShake(var5).updateLastVideoViewedTime(var5, var4.adType);
                  }
               }

               this.isHandledHtmlResponse(var2);
            }

            return true;
         } else {
            this.failWithInfoMessage(new MMException("Millennial ad return failed. HTTP Header value null.", 15));
            return false;
         }
      }
   }

   private void saveMacId(HttpResponse var1) {
      Header[] var7 = var1.getHeaders("Set-Cookie");
      int var3 = var7.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         String var6 = var7[var2].getValue();
         int var4 = var6.indexOf("MAC-ID=");
         if(var4 >= 0) {
            int var5 = var6.indexOf(59, var4);
            if(var5 > var4) {
               MMSDK.macId = var6.substring(var4 + 7, var5);
            }
         }
      }

   }

   boolean fail(MMException var1) {
      MMAdImpl var2 = null;
      if(this.this$0.adImplRef != null) {
         var2 = (MMAdImpl)this.this$0.adImplRef.get();
      }

      MMSDK$Event.requestFailed(var2, var1);
      return false;
   }

   boolean failWithErrorMessage(MMException var1) {
      MMLog.e("MMAdImplController", var1.getMessage());
      return this.fail(var1);
   }

   boolean failWithInfoMessage(MMException var1) {
      MMLog.i("MMAdImplController", var1.getMessage());
      return this.fail(var1);
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }
}
