package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$PlacementType;
import java.util.Map;

class MraidCommandCreateCalendarEvent extends MraidCommand {
   MraidCommandCreateCalendarEvent(Map var1, MraidView var2) {
      super(var1, var2);
   }

   void execute() {
      this.mView.getDisplayController().createCalendarEvent(this.mParams);
   }

   protected boolean isCommandDependentOnUserClick(MraidView$PlacementType var1) {
      return true;
   }
}
