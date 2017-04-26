package org.nexage.sourcekit.vast.model;

import java.math.BigInteger;

public class VASTMediaFile {
   private String apiFramework;
   private BigInteger bitrate;
   private String delivery;
   private BigInteger height;
   private String id;
   private Boolean maintainAspectRatio;
   private Boolean scalable;
   private String type;
   private String value;
   private BigInteger width;

   public String getApiFramework() {
      return this.apiFramework;
   }

   public BigInteger getBitrate() {
      return this.bitrate;
   }

   public String getDelivery() {
      return this.delivery;
   }

   public BigInteger getHeight() {
      return this.height;
   }

   public String getId() {
      return this.id;
   }

   public String getType() {
      return this.type;
   }

   public String getValue() {
      return this.value;
   }

   public BigInteger getWidth() {
      return this.width;
   }

   public Boolean isMaintainAspectRatio() {
      return this.maintainAspectRatio;
   }

   public Boolean isScalable() {
      return this.scalable;
   }

   public void setApiFramework(String var1) {
      this.apiFramework = var1;
   }

   public void setBitrate(BigInteger var1) {
      this.bitrate = var1;
   }

   public void setDelivery(String var1) {
      this.delivery = var1;
   }

   public void setHeight(BigInteger var1) {
      this.height = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setMaintainAspectRatio(Boolean var1) {
      this.maintainAspectRatio = var1;
   }

   public void setScalable(Boolean var1) {
      this.scalable = var1;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public void setValue(String var1) {
      this.value = var1;
   }

   public void setWidth(BigInteger var1) {
      this.width = var1;
   }

   public String toString() {
      return "MediaFile [value=" + this.value + ", id=" + this.id + ", delivery=" + this.delivery + ", type=" + this.type + ", bitrate=" + this.bitrate + ", width=" + this.width + ", height=" + this.height + ", scalable=" + this.scalable + ", maintainAspectRatio=" + this.maintainAspectRatio + ", apiFramework=" + this.apiFramework + "]";
   }
}
