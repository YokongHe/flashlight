package com.inmobi.monetization;

import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMInterstitial;
import java.util.Map;

public interface IMInterstitialListener {
   void onDismissInterstitialScreen(IMInterstitial var1);

   void onInterstitialFailed(IMInterstitial var1, IMErrorCode var2);

   void onInterstitialInteraction(IMInterstitial var1, Map var2);

   void onInterstitialLoaded(IMInterstitial var1);

   void onLeaveApplication(IMInterstitial var1);

   void onShowInterstitialScreen(IMInterstitial var1);
}
