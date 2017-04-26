package com.mopub.common.event;

public enum BaseEvent$SdkProduct {
   NATIVE(2),
   NONE(0),
   WEB_VIEW(1);

   public final int mType;

   private BaseEvent$SdkProduct(int var3) {
      this.mType = var3;
   }
}
