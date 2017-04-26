package com.appsflyer;

import java.util.Date;

public class DebugLogQueue$Item {
   private String msg;
   private long timestamp;

   public DebugLogQueue$Item(String var1) {
      this.msg = var1;
      this.timestamp = (new Date()).getTime();
   }

   public String getMsg() {
      return this.msg;
   }

   public long getTimestamp() {
      return this.timestamp;
   }
}
