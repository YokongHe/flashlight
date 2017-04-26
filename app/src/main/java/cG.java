import java.util.Hashtable;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class cG extends DefaultHandler implements cA {
   private static final ae a = bh.a(cG.class);
   private Stack b = new Stack();
   private StringBuffer c = null;
   private StringBuffer d = null;
   private String e = null;
   private String f = null;
   private double g = 0.0D;
   private Vector h = new Vector();
   private Hashtable i = new Hashtable();

   private void a(cu var1) {
      if(!this.h.isEmpty()) {
         for(int var2 = 0; var2 < this.h.size(); ++var2) {
            if(((cu)this.h.elementAt(var2)).b() < var1.b()) {
               this.h.insertElementAt(var1, var2);
               return;
            }
         }
      }

      this.h.addElement(var1);
   }

   private void b() {
      if(!this.b.isEmpty() && this.b.peek() == "input") {
         if(this.e == null) {
            throw new SAXException("Did not get any timings from input");
         } else if(this.c == null) {
            throw new SAXException("Did not get any character from input");
         } else {
            StringTokenizer var4 = new StringTokenizer(this.c.toString(), " ");
            StringTokenizer var5 = new StringTokenizer(this.e, ",");
            StringTokenizer var3;
            if(this.f != null) {
               var3 = new StringTokenizer(this.f, ",");
            } else {
               var3 = null;
            }

            this.c = null;
            this.e = null;
            this.f = null;
            if(var4.countTokens() != var5.countTokens()) {
               throw new SAXException("timing(" + var5.countTokens() + ") and inputs(" + var4.countTokens() + ") information does not have the same number of items");
            } else {
               cu var6 = new cu();
               var6.a(this.g);

               double var1;
               String var7;
               String var8;
               for(; var4.hasMoreTokens(); var6.a(new cv(var7, Long.parseLong(var8.substring(0, var8.indexOf("-"))), Long.parseLong(var8.substring(var8.indexOf("-") + 1)), var1, true, (byte)0))) {
                  var7 = var4.nextToken();
                  var8 = var5.nextToken();
                  var1 = 0.0D;
                  if(var3 != null) {
                     var1 = Double.parseDouble(var3.nextToken());
                  }
               }

               this.a(var6);
            }
         }
      } else {
         throw new SAXException("End Element> The top of the stack does not contain the token interpretation");
      }
   }

   public final cn a() {
      Vector var1 = this.h;
      Hashtable var2 = this.i;
      return new ct(var1);
   }

   public void characters(char[] var1, int var2, int var3) {
      if(a.a()) {
         a.a((Object)("Received characters: " + new String(var1, var2, var3)));
      }

      if(!this.b.isEmpty() && this.b.peek() == "input") {
         if(this.c == null) {
            this.c = new StringBuffer(var3);
         }

         this.c.append(var1, var2, var3);
      } else if(!this.b.isEmpty() && this.b.peek() == "NSS_Audio_Statistics") {
         if(this.d == null) {
            this.d = new StringBuffer(var3);
         }

         this.d.append(var1, var2, var3);
         return;
      }

   }

   public void endElement(String var1, String var2, String var3) {
      if(a.a()) {
         a.a((Object)("Received endElement " + var2));
      }

      if(var2.equals("result")) {
         if(this.b.isEmpty() || this.b.peek() != "result") {
            throw new SAXException("End Element> The top of the stack does not contain the token result");
         }

         this.b.pop();
      } else {
         if(var2.equals("interpretation")) {
            if(!this.b.isEmpty() && this.b.peek() == "interpretation") {
               this.b.pop();
               return;
            }

            throw new SAXException("End Element> The top of the stack does not contain the token interpretation");
         }

         if(var2.equals("input")) {
            this.b();
            this.b.pop();
            return;
         }

         if(var2.equals("NSS_Audio_Statistics")) {
            if(!this.b.isEmpty() && this.b.peek() == "NSS_Audio_Statistics") {
               this.b.pop();
               return;
            }

            throw new SAXException("End Element> The top of the stack does not contain the token NSS_Audio_Statistics");
         }

         if(!this.b.isEmpty() && this.b.peek() == "NSS_Audio_Statistics") {
            if(this.d == null) {
               var1 = "";
            } else {
               var1 = this.d.toString().trim();
            }

            if(var2.equals("InputAudioLength")) {
               this.i.put("IAL", var1);
            }

            this.i.put(var2, var1);
            this.d = null;
            return;
         }
      }

   }

   public void startElement(String var1, String var2, String var3, Attributes var4) {
      if(a.a()) {
         a.a((Object)("Received startElement " + var2));
      }

      if(var2.equals("result")) {
         if(this.b.size() != 0) {
            throw new SAXException("StartElement> Found result but it is not the first token.");
         }

         this.b.push("result");
      } else {
         if(var2.equals("interpretation")) {
            if(!this.b.isEmpty() && this.b.peek() == "result") {
               this.b.push("interpretation");
               var2 = var4.getValue("timing");
               var1 = var4.getValue("confidence");
               var3 = var4.getValue("word_confidence");
               if(var2 == null) {
                  throw new SAXException("StartElement> There are no timings associated with this interpretation.");
               }

               if(var1 == null) {
                  throw new SAXException("StartElement> There is no confidence associated with this interpretation.");
               }

               this.e = var2;
               this.f = var3;

               try {
                  this.g = Double.parseDouble(var1);
                  return;
               } catch (NumberFormatException var5) {
                  throw new SAXException("StartElement> Could not parse the confidence: " + var1, var5);
               }
            }

            throw new SAXException("StartElement> The interpretation token was found without a result being opened before.");
         }

         if(var2.equals("input")) {
            if(!this.b.isEmpty() && this.b.peek() == "interpretation") {
               this.b.push("input");
               return;
            }

            throw new SAXException("StartElement> The input token was found without a interpretation being opened before.");
         }

         if(var2.equals("NSS_Audio_Statistics")) {
            if(!this.b.isEmpty() && this.b.peek() == "result") {
               this.b.push("NSS_Audio_Statistics");
               return;
            }

            throw new SAXException("StartElement> The NSS_Audio_Statistics token was found without a result being opened before.");
         }
      }

   }
}
