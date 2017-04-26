package com.adsdk.sdk.customevents;

public class CustomEvent {
   private String className;
   private String optionalParameter;
   private String pixelUrl;

   public CustomEvent(String var1, String var2, String var3) {
      this.className = var1;
      this.optionalParameter = var2;
      this.pixelUrl = var3;
   }

   public String getClassName() {
      return this.className;
   }

   public String getOptionalParameter() {
      return this.optionalParameter;
   }

   public String getPixelUrl() {
      return this.pixelUrl;
   }

   public void setClassName(String var1) {
      this.className = var1;
   }

   public void setOptionalParameter(String var1) {
      this.optionalParameter = var1;
   }

   public void setPixelUrl(String var1) {
      this.pixelUrl = var1;
   }
}
