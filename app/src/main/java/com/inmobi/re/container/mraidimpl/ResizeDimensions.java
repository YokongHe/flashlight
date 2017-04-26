package com.inmobi.re.container.mraidimpl;

public class ResizeDimensions {
   int a;
   int b;
   int c;
   int d;

   public ResizeDimensions(int var1, int var2, int var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public int getHeight() {
      return this.d;
   }

   public int getWidth() {
      return this.c;
   }

   public int getX() {
      return this.a;
   }

   public int getY() {
      return this.b;
   }
}
