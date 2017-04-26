import java.util.Iterator;

public abstract class aB {
   private final Iterator a;

   public aB(aA var1) {
      this.a = aA.a(var1).iterator();
   }

   public final boolean a() {
      return this.a.hasNext();
   }

   public final Object b() {
      return this.a.next();
   }
}
