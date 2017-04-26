package com.smaato.soma.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.smaato.soma.AdType;
import com.smaato.soma.ErrorCode;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.OpeningLandingPageFailed;
import java.util.List;

public class ReceivedBanner implements ReceivedBannerInterface {
   public static final String TAG = "SOMA_Banner";
   private String mAdText;
   private AdType mAdType;
   private List mBeacons;
   private String mClickUrl;
   private ErrorCode mErrorCode;
   private String mErrorMessage;
   private boolean mHasBeenClicked = false;
   private String mImageUrl;
   private String mMediaFile;
   private String mRichMediaData;
   private String mSessionId;
   private BannerStatus mStatus;

   public ReceivedBanner() {
      this.mStatus = BannerStatus.ERROR;
      this.mErrorCode = ErrorCode.NO_ERROR;
      this.mErrorMessage = "";
   }

   public final String getAdText() {
      return this.mAdText;
   }

   public final AdType getAdType() {
      return this.mAdType;
   }

   public final List getBeacons() {
      return this.mBeacons;
   }

   public final String getClickUrl() {
      return this.mClickUrl;
   }

   public final ErrorCode getErrorCode() {
      return this.mErrorCode;
   }

   public final String getErrorMessage() {
      return this.mErrorMessage;
   }

   public final String getImageUrl() {
      return this.mImageUrl;
   }

   public final String getMediaFile() {
      return this.mMediaFile;
   }

   public final String getRichMediaData() {
      return this.mRichMediaData;
   }

   public final String getSessionId() {
      return this.mSessionId;
   }

   public final BannerStatus getStatus() {
      return this.mStatus;
   }

   public final void openLandingPage(Context var1) {
      try {
         Debugger.methodStart(new Object() {
         });
         if(!this.mHasBeenClicked && this.getClickUrl() != null && this.getClickUrl().length() > 0) {
            this.mHasBeenClicked = true;
            var1.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getClickUrl())));
         }

      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new OpeningLandingPageFailed(var3);
      }
   }

   public final void setAdText(String var1) {
      this.mAdText = var1;
   }

   public final void setAdType(AdType var1) {
      this.mAdType = var1;
   }

   public final void setBeacons(List var1) {
      this.mBeacons = var1;
   }

   public final void setClickUrl(String var1) {
      this.mClickUrl = var1;
   }

   public final void setErrorCode(ErrorCode var1) {
      this.mErrorCode = var1;
   }

   public final void setErrorMessage(String var1) {
      this.mErrorMessage = var1;
   }

   public final void setImageUrl(String var1) {
      this.mImageUrl = var1;
   }

   public final void setMediaFile(String var1) {
      this.mMediaFile = var1;
   }

   public final void setRichMediaData(String var1) {
      this.mRichMediaData = var1;
   }

   public final void setSessionId(String var1) {
      this.mSessionId = var1;
   }

   public final void setStatus(BannerStatus var1) {
      this.mStatus = var1;
   }
}
