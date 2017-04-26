package com.smaato.soma;

import android.content.Context;
import com.smaato.soma.AbstractAlertView;
import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.AdType;
import com.smaato.soma.AlertBanner$AdListenerImpl;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.AlerBannerInstantiationException;
import com.smaato.soma.internal.DefaultFactory;

public class AlertBanner extends AbstractAlertView {
   public AlertBanner(Context var1) {
      super(var1);
   }

   protected AdListenerInterface createAdListener() {
      return new AlertBanner$AdListenerImpl(this, (AlertBanner$AdListenerImpl)null);
   }

   protected void init() {
      try {
         Debugger.methodStart(new Object() {
         });
         super.init();
         this.mAlertContent = DefaultFactory.getDefaultFactory().createAdDownloader(this.getContext());
         ((AdDownloaderInterface)this.mAlertContent).addAdListener(this.createAdListener());
         ((AdDownloaderInterface)this.mAlertContent).getAdSettings().setAdType(AdType.TEXT);
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new AlerBannerInstantiationException(var3);
      }
   }
}
