package com.mopub.mobileads.dfp.adapters;

import java.util.HashMap;
import java.util.Map;

public final class MoPubExtras implements com.google.a.a.j {
   private Map mExtras;

   public MoPubExtras() {
      this.eraseExtras();
   }

   public final MoPubExtras addExtra(String var1, Object var2) {
      this.mExtras.put(var1, var2);
      return this;
   }

   public final MoPubExtras eraseExtras() {
      this.mExtras = new HashMap();
      return this;
   }

   public final Map getExtras() {
      return this.mExtras;
   }

   public final MoPubExtras setExtras(Map var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Extras cannot be empty");
      } else {
         this.mExtras = var1;
         return this;
      }
   }
}
