package com.inmobi.commons.db;

import java.util.LinkedHashMap;

public class TableData {
   private String a;
   private LinkedHashMap b;

   public LinkedHashMap getmColumns() {
      return this.b;
   }

   public String getmTableName() {
      return this.a;
   }

   public void setmColumns(LinkedHashMap var1) {
      this.b = var1;
   }

   public void setmTableName(String var1) {
      this.a = var1;
   }
}
