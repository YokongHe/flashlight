package com.adsdk.sdk.mraid;

import android.util.Log;
import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidCommandFactory$MraidJavascriptCommand;
import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$PlacementType;
import java.util.Map;

class MraidCommandStorePicture extends MraidCommand {
   public static final String MIME_TYPE_HEADER = "Content-Type";

   public MraidCommandStorePicture(Map var1, MraidView var2) {
      super(var1, var2);
   }

   void execute() {
      String var1 = this.getStringFromParamsForKey("uri");
      if(var1 != null && !var1.equals("")) {
         this.mView.getDisplayController().showUserDownloadImageAlert(var1);
      } else {
         this.mView.fireErrorEvent(MraidCommandFactory$MraidJavascriptCommand.STORE_PICTURE, "Image can\'t be stored with null or empty URL");
         Log.d("MoPub", "Invalid URI for Mraid Store Picture.");
      }
   }

   protected boolean isCommandDependentOnUserClick(MraidView$PlacementType var1) {
      return true;
   }
}
