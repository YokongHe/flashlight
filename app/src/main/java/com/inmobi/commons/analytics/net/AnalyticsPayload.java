package com.inmobi.commons.analytics.net;

import java.util.List;

public class AnalyticsPayload {
   private String a;
   private List b;
   private String c;
   private int d;

   public AnalyticsPayload(String var1, List var2) {
      this.a = var1;
      this.b = var2;
   }

   public String getCompletePayload() {
      return this.c;
   }

   public String getOnlyEvent() {
      return this.a;
   }

   public int getPayloadSize() {
      return this.d;
   }

   public List getTableIdList() {
      return this.b;
   }

   public void setCompletePayload(String var1) {
      this.c = var1;
   }

   public void setPayloadSize(int var1) {
      this.d = var1;
   }
}
