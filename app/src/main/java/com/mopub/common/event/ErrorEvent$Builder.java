package com.mopub.common.event;

import com.mopub.common.event.BaseEvent$Builder;
import com.mopub.common.event.ErrorEvent;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorEvent$Builder extends BaseEvent$Builder {
   private String mErrorClassName;
   private String mErrorExceptionClassName;
   private String mErrorFileName;
   private Integer mErrorLineNumber;
   private String mErrorMessage;
   private String mErrorMethodName;
   private String mErrorStackTrace;

   public ErrorEvent$Builder(String var1, String var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   static String access$16(ErrorEvent$Builder var0) {
      return var0.mErrorExceptionClassName;
   }

   // $FF: synthetic method
   static String access$17(ErrorEvent$Builder var0) {
      return var0.mErrorMessage;
   }

   // $FF: synthetic method
   static String access$18(ErrorEvent$Builder var0) {
      return var0.mErrorStackTrace;
   }

   // $FF: synthetic method
   static String access$19(ErrorEvent$Builder var0) {
      return var0.mErrorFileName;
   }

   // $FF: synthetic method
   static String access$20(ErrorEvent$Builder var0) {
      return var0.mErrorClassName;
   }

   // $FF: synthetic method
   static String access$21(ErrorEvent$Builder var0) {
      return var0.mErrorMethodName;
   }

   // $FF: synthetic method
   static Integer access$22(ErrorEvent$Builder var0) {
      return var0.mErrorLineNumber;
   }

   public ErrorEvent build() {
      return new ErrorEvent(this, (ErrorEvent)null);
   }

   public ErrorEvent$Builder withErrorClassName(String var1) {
      this.mErrorClassName = var1;
      return this;
   }

   public ErrorEvent$Builder withErrorExceptionClassName(String var1) {
      this.mErrorExceptionClassName = var1;
      return this;
   }

   public ErrorEvent$Builder withErrorFileName(String var1) {
      this.mErrorFileName = var1;
      return this;
   }

   public ErrorEvent$Builder withErrorLineNumber(Integer var1) {
      this.mErrorLineNumber = var1;
      return this;
   }

   public ErrorEvent$Builder withErrorMessage(String var1) {
      this.mErrorMessage = var1;
      return this;
   }

   public ErrorEvent$Builder withErrorMethodName(String var1) {
      this.mErrorMethodName = var1;
      return this;
   }

   public ErrorEvent$Builder withErrorStackTrace(String var1) {
      this.mErrorStackTrace = var1;
      return this;
   }

   public ErrorEvent$Builder withException(Exception var1) {
      this.mErrorExceptionClassName = var1.getClass().getName();
      this.mErrorMessage = var1.getMessage();
      StringWriter var2 = new StringWriter();
      var1.printStackTrace(new PrintWriter(var2));
      this.mErrorStackTrace = var2.toString();
      if(var1.getStackTrace().length > 0) {
         this.mErrorFileName = var1.getStackTrace()[0].getFileName();
         this.mErrorClassName = var1.getStackTrace()[0].getClassName();
         this.mErrorMethodName = var1.getStackTrace()[0].getMethodName();
         this.mErrorLineNumber = Integer.valueOf(var1.getStackTrace()[0].getLineNumber());
      }

      return this;
   }
}
