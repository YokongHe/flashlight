package com.mopub.mobileads;

import android.content.Context;
import com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener;
import java.util.Map;

public abstract class CustomEventBanner {
   protected abstract void loadBanner(Context var1, CustomEventBanner$CustomEventBannerListener var2, Map var3, Map var4);

   protected abstract void onInvalidate();
}
