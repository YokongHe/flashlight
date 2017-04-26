package com.adsdk.sdk;

public enum Gender {
   FEMALE("f"),
   MALE("m");

   private String param;

   private Gender(String var3) {
      this.param = var3;
   }

   public final String getServerParam() {
      return this.param;
   }
}
