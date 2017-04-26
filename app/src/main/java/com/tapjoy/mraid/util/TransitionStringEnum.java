package com.tapjoy.mraid.util;

public enum TransitionStringEnum {
   DEFAULT("default"),
   DISSOLVE("dissolve"),
   FADE("fade"),
   NONE("none"),
   ROLL("roll"),
   SLIDE("slide"),
   ZOOM("zoom");

   private String text;

   private TransitionStringEnum(String var3) {
      this.text = var3;
   }

   public static TransitionStringEnum fromString(String var0) {
      if(var0 != null) {
         TransitionStringEnum[] var3 = values();
         int var2 = var3.length;

         for(int var1 = 0; var1 < var2; ++var1) {
            TransitionStringEnum var4 = var3[var1];
            if(var0.equalsIgnoreCase(var4.text)) {
               return var4;
            }
         }
      }

      return null;
   }

   public final String getText() {
      return this.text;
   }
}
