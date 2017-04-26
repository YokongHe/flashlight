package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Vibrator;
import com.millennialmedia.android.MMJSObject;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMWebView;
import java.util.Map;
import java.util.concurrent.Callable;

class BridgeMMNotification extends MMJSObject implements OnClickListener {
   private String ALERT = "alert";
   private String VIBRATE = "vibrate";
   private int index;

   public MMJSResponse alert(final Map var1) {
      synchronized(this){}

      MMJSResponse var4;
      try {
         var4 = this.runOnUiThreadFuture(new Callable() {
            public MMJSResponse call() {
               MMWebView var1x = (MMWebView)BridgeMMNotification.this.mmWebViewRef.get();
               if(var1x != null) {
                  Activity var2 = var1x.getActivity();
                  Map var3 = var1;
                  if(var2 != null) {
                     if(!var2.isFinishing()) {
                        AlertDialog var6 = (new Builder(var2)).create();
                        if(var3.containsKey("title")) {
                           var6.setTitle((CharSequence)var3.get("title"));
                        }

                        if(var3.containsKey("message")) {
                           var6.setMessage((CharSequence)var3.get("message"));
                        }

                        if(var3.containsKey("cancelButton")) {
                           var6.setButton(-2, (CharSequence)var3.get("cancelButton"), BridgeMMNotification.this);
                        }

                        if(var3.containsKey("buttons")) {
                           String[] var4 = ((String)var3.get("buttons")).split(",");
                           if(var4.length > 0) {
                              var6.setButton(-3, var4[0], BridgeMMNotification.this);
                           }

                           if(var4.length > 1) {
                              var6.setButton(-1, var4[1], BridgeMMNotification.this);
                           }
                        }

                        var6.show();
                     }

                     MMJSResponse var5 = new MMJSResponse();
                     var5.result = 1;
                     var5.response = Integer.valueOf(BridgeMMNotification.this.index);
                     return var5;
                  }
               }

               return null;
            }
         });
      } finally {
         ;
      }

      return var4;
   }

   MMJSResponse executeCommand(String var1, Map var2) {
      MMJSResponse var3 = null;
      if(this.ALERT.equals(var1)) {
         var3 = this.alert(var2);
      } else if(this.VIBRATE.equals(var1)) {
         return this.vibrate(var2);
      }

      return var3;
   }

   public void onClick(DialogInterface param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public MMJSResponse vibrate(Map var1) {
      Context var4 = (Context)this.contextRef.get();
      long var2;
      if(var1.containsKey("duration")) {
         var2 = (long)((double)Float.parseFloat((String)var1.get("duration")) * 1000.0D);
      } else {
         var2 = 0L;
      }

      if(var4 != null && var2 > 0L) {
         if(var4.getPackageManager().checkPermission("android.permission.VIBRATE", var4.getPackageName()) == 0) {
            ((Vibrator)var4.getSystemService("vibrator")).vibrate(var2);
            return MMJSResponse.responseWithSuccess("Vibrating for " + var2);
         } else {
            return MMJSResponse.responseWithError("The required permissions to vibrate are not set.");
         }
      } else {
         return null;
      }
   }
}
