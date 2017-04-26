package com.smaato.soma.test;

import com.smaato.soma.internal.DefaultFactory;
import com.smaato.soma.internal.requests.HttpConnectorInterface;
import com.smaato.soma.test.DummyConnector;

public class DummyFactory extends DefaultFactory {
   private DummyConnector mConnector = DummyConnector.getInstance();

   public HttpConnectorInterface createHttpConnector(String var1) {
      return this.mConnector;
   }
}
