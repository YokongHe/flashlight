package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidCommandFactory$MraidJavascriptCommand;
import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$PlacementType;
import java.util.Map;

class MraidCommandOpen extends MraidCommand {
   MraidCommandOpen(Map var1, MraidView var2) {
      super(var1, var2);
   }

   void execute() {
      String var1 = this.getStringFromParamsForKey("url");
      if(var1 == null) {
         this.mView.fireErrorEvent(MraidCommandFactory$MraidJavascriptCommand.OPEN, "Url can not be null.");
      } else {
         this.mView.getBrowserController().open(var1);
      }
   }

   protected boolean isCommandDependentOnUserClick(MraidView$PlacementType var1) {
      return true;
   }
}
