package com.inmobi.re.container;

import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.util.Map;

public interface IMWebView$IMWebViewListener {
   void onDismissAdScreen();

   void onDisplayFailed();

   void onError();

   void onExpand();

   void onExpandClose();

   void onIncentCompleted(Map var1);

   void onLeaveApplication();

   void onResize(ResizeDimensions var1);

   void onResizeClose();

   void onShowAdScreen();

   void onUserInteraction(Map var1);
}
