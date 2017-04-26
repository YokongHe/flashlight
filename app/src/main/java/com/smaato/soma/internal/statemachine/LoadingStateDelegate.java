package com.smaato.soma.internal.statemachine;

public interface LoadingStateDelegate {
   void stateBannerLoadingEntered();

   void stateBannerLoadingExit();

   void stateBlockedEntered();

   void stateBlockedExit();

   void stateIdleEntered();

   void stateIdleExit();

   void stateXmlLoadingEntered();

   void stateXmlLoadingExit();

   void transitionBlockLoadingTriggered();

   void transitionErrorLoadingTriggered();

   void transitionFinishLoadingTriggered();

   void transitionLoadBannerTriggered();

   void transitionLoadXmlTriggered();

   void transitionUnblockLoadingTriggered();
}
