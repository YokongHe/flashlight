package com.ihs.a.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Pattern;

final class c {
   private static final Pattern a = Pattern.compile("\\s*\\d{0,999}\\s*-\\s*\\d{0,999}\\s*");
   private Map b;
   private Context c;
   private String d;
   private String e;
   private String f;
   private com.ihs.a.b.e g;
   private Thread h;

   public c(Context var1, String var2, String var3, boolean var4) {
      (new StringBuilder("assetFileName=")).append(var3).append("\rremotePlistUrl=").append(var2).append("\rdeleteCachedFile=").append(var4).toString();
      this.c = var1;
      this.f = var3;
      this.d = var2;
      if(!com.ihs.a.e.i.a(this.f)) {
         (new StringBuilder("Using unencrypted plist file is not allowed, please use PA instead !!! ")).append(this.f).toString();
      }

      if(!TextUtils.isEmpty(var2)) {
         String[] var6 = var2.split("/");
         this.e = var6[var6.length - 1];
      }

      if(var4 && !TextUtils.isEmpty(this.e)) {
         File var7 = new File(this.c.getFilesDir().getPath(), this.e);
         if(var7.exists()) {
            var7.delete();
         }
      }

      if(!TextUtils.isEmpty(var3) || !TextUtils.isEmpty(this.e)) {
         Map var8 = a(this.c, this.e, this.f);
         if(var8 != null) {
            b(var8);
            this.c(var8);
            synchronized(this) {
               this.b = com.ihs.a.e.g.e(var8, new String[]{"Data"});
               this.g = b(this.c, this.b);
               return;
            }
         }
      }

   }

   // $FF: synthetic method
   static Context a(com.ihs.a.b.c var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static com.ihs.a.b.e a(Context var0, Map var1) {
      return b(var0, var1);
   }

   // $FF: synthetic method
   static com.ihs.a.b.e a(com.ihs.a.b.c var0, com.ihs.a.b.e var1) {
      var0.g = var1;
      return var1;
   }

   // $FF: synthetic method
   static Thread a(com.ihs.a.b.c var0, Thread var1) {
      var0.h = null;
      return null;
   }

   private static Map a(Context param0, String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void a(com.ihs.a.b.c var0, Map var1) {
      var0.c(var1);
   }

   // $FF: synthetic method
   static void a(Map var0) {
      b(var0);
   }

   private static com.ihs.a.b.e b(Context var0, Map var1) {
      com.ihs.a.b.e var4 = new com.ihs.a.b.e();
      if(var1 == null) {
         return var4;
      } else {
         List var11 = com.ihs.a.e.g.d(var1, new String[]{"RestrictedUser"});
         if(var11 != null && var11.size() > 0) {
            List var9 = var0.getPackageManager().getInstalledApplications(8192);
            Iterator var12 = var11.iterator();

            boolean var3;
            String var10;
            while(true) {
               if(!var12.hasNext()) {
                  var10 = "";
                  var3 = false;
                  break;
               }

               Object var5 = var12.next();
               Map var6 = (Map)var5;
               boolean var2;
               if(var6.isEmpty()) {
                  var2 = false;
               } else {
                  int var13 = TimeZone.getDefault().getRawOffset() / 3600000;
                  String var7 = com.ihs.a.e.g.c(var6, new String[]{"TimeZone"});
                  if(!TextUtils.isEmpty(var7) && !String.valueOf(var13).equalsIgnoreCase(var7)) {
                     var2 = false;
                  } else {
                     var7 = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
                     String var8 = com.ihs.a.e.g.c(var6, new String[]{"RegionFormat"});
                     if(!TextUtils.isEmpty(var8) && !var7.equalsIgnoreCase(var8)) {
                        var2 = false;
                     } else {
                        List var14 = com.ihs.a.e.g.d(var6, new String[]{"UrlScheme"});
                        if(var14 != null && !var14.isEmpty()) {
                           Iterator var15 = var14.iterator();

                           while(true) {
                              if(!var15.hasNext()) {
                                 var2 = true;
                                 break;
                              }

                              Object var16 = var15.next();
                              Iterator var17 = var9.iterator();

                              while(true) {
                                 if(!var17.hasNext()) {
                                    var2 = false;
                                    break;
                                 }

                                 if(((ApplicationInfo)var17.next()).packageName.equalsIgnoreCase((String)var16)) {
                                    var2 = true;
                                    break;
                                 }
                              }

                              if(!var2) {
                                 var2 = false;
                                 break;
                              }
                           }
                        } else {
                           var2 = true;
                        }
                     }
                  }
               }

               if(var2) {
                  var10 = com.ihs.a.e.g.a((Map)var5, "", new String[]{"Description"});
                  var3 = true;
                  break;
               }
            }

            var4.a = var3;
            var4.b = var10;
            return var4;
         } else {
            return var4;
         }
      }
   }

   // $FF: synthetic method
   static String b(com.ihs.a.b.c var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static Map b(com.ihs.a.b.c var0, Map var1) {
      var0.b = var1;
      return var1;
   }

   private static void b(Map var0) {
      if(var0 != null) {
         Map var2 = com.ihs.a.e.g.e(var0, new String[]{"Data"});
         (new StringBuilder("mergeRegions(), main data = ")).append(var2).toString();
         Map var3 = com.ihs.a.e.g.e(var0, new String[]{"Regions"});
         if(var3 != null) {
            String var4 = Locale.getDefault().getCountry().trim();
            var0 = com.ihs.a.e.g.e(var3, new String[]{var4});
            Map var1 = var0;
            if(var0 == null) {
               var1 = com.ihs.a.e.g.e(var3, new String[]{Locale.getDefault().getCountry().toUpperCase()});
            }

            var0 = var1;
            if(var1 == null) {
               var0 = com.ihs.a.e.g.e(var3, new String[]{Locale.getDefault().getCountry().toLowerCase()});
            }

            if(var0 == null) {
               Iterator var6 = var3.keySet().iterator();

               while(var6.hasNext()) {
                  String var5 = (String)var6.next();
                  if(var5.toUpperCase().equals(var4.toUpperCase())) {
                     var0 = com.ihs.a.e.g.e(var3, new String[]{var5});
                     break;
                  }
               }
            }

            if(var0 != null) {
               com.ihs.a.e.g.a(var2, com.ihs.a.e.g.e(var0, new String[]{"Data"}));
               return;
            }
         }
      }

   }

   // $FF: synthetic method
   static String c(com.ihs.a.b.c var0) {
      return var0.d;
   }

   private void c(Map var1) {
      if(var1 != null) {
         int var2 = com.ihs.a.e.j.a(this.c).a("hs.commons.config.Test_User_Token", -1);
         int var3 = var2;
         if(-1 == var2) {
            var3 = (new Random(System.currentTimeMillis())).nextInt(1000);
            com.ihs.a.e.j.a(this.c).b("hs.commons.config.Test_User_Token", var3);
         }

         Map var7 = com.ihs.a.e.g.e(var1, new String[]{"Segments"});
         if(var7 != null) {
            Map var6 = null;
            var2 = Integer.MAX_VALUE;
            Iterator var8 = var7.keySet().iterator();

            while(var8.hasNext()) {
               String var9 = (String)var8.next();
               String var10 = var9.replace(" ", "");
               if(a.matcher(var10).matches()) {
                  String[] var11 = var10.split("-");
                  if(2 == var11.length) {
                     int var4 = Integer.valueOf(var11[0]).intValue();
                     int var5 = Integer.valueOf(var11[1]).intValue();
                     if(var4 <= var5 && var3 >= var4 && var3 <= var5 && var4 < var2) {
                        var6 = com.ihs.a.e.g.e(var7, new String[]{var9, "Data"});
                        var2 = var4;
                     }
                  }
               }
            }

            if(var6 != null) {
               com.ihs.a.e.g.a(com.ihs.a.e.g.e(var1, new String[]{"Data"}), var6);
               return;
            }
         }
      }

   }

   // $FF: synthetic method
   static Map d(com.ihs.a.b.c var0) {
      return var0.b;
   }

   public final Map a() {
      return this.b;
   }

   public final void a(final com.ihs.a.b.d var1) {
      if(TextUtils.isEmpty(this.d)) {
         var1.a(false);
      } else if(this.h != null) {
         var1.a(false);
      } else {
         this.h = new Thread(new Runnable() {
            public final void run() {
               // $FF: Couldn't be decompiled
            }
         });
         this.h.start();
      }
   }

   public final boolean b() {
      return this.g == null?false:this.g.a;
   }

   public final String c() {
      return this.g == null?"":this.g.b;
   }

   protected final Object clone() {
      throw new CloneNotSupportedException();
   }
}
