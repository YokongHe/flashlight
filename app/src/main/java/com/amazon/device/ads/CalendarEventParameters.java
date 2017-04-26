package com.amazon.device.ads;

import com.amazon.device.ads.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class CalendarEventParameters {
   public static final String DATE_FORMAT = "yyyy-MM-dd\'T\'HH:mmZZZZZ";
   public static final List DATE_FORMATS = Collections.unmodifiableList(new ArrayList() {
      {
         this.add("yyyy-MM-dd\'T\'HH:mmZZZZZ");
         this.add("yyyy-MM-dd\'T\'HH:mmZ");
         this.add("yyyy-MM-dd\'T\'HH:mm");
         this.add("yyyy-MM-dd");
      }
   });
   private String description;
   private Date end;
   private String location;
   private Date start;
   private String summary;

   public CalendarEventParameters(String var1, String var2, String var3, String var4, String var5) {
      if(StringUtils.isNullOrEmpty(var1)) {
         throw new IllegalArgumentException("No description for event");
      } else {
         this.description = var1;
         this.location = var2;
         this.summary = var3;
         if(StringUtils.isNullOrEmpty(var4)) {
            throw new IllegalArgumentException("No start date for event");
         } else {
            this.start = this.convertToDate(var4);
            if(StringUtils.isNullOrEmpty(var5)) {
               this.end = null;
            } else {
               this.end = this.convertToDate(var5);
            }
         }
      }
   }

   private Date convertToDate(String var1) {
      Iterator var3 = DATE_FORMATS.iterator();

      Date var5;
      while(true) {
         if(!var3.hasNext()) {
            var5 = null;
            break;
         }

         String var2 = (String)var3.next();

         try {
            var5 = (new SimpleDateFormat(var2, Locale.US)).parse(var1);
            break;
         } catch (ParseException var4) {
            ;
         }
      }

      if(var5 == null) {
         throw new IllegalArgumentException("Could not parse datetime string " + var1);
      } else {
         return var5;
      }
   }

   public String getDescription() {
      return this.description;
   }

   public Date getEnd() {
      return this.end;
   }

   public String getLocation() {
      return this.location;
   }

   public Date getStart() {
      return this.start;
   }

   public String getSummary() {
      return this.summary;
   }
}
