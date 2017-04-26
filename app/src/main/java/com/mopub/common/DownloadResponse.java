package com.mopub.common;

import com.mopub.common.util.ResponseHeader;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class DownloadResponse {
   private byte[] mBytes;
   private final long mContentLength;
   private final Header[] mHeaders;
   private final int mStatusCode;

   public DownloadResponse(HttpResponse param1) {
      // $FF: Couldn't be decompiled
   }

   public byte[] getByteArray() {
      return this.mBytes;
   }

   public long getContentLength() {
      return this.mContentLength;
   }

   public String getFirstHeader(ResponseHeader var1) {
      Header[] var4 = this.mHeaders;
      int var3 = var4.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Header var5 = var4[var2];
         if(var5.getName().equalsIgnoreCase(var1.getKey())) {
            return var5.getValue();
         }
      }

      return null;
   }

   public int getStatusCode() {
      return this.mStatusCode;
   }
}
