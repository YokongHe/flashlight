package org.nexage.sourcekit.mraid;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.nexage.sourcekit.mraid.MRAIDView;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;

class MRAIDView$MRAIDWebViewClient extends WebViewClient {
   // $FF: synthetic field
   final MRAIDView this$0;

   private MRAIDView$MRAIDWebViewClient(MRAIDView var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   MRAIDView$MRAIDWebViewClient(MRAIDView var1, MRAIDView$MRAIDWebViewClient var2) {
      this(var1);
   }

   public void onPageFinished(WebView var1, String var2) {
      MRAIDLog.d("MRAIDView", "onPageFinished: " + var2);
      super.onPageFinished(var1, var2);
      if(MRAIDView.access$0(this.this$0) == 0) {
         MRAIDView.access$1(this.this$0, true);
         MRAIDView var5 = this.this$0;
         StringBuilder var3 = new StringBuilder("mraid.setPlacementType(\'");
         String var4;
         if(MRAIDView.access$2(this.this$0)) {
            var4 = "interstitial";
         } else {
            var4 = "inline";
         }

         MRAIDView.access$3(var5, var3.append(var4).append("\');").toString());
         MRAIDView.access$4(this.this$0);
         if(MRAIDView.access$5(this.this$0)) {
            MRAIDView.access$6(this.this$0);
            MRAIDView.access$7(this.this$0);
            MRAIDView.access$8(this.this$0);
            MRAIDView.access$9(this.this$0);
            if(MRAIDView.access$2(this.this$0)) {
               this.this$0.showAsInterstitial();
            } else {
               MRAIDView.access$10(this.this$0, 1);
               MRAIDView.access$11(this.this$0);
               MRAIDView.access$12(this.this$0);
               if(MRAIDView.access$13(this.this$0)) {
                  MRAIDView.access$14(this.this$0);
               }
            }
         }

         if(MRAIDView.access$15(this.this$0) != null) {
            MRAIDView.access$15(this.this$0).mraidViewLoaded(this.this$0);
         }
      }

      if(MRAIDView.access$16(this.this$0)) {
         MRAIDView.access$17(this.this$0, false);
         MRAIDView.access$18(this.this$0).post(new Runnable() {
            public void run() {
               MRAIDView var2 = MRAIDView$MRAIDWebViewClient.this.this$0;
               StringBuilder var3 = new StringBuilder("mraid.setPlacementType(\'");
               String var1;
               if(MRAIDView.access$2(MRAIDView$MRAIDWebViewClient.this.this$0)) {
                  var1 = "interstitial";
               } else {
                  var1 = "inline";
               }

               MRAIDView.access$3(var2, var3.append(var1).append("\');").toString());
               MRAIDView.access$4(MRAIDView$MRAIDWebViewClient.this.this$0);
               MRAIDView.access$6(MRAIDView$MRAIDWebViewClient.this.this$0);
               MRAIDView.access$9(MRAIDView$MRAIDWebViewClient.this.this$0);
               MRAIDLog.d("MRAIDView", "calling fireStateChangeEvent 2");
               MRAIDView.access$11(MRAIDView$MRAIDWebViewClient.this.this$0);
               MRAIDView.access$12(MRAIDView$MRAIDWebViewClient.this.this$0);
               if(MRAIDView.access$13(MRAIDView$MRAIDWebViewClient.this.this$0)) {
                  MRAIDView.access$14(MRAIDView$MRAIDWebViewClient.this.this$0);
               }

            }
         });
      }

   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      MRAIDLog.d("MRAIDView", "onReceivedError: " + var3);
      super.onReceivedError(var1, var2, var3, var4);
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      MRAIDLog.d("MRAIDView", "shouldOverrideUrlLoading: " + var2);
      if(!MRAIDView.access$19(this.this$0)) {
         MRAIDLog.w("MRAIDView", "Ignoring url request because user hasn\'t touched the WebView yet.");
         return false;
      } else if(var2.startsWith("mraid://")) {
         MRAIDView.access$20(this.this$0, var2);
         return true;
      } else {
         MRAIDView.access$21(this.this$0, var2);
         return true;
      }
   }
}
