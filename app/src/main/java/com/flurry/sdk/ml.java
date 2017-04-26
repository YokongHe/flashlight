package com.flurry.sdk;

import com.flurry.sdk.iy;
import com.flurry.sdk.jc;
import com.flurry.sdk.jg;
import com.flurry.sdk.jk;
import com.flurry.sdk.ju;
import com.flurry.sdk.lz;
import com.flurry.sdk.rg;
import com.flurry.sdk.sh;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class ml {
   public static final ml a = new ml();

   private Object a(String var1) {
      try {
         Object var4 = Class.forName(var1).newInstance();
         return var4;
      } catch (LinkageError var2) {
         ;
      } catch (Exception var3) {
         ;
      }

      return null;
   }

   private boolean a(Class var1, String var2) {
      while(true) {
         if(var1 != null) {
            if(!var1.getName().equals(var2) && !this.b(var1, var2)) {
               var1 = var1.getSuperclass();
               continue;
            }

            return true;
         }

         return false;
      }
   }

   private boolean b(Class var1, String var2) {
      Class[] var5 = var1.getInterfaces();
      int var4 = var5.length;

      int var3;
      for(var3 = 0; var3 < var4; ++var3) {
         if(var5[var3].getName().equals(var2)) {
            return true;
         }
      }

      var4 = var5.length;

      for(var3 = 0; var3 < var4; ++var3) {
         if(this.b(var5[var3], var2)) {
            return true;
         }
      }

      return false;
   }

   private boolean c(Class var1, String var2) {
      Class var3 = var1.getSuperclass();

      while(true) {
         Class var4 = var1;
         if(var3 == null) {
            while(var4 != null) {
               if(this.d(var4, var2)) {
                  return true;
               }

               var4 = var4.getSuperclass();
            }

            return false;
         }

         if(var3.getName().startsWith(var2)) {
            return true;
         }

         var3 = var3.getSuperclass();
      }
   }

   private boolean d(Class var1, String var2) {
      Class[] var5 = var1.getInterfaces();
      int var4 = var5.length;

      int var3;
      for(var3 = 0; var3 < var4; ++var3) {
         if(var5[var3].getName().startsWith(var2)) {
            return true;
         }
      }

      var4 = var5.length;

      for(var3 = 0; var3 < var4; ++var3) {
         if(this.d(var5[var3], var2)) {
            return true;
         }
      }

      return false;
   }

   public jg a(sh var1, iy var2, jc var3) {
      Class var6 = var1.p();
      String var5 = var6.getName();
      if(var5.startsWith("org.joda.time.")) {
         var5 = "com.flurry.org.codehaus.jackson.map.ext.JodaDeserializers";
      } else {
         if(!var5.startsWith("javax.xml.") && !this.c(var6, "javax.xml.")) {
            if(this.a(var6, "org.w3c.dom.Node")) {
               return (jg)this.a("com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer");
            }

            if(this.a(var6, "org.w3c.dom.Node")) {
               return (jg)this.a("com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer");
            }

            return null;
         }

         var5 = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLDeserializers";
      }

      Object var7 = this.a(var5);
      if(var7 == null) {
         return null;
      } else {
         Collection var8 = ((rg)var7).a();
         Iterator var9 = var8.iterator();

         lz var4;
         do {
            if(!var9.hasNext()) {
               Iterator var10 = var8.iterator();

               lz var11;
               do {
                  if(!var10.hasNext()) {
                     return null;
                  }

                  var11 = (lz)var10.next();
               } while(!var11.f().isAssignableFrom(var6));

               return var11;
            }

            var4 = (lz)var9.next();
         } while(var6 != var4.f());

         return var4;
      }
   }

   public jk a(ju var1, sh var2) {
      Class var6 = var2.p();
      String var5 = var6.getName();
      if(var5.startsWith("org.joda.time.")) {
         var5 = "com.flurry.org.codehaus.jackson.map.ext.JodaSerializers";
      } else {
         if(!var5.startsWith("javax.xml.") && !this.c(var6, "javax.xml.")) {
            if(this.a(var6, "org.w3c.dom.Node")) {
               return (jk)this.a("com.flurry.org.codehaus.jackson.map.ext.DOMSerializer");
            }

            return null;
         }

         var5 = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLSerializers";
      }

      Object var7 = this.a(var5);
      if(var7 == null) {
         return null;
      } else {
         Collection var8 = ((rg)var7).a();
         Iterator var3 = var8.iterator();

         Entry var4;
         do {
            if(!var3.hasNext()) {
               Iterator var9 = var8.iterator();

               Entry var10;
               do {
                  if(!var9.hasNext()) {
                     return null;
                  }

                  var10 = (Entry)var9.next();
               } while(!((Class)var10.getKey()).isAssignableFrom(var6));

               return (jk)var10.getValue();
            }

            var4 = (Entry)var3.next();
         } while(var6 != var4.getKey());

         return (jk)var4.getValue();
      }
   }
}
