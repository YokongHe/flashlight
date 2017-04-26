package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public interface MoPubAdRenderer {
   View createAdView(Context var1, ViewGroup var2);

   void renderAdView(View var1, Object var2);
}
