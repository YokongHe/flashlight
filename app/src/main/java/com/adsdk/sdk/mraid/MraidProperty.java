package com.adsdk.sdk.mraid;

abstract class MraidProperty {
   private String sanitize(String var1) {
      return var1 != null?var1.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\\'\\\"]", ""):"";
   }

   public abstract String toJsonPair();

   public String toString() {
      return this.sanitize(this.toJsonPair());
   }
}
