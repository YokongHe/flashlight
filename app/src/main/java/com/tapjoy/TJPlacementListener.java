package com.tapjoy;

import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;

public interface TJPlacementListener {
   void onContentDismiss(TJPlacement var1);

   void onContentReady(TJPlacement var1);

   void onContentShow(TJPlacement var1);

   void onPurchaseRequest(TJPlacement var1, TJActionRequest var2, String var3);

   void onRequestFailure(TJPlacement var1, TJError var2);

   void onRequestSuccess(TJPlacement var1);

   void onRewardRequest(TJPlacement var1, TJActionRequest var2, String var3, int var4);
}
