package com.mopub.mobileads;

import android.content.Context;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import java.util.Map;

public abstract class CustomEventInterstitial {
   protected abstract void loadInterstitial(Context var1, CustomEventInterstitial$CustomEventInterstitialListener var2, Map var3, Map var4);

   protected abstract void onInvalidate();

   protected abstract void showInterstitial();
}
