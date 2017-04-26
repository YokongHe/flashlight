import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Bytes;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Integer;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Sequence;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class cT {
   private final int a;
   private final int b;
   private final String c;
   private final byte[] d;
   private final Map e;
   private final List f;

   public cT(PdxValue var1) {
      this.a = var1.getType();
      Iterator var4;
      switch(this.a) {
      case 0:
         this.b = 0;
         this.c = ((PdxValue$String)var1).get();
         this.d = null;
         this.f = null;
         this.e = null;
         return;
      case 1:
         this.b = ((PdxValue$Integer)var1).get();
         this.c = null;
         this.d = null;
         this.f = null;
         this.e = null;
         return;
      case 2:
         this.b = 0;
         this.c = null;
         this.d = null;
         this.f = null;
         this.e = new HashMap();
         var4 = ((PdxValue$Dictionary)var1).getEntries().iterator();

         while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            this.e.put(var5.getKey(), new cT((PdxValue)var5.getValue()));
         }

         return;
      case 3:
         PdxValue$Sequence var3 = (PdxValue$Sequence)var1;
         this.b = 0;
         this.c = null;
         this.d = null;
         this.f = new ArrayList(var3.size());
         this.e = null;
         var4 = var3.getValues().iterator();

         while(var4.hasNext()) {
            PdxValue var2 = (PdxValue)var4.next();
            this.f.add(new cT(var2));
         }

         return;
      case 4:
         this.b = 0;
         this.c = null;
         this.d = ((PdxValue$Bytes)var1).get();
         this.f = null;
         this.e = null;
         return;
      default:
         this.b = 0;
         this.c = null;
         this.d = null;
         this.f = null;
         this.e = null;
      }
   }

   public final Map a() {
      return this.e;
   }

   public final List b() {
      return this.f;
   }

   public final String c() {
      return this.c;
   }

   public final int d() {
      return this.b;
   }

   public final byte[] e() {
      return this.d;
   }

   public final int f() {
      return this.a;
   }
}
