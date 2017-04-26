package com.inmobi.monetization.internal;

import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.Ad;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class Ad$a extends Handler {
   private final WeakReference a;

   public Ad$a(Ad var1) {
      this.a = new WeakReference(var1);
   }

   public void handleMessage(Message var1) {
      Ad var6 = (Ad)this.a.get();
      if(var6 != null) {
         switch(var1.what) {
         case 101:
            long var2 = System.currentTimeMillis();
            long var4 = var6.mFetchStartTime;
            JSONObject var8 = new JSONObject();

            try {
               var8.put("t", var2 - var4);
               var8.put("m", 1);
               Ad.a(var6, var8, NetworkEventType.CONNECT_ERROR);
            } catch (JSONException var7) {
               Log.internal("[InMobi]-[Monetization]", "Error creating metric logs for error at " + System.currentTimeMillis());
            }

            var6.setDownloadingNewAd(false);
            if(var6.mAdListener != null) {
               var6.mAdListener.onAdRequestFailed(AdErrorCode.NETWORK_ERROR);
               return;
            }
            break;
         default:
            return;
         }
      }

   }
}
