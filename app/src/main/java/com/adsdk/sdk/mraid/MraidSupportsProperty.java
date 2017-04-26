package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidProperty;

class MraidSupportsProperty extends MraidProperty {
   private boolean calendar;
   private boolean inlineVideo;
   private boolean sms;
   private boolean storePicture;
   private boolean tel;

   public String toJsonPair() {
      return "supports: {sms: " + String.valueOf(this.sms) + ", tel: " + this.tel + ", calendar: " + this.calendar + ", storePicture: " + this.storePicture + ", inlineVideo: " + this.inlineVideo + "}";
   }

   public MraidSupportsProperty withCalendar(boolean var1) {
      this.calendar = var1;
      return this;
   }

   public MraidSupportsProperty withInlineVideo(boolean var1) {
      this.inlineVideo = var1;
      return this;
   }

   public MraidSupportsProperty withSms(boolean var1) {
      this.sms = var1;
      return this;
   }

   public MraidSupportsProperty withStorePicture(boolean var1) {
      this.storePicture = var1;
      return this;
   }

   public MraidSupportsProperty withTel(boolean var1) {
      this.tel = var1;
      return this;
   }
}
