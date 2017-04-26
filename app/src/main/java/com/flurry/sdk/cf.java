package com.flurry.sdk;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import org.apache.http.client.utils.URIUtils;

public class cf {
   private static final Pattern a = Pattern.compile("/");

   public static String a(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         URI var1 = f(var0);
         if(var1 != null) {
            return var1.toString();
         }
      }

      return null;
   }

   public static String a(String var0, String var1) {
      if(!TextUtils.isEmpty(var0) && !TextUtils.isEmpty(var1)) {
         URI var9 = f(var0);
         if(var9 != null) {
            URI var10 = var9.normalize();
            URI var15 = f(var1);
            if(var15 != null) {
               var9 = var15.normalize();
               if(!var10.isOpaque() && !var9.isOpaque()) {
                  var1 = var10.getScheme();
                  String var11 = var9.getScheme();
                  if((var11 != null || var1 == null) && (var11 == null || var11.equals(var1))) {
                     var1 = var10.getAuthority();
                     var11 = var9.getAuthority();
                     if((var11 != null || var1 == null) && (var11 == null || var11.equals(var1))) {
                        var11 = var10.getPath();
                        var1 = var9.getPath();
                        String[] var13 = a.split(var11, -1);
                        String[] var16 = a.split(var1, -1);
                        int var5 = var13.length;
                        int var6 = var16.length;

                        int var2;
                        for(var2 = 0; var2 < var6 && var2 < var5 && var13[var2].equals(var16[var2]); ++var2) {
                           ;
                        }

                        var1 = var10.getQuery();
                        String var18 = var10.getFragment();
                        var11 = var18;
                        StringBuilder var12 = new StringBuilder();
                        String var17;
                        if(var2 == var6 && var2 == var5) {
                           String var14 = var9.getQuery();
                           var17 = var9.getFragment();
                           boolean var7 = TextUtils.equals(var1, var14);
                           boolean var8 = TextUtils.equals(var18, var17);
                           if(var7 && var8) {
                              var18 = null;
                              var17 = null;
                           } else {
                              if(var7 && !TextUtils.isEmpty(var18)) {
                                 var17 = null;
                              } else {
                                 var17 = var1;
                              }

                              if(TextUtils.isEmpty(var17) && TextUtils.isEmpty(var18)) {
                                 var12.append(var13[var5 - 1]);
                              } else {
                                 var1 = var17;
                              }

                              var17 = var1;
                           }
                        } else {
                           int var3 = var2;

                           while(true) {
                              int var4 = var2;
                              if(var3 >= var6 - 1) {
                                 while(var4 < var5 - 1) {
                                    var12.append(var13[var4]);
                                    var12.append("/");
                                    ++var4;
                                 }

                                 if(var4 < var5) {
                                    var12.append(var13[var4]);
                                 }

                                 var17 = var1;
                                 var18 = var18;
                                 if(var12.length() == 0) {
                                    var12.append(".");
                                    var12.append("/");
                                    var17 = var1;
                                    var18 = var11;
                                 }
                                 break;
                              }

                              var12.append("..");
                              var12.append("/");
                              ++var3;
                           }
                        }

                        var15 = a((String)null, (String)null, var12.toString(), var17, var18);
                        if(var15 != null) {
                           return var15.toString();
                        }
                     }
                  }
               }
            }
         }
      }

      return var0;
   }

   private static URI a(String param0, String param1, String param2, String param3, String param4) {
      // $FF: Couldn't be decompiled
   }

   public static String b(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         URI var1 = f(var0);
         if(var1 != null) {
            var1 = var1.normalize();
            if(!var1.isOpaque()) {
               var1 = a(var1.getScheme(), var1.getAuthority(), "/", (String)null, (String)null);
               if(var1 != null) {
                  return var1.toString();
               }
            }
         }
      }

      return var0;
   }

   public static String c(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         URI var1 = f(var0);
         if(var1 != null) {
            var1 = var1.normalize();
            if(!var1.isOpaque()) {
               var1 = URIUtils.resolve(var1, "./");
               if(var1 != null) {
                  return var1.toString();
               }
            }
         }
      }

      return var0;
   }

   public static boolean d(String var0) {
      boolean var2 = false;
      boolean var1 = var2;
      if(!TextUtils.isEmpty(var0)) {
         Uri var3 = Uri.parse(var0);
         var1 = var2;
         if(var3.getScheme() != null) {
            var1 = var2;
            if(var3.getScheme().equals("market")) {
               var1 = true;
            }
         }
      }

      return var1;
   }

   public static boolean e(String var0) {
      boolean var2 = false;
      boolean var1 = var2;
      if(!TextUtils.isEmpty(var0)) {
         Uri var3 = Uri.parse(var0);
         var1 = var2;
         if(var3.getHost() != null) {
            var1 = var2;
            if(var3.getHost().equals("play.google.com")) {
               var1 = var2;
               if(var3.getScheme() != null) {
                  var1 = var2;
                  if(var3.getScheme().startsWith("http")) {
                     var1 = true;
                  }
               }
            }
         }
      }

      return var1;
   }

   private static URI f(String var0) {
      URI var4;
      try {
         var4 = new URI(var0);
      } catch (URISyntaxException var3) {
         return null;
      }

      try {
         URI var1 = a(var4.getScheme(), var4.getAuthority(), var4.getPath(), var4.getQuery(), var4.getFragment());
         return var1;
      } catch (URISyntaxException var2) {
         return var4;
      }
   }
}
