package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.millennialmedia.android.HandShake;
import org.json.JSONObject;

class HandShake$Scheme {
   int id;
   String scheme;
   // $FF: synthetic field
   final HandShake this$0;

   HandShake$Scheme(HandShake var1) {
      this.this$0 = var1;
   }

   HandShake$Scheme(HandShake var1, String var2, int var3) {
      this.this$0 = var1;
      this.scheme = var2;
      this.id = var3;
   }

   boolean checkAvailability(Context var1) {
      Intent var2;
      if(this.scheme.contains("://")) {
         var2 = new Intent("android.intent.action.VIEW", Uri.parse(this.scheme));
      } else {
         var2 = new Intent("android.intent.action.VIEW", Uri.parse(this.scheme + "://"));
      }

      return var1.getPackageManager().queryIntentActivities(var2, 65536).size() > 0;
   }

   void deserializeFromObj(JSONObject var1) {
      if(var1 != null) {
         this.scheme = var1.optString("scheme", (String)null);
         this.id = var1.optInt("schemeid");
      }
   }
}
