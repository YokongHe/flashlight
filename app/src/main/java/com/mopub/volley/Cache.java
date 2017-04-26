package com.mopub.volley;

import com.mopub.volley.Cache$Entry;

public interface Cache {
   void clear();

   Cache$Entry get(String var1);

   void initialize();

   void invalidate(String var1, boolean var2);

   void put(String var1, Cache$Entry var2);

   void remove(String var1);
}
