package com.mopub.network;

import com.mopub.common.util.DateAndTime;
import com.mopub.network.AdResponse$Builder;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class AdResponse implements Serializable {
   private static final long serialVersionUID = 1L;
   private final Integer mAdTimeoutDelayMillis;
   private final String mAdType;
   private final String mClickTrackingUrl;
   private final String mCustomEventClassName;
   private final String mDspCreativeId;
   private final String mFailoverUrl;
   private final String mFullAdType;
   private final Integer mHeight;
   private final String mImpressionTrackingUrl;
   private final JSONObject mJsonBody;
   private final String mNetworkType;
   private final String mRedirectUrl;
   private final Integer mRefreshTimeMillis;
   private final String mResponseBody;
   private final boolean mScrollable;
   private final Map mServerExtras;
   private final long mTimestamp;
   private final Integer mWidth;

   private AdResponse(AdResponse$Builder var1) {
      this.mAdType = AdResponse$Builder.access$0(var1);
      this.mFullAdType = AdResponse$Builder.access$1(var1);
      this.mNetworkType = AdResponse$Builder.access$2(var1);
      this.mRedirectUrl = AdResponse$Builder.access$3(var1);
      this.mClickTrackingUrl = AdResponse$Builder.access$4(var1);
      this.mImpressionTrackingUrl = AdResponse$Builder.access$5(var1);
      this.mFailoverUrl = AdResponse$Builder.access$6(var1);
      this.mWidth = AdResponse$Builder.access$7(var1);
      this.mHeight = AdResponse$Builder.access$8(var1);
      this.mAdTimeoutDelayMillis = AdResponse$Builder.access$9(var1);
      this.mRefreshTimeMillis = AdResponse$Builder.access$10(var1);
      this.mDspCreativeId = AdResponse$Builder.access$11(var1);
      this.mScrollable = AdResponse$Builder.access$12(var1);
      this.mResponseBody = AdResponse$Builder.access$13(var1);
      this.mJsonBody = AdResponse$Builder.access$14(var1);
      this.mCustomEventClassName = AdResponse$Builder.access$15(var1);
      this.mServerExtras = AdResponse$Builder.access$16(var1);
      this.mTimestamp = DateAndTime.now().getTime();
   }

   // $FF: synthetic method
   AdResponse(AdResponse$Builder var1, AdResponse var2) {
      this(var1);
   }

   public Integer getAdTimeoutMillis() {
      return this.mAdTimeoutDelayMillis;
   }

   public String getAdType() {
      return this.mAdType;
   }

   public String getClickTrackingUrl() {
      return this.mClickTrackingUrl;
   }

   public String getCustomEventClassName() {
      return this.mCustomEventClassName;
   }

   public String getDspCreativeId() {
      return this.mDspCreativeId;
   }

   public String getFailoverUrl() {
      return this.mFailoverUrl;
   }

   public String getFullAdType() {
      return this.mFullAdType;
   }

   public Integer getHeight() {
      return this.mHeight;
   }

   public String getImpressionTrackingUrl() {
      return this.mImpressionTrackingUrl;
   }

   public JSONObject getJsonBody() {
      return this.mJsonBody;
   }

   public String getNetworkType() {
      return this.mNetworkType;
   }

   public String getRedirectUrl() {
      return this.mRedirectUrl;
   }

   public Integer getRefreshTimeMillis() {
      return this.mRefreshTimeMillis;
   }

   public Map getServerExtras() {
      return new TreeMap(this.mServerExtras);
   }

   public String getStringBody() {
      return this.mResponseBody;
   }

   public long getTimestamp() {
      return this.mTimestamp;
   }

   public Integer getWidth() {
      return this.mWidth;
   }

   public boolean hasJson() {
      return this.mJsonBody != null;
   }

   public boolean isScrollable() {
      return this.mScrollable;
   }

   public AdResponse$Builder toBuilder() {
      return (new AdResponse$Builder()).setAdType(this.mAdType).setNetworkType(this.mNetworkType).setRedirectUrl(this.mRedirectUrl).setClickTrackingUrl(this.mClickTrackingUrl).setImpressionTrackingUrl(this.mImpressionTrackingUrl).setFailoverUrl(this.mFailoverUrl).setDimensions(this.mWidth, this.mHeight).setAdTimeoutDelayMilliseconds(this.mAdTimeoutDelayMillis).setRefreshTimeMilliseconds(this.mRefreshTimeMillis).setDspCreativeId(this.mDspCreativeId).setScrollable(Boolean.valueOf(this.mScrollable)).setResponseBody(this.mResponseBody).setJsonBody(this.mJsonBody).setCustomEventClassName(this.mCustomEventClassName).setServerExtras(this.mServerExtras);
   }
}
