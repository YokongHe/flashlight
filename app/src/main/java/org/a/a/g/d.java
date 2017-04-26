package org.a.a.g;

public abstract class d {
   protected org.a.a.c.a a;
   protected boolean b;
   protected Boolean c;
   private org.a.a.g.i d;
   private org.a.a.c.a e;
   private Class f;
   private boolean g;

   public d(org.a.a.g.i var1, org.a.a.c.a var2, org.a.a.c.a var3) {
      this.a(var1);
      this.e = var2;
      this.a = var3;
      this.f = Object.class;
      this.g = false;
      this.b = true;
      this.c = null;
   }

   public abstract org.a.a.g.e a();

   public final void a(Boolean var1) {
      this.c = var1;
   }

   public final void a(org.a.a.g.i var1) {
      if(var1 == null) {
         throw new NullPointerException("tag in a Node is required.");
      } else {
         this.d = var1;
      }
   }

   public final void b(Class var1) {
      if(!var1.isAssignableFrom(this.f)) {
         this.f = var1;
      }

   }

   public final void b(boolean var1) {
      this.g = true;
   }

   public final org.a.a.g.i d() {
      return this.d;
   }

   public final org.a.a.c.a e() {
      return this.a;
   }

   public final boolean equals(Object var1) {
      return super.equals(var1);
   }

   public final org.a.a.c.a f() {
      return this.e;
   }

   public final Class g() {
      return this.f;
   }

   public final boolean h() {
      return this.g;
   }

   public final int hashCode() {
      return super.hashCode();
   }

   public final boolean i() {
      return this.c != null?this.c.booleanValue():this.b && !Object.class.equals(this.f) && !this.d.equals(org.a.a.g.i.l) || this.d.a(this.f);
   }
}
