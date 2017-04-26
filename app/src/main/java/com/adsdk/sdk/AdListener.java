package com.adsdk.sdk;

import com.adsdk.sdk.Ad;

public interface AdListener {
   void adClicked();

   void adClosed(Ad var1, boolean var2);

   void adLoadSucceeded(Ad var1);

   void adShown(Ad var1, boolean var2);

   void noAdFound();
}
