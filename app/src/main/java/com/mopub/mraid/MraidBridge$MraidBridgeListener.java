package com.mopub.mraid;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.mopub.common.CloseableLayout$ClosePosition;
import com.mopub.mraid.MraidOrientation;
import java.net.URI;

public interface MraidBridge$MraidBridgeListener {
   void onClose();

   boolean onConsoleMessage(ConsoleMessage var1);

   void onExpand(URI var1, boolean var2);

   boolean onJsAlert(String var1, JsResult var2);

   void onOpen(URI var1);

   void onPageLoaded();

   void onPlayVideo(URI var1);

   void onResize(int var1, int var2, int var3, int var4, CloseableLayout$ClosePosition var5, boolean var6);

   void onSetOrientationProperties(boolean var1, MraidOrientation var2);

   void onUseCustomClose(boolean var1);

   void onVisibilityChanged(boolean var1);
}
