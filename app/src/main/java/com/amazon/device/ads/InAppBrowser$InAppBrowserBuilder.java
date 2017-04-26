package com.amazon.device.ads;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.Assets;
import com.amazon.device.ads.InAppBrowser;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.StringUtils;

public class InAppBrowser$InAppBrowserBuilder {
   private static final String LOGTAG = InAppBrowser$InAppBrowserBuilder.class.getSimpleName();
   private Context context;
   private boolean showOpenExternalBrowserButton;
   private String url;

   public void show() {
      if(this.context == null) {
         throw new IllegalArgumentException("Context must not be null");
      } else if(StringUtils.isNullOrWhiteSpace(this.url)) {
         throw new IllegalArgumentException("Url must not be null or white space");
      } else if(!Assets.getInstance().ensureAssetsCreated()) {
         Log.e(LOGTAG, "Could not load application assets, failed to open URI: %s", new Object[]{this.url});
      } else {
         Intent var1 = new Intent(this.context, AdActivity.class);
         var1.putExtra("adapter", InAppBrowser.class.getName());
         var1.putExtra("extra_url", this.url);
         var1.putExtra("extra_open_btn", this.showOpenExternalBrowserButton);
         var1.addFlags(268435456);
         this.context.startActivity(var1);
      }
   }

   public InAppBrowser$InAppBrowserBuilder withContext(Context var1) {
      this.context = var1;
      return this;
   }

   public InAppBrowser$InAppBrowserBuilder withExternalBrowserButton() {
      this.showOpenExternalBrowserButton = true;
      return this;
   }

   public InAppBrowser$InAppBrowserBuilder withUrl(String var1) {
      this.url = var1;
      return this;
   }
}
