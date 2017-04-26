package com.adsdk.sdk;

import com.adsdk.sdk.AdRequest;
import java.io.InputStream;
import org.apache.http.Header;

public abstract class RequestAd {
   InputStream is;

   abstract Object parse(InputStream var1, Header[] var2, boolean var3);

   abstract Object parseTestString();

   public Object sendRequest(AdRequest param1) {
      // $FF: Couldn't be decompiled
   }
}
