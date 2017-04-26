package com.amazon.device.ads;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.ViewGroup;
import com.amazon.device.ads.Assets;
import com.amazon.device.ads.InAppBrowser;

class InAppBrowser$LoadButtonsTask extends AsyncTask {
   private final int buttonHeight;
   private final int buttonWidth;
   private final Intent intent;
   private final ViewGroup layout;
   // $FF: synthetic field
   final InAppBrowser this$0;

   public InAppBrowser$LoadButtonsTask(InAppBrowser var1, Intent var2, ViewGroup var3, int var4, int var5) {
      this.this$0 = var1;
      this.intent = var2;
      this.layout = var3;
      this.buttonWidth = var4;
      this.buttonHeight = var5;
   }

   protected Void doInBackground(Void... var1) {
      InAppBrowser.access$302(this.this$0, InAppBrowser.access$400(this.this$0, Assets.getInstance().getFilePath("amazon_ads_leftarrow.png"), 9, -1, this.buttonWidth, this.buttonHeight));
      InAppBrowser.access$300(this.this$0).setContentDescription("inAppBrowserBackButton");
      InAppBrowser.access$300(this.this$0).setId(10537);
      InAppBrowser.access$502(this.this$0, InAppBrowser.access$400(this.this$0, Assets.getInstance().getFilePath("amazon_ads_rightarrow.png"), 1, InAppBrowser.access$300(this.this$0).getId(), this.buttonWidth, this.buttonHeight));
      InAppBrowser.access$500(this.this$0).setContentDescription("inAppBrowserForwardButton");
      InAppBrowser.access$500(this.this$0).setId(10794);
      InAppBrowser.access$602(this.this$0, InAppBrowser.access$400(this.this$0, Assets.getInstance().getFilePath("amazon_ads_close.png"), 11, -1, this.buttonWidth, this.buttonHeight));
      InAppBrowser.access$600(this.this$0).setContentDescription("inAppBrowserCloseButton");
      if(InAppBrowser.access$700(this.this$0)) {
         InAppBrowser.access$802(this.this$0, InAppBrowser.access$400(this.this$0, Assets.getInstance().getFilePath("amazon_ads_open_external_browser.png"), 1, InAppBrowser.access$500(this.this$0).getId(), this.buttonWidth, this.buttonHeight));
         InAppBrowser.access$800(this.this$0).setContentDescription("inAppBrowserOpenExternalBrowserButton");
         InAppBrowser.access$800(this.this$0).setId(10795);
         InAppBrowser.access$902(this.this$0, InAppBrowser.access$400(this.this$0, Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, InAppBrowser.access$800(this.this$0).getId(), this.buttonWidth, this.buttonHeight));
      } else {
         InAppBrowser.access$902(this.this$0, InAppBrowser.access$400(this.this$0, Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, InAppBrowser.access$500(this.this$0).getId(), this.buttonWidth, this.buttonHeight));
      }

      InAppBrowser.access$900(this.this$0).setContentDescription("inAppBrowserRefreshButton");
      return null;
   }

   protected void onPostExecute(Void var1) {
      this.layout.addView(InAppBrowser.access$300(this.this$0));
      this.layout.addView(InAppBrowser.access$500(this.this$0));
      this.layout.addView(InAppBrowser.access$900(this.this$0));
      this.layout.addView(InAppBrowser.access$600(this.this$0));
      if(InAppBrowser.access$700(this.this$0)) {
         this.layout.addView(InAppBrowser.access$800(this.this$0));
      }

      InAppBrowser.access$1000(this.this$0, this.intent);
      InAppBrowser.access$1100(this.this$0).set(true);
   }
}
