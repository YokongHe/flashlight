package com.inmobi.commons.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.internal.ApplicationFocusManager;

class ApplicationFocusManager$a extends Handler {
   private boolean a = false;

   public ApplicationFocusManager$a(Looper var1) {
      super(var1);
   }

   public void handleMessage(Message var1) {
      if(var1.what == 1001 && this.a) {
         this.a = false;
         ApplicationFocusManager.a(Boolean.valueOf(this.a));
      } else if(var1.what == 1002 && !this.a) {
         this.a = true;
         ApplicationFocusManager.a(Boolean.valueOf(this.a));
         return;
      }

   }
}
