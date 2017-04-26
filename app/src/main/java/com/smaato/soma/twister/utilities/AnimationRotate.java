package com.smaato.soma.twister.utilities;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.internal.requests.settings.DeviceDataCollector;
import com.smaato.soma.twister.utilities.AnimationProvider;

public class AnimationRotate extends AnimationProvider {
   public AnimationRotate(int var1) {
      super(var1);
   }

   public Animation getInAnimation() {
      return (Animation)(new CrashReportTemplate() {
         public Animation process() {
            RotateAnimation var1 = new RotateAnimation(-180.0F, 0.0F, (float)(DeviceDataCollector.getInstance().getScreenWidth() / 2), 0.0F);
            var1.setDuration(1000L);
            return var1;
         }
      }).execute();
   }

   public Animation getOutAnimation() {
      return (Animation)(new CrashReportTemplate() {
         public Animation process() {
            RotateAnimation var1 = new RotateAnimation(0.0F, 180.0F, (float)(DeviceDataCollector.getInstance().getScreenWidth() / 2), 0.0F);
            var1.setDuration(1000L);
            return var1;
         }
      }).execute();
   }
}
