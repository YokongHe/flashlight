package com.mopub.volley.toolbox;

import com.mopub.volley.Request;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.Response$Listener;
import com.mopub.volley.VolleyError;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture implements Response$ErrorListener, Response$Listener, Future {
   private VolleyError mException;
   private Request mRequest;
   private Object mResult;
   private boolean mResultReceived = false;

   private Object doGet(Long param1) {
      // $FF: Couldn't be decompiled
   }

   public static RequestFuture newFuture() {
      return new RequestFuture();
   }

   public boolean cancel(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public Object get() {
      try {
         Object var1 = this.doGet((Long)null);
         return var1;
      } catch (TimeoutException var2) {
         throw new AssertionError(var2);
      }
   }

   public Object get(long var1, TimeUnit var3) {
      return this.doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(var1, var3)));
   }

   public boolean isCancelled() {
      return this.mRequest == null?false:this.mRequest.isCanceled();
   }

   public boolean isDone() {
      synchronized(this){}
      boolean var4 = false;

      boolean var1;
      label53: {
         try {
            var4 = true;
            if(this.mResultReceived) {
               var4 = false;
               break label53;
            }

            if(this.mException != null) {
               var4 = false;
               break label53;
            }

            var1 = this.isCancelled();
            var4 = false;
         } finally {
            if(var4) {
               ;
            }
         }

         if(!var1) {
            var1 = false;
            return var1;
         }
      }

      var1 = true;
      return var1;
   }

   public void onErrorResponse(VolleyError var1) {
      synchronized(this){}

      try {
         this.mException = var1;
         this.notifyAll();
      } finally {
         ;
      }

   }

   public void onResponse(Object var1) {
      synchronized(this){}

      try {
         this.mResultReceived = true;
         this.mResult = var1;
         this.notifyAll();
      } finally {
         ;
      }

   }

   public void setRequest(Request var1) {
      this.mRequest = var1;
   }
}
