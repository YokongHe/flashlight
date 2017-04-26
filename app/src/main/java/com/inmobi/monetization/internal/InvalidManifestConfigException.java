package com.inmobi.monetization.internal;

public final class InvalidManifestConfigException extends Exception {
   public static final int MISSING_ACCESS_NETWORK_STATE_PERMISSION = -9;
   public static final int MISSING_ACTIVITY_DECLARATION = -2;
   public static final int MISSING_CONFIG_CHANGES = -3;
   public static final int MISSING_CONFIG_KEYBOARD = -4;
   public static final int MISSING_CONFIG_KEYBOARDHIDDEN = -5;
   public static final int MISSING_CONFIG_ORIENTATION = -6;
   public static final int MISSING_CONFIG_SCREENSIZE = -7;
   public static final int MISSING_CONFIG_SMALLEST_SCREENSIZE = -8;
   public static final int MISSING_INTERNET_PERMISSION = -1;
   private static final long serialVersionUID = 1L;
   private int a;

   InvalidManifestConfigException(int var1) {
      this.a = var1;
   }

   public final int getExceptionCode() {
      return this.a;
   }

   public final String toString() {
      StringBuffer var1 = new StringBuffer("IMConfigException : ");
      switch(this.a) {
      case -9:
         var1.append("App does not have ACCESS_NETWORK_STATE permissions. Please provide ACCESS_NETWORK_STATE permissions");
         break;
      case -8:
         var1.append("Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity");
         break;
      case -7:
         var1.append("Missing Config screenSize from android:configChangesof IMBRowserActivity");
         break;
      case -6:
         var1.append("Missing Config orientation from android:configChangesof IMBRowserActivity");
         break;
      case -5:
         var1.append("Missing Config keyboardHidden from android:configChangesof IMBRowserActivity");
         break;
      case -4:
         var1.append("Missing Config keyboard from android:configChangesof IMBRowserActivity");
         break;
      case -3:
         var1.append("IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest");
         break;
      case -2:
         var1.append("IMBrowserActivity not declared in the manifest. Please declare it in the app manifest");
         break;
      case -1:
         var1.append("App does not have INTERNET permissions. Please provide INTERNET permissions");
      }

      return var1.toString();
   }
}
