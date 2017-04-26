package org.nexage.sourcekit.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.nexage.sourcekit.util.VASTLog;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlTools {
   private static String TAG = "XmlTools";

   public static String getElementValue(Node var0) {
      NodeList var2 = var0.getChildNodes();
      String var3 = null;

      for(int var1 = 0; var1 < var2.getLength(); ++var1) {
         var3 = ((CharacterData)var2.item(var1)).getData().trim();
         if(var3.length() != 0) {
            VASTLog.v(TAG, "getElementValue: " + var3);
            return var3;
         }
      }

      return var3;
   }

   public static void logXmlDocument(Document var0) {
      VASTLog.d(TAG, "logXmlDocument");

      try {
         Transformer var1 = TransformerFactory.newInstance().newTransformer();
         var1.setOutputProperty("omit-xml-declaration", "no");
         var1.setOutputProperty("method", "xml");
         var1.setOutputProperty("indent", "yes");
         var1.setOutputProperty("encoding", "UTF-8");
         var1.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
         StringWriter var2 = new StringWriter();
         var1.transform(new DOMSource(var0), new StreamResult(var2));
         VASTLog.d(TAG, var2.toString());
      } catch (Exception var3) {
         VASTLog.e(TAG, var3.getMessage(), var3);
      }
   }

   public static String stringFromStream(InputStream var0) {
      VASTLog.d(TAG, "stringFromStream");
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      byte[] var3 = new byte[1024];

      while(true) {
         int var1 = var0.read(var3);
         if(var1 == -1) {
            return new String(var2.toByteArray(), "UTF-8");
         }

         var2.write(var3, 0, var1);
      }
   }

   public static Document stringToDocument(String var0) {
      VASTLog.d(TAG, "stringToDocument");

      try {
         DocumentBuilder var1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
         InputSource var2 = new InputSource();
         var2.setCharacterStream(new StringReader(var0));
         Document var4 = var1.parse(var2);
         return var4;
      } catch (Exception var3) {
         VASTLog.e(TAG, var3.getMessage(), var3);
         return null;
      }
   }

   public static String xmlDocumentToString(Document var0) {
      VASTLog.d(TAG, "xmlDocumentToString");

      try {
         Transformer var1 = TransformerFactory.newInstance().newTransformer();
         var1.setOutputProperty("omit-xml-declaration", "no");
         var1.setOutputProperty("method", "xml");
         var1.setOutputProperty("indent", "yes");
         var1.setOutputProperty("encoding", "UTF-8");
         var1.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
         StringWriter var2 = new StringWriter();
         var1.transform(new DOMSource(var0), new StreamResult(var2));
         String var4 = var2.toString();
         return var4;
      } catch (Exception var3) {
         VASTLog.e(TAG, var3.getMessage(), var3);
         return null;
      }
   }

   public static String xmlDocumentToString(Node var0) {
      VASTLog.d(TAG, "xmlDocumentToString");

      try {
         Transformer var1 = TransformerFactory.newInstance().newTransformer();
         var1.setOutputProperty("omit-xml-declaration", "yes");
         var1.setOutputProperty("method", "xml");
         var1.setOutputProperty("indent", "yes");
         var1.setOutputProperty("encoding", "UTF-8");
         var1.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
         StringWriter var2 = new StringWriter();
         var1.transform(new DOMSource(var0), new StreamResult(var2));
         String var4 = var2.toString();
         return var4;
      } catch (Exception var3) {
         VASTLog.e(TAG, var3.getMessage(), var3);
         return null;
      }
   }
}
