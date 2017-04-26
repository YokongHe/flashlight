package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.sdk.eo;
import java.util.Iterator;
import java.util.List;

public final class bd implements com.flurry.sdk.bf {
   private static final String a = com.flurry.sdk.bd.class.getSimpleName();

   private boolean a(String var1, String var2, com.flurry.sdk.bc var3) {
      boolean var5 = false;
      if(!TextUtils.isEmpty(var1) && !TextUtils.isEmpty(var2) && var3 != null) {
         boolean var4 = var5;

         label28: {
            try {
               if(TextUtils.isEmpty(var3.c())) {
                  break label28;
               }

               Class.forName(var3.c());
            } catch (ClassNotFoundException var7) {
               eo.a(6, a, "failed to find third party ad provider api with exception: ", var7);
               var4 = var5;
               break label28;
            } catch (ExceptionInInitializerError var8) {
               eo.a(6, a, "failed to initialize third party ad provider api with exception: ", var8);
               var4 = var5;
               break label28;
            } catch (LinkageError var9) {
               eo.a(6, a, "failed to link third party ad provider api with exception: ", var9);
               var4 = var5;
               break label28;
            }

            var4 = true;
         }

         if(!var4) {
            eo.b(a, var1 + ": package=\"" + var2 + "\": apk should include ad provider library with name=\"" + var3.a() + "\" and version=\"" + var3.b() + "\" or higher");
            return var4;
         } else {
            eo.a(3, a, var1 + ": package=\"" + var2 + "\": apk has ad provider library with name=\"" + var3.a() + "\" and version=\"" + var3.b() + "\" or higher");
            return var4;
         }
      } else {
         return false;
      }
   }

   public final boolean a(Context var1, com.flurry.sdk.bj var2) {
      if(var2 != null) {
         String var4 = var2.a();
         if(!TextUtils.isEmpty(var4)) {
            List var6 = var2.b();
            if(var6 != null) {
               String var5 = var1.getPackageName();
               Iterator var7 = var6.iterator();
               boolean var3 = true;

               while(var7.hasNext()) {
                  if(!this.a(var4, var5, (com.flurry.sdk.bc)var7.next())) {
                     var3 = false;
                  }
               }

               return var3;
            }
         }
      }

      return false;
   }
}
