package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import com.millennialmedia.android.AdViewOverlayActivity;
import com.millennialmedia.android.MMActivity;
import com.millennialmedia.android.MMBaseActivity;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.MMWebView;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

abstract class MMJSObject {
   private static final String TAG = MMJSObject.class.getName();
   protected WeakReference contextRef;
   protected WeakReference mmWebViewRef;

   abstract MMJSResponse executeCommand(String var1, Map var2);

   long getAdImplId(String var1) {
      return var1 != null?(long)Float.parseFloat(var1):-4L;
   }

   AdViewOverlayActivity getBaseActivity() {
      MMWebView var1 = (MMWebView)this.mmWebViewRef.get();
      if(var1 != null) {
         Activity var2 = var1.getActivity();
         if(var2 instanceof MMActivity) {
            MMBaseActivity var3 = ((MMActivity)var2).getWrappedActivity();
            if(var3 instanceof AdViewOverlayActivity) {
               return (AdViewOverlayActivity)var3;
            }
         }
      }

      return null;
   }

   MMJSResponse runOnUiThreadFuture(Callable var1) {
      FutureTask var4 = new FutureTask(var1);
      MMSDK.runOnUiThread(var4);

      try {
         MMJSResponse var5 = (MMJSResponse)var4.get();
         return var5;
      } catch (InterruptedException var2) {
         MMLog.e(TAG, "Future interrupted", var2);
      } catch (ExecutionException var3) {
         MMLog.e(TAG, "Future execution problem: ", var3);
      }

      return null;
   }

   void setContext(Context var1) {
      this.contextRef = new WeakReference(var1);
   }

   void setMMWebView(MMWebView var1) {
      this.mmWebViewRef = new WeakReference(var1);
   }
}
