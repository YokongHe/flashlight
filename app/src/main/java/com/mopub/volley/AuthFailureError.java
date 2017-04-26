package com.mopub.volley;

import android.content.Intent;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class AuthFailureError extends VolleyError {
   private Intent mResolutionIntent;

   public AuthFailureError() {
   }

   public AuthFailureError(Intent var1) {
      this.mResolutionIntent = var1;
   }

   public AuthFailureError(NetworkResponse var1) {
      super(var1);
   }

   public AuthFailureError(String var1) {
      super(var1);
   }

   public AuthFailureError(String var1, Exception var2) {
      super(var1, var2);
   }

   public String getMessage() {
      return this.mResolutionIntent != null?"User needs to (re)enter credentials.":super.getMessage();
   }

   public Intent getResolutionIntent() {
      return this.mResolutionIntent;
   }
}
