package com.inmobi.commons.internal;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.internal.ActivityRecognitionSampler$ActivitySample;
import com.inmobi.commons.internal.PayloadCreator;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONPayloadCreator implements PayloadCreator {
   private JSONObject a(NeighboringCellInfo var1) {
      JSONObject var2 = new JSONObject();

      try {
         var2.put("id", var1.getCid());
         if(var1.getRssi() != 0) {
            var2.put("ss", var1.getRssi());
         }

         return var2;
      } catch (JSONException var3) {
         return null;
      }
   }

   private JSONObject a(ActivityRecognitionSampler$ActivitySample var1) {
      try {
         JSONObject var2 = new JSONObject();
         var2.put("t", 3);
         var2.put("ts", var1.getTimestamp());
         var2.put("a", var1.getActivity());
         return var2;
      } catch (Exception var3) {
         return null;
      }
   }

   private JSONObject a(CellTowerInfo var1) {
      JSONObject var2 = new JSONObject();

      try {
         var2.put("id", var1.id);
         if(var1.signalStrength != 0) {
            var2.put("ss", var1.signalStrength);
         }

         return var2;
      } catch (Exception var3) {
         return null;
      }
   }

   private JSONObject a(Sample param1, ThinICEConfig param2) {
      // $FF: Couldn't be decompiled
   }

   private JSONObject a(WifiInfo var1) {
      JSONObject var2 = new JSONObject();

      try {
         var2.put("bssid", var1.bssid);
         var2.put("essid", var1.ssid);
         return var2;
      } catch (Exception var3) {
         return null;
      }
   }

   public String toPayloadString(List param1, List param2, Context param3) {
      // $FF: Couldn't be decompiled
   }
}
