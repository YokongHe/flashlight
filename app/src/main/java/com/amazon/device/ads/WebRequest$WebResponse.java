package com.amazon.device.ads;

import com.amazon.device.ads.ResponseReader;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$WebRequestInputStream;
import java.io.InputStream;

public class WebRequest$WebResponse {
   private String httpStatus;
   private int httpStatusCode;
   private WebRequest$WebRequestInputStream inputStream;
   // $FF: synthetic field
   final WebRequest this$0;

   protected WebRequest$WebResponse(WebRequest var1) {
      this.this$0 = var1;
   }

   public String getHttpStatus() {
      return this.httpStatus;
   }

   public int getHttpStatusCode() {
      return this.httpStatusCode;
   }

   public ResponseReader getResponseReader() {
      ResponseReader var1 = new ResponseReader(this.inputStream);
      var1.enableLog(this.this$0.logResponseEnabled);
      var1.setExternalLogTag(this.this$0.getLogTag());
      return var1;
   }

   public boolean isHttpStatusCodeOK() {
      return this.getHttpStatusCode() == 200;
   }

   protected void setHttpStatus(String var1) {
      this.httpStatus = var1;
   }

   protected void setHttpStatusCode(int var1) {
      this.httpStatusCode = var1;
   }

   protected void setInputStream(InputStream var1) {
      this.inputStream = new WebRequest$WebRequestInputStream(this.this$0, var1);
   }
}
