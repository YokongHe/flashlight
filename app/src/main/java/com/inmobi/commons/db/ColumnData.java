package com.inmobi.commons.db;

import com.inmobi.commons.db.ColumnData$ColumnType;

public class ColumnData {
   private boolean a = false;
   private boolean b = false;
   private boolean c = false;
   private ColumnData$ColumnType d;

   public ColumnData$ColumnType getDataType() {
      return this.d;
   }

   public boolean isAutoIncrement() {
      return this.b;
   }

   public boolean isMandatory() {
      return this.c;
   }

   public boolean isPrimaryKey() {
      return this.a;
   }

   public void setAutoIncrement(boolean var1) {
      this.b = var1;
   }

   public void setDataType(ColumnData$ColumnType var1) {
      this.d = var1;
   }

   public void setMandatory(boolean var1) {
      this.c = var1;
   }

   public void setPrimaryKey(boolean var1) {
      this.a = var1;
   }
}
