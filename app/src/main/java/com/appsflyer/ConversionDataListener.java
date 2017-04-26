package com.appsflyer;

import java.util.Map;

public interface ConversionDataListener {
   void onConversionDataLoaded(Map var1);

   void onConversionFailure(String var1);
}
