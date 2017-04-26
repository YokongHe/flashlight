package com.tapjoy.mraid.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tapjoy.mraid.controller.Abstract$Dimensions;
import com.tapjoy.mraid.controller.Abstract$PlayerProperties;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.MraidPlayer;
import com.tapjoy.mraid.util.Utils;
import com.tapjoy.mraid.view.MraidView$Action;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ActionHandler extends Activity {
   private HashMap a = new HashMap();
   private RelativeLayout b;

   private MraidPlayer a(Bundle var1, MraidView$Action var2) {
      Abstract$PlayerProperties var5 = (Abstract$PlayerProperties)var1.getParcelable("player_properties");
      Abstract$Dimensions var4 = (Abstract$Dimensions)var1.getParcelable("expand_dimensions");
      MraidPlayer var3 = new MraidPlayer(this);
      var3.setPlayData(var5, Utils.getData("expand_url", var1));
      LayoutParams var6;
      if(!var5.inline && var5.startStyle.equals("fullscreen")) {
         this.getWindow().setFlags(1024, 1024);
         this.getWindow().setFlags(16777216, 16777216);
         var6 = new LayoutParams(-1, -1);
         var6.addRule(13);
      } else {
         var6 = new LayoutParams(var4.width, var4.height);
         var6.topMargin = var4.y;
         var6.leftMargin = var4.x;
      }

      var3.setLayoutParams(var6);
      this.b.addView(var3);
      this.a.put(var2, var3);
      var3.setListener(new Player() {
         public final void onComplete() {
            ActionHandler.this.finish();
         }

         public final void onError() {
            ActionHandler.this.finish();
         }

         public final void onPrepared() {
         }
      });
      return var3;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.requestWindowFeature(1);
      var1 = this.getIntent().getExtras();
      this.b = new RelativeLayout(this);
      this.b.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
      this.b.setBackgroundColor(-16777216);
      this.setContentView(this.b);
      String var2 = var1.getString("action");
      if(var2 != null) {
         MraidView$Action var3 = MraidView$Action.valueOf(var2);
         switch(null.a[var3.ordinal()]) {
         case 1:
            this.a(var1, var3).playAudio();
            return;
         case 2:
            this.a(var1, var3).playVideo();
            return;
         }
      }

   }

   protected void onStop() {
      Iterator var1 = this.a.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         switch(null.a[((MraidView$Action)var2.getKey()).ordinal()]) {
         case 1:
         case 2:
            ((MraidPlayer)var2.getValue()).releasePlayer();
         }
      }

      super.onStop();
   }
}
