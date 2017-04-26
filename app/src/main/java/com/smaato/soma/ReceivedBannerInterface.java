package com.smaato.soma;

import android.content.Context;
import com.smaato.soma.AdType;
import com.smaato.soma.ErrorCode;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import java.util.List;

public interface ReceivedBannerInterface {
   String getAdText();

   AdType getAdType();

   List getBeacons();

   String getClickUrl();

   ErrorCode getErrorCode();

   String getErrorMessage();

   String getImageUrl();

   String getMediaFile();

   String getRichMediaData();

   BannerStatus getStatus();

   void openLandingPage(Context var1);
}
