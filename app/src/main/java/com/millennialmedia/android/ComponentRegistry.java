package com.millennialmedia.android;

import com.millennialmedia.android.BridgeMMBanner;
import com.millennialmedia.android.BridgeMMCachedVideo;
import com.millennialmedia.android.BridgeMMCalendar;
import com.millennialmedia.android.BridgeMMDevice;
import com.millennialmedia.android.BridgeMMInlineVideo;
import com.millennialmedia.android.BridgeMMInterstitial;
import com.millennialmedia.android.BridgeMMMedia;
import com.millennialmedia.android.BridgeMMNotification;
import com.millennialmedia.android.BridgeMMSpeechkit;
import com.millennialmedia.android.ExampleComponent;
import com.millennialmedia.android.MMLog$LoggingComponent;
import java.util.Stack;

class ComponentRegistry {
   static Stack bannerBridges = new Stack();
   static Stack cachedVideoBridges = new Stack();
   static Stack calendarBridges = new Stack();
   static Stack deviceBridges = new Stack();
   static Stack examples = new Stack();
   static Stack inlineVideoBridges = new Stack();
   static Stack interstitialBridges = new Stack();
   static Stack loggingComponents = new Stack();
   static Stack mediaBridges = new Stack();
   static Stack notificationBridges = new Stack();
   static Stack speechkitBridges = new Stack();

   static void addBannerBridge(BridgeMMBanner var0) {
      bannerBridges.push(var0);
   }

   static void addCachedVideoBridge(BridgeMMCachedVideo var0) {
      cachedVideoBridges.push(var0);
   }

   static void addCalendarBridge(BridgeMMCalendar var0) {
      calendarBridges.push(var0);
   }

   static void addDeviceBridge(BridgeMMDevice var0) {
      deviceBridges.push(var0);
   }

   static void addExample(ExampleComponent var0) {
      examples.push(var0);
   }

   static void addInlineVideoBridge(BridgeMMInlineVideo var0) {
      inlineVideoBridges.push(var0);
   }

   static void addInterstitialBridge(BridgeMMInterstitial var0) {
      interstitialBridges.push(var0);
   }

   static void addLoggingComponent(MMLog$LoggingComponent var0) {
      loggingComponents.push(var0);
   }

   static void addMediaBridge(BridgeMMMedia var0) {
      mediaBridges.push(var0);
   }

   static void addNotificationBridge(BridgeMMNotification var0) {
      notificationBridges.push(var0);
   }

   static void addSpeechkitBridge(BridgeMMSpeechkit var0) {
      speechkitBridges.push(var0);
   }

   static BridgeMMBanner getBannerBridge() {
      return (BridgeMMBanner)getComponent(bannerBridges);
   }

   static BridgeMMCachedVideo getCachedVideoBridge() {
      return (BridgeMMCachedVideo)getComponent(cachedVideoBridges);
   }

   static BridgeMMCalendar getCalendarBridge() {
      return (BridgeMMCalendar)getComponent(calendarBridges);
   }

   private static Object getComponent(Stack var0) {
      return var0.isEmpty()?null:var0.lastElement();
   }

   static BridgeMMDevice getDeviceBridge() {
      return (BridgeMMDevice)getComponent(deviceBridges);
   }

   static ExampleComponent getExample() {
      return (ExampleComponent)getComponent(examples);
   }

   static BridgeMMInlineVideo getInlineVideoBridge() {
      return (BridgeMMInlineVideo)getComponent(inlineVideoBridges);
   }

   static BridgeMMInterstitial getInterstitialBridge() {
      return (BridgeMMInterstitial)getComponent(interstitialBridges);
   }

   static MMLog$LoggingComponent getLoggingComponent() {
      return (MMLog$LoggingComponent)getComponent(loggingComponents);
   }

   static BridgeMMMedia getMediaBridge() {
      return (BridgeMMMedia)getComponent(mediaBridges);
   }

   static BridgeMMNotification getNotificationBridge() {
      return (BridgeMMNotification)getComponent(notificationBridges);
   }

   static BridgeMMSpeechkit getSpeechkitBridge() {
      return (BridgeMMSpeechkit)getComponent(speechkitBridges);
   }

   static void removeBannerBridge(boolean var0) {
      removeComponent(var0, bannerBridges);
   }

   static void removeCachedVideoBridge(boolean var0) {
      removeComponent(var0, cachedVideoBridges);
   }

   static void removeCalendarBridge(boolean var0) {
      removeComponent(var0, calendarBridges);
   }

   private static void removeComponent(boolean var0, Stack var1) {
      if(!var1.isEmpty() && (var1.size() != 1 || var0)) {
         var1.pop();
      }
   }

   static void removeDeviceBridge(boolean var0) {
      removeComponent(var0, deviceBridges);
   }

   static void removeExample(boolean var0) {
      removeComponent(var0, examples);
   }

   static void removeInlineVideoBridge(boolean var0) {
      removeComponent(var0, inlineVideoBridges);
   }

   static void removeInterstitialBridge(boolean var0) {
      removeComponent(var0, interstitialBridges);
   }

   static void removeLoggingComponent(boolean var0) {
      removeComponent(var0, loggingComponents);
   }

   static void removeMediaBridge(boolean var0) {
      removeComponent(var0, mediaBridges);
   }

   static void removeNotificationBridge(boolean var0) {
      removeComponent(var0, notificationBridges);
   }

   static void removeSpeechkitBridge(boolean var0) {
      removeComponent(var0, speechkitBridges);
   }
}
