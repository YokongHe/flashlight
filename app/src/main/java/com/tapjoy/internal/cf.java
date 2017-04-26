package com.tapjoy.internal;

import java.io.InputStream;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicHeader;

public abstract class cf extends com.tapjoy.internal.cg {
   protected abstract Object a(com.tapjoy.internal.bt var1);

   public final Object a(URI param1, InputStream param2) {
      // $FF: Couldn't be decompiled
   }

   public final List a() {
      LinkedList var1 = new LinkedList();
      var1.add(new BasicHeader("Accept", "application/json"));
      return var1;
   }
}
