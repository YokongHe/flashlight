package com.mopub.mraid;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.mopub.common.VisibleForTesting;

@VisibleForTesting
public interface MraidWebViewDebugListener {
   boolean onConsoleMessage(ConsoleMessage var1);

   boolean onJsAlert(String var1, JsResult var2);
}
