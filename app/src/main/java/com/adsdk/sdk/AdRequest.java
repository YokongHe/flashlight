package com.adsdk.sdk;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.adsdk.sdk.Gender;
import java.util.List;
import java.util.Random;

public class AdRequest {
   private static final String REQUEST_TYPE_ANDROID = "android_app";
   private boolean adDoNotTrack = false;
   private int adspaceHeight;
   private boolean adspaceStrict;
   private int adspaceWidth;
   private String androidAdId = "";
   private String connectionType;
   private Gender gender;
   private String headers;
   private String ipAddress;
   private boolean isVideoRequest;
   private List keywords;
   private double latitude = 0.0D;
   private String listAds;
   private double longitude = 0.0D;
   private String protocolVersion;
   private String publisherId;
   private String requestURL;
   private long timestamp;
   private int userAge;
   private String userAgent;
   private String userAgent2;
   private int videoMaxDuration;
   private int videoMinDuration;

   public int getAdspaceHeight() {
      return this.adspaceHeight;
   }

   public int getAdspaceWidth() {
      return this.adspaceWidth;
   }

   public String getAndroidAdId() {
      return this.androidAdId;
   }

   public String getAndroidVersion() {
      return VERSION.RELEASE;
   }

   public String getConnectionType() {
      return this.connectionType;
   }

   public String getDeviceMode() {
      return Build.MODEL;
   }

   public String getHeaders() {
      return this.headers == null?"":this.headers;
   }

   public String getIpAddress() {
      return this.ipAddress == null?"":this.ipAddress;
   }

   public double getLatitude() {
      return this.latitude;
   }

   public String getListAds() {
      return this.listAds != null?this.listAds:"";
   }

   public double getLongitude() {
      return this.longitude;
   }

   public String getProtocolVersion() {
      return this.protocolVersion == null?"6.0.7":this.protocolVersion;
   }

   public String getPublisherId() {
      return this.publisherId == null?"":this.publisherId;
   }

   public String getRequestType() {
      return "android_app";
   }

   public String getRequestURL() {
      return this.requestURL;
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public String getUserAgent() {
      return this.userAgent == null?"":this.userAgent;
   }

   public String getUserAgent2() {
      return this.userAgent2 == null?"":this.userAgent2;
   }

   public int getVideoMaxDuration() {
      return this.videoMaxDuration;
   }

   public int getVideoMinDuration() {
      return this.videoMinDuration;
   }

   public Boolean hasAdDoNotTrack() {
      return Boolean.valueOf(this.adDoNotTrack);
   }

   public boolean isAdspaceStrict() {
      return this.adspaceStrict;
   }

   public boolean isVideoRequest() {
      return this.isVideoRequest;
   }

   public void setAdDoNotTrack(boolean var1) {
      this.adDoNotTrack = var1;
   }

   public void setAdspaceHeight(int var1) {
      this.adspaceHeight = var1;
   }

   public void setAdspaceStrict(boolean var1) {
      this.adspaceStrict = var1;
   }

   public void setAdspaceWidth(int var1) {
      this.adspaceWidth = var1;
   }

   public void setAndroidAdId(String var1) {
      this.androidAdId = var1;
   }

   public void setConnectionType(String var1) {
      this.connectionType = var1;
   }

   public void setGender(Gender var1) {
      this.gender = var1;
   }

   public void setHeaders(String var1) {
      this.headers = var1;
   }

   public void setIpAddress(String var1) {
      this.ipAddress = var1;
   }

   public void setKeywords(List var1) {
      this.keywords = var1;
   }

   public void setLatitude(double var1) {
      this.latitude = var1;
   }

   public void setListAds(String var1) {
      this.listAds = var1;
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

   public void setRequestURL(String var1) {
      this.requestURL = var1;
   }

   public void setTimestamp(long var1) {
      this.timestamp = var1;
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

   public void setVideoMaxDuration(int var1) {
      this.videoMaxDuration = var1;
   }

   public void setVideoMinDuration(int var1) {
      this.videoMinDuration = var1;
   }

   public void setVideoRequest(boolean var1) {
      this.isVideoRequest = var1;
   }

   public String toString() {
      return this.toUri().toString();
   }

   public Uri toUri() {
      Builder var3 = Uri.parse(this.getRequestURL()).buildUpon();
      int var1 = (new Random()).nextInt('썐');
      var3.appendQueryParameter("rt", this.getRequestType());
      var3.appendQueryParameter("v", this.getProtocolVersion());
      var3.appendQueryParameter("i", this.getIpAddress());
      var3.appendQueryParameter("u", this.getUserAgent());
      var3.appendQueryParameter("u2", this.getUserAgent2());
      var3.appendQueryParameter("s", this.getPublisherId());
      var3.appendQueryParameter("o_andadvid", this.androidAdId);
      String var2;
      if(this.adDoNotTrack) {
         var2 = "1";
      } else {
         var2 = "0";
      }

      var3.appendQueryParameter("o_andadvdnt", var2);
      var3.appendQueryParameter("r_random", Integer.toString(var1));
      var3.appendQueryParameter("t", Long.toString(this.getTimestamp()));
      var3.appendQueryParameter("connection_type", this.getConnectionType());
      var3.appendQueryParameter("listads", this.getListAds());
      var3.appendQueryParameter("c_customevents", "1");
      var3.appendQueryParameter("c.mraid", "1");
      if(this.isVideoRequest) {
         var3.appendQueryParameter("r_type", "video");
         var3.appendQueryParameter("r_resp", "vast20");
         if(this.videoMaxDuration != 0) {
            var3.appendQueryParameter("v_dur_max", Integer.toString(this.videoMaxDuration));
         }

         if(this.videoMinDuration != 0) {
            var3.appendQueryParameter("v_dur_min", Integer.toString(this.videoMinDuration));
         }
      } else {
         var3.appendQueryParameter("r_type", "banner");
      }

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

      if(this.adspaceHeight != 0 && this.adspaceWidth != 0) {
         if(this.adspaceStrict) {
            var3.appendQueryParameter("adspace.strict", "1");
         } else {
            var3.appendQueryParameter("adspace.strict", "0");
         }

         var3.appendQueryParameter("adspace.width", Integer.toString(this.adspaceWidth));
         var3.appendQueryParameter("adspace.height", Integer.toString(this.adspaceHeight));
      }

      return var3.build();
   }
}
