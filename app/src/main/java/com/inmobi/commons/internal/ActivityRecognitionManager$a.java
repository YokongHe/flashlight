package com.inmobi.commons.internal;

import android.os.Bundle;
import com.inmobi.commons.internal.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ActivityRecognitionManager$a implements InvocationHandler {
   private ActivityRecognitionManager$a() {
   }

   // $FF: synthetic method
   ActivityRecognitionManager$a(Object var1) {
      this();
   }

   public void a(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public Object invoke(Object var1, Method var2, Object[] var3) {
      if(var3 != null) {
         try {
            if(var2.getName().equals("onConnected")) {
               this.a((Bundle)var3[0]);
            }
         } catch (Exception var4) {
            Log.internal("[InMobi]-4.5.2", "Unable to invoke method", var4);
         }
      }

      return null;
   }
}
