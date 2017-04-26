package com.millennialmedia.android;

import com.millennialmedia.android.CachedAd;
import java.io.ObjectInputStream;
import java.util.Date;

class AdCache$Iterator {
   static final int ITERATE_ID = 0;
   static final int ITERATE_INFO = 1;
   static final int ITERATE_OBJECT = 2;

   boolean callback(CachedAd var1) {
      return false;
   }

   boolean callback(String var1) {
      return false;
   }

   boolean callback(String var1, int var2, Date var3, String var4, long var5, ObjectInputStream var7) {
      return false;
   }

   void done() {
   }
}
