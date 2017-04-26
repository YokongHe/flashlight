import java.util.Hashtable;

public final class aP implements aK {
   private final aS a;
   private final Hashtable b = new Hashtable();
   private boolean c = false;

   private aP(aS var1, aQ var2) {
      this.a = var1;
      ((aL)this.a.c).a(var1, var2);
   }

   static aP a(aN var0, String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("eventName is null.");
      } else {
         return new aP(new aO(var0, var1), (aQ)null);
      }
   }

   static aP a(aS var0, String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("eventName is null.");
      } else {
         return new aP(new aM(var0, var1), (aQ)null);
      }
   }

   public static aP a(aS var0, String var1, aQ var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("eventName is null.");
      } else {
         return new aP(new aN(var0, var1), var2);
      }
   }

   static aP a(String var0, String var1, String var2, int var3, aL var4, String var5) {
      if(var5 == null) {
         throw new IllegalArgumentException("eventName is null.");
      } else {
         return new aP(new aO(var0, var1, var2, var3, var4, var5), (aQ)null);
      }
   }

   public final aI a() {
      return this.a((aR)null);
   }

   public final aI a(aR var1) {
      if(!this.c) {
         this.a.a(this.b, var1);
         this.c = true;
      }

      return this.a;
   }

   public final aK a(String var1, int var2) {
      if(this.c) {
         throw new aJ("SessionEvent is alreadt committed.");
      } else {
         this.b.put(var1, new Integer(var2));
         return this;
      }
   }

   public final aK a(String var1, String var2) {
      if(this.c) {
         throw new aJ("SessionEvent is alreadt committed.");
      } else {
         this.b.put(var1, var2);
         return this;
      }
   }

   public final aK a(String var1, boolean var2) {
      if(this.c) {
         throw new aJ("SessionEvent is alreadt committed.");
      } else {
         this.b.put(var1, new Boolean(var2));
         return this;
      }
   }

   public final aI b() {
      if(this.a instanceof aN) {
         ((aN)this.a).a = Boolean.valueOf(true);
      }

      if(!this.c) {
         this.a.a(this.b, (aR)null);
         this.c = true;
      }

      return this.a;
   }
}
