package com.millennialmedia.a.a.b;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class g implements com.millennialmedia.a.a.t, Cloneable {
   public static final com.millennialmedia.a.a.b.g a = new g();
   private double b = -1.0D;
   private int c = 136;
   private boolean d = true;
   private boolean e;
   private List f = Collections.emptyList();
   private List g = Collections.emptyList();

   private com.millennialmedia.a.a.b.g a() {
      try {
         com.millennialmedia.a.a.b.g var1 = (com.millennialmedia.a.a.b.g)super.clone();
         return var1;
      } catch (CloneNotSupportedException var2) {
         throw new AssertionError();
      }
   }

   private boolean a(com.millennialmedia.a.a.a.c var1, com.millennialmedia.a.a.a.d var2) {
      boolean var3;
      if(var1 != null && var1.a() > this.b) {
         var3 = false;
      } else {
         var3 = true;
      }

      if(var3) {
         if(var2 != null && var2.a() <= this.b) {
            var3 = false;
         } else {
            var3 = true;
         }

         if(var3) {
            return true;
         }
      }

      return false;
   }

   private static boolean a(Class var0) {
      return !Enum.class.isAssignableFrom(var0) && (var0.isAnonymousClass() || var0.isLocalClass());
   }

   private boolean b(Class var1) {
      if(var1.isMemberClass()) {
         boolean var2;
         if((var1.getModifiers() & 8) != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         if(!var2) {
            return true;
         }
      }

      return false;
   }

   public final com.millennialmedia.a.a.s a(final com.millennialmedia.a.a.e var1, final com.millennialmedia.a.a.c.a var2) {
      Class var5 = var2.a();
      final boolean var3 = this.a(var5, true);
      final boolean var4 = this.a(var5, false);
      return !var3 && !var4?null:new com.millennialmedia.a.a.s() {
         private com.millennialmedia.a.a.s f;

         private com.millennialmedia.a.a.s a() {
            com.millennialmedia.a.a.s var1x = this.f;
            if(var1x != null) {
               return var1x;
            } else {
               var1x = var1.a((com.millennialmedia.a.a.t)g.this, (com.millennialmedia.a.a.c.a)var2);
               this.f = var1x;
               return var1x;
            }
         }

         public final Object a(com.millennialmedia.a.a.d.a var1x) {
            if(var4) {
               var1x.n();
               return null;
            } else {
               return this.a().a(var1x);
            }
         }

         public final void a(com.millennialmedia.a.a.d.c var1x, Object var2x) {
            if(var3) {
               var1x.f();
            } else {
               this.a().a(var1x, var2x);
            }
         }
      };
   }

   public final boolean a(Class var1, boolean var2) {
      if(this.b != -1.0D && !this.a((com.millennialmedia.a.a.a.c)var1.getAnnotation(com.millennialmedia.a.a.a.c.class), (com.millennialmedia.a.a.a.d)var1.getAnnotation(com.millennialmedia.a.a.a.d.class))) {
         return true;
      } else if(!this.d && this.b(var1)) {
         return true;
      } else if(a(var1)) {
         return true;
      } else {
         List var3;
         if(var2) {
            var3 = this.f;
         } else {
            var3 = this.g;
         }

         Iterator var4 = var3.iterator();

         do {
            if(!var4.hasNext()) {
               return false;
            }
         } while(!((com.millennialmedia.a.a.a)var4.next()).b());

         return true;
      }
   }

   public final boolean a(Field var1, boolean var2) {
      if((this.c & var1.getModifiers()) != 0) {
         return true;
      } else if(this.b != -1.0D && !this.a((com.millennialmedia.a.a.a.c)var1.getAnnotation(com.millennialmedia.a.a.a.c.class), (com.millennialmedia.a.a.a.d)var1.getAnnotation(com.millennialmedia.a.a.a.d.class))) {
         return true;
      } else if(var1.isSynthetic()) {
         return true;
      } else {
         if(this.e) {
            label67: {
               com.millennialmedia.a.a.a.a var3 = (com.millennialmedia.a.a.a.a)var1.getAnnotation(com.millennialmedia.a.a.a.a.class);
               if(var3 != null) {
                  if(var2) {
                     if(var3.a()) {
                        break label67;
                     }
                  } else if(var3.b()) {
                     break label67;
                  }
               }

               return true;
            }
         }

         if(!this.d && this.b(var1.getType())) {
            return true;
         } else if(a(var1.getType())) {
            return true;
         } else {
            List var5;
            if(var2) {
               var5 = this.f;
            } else {
               var5 = this.g;
            }

            if(!var5.isEmpty()) {
               new com.millennialmedia.a.a.b(var1);
               Iterator var4 = var5.iterator();

               while(var4.hasNext()) {
                  if(((com.millennialmedia.a.a.a)var4.next()).a()) {
                     return true;
                  }
               }
            }

            return false;
         }
      }
   }

   // $FF: synthetic method
   protected final Object clone() {
      return this.a();
   }
}
