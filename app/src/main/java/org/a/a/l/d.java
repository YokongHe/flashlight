package org.a.a.l;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class d implements org.a.a.l.b {
   public static final Map a = new HashMap();
   public static final Map b = new HashMap();
   private static final Pattern c = Pattern.compile("[^0-9A-Fa-f]");
   private final org.a.a.i.b d;
   private boolean e = false;
   private int f = 0;
   private List g;
   private int h = 0;
   private int i = -1;
   private org.a.a.n.a j;
   private boolean k = true;
   private Map l;

   static {
      a.put(Character.valueOf('0'), "\u0000");
      a.put(Character.valueOf('a'), "\u0007");
      a.put(Character.valueOf('b'), "\b");
      a.put(Character.valueOf('t'), "\t");
      a.put(Character.valueOf('n'), "\n");
      a.put(Character.valueOf('v'), "\u000b");
      a.put(Character.valueOf('f'), "\f");
      a.put(Character.valueOf('r'), "\r");
      a.put(Character.valueOf('e'), "\u001b");
      a.put(Character.valueOf(' '), " ");
      a.put(Character.valueOf('\"'), "\"");
      a.put(Character.valueOf('\\'), "\\");
      a.put(Character.valueOf('N'), "\u0085");
      a.put(Character.valueOf('_'), " ");
      a.put(Character.valueOf('L'), "\u2028");
      a.put(Character.valueOf('P'), "\u2029");
      b.put(Character.valueOf('x'), Integer.valueOf(2));
      b.put(Character.valueOf('u'), Integer.valueOf(4));
      b.put(Character.valueOf('U'), Integer.valueOf(8));
   }

   public d(org.a.a.i.b var1) {
      this.d = var1;
      this.g = new ArrayList(100);
      this.j = new org.a.a.n.a(10);
      this.l = new LinkedHashMap();
      org.a.a.c.a var2 = this.d.a();
      org.a.a.m.r var3 = new org.a.a.m.r(var2, var2);
      this.g.add(var3);
   }

   private String a(String var1, org.a.a.c.a var2) {
      int var4 = 1;
      byte var5 = 1;
      char var3 = this.d.c();
      if(var3 != 33) {
         throw new c("while scanning a " + var1, var2, "expected \'!\', but found " + var3 + "(" + var3 + ")", this.d.a());
      } else {
         var3 = this.d.b(1);
         if(var3 != 32) {
            for(var4 = var5; org.a.a.l.a.h.a(var3); var3 = this.d.b(var4)) {
               ++var4;
            }

            if(var3 != 33) {
               this.d.a(var4);
               throw new c("while scanning a " + var1, var2, "expected \'!\', but found " + var3 + "(" + var3 + ")", this.d.a());
            }

            ++var4;
         }

         return this.d.d(var4);
      }
   }

   private String a(boolean var1, org.a.a.c.a var2) {
      StringBuilder var5 = new StringBuilder();

      while(true) {
         while(true) {
            while(true) {
               int var4;
               for(var4 = 0; org.a.a.l.a.e.b(this.d.b(var4), "\'\"\\"); ++var4) {
                  ;
               }

               if(var4 != 0) {
                  var5.append(this.d.d(var4));
               }

               char var3 = this.d.c();
               if(var1 || var3 != 39 || this.d.b(1) != 39) {
                  if((!var1 || var3 != 39) && (var1 || "\"\\".indexOf(var3) == -1)) {
                     if(!var1 || var3 != 92) {
                        return var5.toString();
                     }

                     this.d.b();
                     var3 = this.d.c();
                     if(a.containsKey(Character.valueOf(var3))) {
                        var5.append((String)a.get(Character.valueOf(var3)));
                        this.d.b();
                     } else if(b.containsKey(Character.valueOf(var3))) {
                        var4 = ((Integer)b.get(Character.valueOf(var3))).intValue();
                        this.d.b();
                        String var6 = this.d.c(var4);
                        if(c.matcher(var6).find()) {
                           throw new c("while scanning a double-quoted scalar", var2, "expected escape sequence of " + var4 + " hexadecimal numbers, but found: " + var6, this.d.a());
                        }

                        var5.append(new String(Character.toChars(Integer.parseInt(var6, 16))));
                        this.d.a(var4);
                     } else {
                        if(this.l().length() == 0) {
                           throw new c("while scanning a double-quoted scalar", var2, "found unknown escape character " + var3 + "(" + var3 + ")", this.d.a());
                        }

                        var5.append(this.g(var2));
                     }
                  } else {
                     var5.append(var3);
                     this.d.b();
                  }
               } else {
                  var5.append("\'");
                  this.d.a(2);
               }
            }
         }
      }
   }

   private List a(org.a.a.c.a var1) {
      while(this.d.c() == 32) {
         this.d.b();
      }

      Integer var2 = this.b(var1);
      if(this.d.c() != 46) {
         throw new c("while scanning a directive", var1, "expected a digit or \'.\', but found " + this.d.c() + "(" + this.d.c() + ")", this.d.a());
      } else {
         this.d.b();
         Integer var3 = this.b(var1);
         if(org.a.a.l.a.d.b(this.d.c())) {
            throw new c("while scanning a directive", var1, "expected a digit or \' \', but found " + this.d.c() + "(" + this.d.c() + ")", this.d.a());
         } else {
            ArrayList var4 = new ArrayList(2);
            var4.add(var2);
            var4.add(var3);
            return var4;
         }
      }
   }

   private void a(char var1) {
      this.k = true;
      this.g();
      boolean var4;
      if(var1 == 62) {
         var4 = true;
      } else {
         var4 = false;
      }

      StringBuilder var11 = new StringBuilder();
      org.a.a.c.a var12 = this.d.a();
      this.d.b();
      char var2 = this.d.c();
      int var3;
      Boolean var7;
      if(var2 != 45 && var2 != 43) {
         if(Character.isDigit(var2)) {
            var3 = Integer.parseInt(String.valueOf(var2));
            if(var3 == 0) {
               throw new c("while scanning a block scalar", var12, "expected indentation indicator in the range 1-9, but found 0", this.d.a());
            }

            this.d.b();
            char var5 = this.d.c();
            if(var5 != 45 && var5 != 43) {
               var7 = null;
            } else {
               if(var5 == 43) {
                  var7 = Boolean.TRUE;
               } else {
                  var7 = Boolean.FALSE;
               }

               this.d.b();
            }
         } else {
            var7 = null;
            var3 = -1;
         }
      } else {
         if(var2 == 43) {
            var7 = Boolean.TRUE;
         } else {
            var7 = Boolean.FALSE;
         }

         this.d.b();
         var2 = this.d.c();
         if(Character.isDigit(var2)) {
            var3 = Integer.parseInt(String.valueOf(var2));
            if(var3 == 0) {
               throw new c("while scanning a block scalar", var12, "expected indentation indicator in the range 1-9, but found 0", this.d.a());
            }

            this.d.b();
         } else {
            var3 = -1;
         }
      }

      var2 = this.d.c();
      if(org.a.a.l.a.d.b(var2)) {
         throw new c("while scanning a block scalar", var12, "expected chomping or indentation indicators, but found " + var2, this.d.a());
      } else {
         org.a.a.l.e var13 = new org.a.a.l.e(var7, var3);
         int var14 = var13.c();
         this.e(var12);
         var3 = this.i + 1;
         if(var3 <= 0) {
            var3 = 1;
         }

         String var8;
         Object[] var16;
         org.a.a.c.a var18;
         if(var14 == -1) {
            var16 = this.i();
            var8 = (String)var16[0];
            var14 = ((Integer)var16[1]).intValue();
            var18 = (org.a.a.c.a)var16[2];
            var3 = Math.max(var3, var14);
         } else {
            var3 = var3 + var14 - 1;
            var16 = this.c(var3);
            var8 = (String)var16[0];
            var18 = (org.a.a.c.a)var16[1];
         }

         String var10 = "";
         org.a.a.c.a var9 = var18;
         String var19 = var10;

         while(this.d.d() == var3 && this.d.c() != 0) {
            var11.append(var8);
            boolean var15;
            if(" \t".indexOf(this.d.c()) == -1) {
               var15 = true;
            } else {
               var15 = false;
            }

            int var6;
            for(var6 = 0; org.a.a.l.a.c.b(this.d.b(var6)); ++var6) {
               ;
            }

            var11.append(this.d.d(var6));
            var19 = this.l();
            Object[] var17 = this.c(var3);
            var8 = (String)var17[0];
            var9 = (org.a.a.c.a)var17[1];
            if(this.d.d() != var3 || this.d.c() == 0) {
               break;
            }

            if(var4 && "\n".equals(var19) && var15 && " \t".indexOf(this.d.c()) == -1) {
               if(var8.length() == 0) {
                  var11.append(" ");
               }
            } else {
               var11.append(var19);
            }
         }

         if(var13.a()) {
            var11.append(var19);
         }

         if(var13.b()) {
            var11.append(var8);
         }

         org.a.a.m.p var20 = new org.a.a.m.p(var11.toString(), false, var12, var9, var1);
         this.g.add(var20);
      }
   }

   private void a(int var1) {
      if(this.f == 0) {
         while(this.i > var1) {
            org.a.a.c.a var2 = this.d.a();
            this.i = ((Integer)this.j.a()).intValue();
            this.g.add(new org.a.a.m.c(var2, var2));
         }
      }

   }

   private void a(boolean var1) {
      this.a((int)-1);
      this.g();
      this.k = false;
      org.a.a.c.a var2 = this.d.a();
      this.d.a(3);
      org.a.a.c.a var3 = this.d.a();
      Object var4;
      if(var1) {
         var4 = new org.a.a.m.i(var2, var3);
      } else {
         var4 = new org.a.a.m.h(var2, var3);
      }

      this.g.add(var4);
   }

   private Integer b(org.a.a.c.a var1) {
      char var2 = this.d.c();
      if(!Character.isDigit(var2)) {
         throw new c("while scanning a directive", var1, "expected a digit, but found " + var2 + "(" + var2 + ")", this.d.a());
      } else {
         int var3;
         for(var3 = 0; Character.isDigit(this.d.b(var3)); ++var3) {
            ;
         }

         return Integer.valueOf(Integer.parseInt(this.d.d(var3)));
      }
   }

   private String b(String var1, org.a.a.c.a var2) {
      StringBuilder var5 = new StringBuilder();
      char var3 = this.d.b(0);

      int var4;
      for(var4 = 0; org.a.a.l.a.g.a(var3); var3 = this.d.b(var4)) {
         if(var3 == 37) {
            var5.append(this.d.d(var4));
            var5.append(this.c(var1, var2));
            var4 = 0;
         } else {
            ++var4;
         }
      }

      if(var4 != 0) {
         var5.append(this.d.d(var4));
      }

      if(var5.length() == 0) {
         throw new c("while scanning a " + var1, var2, "expected URI, but found " + var3 + "(" + var3 + ")", this.d.a());
      } else {
         return var5.toString();
      }
   }

   private void b(char var1) {
      this.f();
      this.k = false;
      boolean var3;
      if(var1 == 34) {
         var3 = true;
      } else {
         var3 = false;
      }

      StringBuilder var4 = new StringBuilder();
      org.a.a.c.a var5 = this.d.a();
      char var2 = this.d.c();
      this.d.b();
      var4.append(this.a(var3, var5));

      while(this.d.c() != var2) {
         var4.append(this.f(var5));
         var4.append(this.a(var3, var5));
      }

      this.d.b();
      org.a.a.c.a var6 = this.d.a();
      org.a.a.m.p var7 = new org.a.a.m.p(var4.toString(), false, var5, var6, var1);
      this.g.add(var7);
   }

   private void b(boolean var1) {
      this.f();
      ++this.f;
      this.k = true;
      org.a.a.c.a var2 = this.d.a();
      this.d.a(1);
      org.a.a.c.a var3 = this.d.a();
      Object var4;
      if(var1) {
         var4 = new org.a.a.m.l(var2, var3);
      } else {
         var4 = new org.a.a.m.n(var2, var3);
      }

      this.g.add(var4);
   }

   private boolean b(int var1) {
      if(this.i < var1) {
         this.j.a(Integer.valueOf(this.i));
         this.i = var1;
         return true;
      } else {
         return false;
      }
   }

   private String c(String var1, org.a.a.c.a var2) {
      int var3;
      for(var3 = 1; this.d.b(var3 * 3) == 37; ++var3) {
         ;
      }

      org.a.a.c.a var4 = this.d.a();

      ByteBuffer var5;
      for(var5 = ByteBuffer.allocate(var3); this.d.c() == 37; this.d.a(2)) {
         this.d.b();

         try {
            var5.put((byte)Integer.parseInt(this.d.c(2), 16));
         } catch (NumberFormatException var7) {
            throw new c("while scanning a " + var1, var2, "expected URI escape sequence of 2 hexadecimal numbers, but found " + this.d.c() + "(" + this.d.c() + ") and " + this.d.b(1) + "(" + this.d.b(1) + ")", this.d.a());
         }
      }

      var5.flip();

      try {
         String var8 = org.a.a.n.b.a(var5);
         return var8;
      } catch (CharacterCodingException var6) {
         throw new c("while scanning a " + var1, var2, "expected URI in UTF-8: " + var6.getMessage(), var4);
      }
   }

   private List c(org.a.a.c.a var1) {
      while(this.d.c() == 32) {
         this.d.b();
      }

      String var3 = this.a("directive", var1);
      char var2 = this.d.c();
      if(var2 != 32) {
         throw new c("while scanning a directive", var1, "expected \' \', but found " + this.d.c() + "(" + var2 + ")", this.d.a());
      } else {
         while(this.d.c() == 32) {
            this.d.b();
         }

         String var4 = this.b("directive", var1);
         if(org.a.a.l.a.d.b(this.d.c())) {
            throw new c("while scanning a directive", var1, "expected \' \', but found " + this.d.c() + "(" + this.d.c() + ")", this.d.a());
         } else {
            ArrayList var5 = new ArrayList(2);
            var5.add(var3);
            var5.add(var4);
            return var5;
         }
      }
   }

   private void c(boolean var1) {
      this.g();
      --this.f;
      this.k = false;
      org.a.a.c.a var2 = this.d.a();
      this.d.b();
      org.a.a.c.a var3 = this.d.a();
      Object var4;
      if(var1) {
         var4 = new org.a.a.m.k(var2, var3);
      } else {
         var4 = new org.a.a.m.m(var2, var3);
      }

      this.g.add(var4);
   }

   private boolean c() {
      if(this.e) {
         return false;
      } else if(this.g.isEmpty()) {
         return true;
      } else {
         this.e();
         int var1;
         if(!this.l.isEmpty()) {
            var1 = ((org.a.a.l.f)this.l.values().iterator().next()).a();
         } else {
            var1 = -1;
         }

         return var1 == this.h;
      }
   }

   private Object[] c(int var1) {
      StringBuilder var6 = new StringBuilder();
      org.a.a.c.a var5 = this.d.a();
      int var2 = this.d.d();

      int var3;
      for(var3 = 0; var2 < var1 && this.d.b(var3) == 32; ++var2) {
         ++var3;
      }

      org.a.a.c.a var4 = var5;
      if(var3 > 0) {
         this.d.a(var3);
         var4 = var5;
      }

      while(true) {
         String var7 = this.l();
         if(var7.length() == 0) {
            return new Object[]{var6.toString(), var4};
         }

         var6.append(var7);
         var5 = this.d.a();
         var2 = this.d.d();

         for(var3 = 0; var2 < var1 && this.d.b(var3) == 32; ++var2) {
            ++var3;
         }

         var4 = var5;
         if(var3 > 0) {
            this.d.a(var3);
            var4 = var5;
         }
      }
   }

   private String d(org.a.a.c.a var1) {
      byte var4 = 0;

      int var3;
      for(var3 = 0; this.d.b(var3) == 32; ++var3) {
         ;
      }

      if(var3 > 0) {
         this.d.a(var3);
      }

      if(this.d.c() == 35) {
         for(var3 = var4; org.a.a.l.a.c.b(this.d.b(var3)); ++var3) {
            ;
         }

         this.d.a(var3);
      }

      char var2 = this.d.c();
      String var5 = this.l();
      if(var5.length() == 0 && var2 != 0) {
         throw new c("while scanning a directive", var1, "expected a comment or a line break, but found " + var2 + "(" + var2 + ")", this.d.a());
      } else {
         return var5;
      }
   }

   private org.a.a.m.u d(boolean var1) {
      int var3 = 0;
      org.a.a.c.a var5 = this.d.a();
      String var4;
      if(this.d.c() == 42) {
         var4 = "alias";
      } else {
         var4 = "anchor";
      }

      this.d.b();

      char var2;
      for(var2 = this.d.b(0); org.a.a.l.a.h.a(var2); var2 = this.d.b(var3)) {
         ++var3;
      }

      if(var3 == 0) {
         throw new c("while scanning an " + var4, var5, "expected alphabetic or numeric character, but found but found " + var2, this.d.a());
      } else {
         String var6 = this.d.d(var3);
         var2 = this.d.c();
         if(org.a.a.l.a.e.b(var2, "?:,]}%@`")) {
            throw new c("while scanning an " + var4, var5, "expected alphabetic or numeric character, but found " + var2 + "(" + this.d.c() + ")", this.d.a());
         } else {
            org.a.a.c.a var7 = this.d.a();
            return (org.a.a.m.u)(var1?new org.a.a.m.b(var6, var5, var7):new org.a.a.m.a(var6, var5, var7));
         }
      }
   }

   private void d() {
      boolean var8 = true;
      boolean var9 = true;
      boolean var5 = true;
      byte var6 = 0;
      if(this.d.e() == 0 && this.d.c() == '\ufeff') {
         this.d.b();
      }

      boolean var3 = false;

      while(!var3) {
         int var4;
         for(var4 = 0; this.d.b(var4) == 32; ++var4) {
            ;
         }

         if(var4 > 0) {
            this.d.a(var4);
         }

         if(this.d.c() == 35) {
            for(var4 = 0; org.a.a.l.a.c.b(this.d.b(var4)); ++var4) {
               ;
            }

            if(var4 > 0) {
               this.d.a(var4);
            }
         }

         if(this.l().length() != 0) {
            if(this.f == 0) {
               this.k = true;
            }
         } else {
            var3 = true;
         }
      }

      this.e();
      this.a(this.d.d());
      char var1 = this.d.c();
      boolean var7;
      org.a.a.c.a var10;
      org.a.a.m.u var22;
      switch(var1) {
      case '\u0000':
         this.a((int)-1);
         this.g();
         this.k = false;
         this.l.clear();
         var10 = this.d.a();
         org.a.a.m.q var25 = new org.a.a.m.q(var10, var10);
         this.g.add(var25);
         this.e = true;
         return;
      case '!':
         this.f();
         this.k = false;
         var22 = this.h();
         this.g.add(var22);
         return;
      case '\"':
         this.b('\"');
         return;
      case '%':
         if(this.d.d() == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3) {
            this.a((int)-1);
            this.g();
            this.k = false;
            org.a.a.c.a var12 = this.d.a();
            this.d.b();
            var1 = this.d.b(0);

            int var14;
            for(var14 = 0; org.a.a.l.a.h.a(var1); var1 = this.d.b(var14)) {
               ++var14;
            }

            if(var14 == 0) {
               throw new c("while scanning a directive", var12, "expected alphabetic or numeric character, but found " + var1 + "(" + var1 + ")", this.d.a());
            }

            String var13 = this.d.d(var14);
            var1 = this.d.c();
            if(org.a.a.l.a.d.b(var1)) {
               throw new c("while scanning a directive", var12, "expected alphabetic or numeric character, but found " + var1 + "(" + var1 + ")", this.d.a());
            }

            org.a.a.c.a var11;
            List var23;
            if("YAML".equals(var13)) {
               var23 = this.a(var12);
               var11 = this.d.a();
            } else if("TAG".equals(var13)) {
               var23 = this.c(var12);
               var11 = this.d.a();
            } else {
               var11 = this.d.a();

               for(var14 = var6; org.a.a.l.a.c.b(this.d.b(var14)); ++var14) {
                  ;
               }

               if(var14 > 0) {
                  this.d.a(var14);
               }

               var23 = null;
            }

            this.d(var12);
            org.a.a.m.g var24 = new org.a.a.m.g(var13, var23, var12, var11);
            this.g.add(var24);
            return;
         }
         break;
      case '&':
         this.f();
         this.k = false;
         var22 = this.d(true);
         this.g.add(var22);
         return;
      case '\'':
         this.b('\'');
         return;
      case '*':
         this.f();
         this.k = false;
         var22 = this.d(false);
         this.g.add(var22);
         return;
      case ',':
         this.k = true;
         this.g();
         var10 = this.d.a();
         this.d.b();
         org.a.a.m.j var21 = new org.a.a.m.j(var10, this.d.a());
         this.g.add(var21);
         return;
      case '-':
         if(this.d.d() == 0 && "---".equals(this.d.c(3)) && org.a.a.l.a.e.a(this.d.b(3))) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3) {
            this.a(true);
            return;
         }

         if(org.a.a.l.a.e.a(this.d.b(1))) {
            if(this.f == 0) {
               if(!this.k) {
                  throw new c((String)null, (org.a.a.c.a)null, "sequence entries are not allowed here", this.d.a());
               }

               if(this.b(this.d.d())) {
                  var10 = this.d.a();
                  this.g.add(new org.a.a.m.f(var10, var10));
               }
            }

            this.k = true;
            this.g();
            var10 = this.d.a();
            this.d.b();
            org.a.a.m.d var20 = new org.a.a.m.d(var10, this.d.a());
            this.g.add(var20);
            return;
         }
         break;
      case '.':
         if(this.d.d() == 0 && "...".equals(this.d.c(3)) && org.a.a.l.a.e.a(this.d.b(3))) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3) {
            this.a(false);
            return;
         }
         break;
      case ':':
         if(this.f != 0) {
            var7 = true;
         } else {
            var7 = org.a.a.l.a.e.a(this.d.b(1));
         }

         if(var7) {
            org.a.a.l.f var16 = (org.a.a.l.f)this.l.remove(Integer.valueOf(this.f));
            if(var16 != null) {
               this.g.add(var16.a() - this.h, new org.a.a.m.o(var16.c(), var16.c()));
               if(this.f == 0 && this.b(var16.b())) {
                  this.g.add(var16.a() - this.h, new org.a.a.m.e(var16.c(), var16.c()));
               }

               this.k = false;
            } else {
               if(this.f == 0 && !this.k) {
                  throw new c((String)null, (org.a.a.c.a)null, "mapping values are not allowed here", this.d.a());
               }

               if(this.f == 0 && this.b(this.d.d())) {
                  var10 = this.d.a();
                  this.g.add(new org.a.a.m.e(var10, var10));
               }

               if(this.f == 0) {
                  var7 = var9;
               } else {
                  var7 = false;
               }

               this.k = var7;
               this.g();
            }

            var10 = this.d.a();
            this.d.b();
            org.a.a.m.w var17 = new org.a.a.m.w(var10, this.d.a());
            this.g.add(var17);
            return;
         }
         break;
      case '>':
         if(this.f == 0) {
            this.a('>');
            return;
         }
         break;
      case '?':
         if(this.f != 0) {
            var7 = true;
         } else {
            var7 = org.a.a.l.a.e.a(this.d.b(1));
         }

         if(var7) {
            if(this.f == 0) {
               if(!this.k) {
                  throw new c((String)null, (org.a.a.c.a)null, "mapping keys are not allowed here", this.d.a());
               }

               if(this.b(this.d.d())) {
                  var10 = this.d.a();
                  this.g.add(new org.a.a.m.e(var10, var10));
               }
            }

            if(this.f == 0) {
               var7 = var8;
            } else {
               var7 = false;
            }

            this.k = var7;
            this.g();
            var10 = this.d.a();
            this.d.b();
            org.a.a.m.o var15 = new org.a.a.m.o(var10, this.d.a());
            this.g.add(var15);
            return;
         }
         break;
      case '[':
         this.b(false);
         return;
      case ']':
         this.c(false);
         return;
      case '{':
         this.b(true);
         return;
      case '|':
         if(this.f == 0) {
            this.a('|');
            return;
         }
         break;
      case '}':
         this.c(true);
         return;
      }

      char var2 = this.d.c();
      var3 = var5;
      if(!org.a.a.l.a.e.b(var2, "-?:,[]{}#&*!|>\'\"%@`")) {
         label215: {
            if(org.a.a.l.a.e.b(this.d.b(1))) {
               var3 = var5;
               if(var2 == 45) {
                  break label215;
               }

               if(this.f == 0 && "?:".indexOf(var2) != -1) {
                  var3 = var5;
                  break label215;
               }
            }

            var3 = false;
         }
      }

      if(var3) {
         this.f();
         this.k = false;
         var22 = this.j();
         this.g.add(var22);
      } else {
         String var26 = String.valueOf(var1);
         Iterator var18 = a.keySet().iterator();

         while(var18.hasNext()) {
            Character var19 = (Character)var18.next();
            if(((String)a.get(var19)).equals(var26)) {
               var26 = "\\" + var19;
               break;
            }
         }

         throw new c("while scanning for the next token", (org.a.a.c.a)null, "found character " + var1 + "\'" + var26 + "\' that cannot start any token", this.d.a());
      }
   }

   private String e(org.a.a.c.a var1) {
      byte var4 = 0;

      int var3;
      for(var3 = 0; this.d.b(var3) == 32; ++var3) {
         ;
      }

      if(var3 > 0) {
         this.d.a(var3);
      }

      if(this.d.c() == 35) {
         for(var3 = var4; org.a.a.l.a.c.b(this.d.b(var3)); ++var3) {
            ;
         }

         if(var3 > 0) {
            this.d.a(var3);
         }
      }

      char var2 = this.d.c();
      String var5 = this.l();
      if(var5.length() == 0 && var2 != 0) {
         throw new c("while scanning a block scalar", var1, "expected a comment or a line break, but found " + var2, this.d.a());
      } else {
         return var5;
      }
   }

   private void e() {
      if(!this.l.isEmpty()) {
         Iterator var1 = this.l.values().iterator();

         while(true) {
            org.a.a.l.f var2;
            do {
               if(!var1.hasNext()) {
                  return;
               }

               var2 = (org.a.a.l.f)var1.next();
            } while(var2.e() == this.d.f() && this.d.e() - var2.d() <= 1024);

            if(var2.f()) {
               throw new c("while scanning a simple key", var2.c(), "could not found expected \':\'", this.d.a());
            }

            var1.remove();
         }
      }
   }

   private String f(org.a.a.c.a var1) {
      StringBuilder var3 = new StringBuilder();

      int var2;
      for(var2 = 0; " \t".indexOf(this.d.b(var2)) != -1; ++var2) {
         ;
      }

      String var5 = this.d.d(var2);
      if(this.d.c() == 0) {
         throw new c("while scanning a quoted scalar", var1, "found unexpected end of stream", this.d.a());
      } else {
         String var4 = this.l();
         if(var4.length() != 0) {
            String var6 = this.g(var1);
            if(!"\n".equals(var4)) {
               var3.append(var4);
            } else if(var6.length() == 0) {
               var3.append(" ");
            }

            var3.append(var6);
         } else {
            var3.append(var5);
         }

         return var3.toString();
      }
   }

   private void f() {
      boolean var2;
      if(this.f == 0 && this.i == this.d.d()) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(!this.k && var2) {
         throw new org.a.a.c.c("A simple key is required only if it is the first token in the current line");
      } else {
         if(this.k) {
            this.g();
            int var1 = this.h;
            org.a.a.l.f var3 = new org.a.a.l.f(this.g.size() + var1, var2, this.d.e(), this.d.f(), this.d.d(), this.d.a());
            this.l.put(Integer.valueOf(this.f), var3);
         }

      }
   }

   private String g(org.a.a.c.a var1) {
      StringBuilder var2 = new StringBuilder();

      while(true) {
         String var3 = this.d.c(3);
         if(("---".equals(var3) || "...".equals(var3)) && org.a.a.l.a.e.a(this.d.b(3))) {
            throw new c("while scanning a quoted scalar", var1, "found unexpected document separator", this.d.a());
         }

         while(" \t".indexOf(this.d.c()) != -1) {
            this.d.b();
         }

         var3 = this.l();
         if(var3.length() == 0) {
            return var2.toString();
         }

         var2.append(var3);
      }
   }

   private void g() {
      org.a.a.l.f var1 = (org.a.a.l.f)this.l.remove(Integer.valueOf(this.f));
      if(var1 != null && var1.f()) {
         throw new c("while scanning a simple key", var1.c(), "could not found expected \':\'", this.d.a());
      }
   }

   private org.a.a.m.u h() {
      boolean var3 = true;
      org.a.a.c.a var7 = this.d.a();
      char var1 = this.d.b(1);
      String var4;
      String var5;
      if(var1 == 60) {
         this.d.a(2);
         var4 = this.b("tag", var7);
         if(this.d.c() != 62) {
            throw new c("while scanning a tag", var7, "expected \'>\', but found \'" + this.d.c() + "\' (" + this.d.c() + ")", this.d.a());
         }

         this.d.b();
         var5 = null;
      } else if(org.a.a.l.a.e.a(var1)) {
         var4 = "!";
         this.d.b();
         var5 = null;
      } else {
         int var2 = 1;

         boolean var8;
         while(true) {
            if(!org.a.a.l.a.d.b(var1)) {
               var8 = false;
               break;
            }

            if(var1 == 33) {
               var8 = var3;
               break;
            }

            ++var2;
            var1 = this.d.b(var2);
         }

         if(var8) {
            var4 = this.a("tag", var7);
         } else {
            var4 = "!";
            this.d.b();
         }

         String var6 = this.b("tag", var7);
         var5 = var4;
         var4 = var6;
      }

      var1 = this.d.c();
      if(org.a.a.l.a.d.b(var1)) {
         throw new c("while scanning a tag", var7, "expected \' \', but found \'" + var1 + "\' (" + var1 + ")", this.d.a());
      } else {
         return new org.a.a.m.s(new org.a.a.m.t(var5, var4), var7, this.d.a());
      }
   }

   private Object[] i() {
      StringBuilder var3 = new StringBuilder();
      org.a.a.c.a var2 = this.d.a();
      int var1 = 0;

      while(org.a.a.l.a.a.a(this.d.c(), " \r")) {
         if(this.d.c() != 32) {
            var3.append(this.l());
            var2 = this.d.a();
         } else {
            this.d.b();
            if(this.d.d() > var1) {
               var1 = this.d.d();
            }
         }
      }

      return new Object[]{var3.toString(), Integer.valueOf(var1), var2};
   }

   private org.a.a.m.u j() {
      StringBuilder var10 = new StringBuilder();
      org.a.a.c.a var8 = this.d.a();
      int var3 = this.i;
      String var5 = "";
      org.a.a.c.a var4 = var8;

      while(true) {
         org.a.a.c.a var7 = var4;
         if(this.d.c() == 35) {
            return new org.a.a.m.p(var10.toString(), var8, var7, true);
         }

         int var2 = 0;

         while(true) {
            char var1 = this.d.b(var2);
            if(org.a.a.l.a.e.a(var1) || this.f == 0 && var1 == 58 && org.a.a.l.a.e.a(this.d.b(var2 + 1)) || this.f != 0 && ",:?[]{}".indexOf(var1) != -1) {
               if(this.f != 0 && var1 == 58 && org.a.a.l.a.e.b(this.d.b(var2 + 1), ",[]{}")) {
                  this.d.a(var2);
                  throw new c("while scanning a plain scalar", var8, "found unexpected \':\'", this.d.a(), "Please check http://pyyaml.org/wiki/YAMLColonInFlowContext for details.");
               }

               var7 = var4;
               if(var2 == 0) {
                  return new org.a.a.m.p(var10.toString(), var8, var7, true);
               }

               this.k = false;
               var10.append(var5);
               var10.append(this.d.d(var2));
               org.a.a.c.a var6 = this.d.a();
               String var9 = this.k();
               var7 = var6;
               if(var9.length() == 0) {
                  return new org.a.a.m.p(var10.toString(), var8, var7, true);
               }

               var7 = var6;
               if(this.d.c() == 35) {
                  return new org.a.a.m.p(var10.toString(), var8, var7, true);
               }

               var5 = var9;
               var4 = var6;
               if(this.f == 0) {
                  var5 = var9;
                  var4 = var6;
                  if(this.d.d() < var3 + 1) {
                     var7 = var6;
                     return new org.a.a.m.p(var10.toString(), var8, var7, true);
                  }
               }
               break;
            }

            ++var2;
         }
      }
   }

   private String k() {
      int var1;
      for(var1 = 0; this.d.b(var1) == 32 || this.d.b(var1) == 9; ++var1) {
         ;
      }

      String var2 = this.d.d(var1);
      String var3 = this.l();
      if(var3.length() != 0) {
         this.k = true;
         var2 = this.d.c(3);
         if(!"---".equals(var2) && (!"...".equals(var2) || !org.a.a.l.a.e.a(this.d.b(3)))) {
            StringBuilder var5 = new StringBuilder();

            String var4;
            do {
               while(this.d.c() == 32) {
                  this.d.b();
               }

               var4 = this.l();
               if(var4.length() == 0) {
                  if(!"\n".equals(var3)) {
                     return var3 + var5;
                  }

                  if(var5.length() == 0) {
                     return " ";
                  }

                  return var5.toString();
               }

               var5.append(var4);
               var4 = this.d.c(3);
            } while(!"---".equals(var4) && (!"...".equals(var4) || !org.a.a.l.a.e.a(this.d.b(3))));

            return "";
         }

         var2 = "";
      }

      return var2;
   }

   private String l() {
      char var1 = this.d.c();
      if(var1 != 13 && var1 != 10 && var1 != 133) {
         if(var1 != 8232 && var1 != 8233) {
            return "";
         } else {
            this.d.b();
            return String.valueOf(var1);
         }
      } else {
         if(var1 == 13 && 10 == this.d.b(1)) {
            this.d.a(2);
         } else {
            this.d.b();
         }

         return "\n";
      }
   }

   public final org.a.a.m.u a() {
      while(this.c()) {
         this.d();
      }

      return (org.a.a.m.u)this.g.get(0);
   }

   public final boolean a(org.a.a.m.v... var1) {
      boolean var4 = false;

      while(this.c()) {
         this.d();
      }

      boolean var3 = var4;
      if(!this.g.isEmpty()) {
         if(var1.length == 0) {
            var3 = true;
         } else {
            org.a.a.m.v var5 = ((org.a.a.m.u)this.g.get(0)).c();
            int var2 = 0;

            while(true) {
               var3 = var4;
               if(var2 >= var1.length) {
                  break;
               }

               if(var5 == var1[var2]) {
                  return true;
               }

               ++var2;
            }
         }
      }

      return var3;
   }

   public final org.a.a.m.u b() {
      if(!this.g.isEmpty()) {
         ++this.h;
         return (org.a.a.m.u)this.g.remove(0);
      } else {
         return null;
      }
   }
}
