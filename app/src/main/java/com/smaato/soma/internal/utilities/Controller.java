package com.smaato.soma.internal.utilities;

import android.util.Log;
import android.view.View;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;

public class Controller {
   private static int ATTEMPT = 0;
   private static Controller instance;
   private static boolean shouldInit = false;

   public static Controller getInstance() {
      if(instance == null) {
         instance = new Controller();
      }

      return instance;
   }

   private void setShouldInit(boolean var1) {
      shouldInit = var1;
   }

   public boolean isClickInsideView(final View var1, final float var2, final float var3) {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            return var2 >= 0.0F && var2 <= (float)var1.getWidth() && var3 >= 0.0F && var3 <= (float)var1.getHeight()?Boolean.valueOf(true):Boolean.valueOf(false);
         }
      }).execute()).booleanValue();
   }

   public boolean isShouldInit() {
      return shouldInit;
   }

   public void registerProblem() {
      ++ATTEMPT;
      Debugger.showLog(new LogMessage(this.getClass().getCanonicalName(), "Something went wrong !!", 2, DebugCategory.ERROR));
      if(ATTEMPT >= 10) {
         this.setShouldInit(true);
      }

   }

   public void sdkInitSuccess() {
      Log.e("", "INIT SUCCESS");
      ATTEMPT = 0;
      shouldInit = false;
   }
}
