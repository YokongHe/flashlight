package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import org.json.JSONObject;

class ResizeProperties {
   private final Boolean allowOffscreenDefault;
   private final String customClosePositionDefault = "top-right";
   private final JSONObject json = new JSONObject();

   public ResizeProperties() {
      this.allowOffscreenDefault = Boolean.TRUE;
      JSONObject var1 = this.json;
      this.getClass();
      JSONUtils.put(var1, "customClosePosition", "top-right");
      JSONUtils.put(this.json, "allowOffscreen", this.allowOffscreenDefault.booleanValue());
   }

   public Boolean getAllowOffscreen() {
      return Boolean.valueOf(JSONUtils.getBooleanFromJSON(this.json, "allowOffscreen", this.allowOffscreenDefault.booleanValue()));
   }

   public String getCustomClosePosition() {
      JSONObject var1 = this.json;
      this.getClass();
      return JSONUtils.getStringFromJSON(var1, "customClosePosition", "top-right");
   }

   public int getHeight() {
      return JSONUtils.getIntegerFromJSON(this.json, "height", 0);
   }

   public int getOffsetX() {
      return JSONUtils.getIntegerFromJSON(this.json, "offsetX", 0);
   }

   public int getOffsetY() {
      return JSONUtils.getIntegerFromJSON(this.json, "offsetY", 0);
   }

   public int getWidth() {
      return JSONUtils.getIntegerFromJSON(this.json, "width", 0);
   }

   public void setAllowOffscreen(Boolean var1) {
      if(var1 != null) {
         JSONUtils.put(this.json, "allowOffscreen", var1.booleanValue());
      }

   }

   public void setCustomClosePosition(String var1) {
      if(var1 != null) {
         JSONUtils.put(this.json, "customClosePosition", var1);
      }

   }

   public void setHeight(int var1) {
      JSONUtils.put(this.json, "height", var1);
   }

   public void setOffsetX(int var1) {
      JSONUtils.put(this.json, "offsetX", var1);
   }

   public void setOffsetY(int var1) {
      JSONUtils.put(this.json, "offsetY", var1);
   }

   public void setWidth(int var1) {
      JSONUtils.put(this.json, "width", var1);
   }

   public JSONObject toJSONObject() {
      return this.json;
   }
}
