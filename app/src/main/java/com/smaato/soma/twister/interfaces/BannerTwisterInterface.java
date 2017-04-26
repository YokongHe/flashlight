package com.smaato.soma.twister.interfaces;

import com.smaato.soma.AdSettings;
import com.smaato.soma.BannerStateListener;
import com.smaato.soma.internal.requests.settings.UserSettings;
import com.smaato.soma.twister.enums.SomaAnimationType;
import com.smaato.soma.twister.interfaces.AdListener;

public interface BannerTwisterInterface {
   AdSettings getAdSettings();

   int getAutoReloadFrequency();

   int getBackgroundColor();

   UserSettings getUserSettings();

   boolean isLocationUpdateEnabled();

   boolean isScalingEnabled();

   void loadBanners();

   void setAdListener(AdListener var1);

   void setAdSettings(AdSettings var1);

   void setAnimation(SomaAnimationType var1);

   void setAutoReloadFrequency(int var1);

   void setBannerStateListener(BannerStateListener var1);

   void setLocationUpdateEnabled(boolean var1);

   void setScalingEnabled(boolean var1);

   void setUserSettings(UserSettings var1);
}
