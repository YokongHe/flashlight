package com.smaato.soma;

import com.smaato.soma.AdSettings;
import com.smaato.soma.internal.requests.settings.UserSettings;

public interface BaseInterface {
   void asyncLoadNewBanner();

   AdSettings getAdSettings();

   UserSettings getUserSettings();

   boolean isLocationUpdateEnabled();

   void setAdSettings(AdSettings var1);

   void setLocationUpdateEnabled(boolean var1);

   void setUserSettings(UserSettings var1);
}
