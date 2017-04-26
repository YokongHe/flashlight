package com.inmobi.commons.network.abstraction;

import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Response;

public interface INetworkListener {
   void onRequestFailed(Request var1, Response var2);

   void onRequestSucceded(Request var1, Response var2);
}
