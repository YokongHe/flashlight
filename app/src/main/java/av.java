public abstract class av {
   private int a;

   public av(int var1) {
      this.a = var1;
   }

   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if(var1.getClass().getName().equals(this.getClass().getName())) {
         var2 = var3;
         if(((av)var1).a == this.a) {
            var2 = true;
         }
      }

      return var2;
   }
}
