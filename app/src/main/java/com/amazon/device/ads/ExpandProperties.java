package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import org.json.JSONObject;

class ExpandProperties {
   private int height;
   private Boolean isModal;
   private Boolean useCustomClose;
   private int width;

   ExpandProperties() {
      this.useCustomClose = Boolean.FALSE;
      this.isModal = Boolean.TRUE;
   }

   public int getHeight() {
      return this.height;
   }

   public Boolean getIsModal() {
      return this.isModal;
   }

   public Boolean getUseCustomClose() {
      return this.useCustomClose;
   }

   public int getWidth() {
      return this.width;
   }

   public void setHeight(int var1) {
      this.height = var1;
   }

   public void setIsModal(Boolean var1) {
      this.isModal = var1;
   }

   public void setUseCustomClose(Boolean var1) {
      this.useCustomClose = var1;
   }

   public void setWidth(int var1) {
      this.width = var1;
   }

   public JSONObject toJSONObject() {
      JSONObject var1 = new JSONObject();
      JSONUtils.put(var1, "width", this.width);
      JSONUtils.put(var1, "height", this.height);
      JSONUtils.put(var1, "useCustomClose", this.useCustomClose.booleanValue());
      JSONUtils.put(var1, "isModal", this.isModal.booleanValue());
      return var1;
   }
}
