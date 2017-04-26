package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidCommandFactory$MraidJavascriptCommand;
import com.adsdk.sdk.mraid.MraidView;
import java.util.Map;

class MraidCommandSetResizeProperties extends MraidCommand {
   MraidCommandSetResizeProperties(Map var1, MraidView var2) {
      super(var1, var2);
   }

   void execute() {
      this.mView.fireErrorEvent(MraidCommandFactory$MraidJavascriptCommand.SET_RESIZE_PROPERTIES, "Unsupported action setResizeProperties.");
   }
}
