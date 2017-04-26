package com.smaato.soma;

import com.smaato.soma.AdDimension;
import com.smaato.soma.AdType;

public interface AdSettingsInterface {
   AdDimension getAdDimension();

   AdType getAdType();

   int getAdspaceId();

   int getBannerHeight();

   int getBannerWidth();

   int getPublisherId();

   void setAdDimension(AdDimension var1);

   void setAdType(AdType var1);

   void setAdspaceId(int var1);

   void setBannerHeight(int var1);

   void setBannerWidth(int var1);

   void setPublisherId(int var1);
}
