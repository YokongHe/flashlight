package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidView;
import java.util.Map;

class MraidCommandGetScreenSize extends MraidCommand {
   MraidCommandGetScreenSize(Map var1, MraidView var2) {
      super(var1, var2);
   }

   void execute() {
      this.mView.getDisplayController().getScreenSize();
   }
}
