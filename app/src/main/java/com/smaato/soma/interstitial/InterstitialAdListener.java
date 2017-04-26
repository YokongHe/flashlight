package com.smaato.soma.interstitial;

public interface InterstitialAdListener {
   void onFailedToLoadAd();

   void onReadyToShow();

   void onWillClose();

   void onWillOpenLandingPage();

   void onWillShow();
}
