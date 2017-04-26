package com.mopub.mobileads.util.vast;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.common.HttpClient;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.vast.VastXmlManagerAggregator$VastXmlManagerAggregatorListener;
import java.lang.ref.WeakReference;
import java.util.List;
import org.apache.http.HttpEntity;

public class VastXmlManagerAggregator extends AsyncTask {
   static final int MAX_TIMES_TO_FOLLOW_VAST_REDIRECT = 20;
   private int mTimesFollowedVastRedirect;
   private final WeakReference mVastXmlManagerAggregatorListener;

   VastXmlManagerAggregator(VastXmlManagerAggregator$VastXmlManagerAggregatorListener var1) {
      this.mVastXmlManagerAggregatorListener = new WeakReference(var1);
   }

   protected List doInBackground(String... param1) {
      // $FF: Couldn't be decompiled
   }

   String followVastRedirect(AndroidHttpClient var1, String var2) {
      Object var4 = null;
      String var3 = (String)var4;
      if(var2 != null) {
         var3 = (String)var4;
         if(this.mTimesFollowedVastRedirect < 20) {
            ++this.mTimesFollowedVastRedirect;
            HttpEntity var5 = var1.execute(HttpClient.initializeHttpGet(var2)).getEntity();
            var3 = (String)var4;
            if(var5 != null) {
               var3 = Strings.fromStream(var5.getContent());
            }
         }
      }

      return var3;
   }

   protected void onCancelled() {
      VastXmlManagerAggregator$VastXmlManagerAggregatorListener var1 = (VastXmlManagerAggregator$VastXmlManagerAggregatorListener)this.mVastXmlManagerAggregatorListener.get();
      if(var1 != null) {
         var1.onAggregationComplete((List)null);
      }

   }

   protected void onPostExecute(List var1) {
      VastXmlManagerAggregator$VastXmlManagerAggregatorListener var2 = (VastXmlManagerAggregator$VastXmlManagerAggregatorListener)this.mVastXmlManagerAggregatorListener.get();
      if(var2 != null) {
         var2.onAggregationComplete(var1);
      }

   }

   @Deprecated
   void setTimesFollowedVastRedirect(int var1) {
      this.mTimesFollowedVastRedirect = var1;
   }
}
