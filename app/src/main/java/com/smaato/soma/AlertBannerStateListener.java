package com.smaato.soma;

public interface AlertBannerStateListener {
   void onWillCancelAlert();

   void onWillLeaveActivity();

   void onWillShowBanner();
}
