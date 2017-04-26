package com.smaato.soma.internal.utilities;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.constant.Values;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class VersionVerifier extends AsyncTask {
   private final String VERSION_URL = "https://s3.amazonaws.com/smaato-sdk/sdk_versions.xml";

   protected Void doInBackground(Void... var1) {
      return (Void)(new CrashReportTemplate() {
         public Void process() {
            try {
               if(VERSION.SDK_INT < 8) {
                  return null;
               }

               HttpURLConnection var3 = (HttpURLConnection)(new URL("https://s3.amazonaws.com/smaato-sdk/sdk_versions.xml")).openConnection();
               var3.setRequestMethod("GET");
               var3.connect();
               InputStream var5 = var3.getInputStream();
               Document var6 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(var5);
               long var1 = (long)Integer.parseInt(((NodeList)XPathFactory.newInstance().newXPath().compile("/response/platforms/platform[@name=\'android\']/@version").evaluate(var6, XPathConstants.NODESET)).item(0).getNodeValue());
               if(var1 > Values.SDK_VERSION_CODE_INT) {
                  Debugger.showLog(new LogMessage("New SDK Version available", "Current Version " + Values.SDK_VERSION_CODE_INT + ", Version " + var1 + " is now available for download under www.smaato.com", 1, DebugCategory.WARNING));
                  return null;
               }
            } catch (Throwable var4) {
               Debugger.showLog(new LogMessage(this.getClass().getCanonicalName(), "Unable to verify SDK version on this Device.", 3, DebugCategory.ERROR, (Exception)var4));
            }

            return null;
         }
      }).execute();
   }
}
