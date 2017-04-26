package com.mopub.common.event;

public enum BaseEvent$AppPlatform {
   ANDROID(1),
   IOS(0),
   MOBILE_WEB(2);

   public final int mType;

   private BaseEvent$AppPlatform(int var3) {
      this.mType = var3;
   }
}
