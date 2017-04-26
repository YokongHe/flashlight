package org.nexage.sourcekit.vast.processor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import javax.xml.parsers.DocumentBuilderFactory;
import org.nexage.sourcekit.util.VASTLog;
import org.nexage.sourcekit.util.XmlTools;
import org.nexage.sourcekit.util.XmlValidation;
import org.nexage.sourcekit.vast.model.VASTModel;
import org.nexage.sourcekit.vast.model.VAST_DOC_ELEMENTS;
import org.nexage.sourcekit.vast.processor.VASTMediaPicker;
import org.nexage.sourcekit.vast.processor.VASTModelPostValidator;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public final class VASTProcessor {
   private static final boolean IS_VALIDATION_ON = false;
   private static final int MAX_VAST_LEVELS = 5;
   private static final String TAG = "VASTProcessor";
   private VASTMediaPicker mediaPicker;
   private StringBuilder mergedVastDocs = new StringBuilder(500);
   private VASTModel vastModel;

   public VASTProcessor(VASTMediaPicker var1) {
      this.mediaPicker = var1;
   }

   private Document createDoc(InputStream var1) {
      VASTLog.d("VASTProcessor", "About to create doc from InputStream");

      try {
         Document var3 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(var1);
         var3.getDocumentElement().normalize();
         VASTLog.d("VASTProcessor", "Doc successfully created.");
         return var3;
      } catch (Exception var2) {
         VASTLog.e("VASTProcessor", var2.getMessage(), var2);
         return null;
      }
   }

   private void merge(Document var1) {
      VASTLog.d("VASTProcessor", "About to merge doc into main doc.");
      String var2 = XmlTools.xmlDocumentToString(var1.getElementsByTagName("VAST").item(0));
      this.mergedVastDocs.append(var2);
      VASTLog.d("VASTProcessor", "Merge successful.");
   }

   private int processUri(InputStream var1, int var2) {
      byte var4 = 0;
      VASTLog.d("VASTProcessor", "processUri");
      byte var3;
      if(var2 >= 5) {
         VASTLog.e("VASTProcessor", "VAST wrapping exceeded max limit of 5.");
         var3 = 6;
      } else {
         Document var7 = this.createDoc(var1);
         if(var7 == null) {
            return 3;
         }

         this.merge(var7);
         NodeList var8 = var7.getElementsByTagName(VAST_DOC_ELEMENTS.vastAdTagURI.getValue());
         var3 = var4;
         if(var8 != null) {
            var3 = var4;
            if(var8.getLength() != 0) {
               VASTLog.d("VASTProcessor", "Doc is a wrapper. ");
               String var9 = XmlTools.getElementValue(var8.item(0));
               VASTLog.d("VASTProcessor", "Wrapper URL: " + var9);

               try {
                  var1 = (new URL(var9)).openStream();
               } catch (Exception var6) {
                  VASTLog.e("VASTProcessor", var6.getMessage(), var6);
                  return 2;
               }

               var2 = this.processUri(var1, var2 + 1);

               try {
                  var1.close();
                  return var2;
               } catch (IOException var5) {
                  return var2;
               }
            }
         }
      }

      return var3;
   }

   private boolean validateAgainstSchema(Document var1) {
      VASTLog.d("VASTProcessor", "About to validate doc against schema.");
      InputStream var3 = VASTProcessor.class.getResourceAsStream("assets/vast_2_0_1_schema.xsd");
      boolean var2 = XmlValidation.validate(var3, XmlTools.xmlDocumentToString(var1));

      try {
         var3.close();
         return var2;
      } catch (IOException var4) {
         return var2;
      }
   }

   private Document wrapMergedVastDocWithVasts() {
      VASTLog.d("VASTProcessor", "wrapmergedVastDocWithVasts");
      this.mergedVastDocs.insert(0, "<VASTS>");
      this.mergedVastDocs.append("</VASTS>");
      String var1 = this.mergedVastDocs.toString();
      VASTLog.v("VASTProcessor", "Merged VAST doc:\n" + var1);
      return XmlTools.stringToDocument(var1);
   }

   public final VASTModel getModel() {
      return this.vastModel;
   }

   public final int process(String var1) {
      VASTLog.d("VASTProcessor", "process");
      this.vastModel = null;

      ByteArrayInputStream var5;
      try {
         var5 = new ByteArrayInputStream(var1.getBytes(Charset.defaultCharset().name()));
      } catch (UnsupportedEncodingException var4) {
         VASTLog.e("VASTProcessor", var4.getMessage(), var4);
         return 3;
      }

      int var2 = this.processUri(var5, 0);

      try {
         var5.close();
      } catch (IOException var3) {
         ;
      }

      if(var2 != 0) {
         return var2;
      } else {
         Document var6 = this.wrapMergedVastDocWithVasts();
         this.vastModel = new VASTModel(var6);
         return var6 == null?3:(!VASTModelPostValidator.validate(this.vastModel, this.mediaPicker)?5:0);
      }
   }
}
