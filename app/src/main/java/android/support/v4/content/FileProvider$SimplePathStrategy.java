package android.support.v4.content;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.content.FileProvider$PathStrategy;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class FileProvider$SimplePathStrategy implements FileProvider$PathStrategy {
   private final String mAuthority;
   private final HashMap mRoots = new HashMap();

   public FileProvider$SimplePathStrategy(String var1) {
      this.mAuthority = var1;
   }

   public void addRoot(String var1, File var2) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("Name must not be empty");
      } else {
         File var3;
         try {
            var3 = var2.getCanonicalFile();
         } catch (IOException var4) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + var2, var4);
         }

         this.mRoots.put(var1, var3);
      }
   }

   public File getFileForUri(Uri var1) {
      String var4 = var1.getEncodedPath();
      int var2 = var4.indexOf(47, 1);
      String var3 = Uri.decode(var4.substring(1, var2));
      var4 = Uri.decode(var4.substring(var2 + 1));
      File var7 = (File)this.mRoots.get(var3);
      if(var7 == null) {
         throw new IllegalArgumentException("Unable to find configured root for " + var1);
      } else {
         File var6 = new File(var7, var4);

         File var8;
         try {
            var8 = var6.getCanonicalFile();
         } catch (IOException var5) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + var6);
         }

         if(!var8.getPath().startsWith(var7.getPath())) {
            throw new SecurityException("Resolved path jumped beyond configured root");
         } else {
            return var8;
         }
      }
   }

   public Uri getUriForFile(File var1) {
      String var4;
      try {
         var4 = var1.getCanonicalPath();
      } catch (IOException var7) {
         throw new IllegalArgumentException("Failed to resolve canonical path for " + var1);
      }

      Entry var8 = null;

      Entry var2;
      for(Iterator var5 = this.mRoots.entrySet().iterator(); var5.hasNext(); var8 = var2) {
         Entry var3 = (Entry)var5.next();
         String var6 = ((File)var3.getValue()).getPath();
         if(var4.startsWith(var6)) {
            var2 = var3;
            if(var8 == null) {
               continue;
            }

            if(var6.length() > ((File)var8.getValue()).getPath().length()) {
               var2 = var3;
               continue;
            }
         }

         var2 = var8;
      }

      if(var8 == null) {
         throw new IllegalArgumentException("Failed to find configured root that contains " + var4);
      } else {
         String var10 = ((File)var8.getValue()).getPath();
         if(var10.endsWith("/")) {
            var10 = var4.substring(var10.length());
         } else {
            var10 = var4.substring(var10.length() + 1);
         }

         String var9 = Uri.encode((String)var8.getKey()) + '/' + Uri.encode(var10, "/");
         return (new Builder()).scheme("content").authority(this.mAuthority).encodedPath(var9).build();
      }
   }
}
