import java.util.ArrayList;

public abstract class aA {
   private final ArrayList a;

   public aA(int var1) {
      this.a = new ArrayList(var1);
   }

   // $FF: synthetic method
   static ArrayList a(aA var0) {
      return var0.a;
   }

   public final Object a(int var1) {
      return this.a.get(var1);
   }

   public final void a(Object var1) {
      this.a.add(var1);
   }

   public final void b(Object var1) {
      this.a.remove(var1);
   }

   public final boolean c(Object var1) {
      return this.a.contains(var1);
   }

   public final Object d() {
      return this.a.remove(0);
   }

   public final void e() {
      this.a.clear();
   }

   public final int f() {
      return this.a.size();
   }
}
