package com.millennialmedia.android;

import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMWebViewClient$MMWebViewClientListener;
import java.lang.ref.WeakReference;

class MMAdImpl$BasicWebViewClientListener extends MMWebViewClient$MMWebViewClientListener {
   WeakReference adImplRef;

   MMAdImpl$BasicWebViewClientListener(MMAdImpl var1) {
      this.adImplRef = new WeakReference(var1);
   }

   public void onPageFinished(String param1) {
      // $FF: Couldn't be decompiled
   }

   void onPageStarted(String var1) {
      MMAdImpl var2 = (MMAdImpl)this.adImplRef.get();
      if(var2 != null) {
         var2.setClickable(false);
      }

   }
}
