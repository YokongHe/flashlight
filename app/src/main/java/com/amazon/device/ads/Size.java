package com.amazon.device.ads;

class Size {
   private final int height;
   private final int width;

   public Size(int var1, int var2) {
      this.width = var1;
      this.height = var2;
   }

   public Size(String var1) {
      int var2;
      int var3;
      label14: {
         var2 = 0;
         super();
         if(var1 != null) {
            String[] var4 = var1.split("x");
            if(var4 != null && var4.length == 2) {
               var3 = Math.max(parseInt(var4[0], 0), 0);
               var2 = Math.max(parseInt(var4[1], 0), 0);
               break label14;
            }
         }

         var3 = 0;
      }

      this.width = var3;
      this.height = var2;
   }

   private static int parseInt(String var0, int var1) {
      try {
         int var2 = Integer.parseInt(var0);
         return var2;
      } catch (NumberFormatException var3) {
         return var1;
      }
   }

   public int getHeight() {
      return this.height;
   }

   public int getWidth() {
      return this.width;
   }

   public String toString() {
      return this.width + "x" + this.height;
   }
}
