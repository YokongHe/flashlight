package com.mopub.common.event;

import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.ErrorEvent$Builder;

public class ErrorEvent extends BaseEvent {
   private final String mErrorClassName;
   private final String mErrorExceptionClassName;
   private final String mErrorFileName;
   private final Integer mErrorLineNumber;
   private final String mErrorMessage;
   private final String mErrorMethodName;
   private final String mErrorStackTrace;

   private ErrorEvent(ErrorEvent$Builder var1) {
      super(var1);
      this.mErrorExceptionClassName = ErrorEvent$Builder.access$16(var1);
      this.mErrorMessage = ErrorEvent$Builder.access$17(var1);
      this.mErrorStackTrace = ErrorEvent$Builder.access$18(var1);
      this.mErrorFileName = ErrorEvent$Builder.access$19(var1);
      this.mErrorClassName = ErrorEvent$Builder.access$20(var1);
      this.mErrorMethodName = ErrorEvent$Builder.access$21(var1);
      this.mErrorLineNumber = ErrorEvent$Builder.access$22(var1);
   }

   // $FF: synthetic method
   ErrorEvent(ErrorEvent$Builder var1, ErrorEvent var2) {
      this(var1);
   }

   public String getErrorClassName() {
      return this.mErrorClassName;
   }

   public String getErrorExceptionClassName() {
      return this.mErrorExceptionClassName;
   }

   public String getErrorFileName() {
      return this.mErrorFileName;
   }

   public Integer getErrorLineNumber() {
      return this.mErrorLineNumber;
   }

   public String getErrorMessage() {
      return this.mErrorMessage;
   }

   public String getErrorMethodName() {
      return this.mErrorMethodName;
   }

   public String getErrorStackTrace() {
      return this.mErrorStackTrace;
   }

   public String toString() {
      return super.toString() + "ErrorEvent\nErrorExceptionClassName: " + this.getErrorExceptionClassName() + "\nErrorMessage: " + this.getErrorMessage() + "\nErrorStackTrace: " + this.getErrorStackTrace() + "\nErrorFileName: " + this.getErrorFileName() + "\nErrorClassName: " + this.getErrorClassName() + "\nErrorMethodName: " + this.getErrorMethodName() + "\nErrorLineNumber: " + this.getErrorLineNumber() + "\n";
   }
}
