package com.flurry.sdk;

import com.flurry.sdk.ii;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ri extends DateFormat {
   protected static final String[] a = new String[]{"yyyy-MM-dd\'T\'HH:mm:ss.SSSZ", "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
   protected static final DateFormat b;
   protected static final DateFormat c;
   protected static final DateFormat d;
   protected static final DateFormat e;
   public static final ri f;
   protected transient DateFormat g;
   protected transient DateFormat h;
   protected transient DateFormat i;
   protected transient DateFormat j;

   static {
      TimeZone var0 = TimeZone.getTimeZone("GMT");
      SimpleDateFormat var1 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
      b = var1;
      var1.setTimeZone(var0);
      var1 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSSZ");
      c = var1;
      var1.setTimeZone(var0);
      var1 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'");
      d = var1;
      var1.setTimeZone(var0);
      var1 = new SimpleDateFormat("yyyy-MM-dd");
      e = var1;
      var1.setTimeZone(var0);
      f = new ri();
   }

   private static final boolean b(String var0) {
      int var1 = var0.length();
      if(var1 >= 6) {
         char var2 = var0.charAt(var1 - 6);
         if(var2 == 43 || var2 == 45) {
            return true;
         }

         var2 = var0.charAt(var1 - 5);
         if(var2 == 43 || var2 == 45) {
            return true;
         }

         char var3 = var0.charAt(var1 - 3);
         if(var3 == 43 || var3 == 45) {
            return true;
         }
      }

      return false;
   }

   public ri a() {
      return new ri();
   }

   protected Date a(String var1, ParsePosition var2) {
      int var4 = var1.length();
      char var3 = var1.charAt(var4 - 1);
      DateFormat var6;
      String var7;
      DateFormat var8;
      if(var4 <= 10 && Character.isDigit(var3)) {
         var8 = this.j;
         var6 = var8;
         var7 = var1;
         if(var8 == null) {
            var6 = (DateFormat)e.clone();
            this.j = var6;
            var7 = var1;
         }
      } else {
         StringBuilder var9;
         if(var3 == 90) {
            var6 = this.i;
            var8 = var6;
            if(var6 == null) {
               var8 = (DateFormat)d.clone();
               this.i = var8;
            }

            var6 = var8;
            var7 = var1;
            if(var1.charAt(var4 - 4) == 58) {
               var9 = new StringBuilder(var1);
               var9.insert(var4 - 1, ".000");
               var7 = var9.toString();
               var6 = var8;
            }
         } else if(b(var1)) {
            char var5 = var1.charAt(var4 - 3);
            String var10;
            if(var5 == 58) {
               var9 = new StringBuilder(var1);
               var9.delete(var4 - 3, var4 - 2);
               var10 = var9.toString();
            } else {
               label54: {
                  if(var5 != 43) {
                     var10 = var1;
                     if(var5 != 45) {
                        break label54;
                     }
                  }

                  var10 = var1 + "00";
               }
            }

            var4 = var10.length();
            var1 = var10;
            if(Character.isDigit(var10.charAt(var4 - 9))) {
               var9 = new StringBuilder(var10);
               var9.insert(var4 - 5, ".000");
               var1 = var9.toString();
            }

            var6 = this.h;
            var7 = var1;
            if(this.h == null) {
               var6 = (DateFormat)c.clone();
               this.h = var6;
               var7 = var1;
            }
         } else {
            StringBuilder var11 = new StringBuilder(var1);
            if(var4 - var1.lastIndexOf(84) - 1 <= 8) {
               var11.append(".000");
            }

            var11.append('Z');
            var1 = var11.toString();
            var8 = this.i;
            var6 = var8;
            var7 = var1;
            if(var8 == null) {
               var6 = (DateFormat)d.clone();
               this.i = var6;
               var7 = var1;
            }
         }
      }

      return var6.parse(var7, var2);
   }

   protected boolean a(String var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if(var1.length() >= 5) {
         var2 = var3;
         if(Character.isDigit(var1.charAt(0))) {
            var2 = var3;
            if(Character.isDigit(var1.charAt(3))) {
               var2 = var3;
               if(var1.charAt(4) == 45) {
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   protected Date b(String var1, ParsePosition var2) {
      if(this.g == null) {
         this.g = (DateFormat)b.clone();
      }

      return this.g.parse(var1, var2);
   }

   // $FF: synthetic method
   public Object clone() {
      return this.a();
   }

   public StringBuffer format(Date var1, StringBuffer var2, FieldPosition var3) {
      if(this.h == null) {
         this.h = (DateFormat)c.clone();
      }

      return this.h.format(var1, var2, var3);
   }

   public Date parse(String var1) {
      var1 = var1.trim();
      ParsePosition var4 = new ParsePosition(0);
      Date var5 = this.parse(var1, var4);
      if(var5 != null) {
         return var5;
      } else {
         StringBuilder var8 = new StringBuilder();
         String[] var6 = a;
         int var3 = var6.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            String var7 = var6[var2];
            if(var8.length() > 0) {
               var8.append("\", \"");
            } else {
               var8.append('\"');
            }

            var8.append(var7);
         }

         var8.append('\"');
         throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", new Object[]{var1, var8.toString()}), var4.getErrorIndex());
      }
   }

   public Date parse(String var1, ParsePosition var2) {
      if(this.a(var1)) {
         return this.a(var1, var2);
      } else {
         int var3 = var1.length();

         int var4;
         char var5;
         do {
            var4 = var3 - 1;
            if(var4 < 0) {
               break;
            }

            var5 = var1.charAt(var4);
            if(var5 < 48) {
               break;
            }

            var3 = var4;
         } while(var5 <= 57);

         return var4 < 0 && ii.a(var1, false)?new Date(Long.parseLong(var1)):this.b(var1, var2);
      }
   }
}
