import java.util.Vector;

public final class cu implements cp {
   private Vector a = new Vector();
   private ct b = null;
   private double c = 0.0D;

   private Vector b(int var1, int var2) {
      Vector var3 = new Vector();
      Vector var4 = this.c(var1, var2);

      for(var1 = 0; var1 < var4.size(); ++var1) {
         cv var5 = (cv)var4.elementAt(var1);
         if(var5.e()) {
            var3.addElement(var5);
         }
      }

      return var3;
   }

   private Vector c(int var1) {
      Vector var5 = new Vector();
      int var4 = this.toString().length();
      int var2;
      if(var1 > 0) {
         var2 = var1 - 1;
      } else {
         var2 = var1;
      }

      int var3 = var1;
      if(var1 < var4) {
         var3 = var1 + 1;
      }

      Vector var6 = this.c(var2, var3);

      for(var1 = 0; var1 < var6.size(); ++var1) {
         cv var7 = (cv)var6.elementAt(var1);
         if(var7.e()) {
            var5.addElement(var7);
         }
      }

      return var5;
   }

   private Vector c(int var1, int var2) {
      int var3 = 0;
      Vector var9 = new Vector();
      int var8 = this.toString().length();
      int var4 = -1;
      int var5 = -1;

      int var7;
      for(int var6 = 0; var3 < this.a.size(); var6 = var7) {
         if(var1 == var6 && var2 == var6) {
            return var9;
         }

         var7 = var6 + this.d(var3).b().length();
         var6 = var5;
         if(var5 == -1) {
            var6 = var5;
            if(var1 < var7) {
               var6 = var3;
            }
         }

         var5 = var4;
         if(var6 != -1) {
            var5 = var4;
            if(var4 == -1) {
               var5 = var4;
               if(var2 <= var7) {
                  var5 = var3;
               }
            }
         }

         ++var3;
         var4 = var5;
         var5 = var6;
      }

      var1 = var4;
      if(var4 == -1) {
         var1 = var4;
         if(var2 == var8) {
            var1 = this.a.size() - 1;
         }
      }

      if(var5 != -1 && var1 != -1) {
         while(var5 <= var1) {
            var9.addElement(this.d(var5));
            ++var5;
         }

         return var9;
      } else {
         return var9;
      }
   }

   private cv d(int var1) {
      return (cv)this.a.elementAt(var1);
   }

   public final int a() {
      int var1 = 0;
      int var3 = 0;
      int var4 = this.a.size();
      if(var4 != 0) {
         int var2 = 0;

         while(true) {
            var3 = var1;
            if(var2 >= var4) {
               break;
            }

            var3 = var1;
            if(!this.d(var2).f()) {
               var3 = var1 + 1;
            }

            ++var2;
            var1 = var3;
         }
      }

      return var3;
   }

   public final cl a(int var1, int var2) {
      int var3 = this.toString().length();
      if(var1 >= 0 && var2 <= var3) {
         if(var2 < var1) {
            throw new IllegalArgumentException("Cursor position end is less than begin");
         } else {
            Vector var4;
            if(var1 == var2) {
               var4 = this.c(var1);
            } else {
               var4 = this.b(var1, var2);
            }

            if(var4.isEmpty()) {
               return new cl(new Vector());
            } else {
               Vector var5 = this.b.a(this, var4);

               for(var1 = 0; var1 < this.a.size(); ++var1) {
                  this.d(var1);
                  var4.firstElement();
                  var4.lastElement();
               }

               return new cl(var5);
            }
         }
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public final cq a(int var1) {
      int var3 = -1;
      int var2 = -1;

      cv var5;
      while(true) {
         if(var3 == var1) {
            cv var6 = this.d(var2);
            if(var2 + 1 < this.a.size() && this.d(var2 + 1).f()) {
               this.d(var2 + 1);
            }

            var5 = var6;
            if(var2 != 0) {
               var5 = var6;
               if(this.d(var2 - 1).f()) {
                  this.d(var2 - 1);
                  return var6;
               }
            }
            break;
         }

         int var4 = var2 + 1;
         if(var4 > this.a.size()) {
            var5 = null;
            break;
         }

         var2 = var4;
         if(!this.d(var4).f()) {
            ++var3;
            var2 = var4;
         }
      }

      return var5;
   }

   final cs a(long var1, long var3) {
      Vector var10 = new Vector();

      for(int var5 = 0; var5 < this.a.size(); ++var5) {
         cv var11 = this.d(var5);
         long var6 = var11.c();
         long var8 = var11.d();
         if(var6 < var3 && var8 > var1) {
            var10.addElement(var11);
         } else if(var6 > var3) {
            break;
         }
      }

      if(var10.size() > 0 && ((cv)var10.firstElement()).f()) {
         var10.removeElementAt(0);
      }

      if(var10.size() > 0 && ((cv)var10.lastElement()).f()) {
         var10.removeElementAt(var10.size() - 1);
      }

      return new cs(var10);
   }

   public final void a(double var1) {
      this.c = var1;
   }

   final void a(ct var1) {
      this.b = var1;
   }

   public final void a(cv var1) {
      if(this.a.size() != 0 && !((cv)this.a.lastElement()).h() && !var1.g()) {
         int var2 = this.a.size();
         long var3;
         if(this.a.size() == 0) {
            var3 = 0L;
         } else if(var2 == this.a.size()) {
            var3 = this.d(var2 - 1).d();
         } else {
            var3 = this.d(var2).c();
         }

         cv var5 = new cv(" ", var3, var3, 0.0D, false, (byte)0);
         this.a.insertElementAt(var5, var2);
      }

      this.a.addElement(var1);
   }

   public final double b() {
      return this.c;
   }

   public final cq b(int var1) {
      int var2 = 0;
      cq var6 = null;
      cq var5 = null;
      if(this.a.size() > 0 && var1 <= this.toString().length()) {
         int var3 = 0;
         var5 = var6;

         while(var3 <= var1) {
            var6 = (cq)this.a.get(var2);
            int var4 = var2 + 1;
            var5 = var6;
            var2 = var4;
            if(var6 != null) {
               var3 += var6.toString().length();
               var5 = var6;
               var2 = var4;
            }
         }
      }

      return var5;
   }

   final void c() {
      String var4 = System.getProperty("line.separator");
      String var3 = var4;
      if(var4 == null) {
         var3 = "\n";
      }

      for(int var1 = 0; var1 < this.a.size(); ++var1) {
         cv var6 = this.d(var1);
         StringBuffer var5 = new StringBuffer(var6.b());

         int var2;
         for(var2 = 0; var2 < var5.length(); ++var2) {
            var2 = var5.toString().indexOf("\r\n", var2);
            if(var2 == -1) {
               break;
            }

            var5.deleteCharAt(var2);
            var5.deleteCharAt(var2);
            var5.insert(var2, '\n');
         }

         for(var2 = 0; var2 < var5.length(); var2 += var3.length()) {
            var2 = var5.toString().indexOf("\n", var2);
            if(var2 == -1) {
               break;
            }

            var5.deleteCharAt(var2);
            var5.insert(var2, var3);
         }

         var6.a(var5.toString());
      }

   }

   public final String toString() {
      if(this.a.size() == 0) {
         return "";
      } else {
         StringBuffer var2 = new StringBuffer();

         for(int var1 = 0; var1 < this.a.size(); ++var1) {
            var2.append(this.d(var1).toString());
         }

         return var2.toString();
      }
   }
}
