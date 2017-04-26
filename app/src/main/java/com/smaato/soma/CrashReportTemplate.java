package com.smaato.soma;

import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.internal.utilities.Controller;

public abstract class CrashReportTemplate {
   public Object execute() {
      try {
         Object var1 = this.process();
         return var1;
      } catch (Throwable var2) {
         Debugger.showLog(new LogMessage("Error", "Crash Detected", 2, DebugCategory.EXCEPTION, var2));
         Controller.getInstance().registerProblem();
         return null;
      }
   }

   public abstract Object process();
}
