package com.smaato.soma.internal.requests.settings;

import com.smaato.soma.internal.requests.settings.UserSettings$Gender;

public interface UserSettingsInterface {
   int getAge();

   String getCity();

   String getKeywordList();

   double getLatitude();

   double getLongitude();

   String getRegion();

   String getSearchQuery();

   UserSettings$Gender getUserGender();

   boolean getuserProfileEnabled();

   int isCOPPA();

   void setAge(int var1);

   void setCOPPA(boolean var1);

   void setCity(String var1);

   void setKeywordList(String var1);

   void setLatitude(double var1);

   void setLongitude(double var1);

   void setRegion(String var1);

   void setSearchQuery(String var1);

   void setUserGender(UserSettings$Gender var1);

   void setuserProfileEnabled(boolean var1);
}
