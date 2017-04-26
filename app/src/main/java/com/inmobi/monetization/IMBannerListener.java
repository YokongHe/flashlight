package com.inmobi.monetization;

import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMErrorCode;
import java.util.Map;

public interface IMBannerListener {
   void onBannerInteraction(IMBanner var1, Map var2);

   void onBannerRequestFailed(IMBanner var1, IMErrorCode var2);

   void onBannerRequestSucceeded(IMBanner var1);

   void onDismissBannerScreen(IMBanner var1);

   void onLeaveApplication(IMBanner var1);

   void onShowBannerScreen(IMBanner var1);
}
