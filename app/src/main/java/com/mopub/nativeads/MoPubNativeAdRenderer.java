package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubAdRenderer;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.NativeViewHolder;
import com.mopub.nativeads.ViewBinder;
import java.util.WeakHashMap;

public class MoPubNativeAdRenderer implements MoPubAdRenderer {
   private final ViewBinder mViewBinder;
   @VisibleForTesting
   final WeakHashMap mViewHolderMap;

   public MoPubNativeAdRenderer(ViewBinder var1) {
      this.mViewBinder = var1;
      this.mViewHolderMap = new WeakHashMap();
   }

   public View createAdView(Context var1, ViewGroup var2) {
      return LayoutInflater.from(var1).inflate(this.mViewBinder.layoutId, var2, false);
   }

   public void renderAdView(View var1, NativeResponse var2) {
      NativeViewHolder var4 = (NativeViewHolder)this.mViewHolderMap.get(var1);
      NativeViewHolder var3 = var4;
      if(var4 == null) {
         var3 = NativeViewHolder.fromViewBinder(var1, this.mViewBinder);
         this.mViewHolderMap.put(var1, var3);
      }

      var3.update(var2);
      var3.updateExtras(var1, var2, this.mViewBinder);
      var1.setVisibility(0);
   }
}
