import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class aZ extends aV implements bc {
   private static final ae a = bh.a(aZ.class);
   private Vector b = new Vector();

   public aZ() {
      super((short)16);
   }

   public aZ(byte[] var1) {
      super((short)16);
      int var2 = 0;

      while(var2 < var1.length) {
         int var4 = var2 + 1;
         int var3 = var1[var2] & 255;
         var2 = a(var1, var4);
         var4 += a(var2);
         byte[] var5 = new byte[var2];
         System.arraycopy(var1, var4, var5, 0, var5.length);
         var2 += var4;
         switch(var3) {
         case 4:
            this.b.addElement(new aU(var5));
            break;
         case 5:
            this.b.addElement(new aY());
            break;
         case 16:
            this.b.addElement(new aZ(var5));
            break;
         case 22:
            this.b.addElement(new aT(var5));
            break;
         case 192:
            this.b.addElement(new aX(var5));
            break;
         case 193:
            this.b.addElement(new ba(var5));
            break;
         case 224:
            this.b.addElement(new aW(var5, (byte)0));
            break;
         default:
            a.e("PDXSequence() Unknown PDXClass type: " + var3 + ". ");
         }
      }

   }

   public final int a() {
      return this.b.size();
   }

   public final void a(bb var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("value is null.");
      } else if(((aV)var1).c() != 224) {
         a.e("PDXSequence.addDictionary() value is not a valid dictionary.");
         throw new IllegalArgumentException("value is not a valid dictionary. ");
      } else {
         this.b.addElement(var1);
      }
   }

   public final void a(bc var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("value is null.");
      } else if(((aV)var1).c() != 16) {
         a.e("PDXSequence.addSequence() value is not a valid sequence.");
         throw new IllegalArgumentException("value is not a valid sequence. ");
      } else {
         this.b.addElement(var1);
      }
   }

   public final void a(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("value is null.");
      } else {
         ba var2 = new ba(var1);
         this.b.addElement(var2);
      }
   }

   public final short b(int var1) {
      if(var1 >= this.b.size()) {
         a.e("PDXSequence.getType() index " + var1 + " is out of range. ");
         throw new IndexOutOfBoundsException();
      } else {
         return ((aV)this.b.elementAt(var1)).c();
      }
   }

   public final void b(byte[] var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("value is null.");
      } else {
         aU var2 = new aU(var1);
         this.b.addElement(var2);
      }
   }

   public final byte[] b() {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Enumeration var2 = this.b.elements();

      while(var2.hasMoreElements()) {
         aV var3 = (aV)var2.nextElement();

         try {
            switch(var3.c()) {
            case 4:
               var1.write(((aU)var3).b());
               break;
            case 5:
               var1.write(((aY)var3).a());
               break;
            case 16:
               var1.write(((aZ)var3).b());
               break;
            case 22:
               var1.write(((aT)var3).b());
               break;
            case 192:
               var1.write(((aX)var3).b());
               break;
            case 193:
               var1.write(((ba)var3).b());
               break;
            case 224:
               var1.write(((aW)var3).d());
            }
         } catch (IOException var4) {
            a.e("PDXSequence.toByteArray() " + var4.toString() + ". ");
         }
      }

      return super.a(var1.toByteArray());
   }

   public final int c(int var1) {
      if(var1 >= this.b.size()) {
         a.e("PDXSequence.getInteger() index " + var1 + " is out of range. ");
         throw new IndexOutOfBoundsException();
      } else {
         aV var2 = (aV)this.b.elementAt(var1);
         if(var2.c() != 192) {
            a.e("PDXSequence.getInteger() index " + var1 + " is not a PDXInteger. ");
            throw new RuntimeException("index is of wrong type.");
         } else {
            return ((aX)var2).a();
         }
      }
   }

   public final byte[] d(int var1) {
      if(var1 >= this.b.size()) {
         a.e("PDXSequence.getByteString() index " + var1 + " is out of range. ");
         throw new IndexOutOfBoundsException();
      } else {
         aV var2 = (aV)this.b.elementAt(var1);
         if(var2.c() != 4) {
            a.e("PDXSequence.getByteString() index " + var1 + " is not a PDXByteString. ");
            throw new RuntimeException("index is of wrong type.");
         } else {
            return ((aU)var2).a();
         }
      }
   }

   public final String e(int var1) {
      if(var1 >= this.b.size()) {
         a.e("PDXSequence.getUTF8String() index " + var1 + " is out of range. ");
         throw new IndexOutOfBoundsException();
      } else {
         aV var2 = (aV)this.b.elementAt(var1);
         if(var2.c() != 193) {
            a.e("PDXSequence.getUTF8String() index " + var1 + " is not a PDXUTF8String. ");
            throw new RuntimeException("index is of wrong type.");
         } else {
            return ((ba)var2).a();
         }
      }
   }

   public final String f(int var1) {
      if(var1 >= this.b.size()) {
         a.e("PDXSequence.getAsciiString() index " + var1 + " is out of range. ");
         throw new IndexOutOfBoundsException();
      } else {
         aV var2 = (aV)this.b.elementAt(var1);
         if(var2.c() != 22) {
            a.e("PDXSequence.getAsciiString() index " + var1 + " is not a PDXAsciiString. ");
            throw new RuntimeException("index is of wrong type.");
         } else {
            return ((aT)var2).a();
         }
      }
   }

   public final bb g(int var1) {
      if(var1 >= this.b.size()) {
         a.e("PDXSequence.getDictionary() index " + var1 + " is out of range. ");
         throw new IndexOutOfBoundsException();
      } else {
         aV var2 = (aV)this.b.elementAt(var1);
         if(var2.c() != 224) {
            a.e("PDXSequence.getDictionary() index " + var1 + " is not a PDXDictionary. ");
            throw new RuntimeException("index is of wrong type.");
         } else {
            return (aW)var2;
         }
      }
   }

   public final bc h(int var1) {
      if(var1 >= this.b.size()) {
         a.e("PDXSequence.getSequence() index " + var1 + " is out of range. ");
         throw new IndexOutOfBoundsException();
      } else {
         aV var2 = (aV)this.b.elementAt(var1);
         if(var2.c() != 16) {
            a.e("PDXSequence.getSequence() index " + var1 + " is not a PDXSequence. ");
            throw new RuntimeException("index is of wrong type.");
         } else {
            return (aZ)var2;
         }
      }
   }

   public final void i(int var1) {
      aX var2 = new aX(var1);
      this.b.addElement(var2);
   }

   protected final String j(int var1) {
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

      Enumeration var7 = this.b.elements();

      String var3;
      String var8;
      for(var3 = "" + "[ \n"; var7.hasMoreElements(); var3 = var8 + "\n") {
         aV var6 = (aV)var7.nextElement();
         switch(var6.c()) {
         case 4:
            var3 = var3 + var5 + "<BYTES> \"" + ((aU)var6).a() + "\" ";
            break;
         case 5:
            var3 = var3 + var5 + "<NULL> ";
            break;
         case 16:
            var3 = var3 + var5 + ((aZ)var6).j(var1 + 1);
            break;
         case 22:
            var3 = var3 + var5 + "<ASCII> \"" + ((aT)var6).a() + "\" ";
            break;
         case 192:
            var3 = var3 + var5 + "<INT> " + ((aX)var6).a();
            break;
         case 193:
            var3 = var3 + var5 + "<UTF8> \"" + ((ba)var6).a() + "\" ";
            break;
         case 224:
            var3 = var3 + var5 + ((aW)var6).b(var1 + 1);
         }

         var8 = var3;
         if(var7.hasMoreElements()) {
            var8 = var3 + ",";
         }
      }

      return var3 + var4 + "] ";
   }

   public String toString() {
      return this.j(0);
   }
}
