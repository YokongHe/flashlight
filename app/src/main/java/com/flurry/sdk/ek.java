package com.flurry.sdk;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.HttpParams;

public final class ek {
   private static SchemeRegistry a;

   public static HttpClient a(HttpParams var0) {
      return new DefaultHttpClient(new SingleClientConnManager(var0, a()), var0);
   }

   private static SchemeRegistry a() {
      // $FF: Couldn't be decompiled
   }
}
