import java.util.Hashtable;
import java.util.Iterator;

public class aS implements aI {
   private aS a;
   aO b;
   aL c;
   int d;
   private String e;
   private Long f;
   private Hashtable g;

   aS(String var1, aS var2, aO var3, aL var4) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   protected static boolean a(bc var0, String var1, Object var2) {
      aW var4 = new aW();
      String var3;
      if(var2 instanceof byte[]) {
         var3 = "bin";
      } else if(var2 instanceof Boolean) {
         var3 = "bool";
      } else if(var2 instanceof Double) {
         var3 = "float";
      } else if(var2 instanceof Integer) {
         var3 = "int";
      } else if(var2 instanceof Long) {
         var3 = "long";
      } else if(var2 instanceof String) {
         var3 = "str";
      } else if(var2 instanceof aI) {
         var3 = "str";
      } else {
         var3 = "unknown";
      }

      if(var3.compareTo("unknown") == 0) {
         return false;
      } else {
         var4.a("t", var3);
         var4.a("k", var1);
         if(var2 instanceof byte[]) {
            var4.a("v", (byte[])var2);
         } else if(var2 instanceof Boolean) {
            var4.a("v", ((Boolean)var2).toString());
         } else if(var2 instanceof Double) {
            var4.a("v", ((Double)var2).toString());
         } else if(var2 instanceof Integer) {
            var4.b("v", ((Integer)var2).intValue());
         } else if(var2 instanceof Long) {
            var4.a("v", ((Long)var2).toString());
         } else if(var2 instanceof String) {
            var4.b("v", (String)var2);
         } else {
            if(!(var2 instanceof aI)) {
               return false;
            }

            var4.a("v", ((aS)var2).b.b() + "." + ((aS)var2).d);
         }

         var0.a((bb)var4);
         return true;
      }
   }

   public final aK a(String var1) {
      return aP.a(this, var1);
   }

   protected bc a() {
      aZ var1 = new aZ();
      a(var1, "RootParentId", this.b.b());
      if(this.a != null) {
         a(var1, "ParentSeqId", new Integer(this.a.d));
      }

      a(var1, "SeqId", new Integer(this.d));
      a(var1, "Name", this.e);
      a(var1, "Timestamp", this.f);
      return var1;
   }

   public final void a(Hashtable var1, aR var2) {
      this.g = var1;
      this.f = Long.valueOf(System.currentTimeMillis());
      this.c.a(this, var2);
   }

   protected void c() {
      this.d = this.b.d();
   }

   public final aI e() {
      return this.a;
   }

   public final byte[] f() {
      aW var1 = new aW();
      bc var2 = this.a();
      aZ var3 = new aZ();
      Iterator var4 = this.g.keySet().iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         a(var3, var5, this.g.get(var5));
      }

      var1.a("meta", var2);
      if(var3.a() > 0) {
         var1.a("attr", (bc)var3);
      }

      return ((aW)var1).d();
   }
}
