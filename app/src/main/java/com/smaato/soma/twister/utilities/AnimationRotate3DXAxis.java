package com.smaato.soma.twister.utilities;

import android.view.animation.Animation;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.twister.external.Rotate3dXAxisAnimation;
import com.smaato.soma.twister.utilities.AnimationProvider;

public class AnimationRotate3DXAxis extends AnimationProvider {
   public AnimationRotate3DXAxis(int var1) {
      super(var1);
   }

   public Animation getInAnimation() {
      return (Animation)(new CrashReportTemplate() {
         public Animation process() {
            Rotate3dXAxisAnimation var1 = new Rotate3dXAxisAnimation(180.0F, 0.0F, 0.0F, 35.0F, 0.0F, false);
            var1.setDuration(1000L);
            var1.setFillEnabled(false);
            return var1;
         }
      }).execute();
   }

   public Animation getOutAnimation() {
      return (Animation)(new CrashReportTemplate() {
         public Animation process() {
            Rotate3dXAxisAnimation var1 = new Rotate3dXAxisAnimation(0.0F, 180.0F, 0.0F, 35.0F, 0.0F, false);
            var1.setDuration(1000L);
            var1.setFillEnabled(false);
            return var1;
         }
      }).execute();
   }
}
