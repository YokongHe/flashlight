package com.mopub.nativeads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import com.mopub.nativeads.SpinningProgressView;
import com.mopub.nativeads.UrlResolutionTask;
import com.mopub.nativeads.UrlResolutionTask$UrlResolutionListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class ClickDestinationResolutionListener implements UrlResolutionTask$UrlResolutionListener {
   private final Context mContext;
   private final WeakReference mSpinningProgressView;
   private final Iterator mUrlIterator;

   public ClickDestinationResolutionListener(Context var1, Iterator var2, SpinningProgressView var3) {
      this.mContext = var1.getApplicationContext();
      this.mUrlIterator = var2;
      this.mSpinningProgressView = new WeakReference(var3);
   }

   private void removeSpinningProgressView() {
      SpinningProgressView var1 = (SpinningProgressView)this.mSpinningProgressView.get();
      if(var1 != null) {
         var1.removeFromRoot();
      }

   }

   public void onFailure() {
      MoPubLog.d("Failed to resolve URL for click.");
      this.removeSpinningProgressView();
   }

   public void onSuccess(String var1) {
      Intent var2;
      if(Intents.isNativeBrowserScheme(var1)) {
         try {
            var2 = Intents.intentForNativeBrowserScheme(var1);
            Intents.startActivity(this.mContext, var2);
            this.removeSpinningProgressView();
            return;
         } catch (UrlParseException var7) {
            MoPubLog.d(var7.getMessage());
         } catch (IntentNotResolvableException var8) {
            MoPubLog.d("Could not handle intent for URI: " + var1);
         }

         if(this.mUrlIterator.hasNext()) {
            UrlResolutionTask.getResolvedUrl((String)this.mUrlIterator.next(), this);
         } else {
            this.removeSpinningProgressView();
         }
      } else if(!Intents.isDeepLink(var1)) {
         this.removeSpinningProgressView();
         MoPubBrowser.open(this.mContext, var1);
      } else {
         var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         if(Intents.deviceCanHandleIntent(this.mContext, var2)) {
            label86: {
               try {
                  Intents.startActivity(this.mContext, var2);
               } catch (IntentNotResolvableException var9) {
                  MoPubLog.d("Could not handle intent with URI: " + var1);
                  break label86;
               } finally {
                  this.removeSpinningProgressView();
               }

               return;
            }
         }

         if(this.mUrlIterator.hasNext()) {
            UrlResolutionTask.getResolvedUrl((String)this.mUrlIterator.next(), this);
         } else {
            this.removeSpinningProgressView();
         }
      }
   }
}
