package com.amazon.device.ads;

import com.amazon.device.ads.WebRequest;
import java.io.InputStream;

class WebRequest$WebRequestInputStream extends InputStream {
   private final InputStream decoratedStream;
   // $FF: synthetic field
   final WebRequest this$0;

   public WebRequest$WebRequestInputStream(WebRequest var1, InputStream var2) {
      this.this$0 = var1;
      this.decoratedStream = var2;
   }

   public void close() {
      this.decoratedStream.close();
      if(WebRequest.access$000(this.this$0)) {
         this.this$0.closeConnection();
      }

   }

   public int read() {
      return this.decoratedStream.read();
   }
}
