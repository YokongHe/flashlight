package com.flurry.sdk;

import android.view.ViewGroup.LayoutParams;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.sdk.eo;
import com.flurry.sdk.j$c;

final class j$a extends j$c {
   j$a() {
      super(null);
   }

   public final LayoutParams a(AdSpaceLayout var1) {
      eo.a(5, com.flurry.sdk.j.a(), "AbsoluteLayout is deprecated, please consider to use FrameLayout or RelativeLayout for banner ad container view");
      return new android.widget.AbsoluteLayout.LayoutParams(this.b(var1), this.c(var1), 0, 0);
   }
}
