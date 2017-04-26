package com.adsdk.sdk.nativeads;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.adsdk.sdk.Gender;
import java.util.List;
import java.util.Random;

public class NativeAdRequest {
   private static final String IMAGE_TYPES = "icon,main";
   private static final String REQUEST_TYPE = "native";
   private static final String REQUEST_TYPE_ANDROID = "android_app";
   private static final String RESPONSE_TYPE = "json";
   private static final String TEXT_TYPES = "headline,description,cta,advertiser,rating";
   private boolean adDoNotTrack = false;
   private List adTypes;
   private String androidAdId = "";
   private Gender gender;
   private List keywords;
   private double latitude = 0.0D;
   private double longitude = 0.0D;
   private String protocolVersion;
   private String publisherId;
   private String request_url;
   private int userAge;
   private String userAgent;
   private String userAgent2;

   public List getAdTypes() {
      return this.adTypes;
   }

   public String getAndroidAdId() {
      return this.androidAdId;
   }

   public Gender getGender() {
      return this.gender;
   }

   public List getKeywords() {
      return this.keywords;
   }

   public double getLatitude() {
      return this.latitude;
   }

   public double getLongitude() {
      return this.longitude;
   }

   public String getProtocolVersion() {
      return this.protocolVersion == null?"6.0.7":this.protocolVersion;
   }

   public String getPublisherId() {
      return this.publisherId;
   }

   public int getUserAge() {
      return this.userAge;
   }

   public String getUserAgent() {
      return this.userAgent == null?"":this.userAgent;
   }

   public String getUserAgent2() {
      return this.userAgent2 == null?"":this.userAgent2;
   }

   public Boolean hasAdDoNotTrack() {
      return Boolean.valueOf(this.adDoNotTrack);
   }

   public void setAdDoNotTrack(boolean var1) {
      this.adDoNotTrack = var1;
   }

   public void setAdTypes(List var1) {
      this.adTypes = var1;
   }

   public void setAndroidAdId(String var1) {
      this.androidAdId = var1;
   }

   public void setGender(Gender var1) {
      this.gender = var1;
   }

   public void setKeywords(List var1) {
      this.keywords = var1;
   }

   public void setLatitude(double var1) {
      this.latitude = var1;
   }

   public void setLongitude(double var1) {
      this.longitude = var1;
   }

   public void setProtocolVersion(String var1) {
      this.protocolVersion = var1;
   }

   public void setPublisherId(String var1) {
      this.publisherId = var1;
   }

   public void setRequestUrl(String var1) {
      this.request_url = var1;
   }

   public void setUserAge(int var1) {
      this.userAge = var1;
   }

   public void setUserAgent(String var1) {
      this.userAgent = var1;
   }

   public void setUserAgent2(String var1) {
      this.userAgent2 = var1;
   }

   public String toString() {
      return this.toUri().toString();
   }

   public Uri toUri() {
      Builder var3 = Uri.parse(this.request_url).buildUpon();
      int var1 = (new Random()).nextInt('썐');
      var3.appendQueryParameter("rt", "android_app");
      var3.appendQueryParameter("r_type", "native");
      var3.appendQueryParameter("r_resp", "json");
      var3.appendQueryParameter("n_img", "icon,main");
      var3.appendQueryParameter("n_txt", "headline,description,cta,advertiser,rating");
      if(this.adTypes != null && !this.adTypes.isEmpty()) {
         var3.appendQueryParameter("n_type", TextUtils.join(", ", this.adTypes));
      }

      var3.appendQueryParameter("s", this.getPublisherId());
      var3.appendQueryParameter("u", this.getUserAgent());
      var3.appendQueryParameter("u2", this.getUserAgent2());
      var3.appendQueryParameter("r_random", Integer.toString(var1));
      var3.appendQueryParameter("o_andadvid", this.androidAdId);
      String var2;
      if(this.adDoNotTrack) {
         var2 = "1";
      } else {
         var2 = "0";
      }

      var3.appendQueryParameter("o_andadvdnt", var2);
      var3.appendQueryParameter("v", this.getProtocolVersion());
      if(this.userAge != 0) {
         var3.appendQueryParameter("demo.age", Integer.toString(this.userAge));
      }

      if(this.gender != null) {
         var3.appendQueryParameter("demo.gender", this.gender.getServerParam());
      }

      if(this.keywords != null && !this.keywords.isEmpty()) {
         var3.appendQueryParameter("demo.keywords", TextUtils.join(", ", this.keywords));
      }

      var3.appendQueryParameter("u_wv", this.getUserAgent());
      var3.appendQueryParameter("u_br", this.getUserAgent());
      if(this.longitude != 0.0D && this.latitude != 0.0D) {
         var3.appendQueryParameter("longitude", Double.toString(this.longitude));
         var3.appendQueryParameter("latitude", Double.toString(this.latitude));
      }

      return var3.build();
   }
}
