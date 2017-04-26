package com.tapjoy;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import com.tapjoy.TapjoyLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TapjoyUtil {
   private static String a = null;
   private static HashMap b = new HashMap();

   public static String SHA1(String var0) {
      return a("SHA-1", var0);
   }

   public static String SHA256(String var0) {
      return a("SHA-256", var0);
   }

   private static String a(String var0, String var1) {
      MessageDigest var5 = MessageDigest.getInstance(var0);
      var5.update(var1.getBytes("iso-8859-1"), 0, var1.length());
      byte[] var6 = var5.digest();
      StringBuffer var7 = new StringBuffer();

      for(int var2 = 0; var2 < var6.length; ++var2) {
         int var4 = var6[var2] >>> 4 & 15;
         int var3 = 0;

         while(true) {
            if(var4 >= 0 && var4 <= 9) {
               var7.append((char)(var4 + 48));
            } else {
               var7.append((char)(var4 - 10 + 97));
            }

            byte var8 = var6[var2];
            if(var3 > 0) {
               break;
            }

            ++var3;
            var4 = var8 & 15;
         }
      }

      return var7.toString();
   }

   public static Document buildDocument(String var0) {
      try {
         DocumentBuilderFactory var1 = DocumentBuilderFactory.newInstance();
         ByteArrayInputStream var3 = new ByteArrayInputStream(var0.getBytes("UTF-8"));
         Document var4 = var1.newDocumentBuilder().parse(var3);
         return var4;
      } catch (Exception var2) {
         TapjoyLog.e("TapjoyUtil", "buildDocument exception: " + var2.toString());
         return null;
      }
   }

   public static String convertURLParams(Map var0, boolean var1) {
      Iterator var3 = var0.entrySet().iterator();
      String var5 = "";

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         String var2 = var5;
         if(var5.length() > 0) {
            var2 = var5 + "&";
         }

         if(var1) {
            var5 = var2 + Uri.encode((String)var4.getKey()) + "=" + Uri.encode((String)var4.getValue());
         } else {
            var5 = var2 + (String)var4.getKey() + "=" + (String)var4.getValue();
         }
      }

      return var5;
   }

   public static Map convertURLParams(String var0, boolean var1) {
      HashMap var10 = new HashMap();
      String var6 = "";
      String var8 = "";
      boolean var5 = false;

      boolean var3;
      for(int var4 = 0; var4 < var0.length() && var4 != -1; var5 = var3) {
         char var2 = var0.charAt(var4);
         String var7;
         String var9;
         if(!var5) {
            if(var2 == 61) {
               if(var1) {
                  var6 = Uri.decode(var6);
               }

               var7 = "";
               var3 = true;
               var9 = var6;
            } else {
               var7 = var6 + var2;
               var9 = var8;
               var3 = var5;
            }
         } else {
            var9 = var8;
            var7 = var6;
            var3 = var5;
            if(var5) {
               if(var2 == 38) {
                  if(var1) {
                     var6 = Uri.decode(var6);
                  }

                  var7 = "";
                  var10.put(var8, var6);
                  var3 = false;
                  var9 = var8;
               } else {
                  var7 = var6 + var2;
                  var9 = var8;
                  var3 = var5;
               }
            }
         }

         ++var4;
         var8 = var9;
         var6 = var7;
      }

      if(var5 && var6.length() > 0) {
         var0 = var6;
         if(var1) {
            var0 = Uri.decode(var6);
         }

         var10.put(var8, var0);
      }

      return var10;
   }

   public static String copyTextFromJarIntoString(String var0) {
      return copyTextFromJarIntoString(var0, (Context)null);
   }

   public static String copyTextFromJarIntoString(String param0, Context param1) {
      // $FF: Couldn't be decompiled
   }

   public static Bitmap createBitmapFromView(View param0) {
      // $FF: Couldn't be decompiled
   }

   public static void deleteFileOrDirectory(File var0) {
      if(var0.isDirectory()) {
         File[] var3 = var0.listFiles();
         int var2 = var3.length;

         for(int var1 = 0; var1 < var2; ++var1) {
            deleteFileOrDirectory(var3[var1]);
         }
      }

      TapjoyLog.i("TapjoyUtil", "****************************************");
      TapjoyLog.i("TapjoyUtil", "deleteFileOrDirectory: " + var0.getAbsolutePath());
      TapjoyLog.i("TapjoyUtil", "****************************************");
      var0.delete();
   }

   public static String determineMimeType(String var0) {
      String var2 = "";
      String var1 = var0;
      if(var0.endsWith(".")) {
         var1 = var0.substring(0, var0.length() - 1);
      }

      var0 = var2;
      if(var1.lastIndexOf(46) != -1) {
         var0 = var1.substring(var1.lastIndexOf(46) + 1);
      }

      return var0.equals("css")?"text/css":(var0.equals("js")?"text/javascript":(var0.equals("html")?"text/html":"application/octet-stream"));
   }

   public static long fileOrDirectorySize(File var0) {
      File[] var6 = var0.listFiles();
      int var2 = var6.length;
      long var3 = 0L;

      for(int var1 = 0; var1 < var2; ++var1) {
         File var5 = var6[var1];
         if(var5.isFile()) {
            var3 += var5.length();
         } else {
            var3 += fileOrDirectorySize(var5);
         }
      }

      return var3;
   }

   public static String getNodeTrimValue(NodeList var0) {
      int var1 = 0;
      Element var6 = (Element)var0.item(0);
      if(var6 != null) {
         NodeList var4 = var6.getChildNodes();
         int var2 = var4.getLength();

         String var3;
         String var7;
         for(var7 = ""; var1 < var2; var7 = var3) {
            Node var5 = var4.item(var1);
            var3 = var7;
            if(var5 != null) {
               var3 = var7 + var5.getNodeValue();
            }

            ++var1;
         }

         if(var7 != null && !var7.equals("")) {
            return var7.trim();
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public static String getRedirectDomain(String var0) {
      String var1 = "";
      if(var0 != null) {
         var1 = var0.substring(var0.indexOf("//") + 2, var0.lastIndexOf("/"));
      }

      return var1;
   }

   public static Object getResource(String var0) {
      return b.get(var0);
   }

   public static Bitmap loadBitmapFromJar(String param0, Context param1) {
      // $FF: Couldn't be decompiled
   }

   public static void safePut(Map var0, String var1, String var2, boolean var3) {
      if(var1 != null && var1.length() > 0 && var2 != null && var2.length() > 0) {
         if(!var3) {
            var0.put(var1, var2);
            return;
         }

         var0.put(Uri.encode(var1), Uri.encode(var2));
      }

   }

   public static View scaleDisplayAd(View var0, int var1) {
      int var2 = var0.getLayoutParams().width;
      int var3 = var0.getLayoutParams().height;
      TapjoyLog.i("TapjoyUtil", "wxh: " + var2 + "x" + var3);
      if(var2 > var1) {
         int var4 = Double.valueOf(Double.valueOf(Double.valueOf((double)var1).doubleValue() / Double.valueOf((double)var2).doubleValue()).doubleValue() * 100.0D).intValue();
         ((WebView)var0).getSettings().setSupportZoom(true);
         ((WebView)var0).setPadding(0, 0, 0, 0);
         ((WebView)var0).setVerticalScrollBarEnabled(false);
         ((WebView)var0).setHorizontalScrollBarEnabled(false);
         ((WebView)var0).setInitialScale(var4);
         var0.setLayoutParams(new LayoutParams(var1, var3 * var1 / var2));
      }

      return var0;
   }

   public static void setResource(String var0, Object var1) {
      b.put(var0, var1);
   }

   public static void writeFileToDevice(BufferedInputStream var0, OutputStream var1) {
      byte[] var3 = new byte[1024];

      while(true) {
         int var2 = var0.read(var3);
         if(var2 == -1) {
            return;
         }

         var1.write(var3, 0, var2);
      }
   }
}
