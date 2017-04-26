package org.nexage.sourcekit.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import mf.javax.xml.transform.stream.StreamSource;
import mf.org.apache.xerces.jaxp.validation.XMLSchemaFactory;
import org.nexage.sourcekit.util.VASTLog;

public class XmlValidation {
   private static String TAG = "XmlTools";

   public static boolean validate(InputStream var0, String var1) {
      VASTLog.i(TAG, "Beginning XSD validation.");
      XMLSchemaFactory var2 = new XMLSchemaFactory();
      StreamSource var4 = new StreamSource(var0);
      StreamSource var5 = new StreamSource(new ByteArrayInputStream(var1.getBytes()));

      try {
         var2.newSchema(var4).newValidator().validate(var5);
      } catch (Exception var3) {
         VASTLog.e(TAG, var3.getMessage(), var3);
         return false;
      }

      VASTLog.i(TAG, "Completed XSD validation..");
      return true;
   }
}
