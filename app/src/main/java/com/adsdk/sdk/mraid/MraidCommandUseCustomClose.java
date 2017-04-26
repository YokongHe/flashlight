package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidView;
import java.util.Map;

class MraidCommandUseCustomClose extends MraidCommand {
   MraidCommandUseCustomClose(Map var1, MraidView var2) {
      super(var1, var2);
   }

   void execute() {
      boolean var1 = this.getBooleanFromParamsForKey("shouldUseCustomClose");
      this.mView.getDisplayController().useCustomClose(var1);
   }
}
