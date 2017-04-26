package com.inmobi.commons.network;

import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Request$Method;
import com.inmobi.commons.network.abstraction.INetworkListener;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class NetworkRequestTask implements Runnable {
   private Request a;
   private INetworkListener b;
   private HttpURLConnection c;

   NetworkRequestTask(Request var1, INetworkListener var2) {
      this.a = var1;
      this.b = var2;
   }

   private HttpURLConnection a(String var1) {
      HttpURLConnection var2 = (HttpURLConnection)(new URL(var1)).openConnection();
      this.a(var2);
      return var2;
   }

   private void a() {
      // $FF: Couldn't be decompiled
   }

   private void a(Closeable var1) {
      if(var1 != null) {
         try {
            var1.close();
         } catch (IOException var3) {
            Log.debug("[InMobi]-4.5.2", "Exception closing resource: " + var1, var3);
            return;
         }
      }

   }

   private void a(HttpURLConnection var1) {
      var1.setConnectTimeout(this.a.getTimeout());
      var1.setReadTimeout(this.a.getTimeout());
      Iterator var2 = this.a.getHeaders().keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.setRequestProperty(var3, (String)this.a.getHeaders().get(var3));
      }

      var1.setUseCaches(false);
      Request$Method var4 = this.a.getRequestMethod();
      if(var4 != Request$Method.GET) {
         var1.setDoOutput(true);
         var1.setDoInput(true);
      }

      var1.setRequestMethod(var4.toString());
      var1.setRequestProperty("content-type", "application/x-www-form-urlencoded");
   }

   private void b(String var1) {
      this.c.setRequestProperty("Content-Length", Integer.toString(var1.length()));

      BufferedWriter var2;
      try {
         var2 = new BufferedWriter(new OutputStreamWriter(this.c.getOutputStream()));
      } finally {
         ;
      }

      try {
         var2.write(var1);
      } finally {
         this.a((Closeable)var2);
         throw var1;
      }

   }

   public void run() {
      // $FF: Couldn't be decompiled
   }
}
