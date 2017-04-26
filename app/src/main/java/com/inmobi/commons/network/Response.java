package com.inmobi.commons.network;

import com.inmobi.commons.network.ErrorCode;
import java.util.Map;

public class Response {
   String a = null;
   int b = 0;
   Map c = null;
   ErrorCode d;

   public Response(ErrorCode var1) {
      this.d = var1;
   }

   public Response(String var1, int var2, Map var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public ErrorCode getError() {
      return this.d;
   }

   public Map getHeaders() {
      return this.c;
   }

   public String getResponseBody() {
      return this.a;
   }

   public int getStatusCode() {
      return this.b;
   }
}
