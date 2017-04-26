package com.smaato.soma.internal.connector;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.smaato.soma.BaseView;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.exception.NotifyingSizeChangedFailed;
import com.smaato.soma.exception.OrmmaConnectorInstantiationFailed;
import com.smaato.soma.exception.UnableToGetScreenSize;
import com.smaato.soma.exception.UnableToInjectJavaScript;
import com.smaato.soma.exception.UnableToNotifyBannerLoaded;
import com.smaato.soma.interstitial.InterstitialBannerView;

public class OrmmaConnector {
   public static final String TAG = "OrmmaConnector";
   private BaseView mBannerView = null;
   private float mDensity = 0.0F;
   private WebView mWebView = null;
   private WindowManager mWindowManager;

   public OrmmaConnector(Context var1) {
      try {
         DisplayMetrics var2 = new DisplayMetrics();
         this.mWindowManager = (WindowManager)var1.getSystemService("window");
         this.mWindowManager.getDefaultDisplay().getMetrics(var2);
         this.mDensity = var2.density;
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new OrmmaConnectorInstantiationFailed(var4);
      }
   }

   private String getScreenSize() {
      try {
         Debugger.methodStart(new Object() {
         });
         DisplayMetrics var1 = new DisplayMetrics();
         this.mWindowManager.getDefaultDisplay().getMetrics(var1);
         String var4 = "{ width: " + (int)((float)var1.widthPixels / var1.density) + ", height: " + (int)((float)var1.heightPixels / var1.density) + "}";
         return var4;
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new UnableToGetScreenSize(var3);
      }
   }

   private void injectJavaScript(String var1) {
      try {
         Debugger.methodStart(new Object() {
         });
         Debugger.showLog(new LogMessage("OrmmaConnector", "Injecting " + var1, 1, DebugCategory.DEBUG));
         this.mWebView.loadUrl("javascript:" + var1);
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new UnableToInjectJavaScript(var3);
      }
   }

   public void bannerHasBeenLoaded() {
      try {
         Debugger.methodStart(new Object() {
         });
         String var1 = "window.ormmaview.fireChangeEvent({ state: \'default\', size: { width: " + (int)((float)this.mWebView.getWidth() / this.mDensity) + ", height: " + (int)((float)this.mWebView.getHeight() / this.mDensity) + "}," + " maxSize: " + this.getScreenSize() + ", screenSize: " + this.getScreenSize() + ", defaultPosition: { x:" + (int)((float)this.mBannerView.getLeft() / this.mDensity) + ", y: " + (int)((float)this.mBannerView.getTop() / this.mDensity) + ", width: " + (int)((float)this.mBannerView.getWidth() / this.mDensity) + ", height: " + (int)((float)this.mBannerView.getHeight() / this.mDensity) + " }," + "supports: [ \'level-1\', \'screen\',\'sms\',\'phone\',\'email\',\'calendar\',\'tel\',\'inlineVideo\',\'storePicture\'] });";
         if(this.mBannerView instanceof InterstitialBannerView) {
            this.injectJavaScript("window.ormma.setPlacementType(\'interstitial\');");
         }

         this.injectJavaScript(var1);
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new UnableToNotifyBannerLoaded(var3);
      }
   }

   public BaseView getBannerView() {
      return this.mBannerView;
   }

   public WebView getWebView() {
      return this.mWebView;
   }

   public void notifySizeChanged(String var1) {
      try {
         Debugger.methodStart(new Object() {
         });
         this.injectJavaScript("window.ormmaview.fireChangeEvent({state: \'" + var1 + "\', size:{ width:" + (int)((float)this.mWebView.getWidth() / this.mDensity) + ", height:" + (int)((float)this.mWebView.getHeight() / this.mDensity) + "}});");
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new NotifyingSizeChangedFailed(var3);
      }
   }

   public void setBannerView(BaseView var1) {
      this.mBannerView = var1;
   }

   public void setWebView(WebView var1) {
      this.mWebView = var1;
   }
}
