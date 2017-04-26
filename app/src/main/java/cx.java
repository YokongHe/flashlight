import java.util.Hashtable;
import java.util.Vector;

public class cx implements cw {
   private static final ae a = bh.a(cx.class);
   private byte[] b;
   private String c = "Cp1252";
   private <undefinedtype> d = null;

   public cx(byte[] var1) {
      this.b = var1;
      Object var4 = new Object() {
         public int a;
         public int b;
         public int c;
         public int d;
         public int e;

         private {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
         }
      };
      int var2 = this.a(2, this.b());
      ((<undefinedtype>)var4).e = var2;
      var2 = this.b(var2 + 4, this.a(var2));
      ((<undefinedtype>)var4).d = var2;
      var2 = this.a(var2 + 2, this.e(var2));
      ((<undefinedtype>)var4).b = this.a(3, var2, var1.length);
      ((<undefinedtype>)var4).c = this.a(4, var2, var1.length);
      ((<undefinedtype>)var4).a = this.a(1, var2, var1.length);
      this.d = (<undefinedtype>)var4;
      <undefinedtype> var5 = this.d;
      String var6;
      if(var5.c == -1) {
         var6 = "Cp1252";
      } else {
         var2 = var5.c + 4;
         int var3 = (int)cH.c(this.b, var2);
         var6 = cH.a(this.b, var2 + 4, var3 - 1, "Cp1252");
         String var7;
         if(var6 == "Windows-1252") {
            var7 = "Cp1252";
         } else {
            var7 = var6;
         }

         if(!a(var7)) {
            var6 = "Cp1252";
         }
      }

      this.c = var6;
   }

   private int a(int var1) {
      var1 = cH.b(this.b, var1);
      if(a.a()) {
         a.a((Object)("Number of sentences: " + var1));
      }

      return var1;
   }

   private int a(int var1, int var2) {
      int var4;
      for(int var3 = 0; var1 < this.b.length && var3 < var2; var3 = var4) {
         var4 = var3;
         if(this.b[var1] == 0) {
            var4 = var3 + 1;
         }

         ++var1;
      }

      return var1;
   }

   private int a(int var1, int var2, int var3) {
      long var4;
      for(; var2 < var3; var2 = var2 + (int)var4 + 4) {
         var4 = cH.c(this.b, var2);
         if(a.a()) {
            a.a((Object)("Received extension id=" + var4));
         }

         if(var4 == (long)var1) {
            return var2;
         }

         var2 += 4;
         var4 = cH.c(this.b, var2);
         if(a.a()) {
            a.a((Object)("Received payload size: " + var4));
         }
      }

      return -1;
   }

   private cy a(int var1, int var2, Vector var3) {
      byte var5 = 0;
      int var6 = this.b(var1);
      var1 += 4;
      cu var7 = new cu();
      cy var8 = new cy((byte)0);
      int var4 = var2;
      var2 = var1;

      for(var1 = var5; var1 < var6; ++var1) {
         cz var9 = this.a(var2, var4, 2, var3);
         var7.a(var9.c);
         var2 = var9.a;
         var4 = var9.b;
         if(a.a()) {
            cv var10 = var9.c;
            a.a((Object)("Extracted word: startTime [" + var10.c() + "] endTime [" + var10.d() + "] content [" + var10.b() + "]"));
         }
      }

      var8.b = var2;
      var8.c = var4;
      var8.a = var7;
      return var8;
   }

   private cz a(int var1, int var2, int var3, Vector var4) {
      cz var12 = new cz((byte)0);
      int var7 = cH.a(this.b, var1);
      var1 += 2;
      String var13 = (String)var4.elementAt(var7 - 1);
      long var8;
      long var10;
      if(var3 == 4) {
         var8 = this.d(var1);
         var1 += var3;
         var10 = this.d(var1);
         var1 += var3;
      } else {
         var8 = (long)this.c(var1);
         var1 += var3;
         var10 = (long)this.c(var1);
         var1 += var3;
      }

      double var5 = 0.0D;
      var3 = var2;
      if(var2 != -1) {
         var5 = (double)cH.a(this.b, var2);
         var3 = var2 + 2;
      }

      var12.c = new cv(var13, var8, var10, var5, true, (byte)0);
      var12.a = var1;
      var12.b = var3;
      return var12;
   }

   private Vector a(Object var1, Vector var2) {
      byte var7 = 0;
      boolean var4;
      if(var1.a != -1) {
         var4 = true;
      } else {
         var4 = false;
      }

      int var3;
      if(var4) {
         var3 = var1.a;
      } else {
         var3 = var1.e;
      }

      boolean var6;
      if(var1.b != -1) {
         var6 = true;
      } else {
         var6 = false;
      }

      int var5 = var3;
      if(var4) {
         var5 = var3 + 4 + 4;
      }

      int var9 = this.a(var5);
      int var8 = var1.b;
      var3 = var8;
      if(var6) {
         var3 = var8 + 4 + 4 + 4 + 4;
      }

      Vector var10 = new Vector();
      var5 += 4;
      int var12 = var3;

      for(var3 = var7; var3 < var9; ++var3) {
         cy var11;
         if(var4) {
            var11 = this.b(var5, var12, var2);
         } else {
            var11 = this.a(var5, var12, var2);
         }

         if(a.a()) {
            a.a((Object)("Number of words in Sentence " + var3 + ": [" + var11.a.a() + "]"));
         }

         var10.addElement(var11.a);
         var5 = var11.b;
         var12 = var11.c;
         if(a.a()) {
            a.a((Object)("Extracted sentence: [" + var11.a + "]"));
         }
      }

      return var10;
   }

   private static void a(Hashtable var0) {
      for(int var1 = 0; var0.remove("CFD" + var1) != null; ++var1) {
         ;
      }

      if(var0.containsKey("IAL")) {
         var0.put("InputAudioLength", var0.get("IAL"));
      }

   }

   private static void a(Hashtable var0, Vector var1) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         String var5 = (String)var0.get("CFD" + var4);
         if(var5 != null) {
            double var2;
            try {
               var2 = Double.parseDouble(var5);
            } catch (NumberFormatException var6) {
               continue;
            }

            ((cu)var1.elementAt(var4)).a(var2);
         }
      }

   }

   private static boolean a(String var0) {
      return true;
   }

   private int b() {
      int var1 = cH.a(this.b, 0);
      if(a.a()) {
         a.a((Object)("Number of words: " + var1));
      }

      return var1;
   }

   private int b(int var1) {
      return cH.b(this.b, var1);
   }

   private int b(int var1, int var2) {
      for(int var3 = 0; var3 < var2; ++var3) {
         int var5 = this.b(var1);
         var1 += 4;

         for(int var4 = 0; var4 < var5; ++var4) {
            var1 += 6;
         }
      }

      return var1;
   }

   private cy b(int var1, int var2, Vector var3) {
      byte var5 = 0;
      int var6 = this.b(var1);
      var1 += 4;
      cy var7 = new cy((byte)0);
      int var4 = var2;
      var2 = var1;

      for(var1 = var5; var1 < var6; ++var1) {
         cz var8 = this.a(var2, var4, 4, var3);
         var7.a.a(var8.c);
         var2 = var8.a;
         var4 = var8.b;
         if(a.a()) {
            cv var9 = var8.c;
            a.a((Object)("Extracted word: startTime [" + var9.c() + "] endTime [" + var9.d() + "] content [" + var9.b() + "]"));
         }
      }

      var7.b = var2;
      var7.c = var4;
      return var7;
   }

   private int c(int var1) {
      return cH.a(this.b, var1);
   }

   private Vector c(int var1, int var2) {
      Vector var6 = new Vector();
      byte var4 = 0;
      int var3 = var2;

      for(var2 = var4; var2 < var1; ++var2) {
         int var8 = cH.d(this.b, var3);
         byte[] var7 = this.b;
         String var5;
         if(this.c.equals("Cp1252")) {
            var5 = "Windows-1252";
         } else {
            var5 = this.c;
         }

         var5 = cH.a(var7, var3, var8, var5);
         var6.addElement(var5);
         if(a.a()) {
            a.a((Object)("Added a word to the list: [" + var5 + "] offset [" + var3 + "] len [" + var8 + "]"));
         }

         var3 += var8 + 1;
      }

      return var6;
   }

   private long d(int var1) {
      return cH.c(this.b, var1);
   }

   private int e(int var1) {
      var1 = cH.a(this.b, var1);
      if(a.a()) {
         a.a((Object)("Number of key-value pairs: " + var1));
      }

      return var1;
   }

   private Hashtable f(int var1) {
      int var2 = this.e(var1);
      Hashtable var3 = new Hashtable();
      Vector var4 = this.c(var2, var1 + 2);
      if(a.a()) {
         a.a((Object)("Extracted " + var4.size() + " words from the set of key-value pairs."));
      }

      for(var1 = 0; var1 < var4.size(); ++var1) {
         String var5 = (String)var4.elementAt(var1);
         var2 = var5.indexOf(61);
         if(var2 == -1) {
            throw new IllegalArgumentException("Received an invalid key-value pair: " + (String)var4.elementAt(var1));
         }

         var3.put(var5.substring(0, var2), var5.substring(var2 + 1, var5.length()));
      }

      return var3;
   }

   public final cn a() {
      byte var2 = 0;
      a.b((Object)"Unpacking DNS binary version 3.2 results.");
      Vector var3 = this.c(this.b(), 2);
      int var1;
      if(a.b()) {
         a.b((Object)("Found " + var3.size() + " in word list"));
         if(a.a()) {
            for(var1 = 0; var1 < var3.size(); ++var1) {
               a.a((Object)var3.elementAt(var1).toString());
            }
         }
      }

      var3 = this.a(this.d, var3);
      if(a.b()) {
         a.b((Object)("Found " + var3.size() + " in n-best list"));
         if(a.a()) {
            for(var1 = var2; var1 < var3.size(); ++var1) {
               a.a((Object)var3.elementAt(var1).toString());
            }
         }
      }

      Hashtable var4 = this.f(this.d.d);
      a(var4, var3);
      a(var4);
      return new ct(var3);
   }
}
