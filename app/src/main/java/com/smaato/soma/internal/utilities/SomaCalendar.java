package com.smaato.soma.internal.utilities;

import com.smaato.soma.CrashReportTemplate;
import org.json.JSONObject;

public class SomaCalendar {
   private String description;
   private String end;
   private String exceptionDates;
   private String frequency;
   private String id;
   private String location;
   private JSONObject recurrence;
   private String start;
   private String status;
   private String summary;

   public SomaCalendar(final JSONObject var1) {
      (new CrashReportTemplate() {
         public Void process() {
            SomaCalendar.this.id = var1.optString("id");
            SomaCalendar.this.summary = var1.optString("summary");
            SomaCalendar.this.description = var1.optString("description");
            SomaCalendar.this.start = var1.optString("start");
            SomaCalendar.this.end = var1.optString("end");
            JSONObject var1x = var1.optJSONObject("recurrence");
            if(var1x != null) {
               SomaCalendar.this.frequency = var1x.optString("frequency");
            }

            SomaCalendar.this.location = var1.optString("location");
            SomaCalendar.this.status = var1.optString("status");
            SomaCalendar.this.exceptionDates = var1.optString("exceptionDates");
            return null;
         }
      }).execute();
   }

   public final String getDescription() {
      return this.description;
   }

   public final String getEnd() {
      return this.end;
   }

   public final String getExceptionDates() {
      return this.exceptionDates;
   }

   public final String getFrequency() {
      return this.frequency;
   }

   public final String getId() {
      return this.id;
   }

   public final String getLocation() {
      return this.location;
   }

   public final JSONObject getRecurrence() {
      return this.recurrence;
   }

   public final String getStart() {
      return this.start;
   }

   public final String getStatus() {
      return this.status;
   }

   public final String getSummary() {
      return this.summary;
   }

   public final void setDescription(String var1) {
      this.description = var1;
   }

   public final void setEnd(String var1) {
      this.end = var1;
   }

   public final void setExceptionDates(String var1) {
      this.exceptionDates = var1;
   }

   public final void setFrequency(String var1) {
      this.frequency = var1;
   }

   public final void setId(String var1) {
      this.id = var1;
   }

   public final void setLocation(String var1) {
      this.location = var1;
   }

   public final void setRecurrence(JSONObject var1) {
      this.recurrence = var1;
   }

   public final void setStart(String var1) {
      this.start = var1;
   }

   public final void setStatus(String var1) {
      this.status = var1;
   }

   public final void setSummary(String var1) {
      this.summary = var1;
   }
}
