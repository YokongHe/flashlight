package com.inmobi.re.container;

import android.os.Handler;
import android.os.Message;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.container.mraidimpl.MRAIDBasic;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.container.mraidimpl.MRAIDResizeController;
import java.lang.ref.WeakReference;

class IMWebView$c extends Handler {
   private final WeakReference a;
   private final WeakReference b;
   private final WeakReference c;
   private final WeakReference d;
   private final WeakReference e;
   private final WeakReference f;

   public IMWebView$c(IMWebView var1, MRAIDBasic var2, MRAIDExpandController var3, MRAIDInterstitialController var4, MRAIDAudioVideoController var5, MRAIDResizeController var6) {
      this.a = new WeakReference(var1);
      this.b = new WeakReference(var3);
      this.d = new WeakReference(var2);
      this.e = new WeakReference(var4);
      this.f = new WeakReference(var5);
      this.c = new WeakReference(var6);
   }

   public void handleMessage(Message param1) {
      // $FF: Couldn't be decompiled
   }
}
