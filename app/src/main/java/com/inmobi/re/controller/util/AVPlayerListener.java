package com.inmobi.re.controller.util;

import com.inmobi.re.controller.util.AVPlayer;

public interface AVPlayerListener {
   void onComplete(AVPlayer var1);

   void onError(AVPlayer var1);

   void onPrepared(AVPlayer var1);
}
