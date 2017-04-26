import java.util.Vector;

public class cs implements ck {
   private static final ae a = bh.a(cs.class);
   private Vector b;

   public cs() {
      if(a.b()) {
         a.b((Object)"AlternativeImpl()");
      }

      this.b = new Vector();
   }

   public cs(Vector var1) {
      if(a.b()) {
         a.b((Object)"AlternativeImpl(Vector)");
      }

      this.b = var1;
   }

   private cv b(int var1) {
      return (cv)this.b.elementAt(var1);
   }

   public static void b() {
   }

   public final int a() {
      int var1 = 0;
      int var3 = 0;
      int var4 = this.b.size();
      if(var4 != 0) {
         int var2 = 0;

         while(true) {
            var3 = var1;
            if(var2 >= var4) {
               break;
            }

            var3 = var1;
            if(!this.b(var2).f()) {
               var3 = var1 + 1;
            }

            ++var2;
            var1 = var3;
         }
      }

      return var3;
   }

   public final cq a(int var1) {
      int var3 = -1;
      int var2 = -1;

      cv var5;
      while(true) {
         if(var3 == var1) {
            cv var6 = this.b(var2);
            if(var2 + 1 < this.b.size() && this.b(var2 + 1).f()) {
               this.b(var2 + 1);
            }

            var5 = var6;
            if(var2 != 0) {
               var5 = var6;
               if(this.b(var2 - 1).f()) {
                  this.b(var2 - 1);
                  return var6;
               }
            }
            break;
         }

         int var4 = var2 + 1;
         if(var4 > this.b.size()) {
            var5 = null;
            break;
         }

         var2 = var4;
         if(!this.b(var4).f()) {
            ++var3;
            var2 = var4;
         }
      }

      return var5;
   }

   public String toString() {
      if(this.b.size() == 0) {
         return "";
      } else {
         StringBuffer var2 = new StringBuffer("");

         for(int var1 = 0; var1 < this.b.size(); ++var1) {
            var2.append(this.b.elementAt(var1));
         }

         return var2.toString();
      }
   }
}
