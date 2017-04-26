package org.nexage.sourcekit.mraid.internal;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.ArrayList;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;

public class MRAIDNativeFeatureManager {
   private static final String TAG = "MRAIDNativeFeatureManager";
   private Context context;
   private ArrayList supportedNativeFeatures;

   public MRAIDNativeFeatureManager(Context var1, ArrayList var2) {
      this.context = var1;
      this.supportedNativeFeatures = var2;
   }

   public ArrayList getSupportedNativeFeatures() {
      return this.supportedNativeFeatures;
   }

   public boolean isCalendarSupported() {
      boolean var1;
      if(this.supportedNativeFeatures.contains("calendar") && VERSION.SDK_INT >= 14 && this.context.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      MRAIDLog.d("MRAIDNativeFeatureManager", "isCalendarSupported " + var1);
      return var1;
   }

   public boolean isInlineVideoSupported() {
      boolean var1 = this.supportedNativeFeatures.contains("inlineVideo");
      MRAIDLog.d("MRAIDNativeFeatureManager", "isInlineVideoSupported " + var1);
      return var1;
   }

   public boolean isSmsSupported() {
      boolean var1;
      if(this.supportedNativeFeatures.contains("sms") && this.context.checkCallingOrSelfPermission("android.permission.SEND_SMS") == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      MRAIDLog.d("MRAIDNativeFeatureManager", "isSmsSupported " + var1);
      return var1;
   }

   public boolean isStorePictureSupported() {
      boolean var1 = this.supportedNativeFeatures.contains("storePicture");
      MRAIDLog.d("MRAIDNativeFeatureManager", "isStorePictureSupported " + var1);
      return var1;
   }

   public boolean isTelSupported() {
      boolean var1;
      if(this.supportedNativeFeatures.contains("tel") && this.context.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      MRAIDLog.d("MRAIDNativeFeatureManager", "isTelSupported " + var1);
      return var1;
   }
}
