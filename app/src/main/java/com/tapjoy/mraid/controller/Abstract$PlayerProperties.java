package com.tapjoy.mraid.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tapjoy.mraid.controller.Abstract$ReflectedParcelable;

public class Abstract$PlayerProperties extends Abstract$ReflectedParcelable {
   public static final Creator CREATOR = new Creator() {
      // $FF: synthetic method
      public final Object createFromParcel(Parcel var1) {
         return new Abstract$PlayerProperties(var1);
      }
   };
   public boolean audioMuted;
   public boolean autoPlay;
   public boolean doLoop;
   public boolean inline;
   public boolean showControl;
   public String startStyle;
   public String stopStyle;

   public Abstract$PlayerProperties() {
      this.showControl = true;
      this.autoPlay = true;
      this.audioMuted = false;
      this.doLoop = false;
      this.stopStyle = "normal";
      this.startStyle = "normal";
      this.inline = false;
   }

   public Abstract$PlayerProperties(Parcel var1) {
      super(var1);
   }

   public boolean doLoop() {
      return this.doLoop;
   }

   public boolean doMute() {
      return this.audioMuted;
   }

   public boolean exitOnComplete() {
      return this.stopStyle.equalsIgnoreCase("exit");
   }

   public boolean isAutoPlay() {
      return this.autoPlay;
   }

   public boolean isFullScreen() {
      return this.startStyle.equalsIgnoreCase("fullscreen");
   }

   public void muteAudio() {
      this.audioMuted = true;
   }

   public void setProperties(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, String var6, String var7) {
      this.autoPlay = var2;
      this.showControl = var3;
      this.doLoop = var5;
      this.audioMuted = var1;
      this.startStyle = var6;
      this.stopStyle = var7;
      this.inline = var4;
   }

   public void setStopStyle(String var1) {
      this.stopStyle = var1;
   }

   public boolean showControl() {
      return this.showControl;
   }
}
