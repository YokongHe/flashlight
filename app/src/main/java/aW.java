import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

public class aW extends aV implements bb {
   private static final ae a = bh.a(aW.class);
   private Hashtable b = new Hashtable();

   public aW() {
      super((short)224);
   }

   public aW(byte[] var1) {
      super((short)224);
      if(var1.length > 0) {
         if((var1[0] & 255) == 224) {
            int var2 = a(var1, 1);
            byte[] var3 = new byte[var2];
            System.arraycopy(var1, var1.length - var2, var3, 0, var3.length);
            this.b(var3);
            return;
         }

         a.e("PDXDictionary() Expected a dictionary. ");
      }

   }

   public aW(byte[] var1, byte var2) {
      super((short)224);
      this.b(var1);
   }

   private void b(byte[] var1) {
      int var2 = 0;

      while(var2 < var1.length) {
         int var3 = var2 + 1;
         var2 = var1[var2] & 255;
         if(var2 != 22) {
            a.e("PDXDictionary.setContent() Expected an ASCII string but got " + var2 + ". ");
            break;
         }

         var2 = a(var1, var3);
         var3 += a(var2);
         byte[] var5 = new byte[var2];
         System.arraycopy(var1, var3, var5, 0, var5.length);
         var3 += var2;
         String var7 = new String(var5);
         var2 = var3 + 1;
         var3 = var1[var3] & 255;
         int var4 = a(var1, var2);
         var2 += a(var4);
         byte[] var6 = new byte[var4];
         System.arraycopy(var1, var2, var6, 0, var6.length);
         var2 += var4;
         switch(var3) {
         case 4:
            this.b.put(var7, new aU(var6));
            break;
         case 5:
            this.b.put(var7, new aY());
            break;
         case 16:
            this.b.put(var7, new aZ(var6));
            break;
         case 22:
            this.b.put(var7, new aT(var6));
            break;
         case 192:
            this.b.put(var7, new aX(var6));
            break;
         case 193:
            this.b.put(var7, new ba(var6));
            break;
         case 224:
            this.b.put(var7, new aW(var6, (byte)0));
            break;
         default:
            a.e("PDXDictionary.setContent() Unknown PDXClass type: " + var3 + ". ");
         }
      }

   }

   public final Enumeration a() {
      return this.b.keys();
   }

   protected final void a(String var1, int var2) {
      this.b.put(var1, new aX(var2));
   }

   public final void a(String var1, bb var2) {
      if(var1 != null && var2 != null) {
         if(((aV)var2).c() != 224) {
            a.e("PDXDictionary.addDictionary() value is not a valid dictionary.");
            throw new IllegalArgumentException("value is not a valid dictionary. ");
         } else {
            this.b.put(var1, var2);
         }
      } else {
         throw new IllegalArgumentException("key is : " + var1 + " value is : " + var2);
      }
   }

   public final void a(String var1, bc var2) {
      if(var1 != null && var2 != null) {
         if(((aV)var2).c() != 16) {
            a.e("PDXDictionary.addSequence() value is not a valid sequence.");
            throw new IllegalArgumentException("value is not a valid sequence. ");
         } else {
            this.b.put(var1, var2);
         }
      } else {
         throw new IllegalArgumentException("key is : " + var1 + " value is : " + var2);
      }
   }

   public final void a(String var1, String var2) {
      if(var1 != null && var2 != null) {
         aT var3 = new aT(var2);
         this.b.put(var1, var3);
      } else {
         throw new IllegalArgumentException("key is : " + var1 + " value is : " + var2);
      }
   }

   public final void a(String var1, String var2, short var3) {
      switch(var3) {
      case 22:
         this.b.put(var1, new aT(var2));
         return;
      case 193:
         this.b.put(var1, new ba(var2));
         return;
      default:
      }
   }

   public final void a(String var1, byte[] var2) {
      if(var1 != null && var2 != null) {
         aU var3 = new aU(var2);
         this.b.put(var1, var3);
      } else {
         throw new IllegalArgumentException("key is : " + var1 + " value is : " + var2);
      }
   }

   protected final void a(String var1, byte[] var2, short var3) {
      switch(var3) {
      case 4:
         this.b.put(var1, new aU(var2));
         return;
      case 5:
         this.b.put(var1, new aY());
         return;
      case 16:
         this.b.put(var1, new aZ(var2));
         return;
      case 22:
         this.b.put(var1, new aT(var2));
         return;
      case 192:
         this.b.put(var1, new aX(var2));
         return;
      case 193:
         this.b.put(var1, new ba(var2));
         return;
      case 224:
         this.b.put(var1, new aW(var2, (byte)0));
         return;
      default:
         a.e("PDXDictionary.put() Unknown PDXClass type: " + var3 + ". ");
      }
   }

   public final boolean a(String var1) {
      if(var1 == null) {
         throw new NullPointerException("PDXDictionary.containsKey key is null");
      } else {
         return this.b.containsKey(var1);
      }
   }

   public final aV b(String var1) {
      return (aV)this.b.get(var1);
   }

   protected final String b(int var1) {
      int var2 = 0;

      String var4;
      for(var4 = ""; var2 < var1 - 1; ++var2) {
         var4 = var4 + "    ";
      }

      String var5;
      if(var1 > 0) {
         var5 = var4 + "    ";
      } else {
         var5 = "";
      }

      Enumeration var6 = this.b.keys();
      String var3;
      if(var1 != 0) {
         var3 = "" + "{ \n";
      } else {
         var3 = "";
      }

      while(var6.hasMoreElements()) {
         String var7 = (String)var6.nextElement();
         aV var8 = (aV)this.b.get(var7);
         switch(var8.c()) {
         case 4:
            var3 = var3 + var5 + var7 + ": <BYTES> \"" + ((aU)var8).a() + "\"\n";
            break;
         case 5:
            var3 = var3 + var5 + var7 + ": <NULL> \n";
            break;
         case 16:
            var3 = var3 + var5 + var7 + ": " + ((aZ)var8).j(var1 + 1) + "\n";
            break;
         case 22:
            var3 = var3 + var5 + var7 + ": <ASCII> \"" + ((aT)var8).a() + "\"\n";
            break;
         case 192:
            var3 = var3 + var5 + var7 + ": <INT> " + ((aX)var8).a() + "\n";
            break;
         case 193:
            var3 = var3 + var5 + var7 + ": <UTF8> \"" + ((ba)var8).a() + "\"\n";
            break;
         case 224:
            var3 = var3 + var5 + var7 + ": " + ((aW)var8).b(var1 + 1) + "\n";
         }
      }

      var5 = var3;
      if(var1 != 0) {
         var5 = var3 + var4 + "} ";
      }

      return var5;
   }

   public final void b(String var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("key is null.");
      } else {
         aX var3 = new aX(var2);
         this.b.put(var1, var3);
      }
   }

   public final void b(String var1, String var2) {
      if(var1 != null && var2 != null) {
         ba var3 = new ba(var2);
         this.b.put(var1, var3);
      } else {
         throw new IllegalArgumentException("key is : " + var1 + " value is : " + var2);
      }
   }

   public final byte[] b() {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Enumeration var2 = this.b.keys();

      while(var2.hasMoreElements()) {
         String var3 = (String)var2.nextElement();
         aT var4 = new aT(var3);

         try {
            var1.write(var4.b());
            aV var6 = (aV)this.b.get(var3);
            switch(var6.c()) {
            case 4:
               var1.write(((aU)var6).b());
               break;
            case 5:
               var1.write(((aY)var6).a());
               break;
            case 16:
               var1.write(((aZ)var6).b());
               break;
            case 22:
               var1.write(((aT)var6).b());
               break;
            case 192:
               var1.write(((aX)var6).b());
               break;
            case 193:
               var1.write(((ba)var6).b());
               break;
            case 224:
               var1.write(((aW)var6).d());
            }
         } catch (IOException var5) {
            a.e("PDXDictionary.getContent() " + var5.toString() + ". ");
         }
      }

      return var1.toByteArray();
   }

   public final short c(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("key is null.");
      } else {
         return ((aV)this.b.get(var1)).c();
      }
   }

   public final int d(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("key is null.");
      } else {
         aV var2 = (aV)this.b.get(var1);
         if(var2 == null) {
            if(a.e()) {
               a.e("PDXDictionary.getInteger() " + var1 + " does not exist. ");
            }

            throw new RuntimeException("key does not exist. ");
         } else if(var2.c() != 192) {
            if(a.e()) {
               a.e("PDXDictionary.getInteger() " + var1 + " is not a PDXInteger. ");
            }

            throw new RuntimeException("key is of wrong type. ");
         } else {
            return ((aX)var2).a();
         }
      }
   }

   public byte[] d() {
      return super.a(this.b());
   }

   public final byte[] e(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("key is null.");
      } else {
         aV var2 = (aV)this.b.get(var1);
         if(var2 == null) {
            a.e("PDXDictionary.getByteString() " + var1 + " does not exist. ");
            throw new RuntimeException("key does not exist. ");
         } else if(var2.c() != 4) {
            a.e("PDXDictionary.getByteString() " + var1 + " is not a PDXByteString. ");
            throw new RuntimeException("key is of wrong type. ");
         } else {
            return ((aU)var2).a();
         }
      }
   }

   public final String f(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("key is null.");
      } else {
         aV var2 = (aV)this.b.get(var1);
         if(var2 == null) {
            a.e("PDXDictionary.getUTF8String() " + var1 + " does not exist. ");
            throw new RuntimeException("key does not exist. ");
         } else if(var2.c() != 193) {
            a.e("PDXDictionary.getUTF8String() " + var1 + " is not a PDXUTF8String. ");
            throw new RuntimeException("key is of wrong type. ");
         } else {
            return ((ba)var2).a();
         }
      }
   }

   public final String g(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("key is null.");
      } else {
         aV var2 = (aV)this.b.get(var1);
         if(var2 == null) {
            a.e("PDXDictionary.getAsciiString() " + var1 + " does not exist. ");
            throw new RuntimeException("key does not exist. ");
         } else if(var2.c() != 22) {
            a.e("PDXDictionary.getAsciiString() " + var1 + " is not a PDXAsciiString. ");
            throw new RuntimeException("key is of wrong type. ");
         } else {
            return ((aT)var2).a();
         }
      }
   }

   public final bb h(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("key is null.");
      } else {
         aV var2 = (aV)this.b.get(var1);
         if(var2 == null) {
            a.e("PDXDictionary.getDictionary() " + var1 + " does not exist. ");
            throw new RuntimeException("key does not exist. ");
         } else if(var2.c() != 224) {
            a.e("PDXDictionary.getDictionary() " + var1 + " is not a PDXDictionary. ");
            throw new RuntimeException("key is of wrong type. ");
         } else {
            return (aW)var2;
         }
      }
   }

   public final bc i(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("key is null.");
      } else {
         aV var2 = (aV)this.b.get(var1);
         if(var2 == null) {
            a.e("PDXDictionary.getSequence() " + var1 + " does not exist. ");
            throw new RuntimeException("key does not exist. ");
         } else if(var2.c() != 16) {
            a.e("PDXDictionary.getSequence() " + var1 + " is not a PDXSequence. ");
            throw new RuntimeException("key is of wrong type. ");
         } else {
            return (aZ)var2;
         }
      }
   }

   public String toString() {
      return this.b(0);
   }
}
