package com.amazon.device.ads;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringUtils {
   private static final String LOGTAG = StringUtils.class.getSimpleName();

   public static boolean containsRegEx(String var0, String var1) {
      return Pattern.compile(var0).matcher(var1).find();
   }

   protected static boolean doesExceptionContainLockedDatabaseMessage(Exception var0) {
      return var0 != null && var0.getMessage() != null?var0.getMessage().contains("database is locked"):false;
   }

   public static String getFirstMatch(String var0, String var1) {
      Matcher var2 = Pattern.compile(var0).matcher(var1);
      return var2.find()?var2.group():null;
   }

   public static final boolean isNullOrEmpty(String var0) {
      return var0 == null || var0.equals("");
   }

   public static final boolean isNullOrWhiteSpace(String var0) {
      return isNullOrEmpty(var0) || var0.trim().equals("");
   }

   public static String readStringFromInputStream(InputStream param0) {
      // $FF: Couldn't be decompiled
   }

   public static String sha1(String param0) {
      // $FF: Couldn't be decompiled
   }
}
