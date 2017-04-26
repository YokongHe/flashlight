import java.util.Hashtable;
import java.util.Vector;

public class ct implements cn {
   private static final ae a = bh.a(ct.class);
   private Vector b;

   public ct(Vector var1) {
      if(a.b()) {
         a.b((Object)("Received " + var1.size() + " sentences constituting the dictation result."));
      }

      this.b = var1;

      for(int var2 = 0; var2 < this.b.size(); ++var2) {
         cu var3 = (cu)var1.elementAt(var2);
         var3.a(this);
         var3.c();
      }

   }

   public final int a() {
      return this.b.size();
   }

   public final cp a(int var1) {
      return var1 >= 0 && var1 < this.b.size()?(cp)this.b.elementAt(var1):null;
   }

   final Vector a(cu var1, Vector var2) {
      int var3 = 0;
      if(var2.size() == 0) {
         return new Vector();
      } else {
         long var4 = ((cv)var2.elementAt(0)).c();
         long var6 = ((cv)var2.elementAt(var2.size() - 1)).d();
         if(a.b()) {
            a.b((Object)("Getting alternatives of " + var1 + " at times [" + var4 + ", " + var6 + "]"));
         }

         var2 = new Vector();
         Hashtable var8 = new Hashtable();
         Object var9 = new Object();
         var8.put(var1.a(var4, var6).toString(), var9);

         for(; var3 < this.b.size(); ++var3) {
            cu var10 = (cu)this.b.elementAt(var3);
            if(var10 == var1) {
               if(a.b()) {
                  a.b((Object)("Found the same sentence at index " + var3));
               }
            } else {
               cs var12 = var10.a(var4, var6);
               cs.b();
               if(a.b()) {
                  a.b((Object)("Got alternative [" + var12 + "] for sentence at index " + var3));
               }

               if(var12.a() == 0) {
                  if(a.b()) {
                     a.b((Object)("Got no alternative for sentence at index " + var3));
                  }
               } else {
                  String var11 = var12.toString();
                  if(var8.containsKey(var11)) {
                     if(a.b()) {
                        a.b((Object)"That alternative has already been given by another sentence.");
                     }
                  } else {
                     var8.put(var11, var9);
                     var2.addElement(var12);
                  }
               }
            }
         }

         return var2;
      }
   }

   public String toString() {
      return this.b.size() > 0?this.b.elementAt(0).toString():"";
   }
}
