package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.inmobi.re.controller.JSController$ReflectedParcelable;

public class JSController$PlayerProperties extends JSController$ReflectedParcelable {
   public static final Creator CREATOR = new Creator() {
      public final JSController$PlayerProperties a(Parcel var1) {
         return new JSController$PlayerProperties(var1);
      }

      public final JSController$PlayerProperties[] a(int var1) {
         return new JSController$PlayerProperties[var1];
      }

      // $FF: synthetic method
      public final Object createFromParcel(Parcel var1) {
         return this.a(var1);
      }

      // $FF: synthetic method
      public final Object[] newArray(int var1) {
         return this.a(var1);
      }
   };
   public boolean audioMuted;
   public boolean autoPlay;
   public boolean doLoop;
   public String id;
   public boolean showControl;
   public String startStyle;
   public String stopStyle;

   public JSController$PlayerProperties() {
      this.showControl = true;
      this.autoPlay = true;
      this.audioMuted = false;
      this.doLoop = false;
      this.stopStyle = "normal";
      this.startStyle = "normal";
      this.id = "";
   }

   public JSController$PlayerProperties(Parcel var1) {
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

   public void setFullScreen() {
      this.startStyle = "fullscreen";
   }

   public void setProperties(boolean var1, boolean var2, boolean var3, boolean var4, String var5, String var6, String var7) {
      this.autoPlay = var2;
      this.showControl = var3;
      this.doLoop = var4;
      this.audioMuted = var1;
      this.startStyle = var5;
      this.stopStyle = var6;
      this.id = var7;
   }

   public void setStopStyle(String var1) {
      this.stopStyle = var1;
   }

   public boolean showControl() {
      return this.showControl;
   }
}
