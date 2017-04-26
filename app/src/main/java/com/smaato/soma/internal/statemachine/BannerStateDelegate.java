package com.smaato.soma.internal.statemachine;

public interface BannerStateDelegate {
   void stateBannerDisplayedEntered();

   void stateBannerDisplayedExit();

   void stateBannerExpandedEntered();

   void stateBannerExpandedExit();

   void stateEmptyEntered();

   void stateEmptyExit();

   void transitionCloseNoOrmmaTriggered();

   void transitionCloseOrmmaTriggered();

   void transitionDisplayBannerTriggered();

   void transitionExpandBannerTriggered();
}
