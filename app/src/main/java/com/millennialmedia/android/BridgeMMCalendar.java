package com.millennialmedia.android;

import android.annotation.TargetApi;
import com.millennialmedia.android.MMJSObject;
import com.millennialmedia.android.MMJSResponse;
import java.text.SimpleDateFormat;
import java.util.Map;
import org.json.JSONObject;

class BridgeMMCalendar extends MMJSObject {
   private static final String ADD_EVENT = "addEvent";
   private static final String TAG = BridgeMMCalendar.class.getName();
   private static final String[] mraidCreateCalendarEventDateFormats = new String[]{"yyyy-MM-dd\'T\'HH:mmZZZ", "yyyy-MM-dd\'T\'HH:mm:ssZZZ"};
   private static final SimpleDateFormat rruleUntilDateFormat = new SimpleDateFormat("yyyyMMdd\'T\'HHmmss");

   private String convertMraidDayToRRuleDay(int var1) {
      switch(var1) {
      case 1:
         return "MO";
      case 2:
         return "TU";
      case 3:
         return "WE";
      case 4:
         return "TH";
      case 5:
         return "FR";
      case 6:
         return "SA";
      case 7:
         return "SU";
      default:
         return null;
      }
   }

   private String convertRecurrence(JSONObject param1) {
      // $FF: Couldn't be decompiled
   }

   @TargetApi(14)
   public MMJSResponse addEvent(Map param1) {
      // $FF: Couldn't be decompiled
   }

   MMJSResponse executeCommand(String var1, Map var2) {
      MMJSResponse var3 = null;
      if("addEvent".equals(var1)) {
         var3 = this.addEvent(var2);
      }

      return var3;
   }
}
