package com.tapjoy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TJEventOptimizer$a;
import com.tapjoy.TJEventOptimizer$b;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.util.concurrent.CountDownLatch;

@SuppressLint({"SetJavaScriptEnabled"})
public class TJEventOptimizer extends WebView {
   private static String a = "TJEventOptimizer";
   private static TJEventOptimizer b;
   private static CountDownLatch c;
   private Context d;
   private TJAdUnitJSBridge e;

   private TJEventOptimizer(Context var1) {
      super(var1);
      this.d = var1;
      this.e = new TJAdUnitJSBridge(this.d, this, (TJPlacementData)null);
      this.getSettings().setJavaScriptEnabled(true);
      this.setWebViewClient(new TJEventOptimizer$b(this, (byte)0));
      this.setWebChromeClient(new TJEventOptimizer$a(this, (byte)0));
      this.loadUrl(TapjoyConnectCore.getHostURL() + "events/proxy?" + TapjoyUtil.convertURLParams(TapjoyConnectCore.getGenericURLParams(), true));
   }

   // $FF: synthetic method
   TJEventOptimizer(Context var1, byte var2) {
      this(var1);
   }

   // $FF: synthetic method
   static String b() {
      return a;
   }

   public static TJEventOptimizer getInstance() {
      return b;
   }

   public static void init(final Context var0) {
      TapjoyLog.d(a, "Initializing event optimizer");
      c = new CountDownLatch(1);
      Runnable var1 = new Runnable() {
         public final void run() {
            TJEventOptimizer.b = new TJEventOptimizer(var0, (byte)0);
            TJEventOptimizer.c.countDown();
         }
      };
      if(Looper.myLooper() == Looper.getMainLooper()) {
         var1.run();
      } else {
         (new Handler(var0.getMainLooper())).post(var1);
      }

      c.await();
   }
}
