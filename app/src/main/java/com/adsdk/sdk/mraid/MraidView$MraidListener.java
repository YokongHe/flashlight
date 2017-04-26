package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$ViewState;

public interface MraidView$MraidListener {
   void onClose(MraidView var1, MraidView$ViewState var2);

   void onExpand(MraidView var1);

   void onFailure(MraidView var1);

   void onReady(MraidView var1);
}
