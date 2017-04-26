package com.mopub.nativeads;

public enum RequestParameters$NativeAdAsset {
   CALL_TO_ACTION_TEXT("ctatext"),
   ICON_IMAGE("iconimage"),
   MAIN_IMAGE("mainimage"),
   STAR_RATING("starrating"),
   TEXT("text"),
   TITLE("title");

   private final String mAssetName;

   private RequestParameters$NativeAdAsset(String var3) {
      this.mAssetName = var3;
   }

   public final String toString() {
      return this.mAssetName;
   }
}
