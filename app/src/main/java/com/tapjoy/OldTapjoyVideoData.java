package com.tapjoy;

import java.io.Serializable;

public class OldTapjoyVideoData implements Serializable {
   private String a;
   private String b;
   private String c;
   private String d;
   private String e;
   private String f;
   private String g;
   private String h;
   private String i;

   public void addButton(String var1, String var2) {
   }

   public String getClickURL() {
      return this.c;
   }

   public String getCurrencyAmount() {
      return this.f;
   }

   public String getCurrencyName() {
      return this.e;
   }

   public String getIconURL() {
      return this.g;
   }

   public String getLocalFilePath() {
      return this.i;
   }

   public String getOfferId() {
      return this.a;
   }

   public String getVideoAdName() {
      return this.d;
   }

   public String getVideoURL() {
      return this.b;
   }

   public String getWebviewURL() {
      return this.h;
   }

   public void setClickURL(String var1) {
      this.c = var1;
   }

   public void setCurrencyAmount(String var1) {
      this.f = var1;
   }

   public void setCurrencyName(String var1) {
      this.e = var1;
   }

   public void setIconURL(String var1) {
      this.g = var1;
   }

   public void setLocalFilePath(String var1) {
      this.i = var1;
   }

   public void setOfferID(String var1) {
      this.a = var1;
   }

   public void setVideoAdName(String var1) {
      this.d = var1;
   }

   public void setVideoURL(String var1) {
      this.b = var1;
   }

   public void setWebviewURL(String var1) {
      this.h = var1;
   }
}
