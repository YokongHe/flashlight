package com.millennialmedia.a.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.Map.Entry;

public final class j extends AbstractMap implements Serializable {
   // $FF: synthetic field
   static final boolean g;
   private static final Comparator h;
   Comparator a;
   com.millennialmedia.a.a.b.p[] b;
   final com.millennialmedia.a.a.b.p c;
   int d;
   int e;
   int f;
   private com.millennialmedia.a.a.b.m i;
   private com.millennialmedia.a.a.b.n j;

   static {
      boolean var0;
      if(!com.millennialmedia.a.a.b.j.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      g = var0;
      h = new Comparator() {
         // $FF: synthetic method
         public final int compare(Object var1, Object var2) {
            return ((Comparable)var1).compareTo((Comparable)var2);
         }
      };
   }

   public j() {
      this(h);
   }

   private j(Comparator var1) {
      this.d = 0;
      this.e = 0;
      if(var1 == null) {
         var1 = h;
      }

      this.a = var1;
      this.c = new com.millennialmedia.a.a.b.p();
      this.b = new com.millennialmedia.a.a.b.p[16];
      this.f = this.b.length / 2 + this.b.length / 4;
   }

   private com.millennialmedia.a.a.b.p a(Object var1, boolean var2) {
      Object var9 = null;
      Comparator var11 = this.a;
      com.millennialmedia.a.a.b.p[] var10 = this.b;
      int var3 = var1.hashCode();
      var3 ^= var3 >>> 20 ^ var3 >>> 12;
      int var4 = var3 >>> 7 ^ var3 ^ var3 >>> 4;
      int var5 = var4 & var10.length - 1;
      com.millennialmedia.a.a.b.p var6 = var10[var5];
      com.millennialmedia.a.a.b.p var7;
      if(var6 != null) {
         Comparable var8;
         if(var11 == h) {
            var8 = (Comparable)var1;
         } else {
            var8 = null;
         }

         while(true) {
            if(var8 != null) {
               var3 = var8.compareTo(var6.f);
            } else {
               var3 = var11.compare(var1, var6.f);
            }

            if(var3 == 0) {
               var7 = var6;
               return var7;
            }

            if(var3 < 0) {
               var7 = var6.b;
            } else {
               var7 = var6.c;
            }

            if(var7 == null) {
               break;
            }

            var6 = var7;
         }
      } else {
         var3 = 0;
      }

      var7 = (com.millennialmedia.a.a.b.p)var9;
      if(var2) {
         var7 = this.c;
         com.millennialmedia.a.a.b.p var12;
         if(var6 == null) {
            if(var11 == h && !(var1 instanceof Comparable)) {
               throw new ClassCastException(var1.getClass().getName() + " is not Comparable");
            }

            var12 = new com.millennialmedia.a.a.b.p(var6, var1, var4, var7, var7.e);
            var10[var5] = var12;
         } else {
            var12 = new com.millennialmedia.a.a.b.p(var6, var1, var4, var7, var7.e);
            if(var3 < 0) {
               var6.b = var12;
            } else {
               var6.c = var12;
            }

            this.b(var6, true);
         }

         var3 = this.d;
         this.d = var3 + 1;
         if(var3 > this.f) {
            this.b = a(this.b);
            this.f = this.b.length / 2 + this.b.length / 4;
         }

         ++this.e;
         return var12;
      } else {
         return var7;
      }
   }

   private void a(com.millennialmedia.a.a.b.p var1) {
      byte var4 = 0;
      com.millennialmedia.a.a.b.p var5 = var1.b;
      com.millennialmedia.a.a.b.p var6 = var1.c;
      com.millennialmedia.a.a.b.p var7 = var6.b;
      com.millennialmedia.a.a.b.p var8 = var6.c;
      var1.c = var7;
      if(var7 != null) {
         var7.a = var1;
      }

      this.a(var1, var6);
      var6.b = var1;
      var1.a = var6;
      int var2;
      if(var5 != null) {
         var2 = var5.i;
      } else {
         var2 = 0;
      }

      int var3;
      if(var7 != null) {
         var3 = var7.i;
      } else {
         var3 = 0;
      }

      var1.i = Math.max(var2, var3) + 1;
      var3 = var1.i;
      var2 = var4;
      if(var8 != null) {
         var2 = var8.i;
      }

      var6.i = Math.max(var3, var2) + 1;
   }

   private void a(com.millennialmedia.a.a.b.p var1, com.millennialmedia.a.a.b.p var2) {
      com.millennialmedia.a.a.b.p var5 = var1.a;
      var1.a = null;
      if(var2 != null) {
         var2.a = var5;
      }

      if(var5 != null) {
         if(var5.b == var1) {
            var5.b = var2;
         } else if(!g && var5.c != var1) {
            throw new AssertionError();
         } else {
            var5.c = var2;
         }
      } else {
         int var3 = var1.g;
         int var4 = this.b.length;
         this.b[var3 & var4 - 1] = var2;
      }
   }

   private static com.millennialmedia.a.a.b.p[] a(com.millennialmedia.a.a.b.p[] var0) {
      int var4 = var0.length;
      com.millennialmedia.a.a.b.p[] var7 = new com.millennialmedia.a.a.b.p[var4 * 2];
      com.millennialmedia.a.a.b.l var8 = new com.millennialmedia.a.a.b.l();
      com.millennialmedia.a.a.b.k var9 = new com.millennialmedia.a.a.b.k();
      com.millennialmedia.a.a.b.k var10 = new com.millennialmedia.a.a.b.k();

      for(int var1 = 0; var1 < var4; ++var1) {
         com.millennialmedia.a.a.b.p var6 = var0[var1];
         if(var6 != null) {
            var8.a(var6);
            int var3 = 0;
            int var2 = 0;

            while(true) {
               com.millennialmedia.a.a.b.p var5 = var8.a();
               if(var5 == null) {
                  if(var2 > 0 && var3 > 0) {
                     var9.a(var2);
                     var10.a(var3);
                     var8.a(var6);

                     while(true) {
                        var5 = var8.a();
                        if(var5 == null) {
                           var6 = var9.a();
                           var5 = var10.a();
                           break;
                        }

                        if((var5.g & var4) == 0) {
                           var9.a(var5);
                        } else {
                           var10.a(var5);
                        }
                     }
                  } else if(var2 > 0) {
                     var5 = null;
                  } else {
                     var5 = var6;
                     var6 = null;
                  }

                  var7[var1] = var6;
                  var7[var1 + var4] = var5;
                  break;
               }

               if((var5.g & var4) == 0) {
                  ++var2;
               } else {
                  ++var3;
               }
            }
         }
      }

      return var7;
   }

   private com.millennialmedia.a.a.b.p b(Object var1) {
      com.millennialmedia.a.a.b.p var2 = null;
      if(var1 != null) {
         try {
            var2 = this.a(var1, false);
         } catch (ClassCastException var3) {
            return null;
         }
      }

      return var2;
   }

   private void b(com.millennialmedia.a.a.b.p var1) {
      byte var4 = 0;
      com.millennialmedia.a.a.b.p var5 = var1.b;
      com.millennialmedia.a.a.b.p var6 = var1.c;
      com.millennialmedia.a.a.b.p var7 = var5.b;
      com.millennialmedia.a.a.b.p var8 = var5.c;
      var1.b = var8;
      if(var8 != null) {
         var8.a = var1;
      }

      this.a(var1, var5);
      var5.c = var1;
      var1.a = var5;
      int var2;
      if(var6 != null) {
         var2 = var6.i;
      } else {
         var2 = 0;
      }

      int var3;
      if(var8 != null) {
         var3 = var8.i;
      } else {
         var3 = 0;
      }

      var1.i = Math.max(var2, var3) + 1;
      var3 = var1.i;
      var2 = var4;
      if(var7 != null) {
         var2 = var7.i;
      }

      var5.i = Math.max(var3, var2) + 1;
   }

   private void b(com.millennialmedia.a.a.b.p var1, boolean var2) {
      while(true) {
         label104: {
            if(var1 != null) {
               com.millennialmedia.a.a.b.p var6 = var1.b;
               com.millennialmedia.a.a.b.p var7 = var1.c;
               int var3;
               if(var6 != null) {
                  var3 = var6.i;
               } else {
                  var3 = 0;
               }

               int var4;
               if(var7 != null) {
                  var4 = var7.i;
               } else {
                  var4 = 0;
               }

               int var5 = var3 - var4;
               com.millennialmedia.a.a.b.p var8;
               if(var5 == -2) {
                  var6 = var7.b;
                  var8 = var7.c;
                  if(var8 != null) {
                     var3 = var8.i;
                  } else {
                     var3 = 0;
                  }

                  if(var6 != null) {
                     var4 = var6.i;
                  } else {
                     var4 = 0;
                  }

                  var3 = var4 - var3;
                  if(var3 == -1 || var3 == 0 && !var2) {
                     this.a(var1);
                  } else {
                     if(!g && var3 != 1) {
                        throw new AssertionError();
                     }

                     this.b(var7);
                     this.a(var1);
                  }

                  if(!var2) {
                     break label104;
                  }
               } else if(var5 == 2) {
                  var7 = var6.b;
                  var8 = var6.c;
                  if(var8 != null) {
                     var3 = var8.i;
                  } else {
                     var3 = 0;
                  }

                  if(var7 != null) {
                     var4 = var7.i;
                  } else {
                     var4 = 0;
                  }

                  var3 = var4 - var3;
                  if(var3 != 1 && (var3 != 0 || var2)) {
                     if(!g && var3 != -1) {
                        throw new AssertionError();
                     }

                     this.a(var6);
                     this.b(var1);
                  } else {
                     this.b(var1);
                  }

                  if(!var2) {
                     break label104;
                  }
               } else {
                  if(var5 == 0) {
                     var1.i = var3 + 1;
                     if(var2) {
                        return;
                     }
                     break label104;
                  }

                  if(!g && var5 != -1 && var5 != 1) {
                     throw new AssertionError();
                  }

                  var1.i = Math.max(var3, var4) + 1;
                  if(var2) {
                     break label104;
                  }
               }
            }

            return;
         }

         var1 = var1.a;
      }
   }

   final com.millennialmedia.a.a.b.p a(Object var1) {
      com.millennialmedia.a.a.b.p var2 = this.b(var1);
      if(var2 != null) {
         this.a(var2, true);
      }

      return var2;
   }

   final com.millennialmedia.a.a.b.p a(Entry var1) {
      boolean var3 = true;
      com.millennialmedia.a.a.b.p var4 = this.b(var1.getKey());
      boolean var2;
      if(var4 != null) {
         Object var5 = var4.h;
         Object var6 = var1.getValue();
         if(var5 != var6 && (var5 == null || !var5.equals(var6))) {
            var2 = false;
         } else {
            var2 = true;
         }

         if(var2) {
            var2 = var3;
            return var2?var4:null;
         }
      }

      var2 = false;
      return var2?var4:null;
   }

   final void a(com.millennialmedia.a.a.b.p var1, boolean var2) {
      int var4 = 0;
      if(var2) {
         var1.e.d = var1.d;
         var1.d.e = var1.e;
         var1.e = null;
         var1.d = null;
      }

      com.millennialmedia.a.a.b.p var5 = var1.b;
      com.millennialmedia.a.a.b.p var6 = var1.c;
      com.millennialmedia.a.a.b.p var7 = var1.a;
      if(var5 != null && var6 != null) {
         if(var5.i > var6.i) {
            var5 = var5.b();
         } else {
            var5 = var6.a();
         }

         this.a(var5, false);
         var6 = var1.b;
         int var3;
         if(var6 != null) {
            var3 = var6.i;
            var5.b = var6;
            var6.a = var5;
            var1.b = null;
         } else {
            var3 = 0;
         }

         var6 = var1.c;
         if(var6 != null) {
            var4 = var6.i;
            var5.c = var6;
            var6.a = var5;
            var1.c = null;
         }

         var5.i = Math.max(var3, var4) + 1;
         this.a(var1, var5);
      } else {
         if(var5 != null) {
            this.a(var1, var5);
            var1.b = null;
         } else if(var6 != null) {
            this.a(var1, var6);
            var1.c = null;
         } else {
            this.a(var1, (com.millennialmedia.a.a.b.p)null);
         }

         this.b(var7, false);
         --this.d;
         ++this.e;
      }
   }

   public final void clear() {
      Arrays.fill(this.b, (Object)null);
      this.d = 0;
      ++this.e;
      com.millennialmedia.a.a.b.p var3 = this.c;

      com.millennialmedia.a.a.b.p var2;
      for(com.millennialmedia.a.a.b.p var1 = var3.d; var1 != var3; var1 = var2) {
         var2 = var1.d;
         var1.e = null;
         var1.d = null;
      }

      var3.e = var3;
      var3.d = var3;
   }

   public final boolean containsKey(Object var1) {
      return this.b(var1) != null;
   }

   public final Set entrySet() {
      com.millennialmedia.a.a.b.m var1 = this.i;
      if(var1 != null) {
         return var1;
      } else {
         var1 = new com.millennialmedia.a.a.b.m(this);
         this.i = var1;
         return var1;
      }
   }

   public final Object get(Object var1) {
      com.millennialmedia.a.a.b.p var2 = this.b(var1);
      return var2 != null?var2.h:null;
   }

   public final Set keySet() {
      com.millennialmedia.a.a.b.n var1 = this.j;
      if(var1 != null) {
         return var1;
      } else {
         var1 = new com.millennialmedia.a.a.b.n(this);
         this.j = var1;
         return var1;
      }
   }

   public final Object put(Object var1, Object var2) {
      if(var1 == null) {
         throw new NullPointerException("key == null");
      } else {
         com.millennialmedia.a.a.b.p var4 = this.a(var1, true);
         Object var3 = var4.h;
         var4.h = var2;
         return var3;
      }
   }

   public final Object remove(Object var1) {
      com.millennialmedia.a.a.b.p var2 = this.a(var1);
      return var2 != null?var2.h:null;
   }

   public final int size() {
      return this.d;
   }
}
