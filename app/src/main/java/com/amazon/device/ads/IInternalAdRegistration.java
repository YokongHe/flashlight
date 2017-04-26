package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AppInfo;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.RegistrationInfo;
import java.io.File;

interface IInternalAdRegistration {
   void contextReceived(Context var1);

   AppInfo getAppInfo();

   Context getApplicationContext();

   DeviceInfo getDeviceInfo();

   File getFilesDir();

   boolean getIsAppDisabled();

   int getNoRetryTtlRemainingMillis();

   RegistrationInfo getRegistrationInfo();

   boolean isRegistered();

   void register();

   void setIsAppDisabled(boolean var1);

   void setNoRetryTtl(int var1);
}
