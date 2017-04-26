package com.smaato.soma.twister.utilities;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.internal.requests.settings.DeviceDataCollector;
import com.smaato.soma.twister.utilities.AnimationProvider;

public class AnimationTranslate extends AnimationProvider {
   public AnimationTranslate(int var1) {
      super(var1);
   }

   public Animation getInAnimation() {
      return (Animation)(new CrashReportTemplate() {
         public Animation process() {
            TranslateAnimation var1 = new TranslateAnimation((float)(-DeviceDataCollector.getInstance().getScreenWidth()), 0.0F, 0.0F, 0.0F);
            var1.setDuration((long)AnimationTranslate.this.duration);
            return var1;
         }
      }).execute();
   }

   public Animation getOutAnimation() {
      return (Animation)(new CrashReportTemplate() {
         public Animation process() {
            TranslateAnimation var1 = new TranslateAnimation(0.0F, (float)DeviceDataCollector.getInstance().getScreenWidth(), 0.0F, 0.0F);
            var1.setDuration((long)AnimationTranslate.this.duration);
            return var1;
         }
      }).execute();
   }
}
