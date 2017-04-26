package com.smaato.soma.interstitial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.exception.AddingCloseButtonToInterstitialFailed;
import com.smaato.soma.exception.RequestingActivityFeaturesFailed;
import com.smaato.soma.toaster.CloseButtonView;

public class BaseActivity extends Activity {
   private CloseButtonView mCloseButton;
   private RelativeLayout mLayout;

   private void initActivityFeatures() {
      try {
         this.requestWindowFeature(1);
         this.getWindow().addFlags(1024);
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new RequestingActivityFeaturesFailed(var3);
      }
   }

   protected void addCloseButton() {
      try {
         this.mCloseButton = new CloseButtonView(this.getBaseContext());
         this.mCloseButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               (new CrashReportTemplate() {
                  public Void process() {
                     BaseActivity.this.finish();
                     return null;
                  }
               }).execute();
            }
         });
         this.mLayout.addView(this.mCloseButton);
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new AddingCloseButtonToInterstitialFailed(var3);
      }
   }

   protected RelativeLayout getLayout() {
      return this.mLayout;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      (new CrashReportTemplate() {
         public Void process() {
            BaseActivity.this.initActivityFeatures();
            BaseActivity.this.mLayout = new RelativeLayout(BaseActivity.this);
            (new LayoutParams(-1, -2)).addRule(13);
            BaseActivity.this.setContentView(BaseActivity.this.mLayout, new LayoutParams(-1, -1));
            return null;
         }
      }).execute();
   }
}
