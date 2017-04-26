package com.smaato.soma.internal.requests;

import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.internal.utilities.ConnectionListenerInterface;
import java.net.URL;

public interface HttpConnectorInterface {
   void asyncLoadBeacons();

   boolean asyncLoadNewBanner(URL var1);

   ReceivedBannerInterface loadNewBanner(URL var1);

   void setConnectionListener(ConnectionListenerInterface var1);
}
