package com.flurry.android;

import android.content.Context;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;

public interface ICustomAdNetworkHandler {
   AdNetworkView getAdFromNetwork(Context var1, AdCreative var2, String var3);
}
