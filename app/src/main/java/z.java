import java.util.Vector;

public final class z extends aA {
   public z() {
      super(0);
   }

   private z(int var1) {
      super(var1);
   }

   public final A a() {
      return new A(this);
   }

   public final z b() {
      z var1 = new z(this.f());
      A var2 = this.a();

      while(var2.a()) {
         var1.a(var2.b());
      }

      return var1;
   }

   public final Vector c() {
      Vector var1 = new Vector(this.f());
      A var2 = this.a();

      while(var2.a()) {
         var1.addElement(var2.b());
      }

      return var1;
   }
}
