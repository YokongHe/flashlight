package com.adsdk.sdk.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import com.adsdk.sdk.video.AspectRatioImageViewWidth;
import com.adsdk.sdk.video.NavIconData;

@SuppressLint({"ViewConstructor"})
public class NavIcon extends AspectRatioImageViewWidth implements OnClickListener {
   private Context mContext;
   private Handler mHandler;
   private NavIconData mIcon;

   public NavIcon(Context var1, NavIconData var2) {
      super(var1);
      int var3 = (int)TypedValue.applyDimension(1, 4.0F, this.getResources().getDisplayMetrics());
      this.mContext = var1;
      this.mIcon = var2;
      this.setPadding(var3, 0, var3, 0);
      this.mHandler = new Handler();
      this.setVisibility(8);
      this.setImageDrawable(var2.iconUrl);
      this.setOnClickListener(this);
   }

   private Drawable fetchImage(String param1) {
      // $FF: Couldn't be decompiled
   }

   private void setImageDrawable(final String var1) {
      (new Thread(new Runnable() {
         public void run() {
            final Drawable var1x = NavIcon.this.fetchImage(var1);
            if(var1x != null) {
               NavIcon.this.mHandler.post(new Runnable() {
                  public void run() {
                     NavIcon.this.setImageDrawable(var1x);
                     NavIcon.this.setVisibility(0);
                     NavIcon.this.requestLayout();
                  }
               });
            }

         }
      })).start();
   }

   public void onClick(View param1) {
      // $FF: Couldn't be decompiled
   }
}
