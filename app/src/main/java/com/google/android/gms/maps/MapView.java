package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.GoogleMapOptions;

public class MapView extends FrameLayout {
   private final com.google.android.gms.maps.b a;

   public MapView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a = new com.google.android.gms.maps.b(this, var1, GoogleMapOptions.a(var1, var2));
   }

   public MapView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a = new com.google.android.gms.maps.b(this, var1, GoogleMapOptions.a(var1, var2));
   }
}
