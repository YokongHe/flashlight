package com.mopub.nativeads;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.ViewBinder;
import java.util.Iterator;

class NativeViewHolder {
   @VisibleForTesting
   static final NativeViewHolder EMPTY_VIEW_HOLDER = new NativeViewHolder();
   TextView callToActionView;
   ImageView iconImageView;
   ImageView mainImageView;
   TextView textView;
   TextView titleView;

   private void addTextView(TextView var1, String var2) {
      if(var1 == null) {
         MoPubLog.d("Attempted to add text (" + var2 + ") to null TextView.");
      } else {
         var1.setText((CharSequence)null);
         if(var2 == null) {
            MoPubLog.d("Attempted to set TextView contents to null.");
         } else {
            var1.setText(var2);
         }
      }
   }

   static NativeViewHolder fromViewBinder(View var0, ViewBinder var1) {
      NativeViewHolder var2 = new NativeViewHolder();

      try {
         var2.titleView = (TextView)var0.findViewById(var1.titleId);
         var2.textView = (TextView)var0.findViewById(var1.textId);
         var2.callToActionView = (TextView)var0.findViewById(var1.callToActionId);
         var2.mainImageView = (ImageView)var0.findViewById(var1.mainImageId);
         var2.iconImageView = (ImageView)var0.findViewById(var1.iconImageId);
         return var2;
      } catch (ClassCastException var3) {
         MoPubLog.w("Could not cast from id in ViewBinder to expected View type", var3);
         return EMPTY_VIEW_HOLDER;
      }
   }

   void update(NativeResponse var1) {
      this.addTextView(this.titleView, var1.getTitle());
      this.addTextView(this.textView, var1.getText());
      this.addTextView(this.callToActionView, var1.getCallToAction());
      var1.loadMainImage(this.mainImageView);
      var1.loadIconImage(this.iconImageView);
   }

   void updateExtras(View var1, NativeResponse var2, ViewBinder var3) {
      Iterator var4 = var3.extras.keySet().iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         View var6 = var1.findViewById(((Integer)var3.extras.get(var5)).intValue());
         Object var7 = var2.getExtra(var5);
         if(var6 instanceof ImageView) {
            ((ImageView)var6).setImageDrawable((Drawable)null);
            var2.loadExtrasImage(var5, (ImageView)var6);
         } else if(var6 instanceof TextView) {
            ((TextView)var6).setText((CharSequence)null);
            if(var7 instanceof String) {
               this.addTextView((TextView)var6, (String)var7);
            }
         } else {
            MoPubLog.d("View bound to " + var5 + " should be an instance of TextView or ImageView.");
         }
      }

   }
}
