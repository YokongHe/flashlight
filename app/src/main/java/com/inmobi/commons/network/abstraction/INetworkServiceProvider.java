package com.inmobi.commons.network.abstraction;

import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.abstraction.INetworkListener;

public interface INetworkServiceProvider {
   void executeTask(Request var1, INetworkListener var2);
}
