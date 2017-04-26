package com.ihs.a.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.FlurryAgent;
import java.util.Map;

public final class b {
   private Context a;
   private String b = com.ihs.a.b.b.b(new String[]{"libCommons", "Analytics", "FlurryKey"});
   private boolean c = false;

   public final void a() {
      if(this.c) {
         this.c = false;
         FlurryAgent.onEndSession(this.a);
      }
   }

   public final void a(Context var1) {
      if(!this.c && !TextUtils.isEmpty(this.b)) {
         this.a = var1;
         this.c = true;
         FlurryAgent.setCaptureUncaughtExceptions(true);
         FlurryAgent.onStartSession(var1, this.b);
         FlurryAgent.setLogEnabled(true);
         FlurryAgent.setLogEvents(true);
      }
   }

   public final void a(String var1, Map var2) {
      if(var1 != null) {
         boolean var3 = this.c;
         FlurryAgent.logEvent(var1, var2);
      }
   }
}
