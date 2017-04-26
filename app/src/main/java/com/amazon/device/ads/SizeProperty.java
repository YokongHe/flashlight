package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import org.json.JSONObject;

class SizeProperty {
   private int height;
   private int width;

   public int getHeight() {
      return this.height;
   }

   public int getWidth() {
      return this.width;
   }

   public void setHeight(int var1) {
      this.height = var1;
   }

   public void setWidth(int var1) {
      this.width = var1;
   }

   public JSONObject toJSONObject() {
      JSONObject var1 = new JSONObject();
      JSONUtils.put(var1, "width", this.width);
      JSONUtils.put(var1, "height", this.height);
      return var1;
   }
}
