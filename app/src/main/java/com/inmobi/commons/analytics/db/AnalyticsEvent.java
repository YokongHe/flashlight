package com.inmobi.commons.analytics.db;

import com.inmobi.commons.analytics.db.AnalyticsEvent$TRANSACTION_ITEM_TYPE;
import com.inmobi.commons.analytics.db.AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE;

public class AnalyticsEvent {
   public static final String EVENT_ID = "id";
   public static final String IN_APP = "inapp";
   public static final String SUBS = "subs";
   public static final String TYPE_CUSTOM_EVENT = "ce";
   public static final String TYPE_END_SESSION = "es";
   public static final String TYPE_LEVEL_BEGIN = "lb";
   public static final String TYPE_LEVEL_END = "le";
   public static final String TYPE_START_SESSION = "ss";
   public static final String TYPE_TAG_TRANSACTION = "pi";
   public static final String TYPE_USER_ATTRIBUTE = "ae";
   private long a;
   private String b;
   private String c;
   private long d;
   private String e;
   private String f;
   private String g;
   private String h;
   private String i;
   private String j;
   private String k;
   private String l;
   private String m;
   private String n;
   private AnalyticsEvent$TRANSACTION_ITEM_TYPE o;
   private double p;
   private int q;
   private String r;
   private String s;
   private String t;
   private AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE u;
   private long v;
   private long w;
   private String x;
   private String y;

   public AnalyticsEvent(String var1) {
      this.b = var1;
   }

   public String getAttributeName() {
      return this.x;
   }

   public String getAttributeValue() {
      return this.y;
   }

   public String getEventAttemptCount() {
      return this.j;
   }

   public String getEventAttemptTime() {
      return this.k;
   }

   public String getEventAttributeMap() {
      return this.e;
   }

   public String getEventCustomName() {
      return this.l;
   }

   public long getEventId() {
      return this.a;
   }

   public String getEventLevelId() {
      return this.f;
   }

   public String getEventLevelName() {
      return this.g;
   }

   public String getEventLevelStatus() {
      return this.h;
   }

   public String getEventSessionId() {
      return this.c;
   }

   public long getEventSessionTimeStamp() {
      return this.d;
   }

   public long getEventTableId() {
      return this.w;
   }

   public long getEventTimeStamp() {
      return this.v;
   }

   public String getEventTimeTaken() {
      return this.i;
   }

   public String getEventType() {
      return this.b;
   }

   public String getTransactionCurrencyCode() {
      return this.r;
   }

   public String getTransactionId() {
      return this.t;
   }

   public int getTransactionItemCount() {
      return this.q;
   }

   public String getTransactionItemDescription() {
      return this.n;
   }

   public String getTransactionItemName() {
      return this.m;
   }

   public double getTransactionItemPrice() {
      return this.p;
   }

   public int getTransactionItemType() {
      return this.o == null?AnalyticsEvent$TRANSACTION_ITEM_TYPE.INVALID.getValue():this.o.getValue();
   }

   public String getTransactionProductId() {
      return this.s;
   }

   public int getTransactionStatus() {
      return this.u == null?AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.INVALID.getValue():this.u.getValue();
   }

   public void setEventAttemptCount(String var1) {
      this.j = var1;
   }

   public void setEventAttemptTime(String var1) {
      this.k = var1;
   }

   public void setEventAttributeMap(String var1) {
      this.e = var1;
   }

   public void setEventCustomName(String var1) {
      this.l = var1;
   }

   public void setEventId(long var1) {
      this.a = var1;
   }

   public void setEventLevelId(String var1) {
      this.f = var1;
   }

   public void setEventLevelName(String var1) {
      this.g = var1;
   }

   public void setEventLevelStatus(String var1) {
      this.h = var1;
   }

   public void setEventSessionId(String var1) {
      this.c = var1;
   }

   public void setEventSessionTimeStamp(long var1) {
      this.d = var1;
   }

   public void setEventTableId(long var1) {
      this.w = var1;
   }

   public void setEventTimeStamp(long var1) {
      this.v = var1;
   }

   public void setEventTimeTaken(String var1) {
      this.i = var1;
   }

   public void setTransactionCurrencyCode(String var1) {
      this.r = var1;
   }

   public void setTransactionId(String var1) {
      this.t = var1;
   }

   public void setTransactionItemCount(int var1) {
      this.q = var1;
   }

   public void setTransactionItemDescription(String var1) {
      this.n = var1;
   }

   public void setTransactionItemName(String var1) {
      this.m = var1;
   }

   public void setTransactionItemPrice(double var1) {
      this.p = var1;
   }

   public void setTransactionItemType(int var1) {
      if(AnalyticsEvent$TRANSACTION_ITEM_TYPE.INAPP.getValue() == var1) {
         this.o = AnalyticsEvent$TRANSACTION_ITEM_TYPE.INAPP;
      } else if(AnalyticsEvent$TRANSACTION_ITEM_TYPE.SUBSCRIPTION.getValue() == var1) {
         this.o = AnalyticsEvent$TRANSACTION_ITEM_TYPE.SUBSCRIPTION;
      } else {
         this.o = AnalyticsEvent$TRANSACTION_ITEM_TYPE.INVALID;
      }
   }

   public void setTransactionProductId(String var1) {
      this.s = var1;
   }

   public void setTransactionStatus(int var1) {
      if(AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.PURCHASED.getValue() == var1) {
         this.u = AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.PURCHASED;
      } else if(AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.REFUNDED.getValue() == var1) {
         this.u = AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.REFUNDED;
      } else if(AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.FAILED.getValue() == var1) {
         this.u = AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.FAILED;
      } else {
         this.u = AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.INVALID;
      }
   }

   public void setUserAttribute(String var1, String var2) {
      if(var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         this.x = var1;
         this.y = var2;
      }

   }
}
