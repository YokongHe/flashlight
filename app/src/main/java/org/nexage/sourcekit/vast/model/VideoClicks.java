package org.nexage.sourcekit.vast.model;

import java.util.ArrayList;
import java.util.List;

public class VideoClicks {
   private String clickThrough;
   private List clickTracking;
   private List customClick;

   private String listToString(List var1) {
      StringBuffer var3 = new StringBuffer();
      if(var1 == null) {
         return "";
      } else {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            var3.append(((String)var1.get(var2)).toString());
         }

         return var3.toString();
      }
   }

   public String getClickThrough() {
      return this.clickThrough;
   }

   public List getClickTracking() {
      if(this.clickTracking == null) {
         this.clickTracking = new ArrayList();
      }

      return this.clickTracking;
   }

   public List getCustomClick() {
      if(this.customClick == null) {
         this.customClick = new ArrayList();
      }

      return this.customClick;
   }

   public void setClickThrough(String var1) {
      this.clickThrough = var1;
   }

   public String toString() {
      return "VideoClicks [clickThrough=" + this.clickThrough + ", clickTracking=[" + this.listToString(this.clickTracking) + "], customClick=[" + this.listToString(this.customClick) + "] ]";
   }
}
