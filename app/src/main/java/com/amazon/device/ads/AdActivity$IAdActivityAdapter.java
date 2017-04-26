package com.amazon.device.ads;

import android.app.Activity;

public interface AdActivity$IAdActivityAdapter {
   boolean onBackPressed();

   void onConfigurationChanged(android.content.res.Configuration var1);

   void onCreate();

   void onPause();

   void onResume();

   void onStop();

   void preOnCreate();

   void setActivity(Activity var1);
}
