package com.inneractive.api.ads.sdk;

enum IAmraidWebViewController$ForceOrientationType {
   LANDSCAPE("landscape"),
   NONE("none"),
   PORTRAIT("portrait");

   final String key;

   private IAmraidWebViewController$ForceOrientationType(String var3) {
      this.key = var3;
   }

   final String getKey() {
      return this.key;
   }
}
