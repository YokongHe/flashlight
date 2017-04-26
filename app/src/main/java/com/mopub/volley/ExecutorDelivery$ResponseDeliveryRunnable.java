package com.mopub.volley;

import com.mopub.volley.ExecutorDelivery;
import com.mopub.volley.Request;
import com.mopub.volley.Response;

class ExecutorDelivery$ResponseDeliveryRunnable implements Runnable {
   private final Request mRequest;
   private final Response mResponse;
   private final Runnable mRunnable;
   // $FF: synthetic field
   final ExecutorDelivery this$0;

   public ExecutorDelivery$ResponseDeliveryRunnable(ExecutorDelivery var1, Request var2, Response var3, Runnable var4) {
      this.this$0 = var1;
      this.mRequest = var2;
      this.mResponse = var3;
      this.mRunnable = var4;
   }

   public void run() {
      if(this.mRequest.isCanceled()) {
         this.mRequest.finish("canceled-at-delivery");
      } else {
         if(this.mResponse.isSuccess()) {
            this.mRequest.deliverResponse(this.mResponse.result);
         } else {
            this.mRequest.deliverError(this.mResponse.error);
         }

         if(this.mResponse.intermediate) {
            this.mRequest.addMarker("intermediate-response");
         } else {
            this.mRequest.finish("done");
         }

         if(this.mRunnable != null) {
            this.mRunnable.run();
            return;
         }
      }

   }
}
