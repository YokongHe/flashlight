package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public class StreetViewPanoramaView extends FrameLayout {
   private final com.google.android.gms.maps.d a;

   public StreetViewPanoramaView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a = new com.google.android.gms.maps.d(this, var1, (StreetViewPanoramaOptions)null);
   }

   public StreetViewPanoramaView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a = new com.google.android.gms.maps.d(this, var1, (StreetViewPanoramaOptions)null);
   }
}
