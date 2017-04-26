package com.mopub.nativeads;

import android.content.Context;
import com.mopub.nativeads.CustomEventNative$CustomEventNativeListener;
import java.util.Map;

public abstract class CustomEventNative {
   protected abstract void loadNativeAd(Context var1, CustomEventNative$CustomEventNativeListener var2, Map var3, Map var4);
}
