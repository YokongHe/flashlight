package com.flurry.sdk;

import android.view.ViewGroup.LayoutParams;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.sdk.j$c;

final class j$b extends j$c {
   j$b() {
      super(null);
   }

   public final LayoutParams a(AdSpaceLayout var1) {
      return new android.widget.FrameLayout.LayoutParams(this.b(var1), this.c(var1), 17);
   }
}
