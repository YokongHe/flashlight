package com.smaato.soma.twister.utilities;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.internal.requests.settings.DeviceDataCollector;
import com.smaato.soma.twister.external.Rotate3dYAxisAnimation;
import com.smaato.soma.twister.utilities.AnimationProvider;

public class AnimationRotate3DYAxis extends AnimationProvider {
   public AnimationRotate3DYAxis(int var1) {
      super(var1);
   }

   public Animation getInAnimation() {
      return (Animation)(new CrashReportTemplate() {
         public Animation process() {
            Rotate3dYAxisAnimation var1 = new Rotate3dYAxisAnimation(90.0F, 0.0F, (float)(DeviceDataCollector.getInstance().getScreenWidth() / 2), 90.0F, 180.0F, false);
            var1.reset();
            var1.setDuration(1000L);
            var1.setFillAfter(true);
            var1.setInterpolator(new AccelerateInterpolator());
            return var1;
         }
      }).execute();
   }

   public Animation getOutAnimation() {
      return (Animation)(new CrashReportTemplate() {
         public Animation process() {
            Rotate3dYAxisAnimation var1 = new Rotate3dYAxisAnimation(0.0F, 90.0F, (float)(DeviceDataCollector.getInstance().getScreenWidth() / 2), 90.0F, 180.0F, true);
            var1.reset();
            var1.setDuration(1000L);
            var1.setFillAfter(true);
            var1.setInterpolator(new AccelerateInterpolator());
            return var1;
         }
      }).execute();
   }
}
