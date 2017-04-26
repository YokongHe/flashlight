package com.amazon.device.ads;

import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$WebRequestStatus;

public class WebRequest$WebRequestException extends Exception {
   private static final long serialVersionUID = -4980265484926465548L;
   private final WebRequest$WebRequestStatus status;
   // $FF: synthetic field
   final WebRequest this$0;

   protected WebRequest$WebRequestException(WebRequest var1, WebRequest$WebRequestStatus var2, String var3) {
      this(var1, var2, var3, (Throwable)null);
   }

   protected WebRequest$WebRequestException(WebRequest var1, WebRequest$WebRequestStatus var2, String var3, Throwable var4) {
      super(var3, var4);
      this.this$0 = var1;
      this.status = var2;
   }

   public WebRequest$WebRequestStatus getStatus() {
      return this.status;
   }
}
