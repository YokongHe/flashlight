package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import com.inneractive.api.ads.sdk.IAdefines$ApiLevel;

final class af extends com.inneractive.api.ads.sdk.ae {
   public af(Context var1) {
      super(var1);
      this.setId(800);
      this.setText("Visit Us >");
      GradientDrawable var4 = new GradientDrawable();
      var4.mutate();
      var4.setShape(0);
      var4.setColor(-870178270);
      if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.g)) {
         this.setBackground(var4);
      } else {
         this.setBackgroundDrawable(var4);
      }

      int var2 = com.inneractive.api.ads.sdk.an.b(var1, 15);
      int var3 = com.inneractive.api.ads.sdk.an.b(var1, 8);
      this.setPadding(var2, var3, var2, var3);
   }

   protected final void onDraw(Canvas var1) {
      super.onDraw(var1);
   }
}
