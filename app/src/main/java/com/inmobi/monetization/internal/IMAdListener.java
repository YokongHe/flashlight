package com.inmobi.monetization.internal;

import com.inmobi.monetization.internal.AdErrorCode;
import java.util.Map;

public interface IMAdListener {
   void onAdInteraction(Map var1);

   void onAdRequestFailed(AdErrorCode var1);

   void onAdRequestSucceeded();

   void onDismissAdScreen();

   void onIncentCompleted(Map var1);

   void onLeaveApplication();

   void onShowAdScreen();
}
