package com.inmobi.commons.internal;

import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.metric.Storage$PreProcessor;
import org.json.JSONObject;

public class ApiStatCollector {
   private static Logger a = new Logger(3, "apiStats", new Storage$PreProcessor() {
      public final JSONObject process(JSONObject param1) {
         // $FF: Couldn't be decompiled
      }
   });

   public static Logger getLogger() {
      return a;
   }
}
