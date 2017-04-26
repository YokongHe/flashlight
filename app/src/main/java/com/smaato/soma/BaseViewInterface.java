package com.smaato.soma;

import com.smaato.soma.BannerStateListener;
import com.smaato.soma.StandardPublisherMethods;

public interface BaseViewInterface extends StandardPublisherMethods {
   int getBackgroundColor();

   boolean isScalingEnabled();

   void setBackgroundColor(int var1);

   void setBannerStateListener(BannerStateListener var1);

   void setScalingEnabled(boolean var1);
}
