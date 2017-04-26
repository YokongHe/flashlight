package com.flurry.sdk;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;

public enum en$a {
   a,
   b,
   c,
   d,
   e,
   f;

   public final HttpRequestBase a(String var1) {
      switch(null.a[this.ordinal()]) {
      case 1:
         return new HttpPost(var1);
      case 2:
         return new HttpPut(var1);
      case 3:
         return new HttpDelete(var1);
      case 4:
         return new HttpHead(var1);
      case 5:
         return new HttpGet(var1);
      default:
         return null;
      }
   }

   public final String toString() {
      switch(null.a[this.ordinal()]) {
      case 1:
         return "POST";
      case 2:
         return "PUT";
      case 3:
         return "DELETE";
      case 4:
         return "HEAD";
      case 5:
         return "GET";
      default:
         return null;
      }
   }
}
