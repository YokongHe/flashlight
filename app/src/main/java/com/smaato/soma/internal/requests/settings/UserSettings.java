package com.smaato.soma.internal.requests.settings;

import com.smaato.soma.internal.requests.settings.UserSettings$Gender;
import com.smaato.soma.internal.requests.settings.UserSettingsInterface;

public class UserSettings implements UserSettingsInterface {
   private static final String FEMALE_String = "f";
   private static final String MALE_String = "m";
   protected int mAge;
   private boolean mCOPPA;
   protected String mCity;
   protected String mKeywordList;
   protected double mLatitude;
   protected double mLongitude;
   protected String mRegion;
   protected String mSearchQuery;
   protected UserSettings$Gender mUserGender;
   private boolean mUserProfileEnabled;

   public UserSettings() {
      this.mUserGender = UserSettings$Gender.UNSET;
      this.mAge = 0;
      this.mKeywordList = "";
      this.mSearchQuery = "";
      this.mRegion = "";
      this.mCity = "";
      this.mLatitude = 0.0D;
      this.mLongitude = 0.0D;
      this.mUserProfileEnabled = true;
      this.mCOPPA = false;
   }

   public int getAge() {
      return this.mAge;
   }

   public String getCity() {
      return this.mCity;
   }

   public String getKeywordList() {
      return this.mKeywordList;
   }

   public double getLatitude() {
      return this.mLatitude;
   }

   public double getLongitude() {
      return this.mLongitude;
   }

   public String getRegion() {
      return this.mRegion;
   }

   public String getSearchQuery() {
      return this.mSearchQuery;
   }

   public UserSettings$Gender getUserGender() {
      return this.mUserGender;
   }

   public boolean getuserProfileEnabled() {
      return this.mUserProfileEnabled;
   }

   public int isCOPPA() {
      return this.mCOPPA?1:0;
   }

   public void setAge(int var1) {
      this.mAge = var1;
   }

   public void setCOPPA(boolean var1) {
      this.mCOPPA = var1;
   }

   public void setCity(String var1) {
      this.mCity = var1;
   }

   public void setKeywordList(String var1) {
      this.mKeywordList = var1;
   }

   public void setLatitude(double var1) {
      this.mLatitude = var1;
   }

   public void setLongitude(double var1) {
      this.mLongitude = var1;
   }

   public void setRegion(String var1) {
      this.mRegion = var1;
   }

   public void setSearchQuery(String var1) {
      this.mSearchQuery = var1;
   }

   public void setUserGender(UserSettings$Gender var1) {
      this.mUserGender = var1;
   }

   public void setuserProfileEnabled(boolean var1) {
      this.mUserProfileEnabled = var1;
   }
}
