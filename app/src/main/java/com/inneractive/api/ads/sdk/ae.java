package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;

class ae extends TextView {
   ae(Context var1) {
      super(var1);
      this.setTextColor(-1);
      this.setTextSize(2, 16.0F);
      this.setGravity(16);
      this.setTypeface((Typeface)null, 0);
      this.setShadowLayer(0.5F, 1.5F, 1.0F, -14540254);
   }

   ae(Context var1, boolean var2) {
      this(var1);
   }

   void a(int var1, String var2) {
      int var3 = var1 / 60;
      StringBuilder var4 = new StringBuilder();
      var4.append(var3).append(':');
      var1 %= 60;
      if(var1 < 10) {
         var4.append('0');
      }

      var4.append(var1);
      if(!TextUtils.isEmpty(var2)) {
         var4.append("  ").append(var2);
      }

      this.setText(var4.toString());
   }
}
