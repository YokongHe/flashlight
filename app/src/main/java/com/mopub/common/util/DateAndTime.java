package com.mopub.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateAndTime {
   protected static DateAndTime instance = new DateAndTime();

   public static String getTimeZoneOffsetString() {
      SimpleDateFormat var0 = new SimpleDateFormat("Z", Locale.US);
      var0.setTimeZone(localTimeZone());
      return var0.format(now());
   }

   public static TimeZone localTimeZone() {
      return instance.internalLocalTimeZone();
   }

   public static Date now() {
      return instance.internalNow();
   }

   @Deprecated
   public static void setInstance(DateAndTime var0) {
      instance = var0;
   }

   public TimeZone internalLocalTimeZone() {
      return TimeZone.getDefault();
   }

   public Date internalNow() {
      return new Date();
   }
}
