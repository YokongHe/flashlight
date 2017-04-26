package com.smaato.soma.internal.utilities;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.internal.utilities.SomaCalendar;

public class CalendarEventCreator {
   String TAG = "CalendarEventCreator";
   Context mContext;
   SomaCalendar mSomaCalendar;

   public CalendarEventCreator(final SomaCalendar var1, final Context var2) {
      (new CrashReportTemplate() {
         public Void process() {
            CalendarEventCreator.this.mSomaCalendar = var1;
            CalendarEventCreator.this.mContext = var2;
            if(VERSION.SDK_INT >= 14) {
               CalendarEventCreator.this.addCalendarSDK14();
            } else {
               Toast.makeText(CalendarEventCreator.this.mContext, "Oups ! This feature is not supported by your device", 0).show();
            }

            return null;
         }
      }).execute();
   }

   private void addCalendarSDK14() {
      // $FF: Couldn't be decompiled
   }
}
