package com.inmobi.commons.network;

import com.inmobi.commons.network.NetworkRequestTask;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.abstraction.INetworkListener;
import com.inmobi.commons.network.abstraction.INetworkServiceProvider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceProvider implements INetworkServiceProvider {
   private static ServiceProvider a;
   private ExecutorService b = Executors.newFixedThreadPool(15);

   public static ServiceProvider getInstance() {
      if(a == null) {
         synchronized(ServiceProvider.class) {
            if(a == null) {
               a = new ServiceProvider();
            }

         }
      }

      return a;
   }

   public void executeTask(Request var1, INetworkListener var2) {
      this.b.execute(new NetworkRequestTask(var1, var2));
   }
}
