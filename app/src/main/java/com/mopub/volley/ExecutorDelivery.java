package com.mopub.volley;

import android.os.Handler;
import com.mopub.volley.ExecutorDelivery$ResponseDeliveryRunnable;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.ResponseDelivery;
import com.mopub.volley.VolleyError;
import java.util.concurrent.Executor;

public class ExecutorDelivery implements ResponseDelivery {
   private final Executor mResponsePoster;

   public ExecutorDelivery(final Handler var1) {
      this.mResponsePoster = new Executor() {
         public void execute(Runnable var1x) {
            var1.post(var1x);
         }
      };
   }

   public ExecutorDelivery(Executor var1) {
      this.mResponsePoster = var1;
   }

   public void postError(Request var1, VolleyError var2) {
      var1.addMarker("post-error");
      Response var3 = Response.error(var2);
      this.mResponsePoster.execute(new ExecutorDelivery$ResponseDeliveryRunnable(this, var1, var3, (Runnable)null));
   }

   public void postResponse(Request var1, Response var2) {
      this.postResponse(var1, var2, (Runnable)null);
   }

   public void postResponse(Request var1, Response var2, Runnable var3) {
      var1.markDelivered();
      var1.addMarker("post-response");
      this.mResponsePoster.execute(new ExecutorDelivery$ResponseDeliveryRunnable(this, var1, var2, var3));
   }
}
