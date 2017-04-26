import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public abstract class cB {
   private byte[] a;
   private cn b;
   private String c = "";

   public cB(byte[] var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Buffer cannot be null");
      } else {
         this.a = var1;
      }
   }

   private static boolean a(byte[] var0) {
      boolean var7 = false;

      InputStreamReader var13;
      label57: {
         try {
            var7 = true;
            var13 = new InputStreamReader(new ByteArrayInputStream(var0), "UTF8");
            var7 = false;
            break label57;
         } catch (Exception var11) {
            var7 = false;
         } finally {
            if(var7) {
               try {
                  throw new NullPointerException();
               } catch (IOException var8) {
                  var8.printStackTrace();
               }
            }
         }

         try {
            throw new NullPointerException();
         } catch (IOException var9) {
            var9.printStackTrace();
            return false;
         }
      }

      try {
         var13.close();
      } catch (IOException var10) {
         var10.printStackTrace();
      }

      return true;
   }

   public final void a() {
      try {
         System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
         InputSource var1 = new InputSource(new ByteArrayInputStream(this.a));
         if(!a(this.a)) {
            var1.setEncoding("cp1252");
         }

         XMLReader var2 = XMLReaderFactory.createXMLReader();
         cA var3 = this.e();
         var2.setContentHandler(var3);
         var2.parse(var1);
         this.b = var3.a();
      } catch (SAXException var4) {
         this.c = var4.getMessage();
      }
   }

   public final boolean b() {
      return this.b != null;
   }

   public final cn c() {
      return this.b;
   }

   public final String d() {
      return this.c;
   }

   protected abstract cA e();
}
