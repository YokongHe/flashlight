package com.smaato.soma.internal.utilities;

import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.internal.utilities.HttpUrlRedirect$RetrieveFeedTask;

public class HttpUrlRedirect {
   public static String getFinalUrl(final String var0) {
      return (String)(new CrashReportTemplate() {
         public String process() {
            return (String)(new HttpUrlRedirect$RetrieveFeedTask()).execute(new String[]{var0}).get();
         }
      }).execute();
   }
}
