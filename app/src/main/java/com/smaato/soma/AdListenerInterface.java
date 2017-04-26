package com.smaato.soma;

import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.ReceivedBannerInterface;

public interface AdListenerInterface {
   void onReceiveAd(AdDownloaderInterface var1, ReceivedBannerInterface var2);
}
