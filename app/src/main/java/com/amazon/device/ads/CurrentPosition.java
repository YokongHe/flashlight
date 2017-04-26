package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import org.json.JSONObject;

class CurrentPosition {
   private int height;
   private int width;
   private int x;
   private int y;

   public int getHeight() {
      return this.height;
   }

   public int getWidth() {
      return this.width;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public void setHeight(int var1) {
      this.height = var1;
   }

   public void setWidth(int var1) {
      this.width = var1;
   }

   public void setX(int var1) {
      this.x = var1;
   }

   public void setY(int var1) {
      this.y = var1;
   }

   public JSONObject toJSONObject() {
      JSONObject var1 = new JSONObject();
      JSONUtils.put(var1, "width", this.width);
      JSONUtils.put(var1, "height", this.height);
      JSONUtils.put(var1, "x", this.x);
      JSONUtils.put(var1, "y", this.y);
      return var1;
   }
}
