package com.amazon.device.ads;

import android.graphics.Rect;
import com.amazon.device.ads.AdListener;

public interface ExtendedAdListener extends AdListener {
   void onAdResized(Rect var1);
}
