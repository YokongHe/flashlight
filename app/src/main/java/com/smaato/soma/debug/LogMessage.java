package com.smaato.soma.debug;

import com.smaato.soma.debug.DebugCategory;

public class LogMessage {
   private DebugCategory category;
   private Throwable exception;
   private int level;
   private String msg;
   private String tag;

   public LogMessage(String var1, String var2, int var3, DebugCategory var4) {
      this.tag = var1;
      this.msg = var2;
      this.level = var3;
      this.category = var4;
   }

   public LogMessage(String var1, String var2, int var3, DebugCategory var4, Throwable var5) {
      this.tag = var1;
      this.msg = var2;
      this.level = var3;
      this.category = var4;
      this.exception = var5;
   }

   public final DebugCategory getCategory() {
      return this.category;
   }

   public Throwable getException() {
      return this.exception;
   }

   public final int getLevel() {
      return this.level;
   }

   public final String getMsg() {
      return this.msg;
   }

   public final String getTag() {
      return this.tag;
   }

   public final void setCategory(DebugCategory var1) {
      this.category = var1;
   }

   public void setException(Throwable var1) {
      this.exception = var1;
   }

   public final void setLevel(int var1) {
      this.level = var1;
   }

   public final void setMsg(String var1) {
      this.msg = var1;
   }

   public final void setTag(String var1) {
      this.tag = var1;
   }
}
