package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidCommandFactory$MraidJavascriptCommand;
import com.adsdk.sdk.mraid.MraidView;
import java.util.Map;

class MraidCommandGetResizeProperties extends MraidCommand {
   MraidCommandGetResizeProperties(Map var1, MraidView var2) {
      super(var1, var2);
   }

   void execute() {
      this.mView.fireErrorEvent(MraidCommandFactory$MraidJavascriptCommand.GET_RESIZE_PROPERTIES, "Unsupported action getResizeProperties.");
   }
}
