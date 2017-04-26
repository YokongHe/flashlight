package com.smaato.soma.internal.utilities;

import com.smaato.soma.exception.InvalidDateException;
import com.smaato.soma.exception.UnableToGetIsoDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class DateParser {
   private static boolean check(StringTokenizer var0, String var1) {
      try {
         if(var0.nextToken().equals(var1)) {
            return true;
         } else {
            throw new InvalidDateException("Missing [" + var1 + "]");
         }
      } catch (NoSuchElementException var2) {
         return false;
      } catch (InvalidDateException var3) {
         var3.printStackTrace();
         return false;
      }
   }

   private static Calendar getCalendar(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static String getIsoDate(Date var0) {
      try {
         GregorianCalendar var1 = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
         var1.setTime(var0);
         StringBuffer var4 = new StringBuffer();
         var4.append(var1.get(1));
         var4.append("-");
         var4.append(twoDigit(var1.get(2) + 1));
         var4.append("-");
         var4.append(twoDigit(var1.get(5)));
         var4.append("T");
         var4.append(twoDigit(var1.get(11)));
         var4.append(":");
         var4.append(twoDigit(var1.get(12)));
         var4.append(":");
         var4.append(twoDigit(var1.get(13)));
         var4.append(".");
         var4.append(twoDigit(var1.get(14) / 10));
         var4.append("Z");
         String var5 = var4.toString();
         return var5;
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new UnableToGetIsoDateFormat(var3);
      }
   }

   public static Date parse(String var0) {
      return getCalendar(var0).getTime();
   }

   private static String twoDigit(int var0) {
      return var0 >= 0 && var0 < 10?"0" + String.valueOf(var0):String.valueOf(var0);
   }
}
