package com.inmobi.monetization;

import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;

public interface IMNativeListener {
   void onNativeRequestFailed(IMErrorCode var1);

   void onNativeRequestSucceeded(IMNative var1);
}
