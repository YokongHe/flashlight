package com.mopub.volley;

import java.util.Collections;
import java.util.Map;

public class Cache$Entry {
   public byte[] data;
   public String etag;
   public Map responseHeaders = Collections.emptyMap();
   public long serverDate;
   public long softTtl;
   public long ttl;

   public boolean isExpired() {
      return this.ttl < System.currentTimeMillis();
   }

   public boolean refreshNeeded() {
      return this.softTtl < System.currentTimeMillis();
   }
}
