package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.millennialmedia.android.HttpMMHeaders;
import com.millennialmedia.android.MMLog;

class OverlaySettings implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public final OverlaySettings createFromParcel(Parcel var1) {
         return new OverlaySettings(var1);
      }

      public final OverlaySettings[] newArray(int var1) {
         return new OverlaySettings[var1];
      }
   };
   static final String PROPERTIES_ACID = "acid";
   static final String PROPERTIES_ALLOW_ORIENTATION_CHANGE = "allowOrientationChange";
   static final String PROPERTIES_CUSTOM_CLOSE = "useCustomClose";
   static final String PROPERTIES_ENABLE_HARDWARE_ACCEL = "enableHardwareAccel";
   static final String PROPERTIES_FORCE_ORIENTATION = "forceOrientation";
   static final String PROPERTIES_HEIGHT = "height";
   static final String PROPERTIES_MODAL = "modal";
   static final String PROPERTIES_ORIENTATION = "orientation";
   static final String PROPERTIES_TRANSITION = "transition";
   static final String PROPERTIES_TRANSITION_DURATION = "transitionDuration";
   static final String PROPERTIES_TRANSPARENT = "transparent";
   static final String PROPERTIES_WIDTH = "width";
   private static final String TAG = "OverlaySettings";
   String adUrl = "";
   boolean allowOrientationChange = true;
   String content = "";
   long creatorAdImplId;
   boolean hasLoadedExpandUrl = false;
   int height;
   boolean isFromInterstitial;
   @com.millennialmedia.a.a.a.b(
      a = "transparent"
   )
   private boolean isTransparent;
   HttpMMHeaders mmHeaders;
   boolean modal;
   String orientation = "";
   boolean shouldLaunchToOverlay;
   int shouldResizeOverlay;
   private String transition = "";
   @com.millennialmedia.a.a.a.b(
      a = "transitionDuration"
   )
   private long transitionTimeInMillis;
   String urlToLoad = "";
   private boolean useCustomClose;
   int width;

   OverlaySettings() {
   }

   OverlaySettings(Parcel param1) {
      // $FF: Couldn't be decompiled
   }

   static final OverlaySettings createFromJson(String var0) {
      return (OverlaySettings)(new com.millennialmedia.a.a.e()).a(var0, OverlaySettings.class);
   }

   public int describeContents() {
      return 0;
   }

   boolean enableHardwareAccel() {
      return this.mmHeaders != null && this.mmHeaders.enableHardwareAccel;
   }

   String getAcid() {
      return this.mmHeaders != null && !TextUtils.isEmpty(this.mmHeaders.acid)?this.mmHeaders.acid:"";
   }

   boolean getIsTransparent() {
      return this.isTransparent || this.mmHeaders != null && this.mmHeaders.isTransparent;
   }

   String getTransition() {
      return !TextUtils.isEmpty(this.transition)?this.transition:(this.mmHeaders != null && !TextUtils.isEmpty(this.mmHeaders.transition)?this.mmHeaders.transition:"none");
   }

   long getTransitionDurationInMillis() {
      long var1 = 0L;
      if(this.transitionTimeInMillis > 0L) {
         var1 = this.transitionTimeInMillis;
      } else if(this.mmHeaders != null) {
         return this.mmHeaders.transitionTimeInMillis;
      }

      return var1;
   }

   boolean getUseCustomClose() {
      return this.useCustomClose || this.mmHeaders != null && this.mmHeaders.useCustomClose;
   }

   boolean hasExpandUrl() {
      return this.urlToLoad != null && !this.urlToLoad.equals("");
   }

   boolean hasLoadedExpandUrl() {
      boolean var1 = true;
      if(!this.hasLoadedExpandUrl) {
         this.hasLoadedExpandUrl = true;
         var1 = false;
      }

      return var1;
   }

   boolean isExpanded() {
      return !this.isFromInterstitial && this.creatorAdImplId != 0L;
   }

   boolean isFromInterstitial() {
      return this.isFromInterstitial && this.creatorAdImplId != 0L;
   }

   void log() {
      MMLog.v("OverlaySettings", this.toString());
   }

   void setIsTransparent(boolean var1) {
      this.isTransparent = var1;
   }

   void setTransition(String var1) {
      this.transition = var1;
   }

   void setTransitionDurationInMillis(long var1) {
      this.transitionTimeInMillis = var1;
   }

   void setUseCustomClose(boolean var1) {
      this.useCustomClose = var1;
   }

   void setWebMMHeaders(HttpMMHeaders var1) {
      this.mmHeaders = var1;
   }

   public String toString() {
      return String.format("height %d width %d modal %b urlToLoad %s creatorAdImplId %s shouldResizeOverlay: %d transitionTime: %d overlayTransition: %s shouldMakeOverlayTransparent: %b shouldShowCustomClose: %b Orientation: %s", new Object[]{Integer.valueOf(this.height), Integer.valueOf(this.width), Boolean.valueOf(this.modal), this.urlToLoad, Long.valueOf(this.creatorAdImplId), Integer.valueOf(this.shouldResizeOverlay), Long.valueOf(this.transitionTimeInMillis), this.transition, Boolean.valueOf(this.isTransparent), Boolean.valueOf(this.useCustomClose), this.orientation});
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeBooleanArray(new boolean[]{this.shouldLaunchToOverlay, this.isTransparent, this.useCustomClose, this.modal, this.isFromInterstitial, this.allowOrientationChange});
      var1.writeInt(this.shouldResizeOverlay);
      var1.writeString(this.transition);
      var1.writeLong(this.transitionTimeInMillis);
      var1.writeString(this.orientation);
      var1.writeLong(this.creatorAdImplId);
      var1.writeString(this.urlToLoad);
      var1.writeInt(this.height);
      var1.writeInt(this.width);
      var1.writeString(this.content);
      var1.writeString(this.adUrl);
      var1.writeParcelable(this.mmHeaders, var2);
   }
}
