package com.flurry.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Toast;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.do;
import com.flurry.sdk.el;
import com.flurry.sdk.el$a;
import com.flurry.sdk.em;
import com.flurry.sdk.eo;
import com.flurry.sdk.fe;
import com.flurry.sdk.ff;
import com.flurry.sdk.r$a;
import com.flurry.sdk.r$b;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class r implements com.flurry.sdk.ad {
   private static final String d = com.flurry.sdk.r.class.getSimpleName();
   private static int e = 0;
   FlurryAdModule a;
   com.flurry.sdk.y b;
   com.flurry.sdk.ag c;
   private boolean f = true;

   public r(FlurryAdModule var1) {
      this.a = var1;
      this.c = new com.flurry.sdk.ag(var1);
      this.b = com.flurry.sdk.y.a();
   }

   private void a(com.flurry.sdk.a var1, String var2, int var3) {
      Context var4 = var1.c.a();
      com.flurry.sdk.e var5 = var1.c.d;
      AdUnit var6 = var1.c.c;
      HashMap var7 = new HashMap();
      var7.put("event", var1.c.a);
      var7.put("url", var2);
      var7.put("response", "" + var3);
      this.a.a((com.flurry.sdk.q)(new com.flurry.sdk.q("sendUrlStatusResult", var7, var4, var6, var5, var1.c.e)), (com.flurry.sdk.ad)this, 0);
   }

   private void a(final com.flurry.sdk.a var1, final String var2, final int var3, final r$b var4, int var5) {
      if(var3 >= 5) {
         eo.a(5, d, "No response for url: " + var2);
         if(var5 != 0) {
            this.a(var1, var2, var5);
         }

         if(var4 != null) {
            var4.a(true);
         }

      } else {
         el var6 = new el();
         var6.a((String)var2);
         var6.a(new el$a() {
            public void a(el var1x, Void var2x) {
               final int var3x = var1x.e();
               if(eo.c() <= 3 && eo.d()) {
                  do.a().a(new Runnable() {
                     public void run() {
                        Toast.makeText(do.a().b(), "sUUS HTTP Response Code: " + var3x, 0).show();
                     }
                  });
               }

               if(var3x == 200) {
                  eo.a(3, com.flurry.sdk.r.d, "URL hit succeeded for: " + var2);
                  r.this.a(var1, var2, var3x);
                  if(var4 != null) {
                     var4.a(true);
                  }

               } else {
                  r.this.a(var1, var2, var3 + 1, var4, var3x);
               }
            }
         });
         em.a().a(this, var6);
      }
   }

   private void a(final String var1, final String var2, final int var3, final r$a var4) {
      if(var4 != null) {
         if(var1 == null || var2 == null) {
            var4.a((String)null);
            return;
         }

         if(var3 >= 5) {
            var4.a((String)null);
            return;
         }

         var2 = com.flurry.sdk.cf.a(var2);
         if(!TextUtils.isEmpty(var2)) {
            if(var2.startsWith("http")) {
               el var5 = new el();
               var5.a((String)var2);
               var5.a(false);
               var5.a(new el$a() {
                  public void a(el var1x, Void var2x) {
                     final int var3x = var1x.e();
                     if(eo.c() <= 3 && eo.d()) {
                        do.a().a(new Runnable() {
                           public void run() {
                              Toast.makeText(do.a().b(), "pRU HTTP Response Code: " + var3x, 0).show();
                           }
                        });
                     }

                     if(var3x == 200) {
                        eo.a(3, com.flurry.sdk.r.d, "Redirect URL found for: " + var1);
                        var4.a(var2);
                     } else {
                        if(var3x >= 300 && var3x < 400) {
                           eo.a(3, com.flurry.sdk.r.d, "Num redirects: " + (var3 + 1));
                           List var4x = var1x.b((String)"Location");
                           if(var4x != null && var4x.size() > 0) {
                              r.this.a(var1, (String)var4x.get(0), var3 + 1, var4);
                              return;
                           }

                           eo.a(3, com.flurry.sdk.r.d, "No location for redirect url: " + var2);
                        } else {
                           eo.a(3, com.flurry.sdk.r.d, "Bad Response status code: " + var3x);
                        }

                        var4.a((String)null);
                     }
                  }
               });
               em.a().a(this, var5);
               return;
            }

            if(this.a(var2, "android.intent.action.VIEW")) {
               var4.a(var2);
               return;
            }

            if(!TextUtils.isEmpty(var2) && var2.startsWith("market://")) {
               var4.a(var2);
               return;
            }

            var4.a((String)null);
            return;
         }
      }

   }

   private boolean a(AdUnit var1) {
      return var1 != null && var1.d().size() > 0?((AdFrame)var1.d().get(0)).e().e().toString().equalsIgnoreCase("banner"):false;
   }

   public int a(com.flurry.sdk.a var1) {
      String var2 = var1.c.c.b().toString();
      return this.a.d().c().c(var2);
   }

   Intent a(Intent var1, String var2) {
      if(fe.b(var1)) {
         var1 = new Intent(var1);
      } else {
         Intent var3 = new Intent(do.a().b(), FlurryFullscreenTakeoverActivity.class);
         var3.putExtra("targetIntent", var1);
         var1 = var3;
      }

      if(var1 != null) {
         var1.putExtra("adSpaceName", var2);
      }

      return var1;
   }

   public String a(com.flurry.sdk.e var1, AdUnit var2, com.flurry.sdk.a var3, String var4) {
      Pattern var7 = Pattern.compile(".*?(%\\{\\w+\\}).*?");
      Matcher var6 = var7.matcher(var4);
      String var5 = var4;

      for(Matcher var8 = var6; var8.matches(); var8 = var7.matcher(var5)) {
         var5 = this.c.a(var1, var2, var3, var5, var8.group(1));
      }

      return var5;
   }

   public void a() {
      this.f = this.b((String)null);
   }

   void a(Context var1, String var2, AdUnit var3) {
      Intent var4 = do.a().c().getLaunchIntentForPackage(var2);
      if(var4 != null && fe.a(var4)) {
         this.a(var1, var4, var3.b().toString());
      } else {
         this.a(var1, "https://play.google.com/store/apps/details?id=" + var2, false, var3, true);
      }
   }

   public void a(Context var1, String var2, String var3) {
      if(var1 != null && !TextUtils.isEmpty(var2) && !TextUtils.isEmpty(var3)) {
         if(!var2.startsWith("market://details?id=")) {
            eo.a(5, d, "Unexpected Google Play url scheme: " + var2);
            return;
         }

         if(!this.f) {
            var2 = var2.substring(20);
            this.d(var1, "https://market.android.com/details?id=" + var2, var3);
            return;
         }

         if(!this.d(var1, var2, var3)) {
            eo.a(6, d, "Cannot launch Google Play url " + var2);
            return;
         }
      }

   }

   public void a(Context var1, String var2, boolean var3, AdUnit var4, String var5) {
      if(var1 == null) {
         eo.a(5, d, "Cannot process redirect, null context");
      } else {
         com.flurry.sdk.am var6 = this.a.c(var5);
         if(var6.h()) {
            var6.g(false);
            if(var1 instanceof FlurryFullscreenTakeoverActivity) {
               ((FlurryFullscreenTakeoverActivity)var1).setVideoMoreInfoInProgress(var6);
            }
         }

         this.a(var1, var2, var3, var4, false);
      }
   }

   void a(final Context var1, final String var2, final boolean var3, final AdUnit var4, final boolean var5) {
      if(var1 == null) {
         eo.a(5, d, "Unable to launch url, null context");
      } else {
         this.a.b(new ff() {
            public void a() {
               String var2x;
               if(var2 != null) {
                  var2x = var4.b().toString();
                  String var3x = com.flurry.sdk.cf.a(var2);
                  eo.a(5, com.flurry.sdk.r.d, "Generic Launch of " + var3x);
                  if(!TextUtils.isEmpty(var3x)) {
                     if(var3x.startsWith("market://")) {
                        r.this.a(var1, var3x, var2x);
                        return;
                     }

                     if(var3x.startsWith("http")) {
                        boolean var1x;
                        if(com.flurry.sdk.cf.e(var3x)) {
                           var1x = r.this.b(var1, var3x, var2x);
                        } else {
                           var1x = r.this.c(var1, var3x, var2x);
                        }

                        if(!var1x) {
                           Intent var4x = new Intent(do.a().b(), FlurryFullscreenTakeoverActivity.class);
                           var4x.putExtra("url", var3x);
                           var4x.putExtra("should_close_ad", var5);
                           if(var3 && fe.a(var4x)) {
                              r.this.a(var1, var4x, var2x);
                              return;
                           }

                           eo.a(6, com.flurry.sdk.r.d, "Unable to launch FlurryFullscreenTakeoverActivity, falling back to browser. Fix by declaring this Activity in your AndroidManifest.xml");
                           r.this.d(var1, var3x, var2x);
                           return;
                        }
                     } else if(!r.this.d(var1, var3x, var2x)) {
                        eo.a(5, com.flurry.sdk.r.d, "Failed to launch intent for:" + var3x);
                        return;
                     }
                  }

               } else {
                  var2x = "Unable to launch intent for: " + var2;
                  eo.a(5, com.flurry.sdk.r.d, var2x);
               }
            }
         });
      }
   }

   void a(com.flurry.sdk.a var1, int var2) {
      e = this.a(var1);
      if(var2 > e) {
         eo.a(5, d, "Maximum depth for event/action loop exceeded when performing next AdUnit:");
      } else {
         boolean var3;
         final boolean var4;
         long var5;
         final Context var7;
         final String var8;
         label34: {
            var7 = var1.c.a();
            AdUnit var9 = var1.c.c;
            var8 = var9.b().toString();
            var3 = var1.b.containsKey("delay");
            var4 = this.a(var9, var1.c.e);
            if(var3) {
               try {
                  var5 = Long.parseLong((String)var1.b.get("delay"));
                  break label34;
               } catch (NumberFormatException var10) {
                  eo.a(6, d, "caught NumberFormatException with delay parameter in nextAdUnit:" + (String)var1.b.get("delay"));
               }
            }

            var5 = 30L;
         }

         final com.flurry.sdk.l var11 = this.a.d().c(var8);
         if(var11 != null && var3 && var4) {
            var11.a(var5 * 1000L);
         } else if(var11 != null) {
            do.a().c(new ff() {
               public void a() {
                  com.flurry.sdk.u var2 = r.this.a.d();
                  Context var3 = var7;
                  String var4x = var8;
                  ViewGroup var5 = var11.getViewGroup();
                  FlurryAdSize var1;
                  if(var4) {
                     var1 = FlurryAdSize.BANNER_BOTTOM;
                  } else {
                     var1 = FlurryAdSize.FULLSCREEN;
                  }

                  var2.a(var3, var4x, var5, var1, true);
               }
            });
         } else if(var4) {
            do.a().c(new ff() {
               public void a() {
                  r.this.a.d().a(var7, var8, (ViewGroup)null, FlurryAdSize.BANNER_BOTTOM, false);
               }
            });
         } else {
            do.a().c(new ff() {
               public void a() {
                  r.this.a.d().a(var7, var8, (ViewGroup)null, FlurryAdSize.FULLSCREEN, true);
               }
            });
         }
      }
   }

   public void a(com.flurry.sdk.a var1, com.flurry.sdk.ae var2, int var3) {
      String var4 = null;
      if(var1.c != null) {
         var4 = var1.c.a;
      }

      eo.a(3, d, "performAction:action=" + var1.a + ",params=" + var1.b + ",triggering event=" + var4);
      String var5 = var1.a;
      if(var3 > 10) {
         eo.a(5, d, "Maximum depth for event/action loop exceeded when performing action:" + var5 + "," + var1.b + ",triggered by:" + var4);
      } else if(var5.equals("directOpen")) {
         this.b(var1);
      } else if(var5.equals("delete")) {
         this.c(var1);
      } else if(var5.equals("processRedirect")) {
         this.d(var1);
      } else if(var5.equals("verifyUrl")) {
         this.b(var1, var2, var3);
      } else if(var5.equals("launchPackage")) {
         this.e(var1);
      } else if(var5.equals("sendUrlAsync")) {
         this.f(var1);
      } else if(var5.equals("sendAdLogs")) {
         this.g(var1);
      } else if(var5.equals("logEvent")) {
         this.h(var1);
      } else if(var5.equals("nextFrame")) {
         this.i(var1);
      } else if(var5.equals("nextAdUnit")) {
         this.a(var1, var3);
      } else if(var5.equals("checkCap")) {
         this.c(var1, var2, var3);
      } else if(var5.equals("updateViewCount")) {
         this.j(var1);
      } else {
         eo.a(5, d, "Unknown action:" + var5 + ",triggered by:" + var4);
      }
   }

   void a(com.flurry.sdk.a var1, String var2) {
      eo.a(3, d, "url after is: " + var2);
      this.a((com.flurry.sdk.a)var1, (String)var2, (r$b)null);
   }

   void a(com.flurry.sdk.a var1, String var2, r$b var3) {
      this.a(var1, var2, 0, var3, 0);
   }

   void a(String var1, r$a var2) {
      this.a(var1, var1, 0, var2);
   }

   public boolean a(Context var1, Intent var2, String var3) {
      if(var1 == null) {
         eo.a(5, d, "Cannot launch activity, null context");
      } else if(var2 != null && var3 != null && fe.a(var2)) {
         var2 = this.a(var2, var3);

         try {
            var1.startActivity(var2);
            return true;
         } catch (ActivityNotFoundException var4) {
            eo.a(6, d, "Cannot launch Activity", var4);
            return false;
         }
      }

      return false;
   }

   boolean a(AdUnit var1, int var2) {
      return var1 != null && var1.d().size() > 0?((AdFrame)var1.d().get(var2)).e().e().toString().equals("banner"):false;
   }

   boolean a(String var1) {
      Intent var2 = do.a().c().getLaunchIntentForPackage(var1);
      return var2 != null && fe.a(var2);
   }

   boolean a(String var1, String var2) {
      Intent var3 = new Intent(var2);
      var3.setData(Uri.parse(var1));
      return fe.a(var3);
   }

   void b(final Context var1, final String var2, final boolean var3, final AdUnit var4, final boolean var5) {
      if(var1 == null) {
         eo.a(5, d, "Cannot process redirect, null context");
      } else {
         this.a(var2, new r$a() {
            public void a(String var1x) {
               if(var1x != null) {
                  eo.a(3, com.flurry.sdk.r.d, "Got final url after processRedirect:" + var1x);
                  r.this.a(var1, var1x, var3, var4, var5);
               } else {
                  eo.a(5, com.flurry.sdk.r.d, "Redirect URL could not be found for: " + var2);
               }
            }
         });
      }
   }

   void b(com.flurry.sdk.a var1) {
      Context var2 = var1.c.a();
      com.flurry.sdk.e var5 = var1.c.d;
      AdUnit var6 = var1.c.c;
      String var3 = var6.b().toString();
      if(var1.b.containsKey("url")) {
         String var4 = (String)var1.b.get("url");
         if(var4.startsWith("market://")) {
            this.a(var2, var4, var3);
         } else if("true".equals(var1.b.get("native"))) {
            eo.a(2, d, "Explictly instructed to use native browser");
            this.d(var2, this.a(var5, var6, var1, var4), var3);
         } else {
            if(this.a(var6)) {
               this.a.b(var5);
               this.a.b(var6);
            }

            Intent var7 = new Intent(do.a().b(), FlurryFullscreenTakeoverActivity.class);
            var7.putExtra("url", var4);
            var7.putExtra("is_mraid_ad", true);
            if(fe.a(var7)) {
               this.a(var2, var7, var3);
            } else {
               eo.a(6, d, "Can\'t start FlurryFullscreenTakeoverActivity, was it declared in the manifest? Falling back to default browser");
               this.d(var2, var4, var3);
            }
         }
      } else {
         eo.a(6, d, "failed to perform directOpen action: no url in " + var1.c.a);
      }
   }

   void b(com.flurry.sdk.a var1, com.flurry.sdk.ae var2, int var3) {
      Context var5 = var1.c.a();
      com.flurry.sdk.e var6 = var1.c.d;
      AdUnit var7 = var1.c.c;
      if(var1.b.containsKey("url")) {
         String var4;
         if(this.a((String)var1.b.get("url"))) {
            var4 = "urlVerified";
         } else {
            var4 = "urlNotVerified";
         }

         this.a.a(var4, 1);
         var2.a(new com.flurry.sdk.q(var4, Collections.emptyMap(), var5, var7, var6, var1.c.e), this, var3 + 1);
      }

   }

   public void b(com.flurry.sdk.a var1, String var2) {
      eo.a(3, d, "url after is: " + var2);
      this.a(var1, var2, 4, (r$b)null, 0);
   }

   public boolean b(Context var1, String var2, String var3) {
      if(var1 != null && !TextUtils.isEmpty(var2) && !TextUtils.isEmpty(var3)) {
         Intent var4 = com.flurry.sdk.h.b(var1, var2);
         if(var4 != null) {
            return this.a(var1, var4, var3);
         } else {
            eo.a(5, d, "Google Play is not installed: " + var2);
            return false;
         }
      } else {
         return false;
      }
   }

   boolean b(String var1) {
      String var3 = do.a().b().getPackageName();
      String var2 = var1;
      if(var1 == null) {
         var2 = "market://details?id=" + var3;
      }

      return this.a(var2, "android.intent.action.VIEW");
   }

   void c(com.flurry.sdk.a var1) {
      String var3 = var1.c.c.b().toString();
      String var6;
      if(var1.b.containsKey("count")) {
         var6 = (String)var1.b.get("count");

         int var2;
         try {
            var2 = Integer.parseInt(var6);
         } catch (NumberFormatException var5) {
            eo.a(6, d, "caught NumberFormatException with count parameter in deleteAds:" + var6);
            var2 = -1;
         }

         this.a.d().a(var3, var2);
      } else if(var1.b.containsKey("groupId")) {
         var6 = (String)var1.b.get("groupId");
         this.a.d().a(var3, var6);
         return;
      }

   }

   void c(com.flurry.sdk.a var1, com.flurry.sdk.ae var2, int var3) {
      Context var7 = var1.c.a();
      com.flurry.sdk.e var8 = var1.c.d;
      AdUnit var9 = var1.c.c;
      if(var1.b.containsKey("idHash")) {
         String var10 = (String)var1.b.get("idHash");
         com.flurry.sdk.x var5 = this.b.a(var10);
         String var6 = "capNotExhausted";
         com.flurry.sdk.x var4 = var5;
         if(var5 != null) {
            var4 = var5;
            if(this.b.a(var5.h())) {
               eo.a(4, d, "Discarding expired frequency cap info for idHash=" + var10);
               this.b.b(var10);
               var4 = null;
            }
         }

         String var11 = var6;
         if(var4 != null) {
            var11 = var6;
            if(var4.c() >= var4.e()) {
               eo.a(4, d, "Frequency cap exhausted for idHash=" + var10);
               var11 = "capExhausted";
            }
         }

         this.a.a(var11, 1);
         var2.a(new com.flurry.sdk.q(var11, Collections.emptyMap(), var7, var9, var8, var1.c.e), this, var3 + 1);
      }

   }

   public boolean c(Context var1, String var2, String var3) {
      if(var1 != null && !TextUtils.isEmpty(var2) && !TextUtils.isEmpty(var3)) {
         Intent var4 = com.flurry.sdk.h.a(var1, var2);
         if(var4 != null) {
            return this.a(var1, var4, var3);
         } else {
            eo.a(5, d, "Cannot launch App: " + var2);
            return false;
         }
      } else {
         return false;
      }
   }

   void d(com.flurry.sdk.a var1) {
      Context var3 = var1.c.a();
      com.flurry.sdk.e var5 = var1.c.d;
      AdUnit var4 = var1.c.c;
      if(var1.b.containsKey("url")) {
         String var6 = (String)var1.b.get("url");
         boolean var2;
         if(var1.b.containsKey("native")) {
            var2 = "false".equals(var1.b.get("native"));
         } else {
            var2 = true;
         }

         if(!TextUtils.isEmpty(var6)) {
            String var7 = com.flurry.sdk.cf.a(this.a(var5, var4, var1, var6));
            if(!TextUtils.isEmpty(var7)) {
               if(!var7.startsWith("http")) {
                  this.a(var3, var7, false, var4, true);
                  return;
               }

               eo.a(3, d, "Calling processRedirectURL for: " + var7 + " and launching in webView: " + var2);
               this.b(var3, var7, var2, var4, true);
            }
         }
      }

   }

   public boolean d(Context var1, String var2, String var3) {
      if(var1 == null) {
         eo.a(5, d, "Cannot launch url, null context");
         return false;
      } else {
         return this.a(var1, (new Intent("android.intent.action.VIEW")).setData(Uri.parse(var2)), var3);
      }
   }

   void e(com.flurry.sdk.a var1) {
      Context var2 = var1.c.a();
      AdUnit var3 = var1.c.c;
      if(var1.b.containsKey("package")) {
         this.a(var2, (String)var1.b.get("package"), var3);
      }

   }

   void f(com.flurry.sdk.a var1) {
      com.flurry.sdk.e var2 = var1.c.d;
      AdUnit var3 = var1.c.c;
      if(var1.b.containsKey("url")) {
         this.a(var1, this.a(var2, var3, var1, (String)var1.b.get("url")));
      }

   }

   void g(com.flurry.sdk.a var1) {
      this.a.C();
   }

   void h(com.flurry.sdk.a var1) {
      boolean var2;
      if(var1.b.containsKey("__sendToServer") && ((String)var1.b.get("__sendToServer")).equals("true")) {
         var2 = true;
      } else {
         var2 = false;
      }

      var1.b.remove("__sendToServer");
      this.a.a(var1.c.d, var1.c.a, var2, var1.b);
   }

   void i(com.flurry.sdk.a var1) {
   }

   void j(com.flurry.sdk.a var1) {
      if(var1.b.containsKey("idHash")) {
         String var2 = (String)var1.b.get("idHash");
         com.flurry.sdk.x var4 = this.b.a(var2);
         if(var4 != null) {
            var4.d();
            eo.a(4, d, "updateViewCount:idHash=" + var4.b() + ",newCap=" + var4.e() + ",prevCap=" + var4.f() + ",views=" + var4.c());
            if(var4.c() >= var4.e()) {
               String var3 = var1.c.c.b().toString();
               if(var4.c() > var4.e()) {
                  eo.a(6, d, "FlurryAdAction: !! rendering a capped object: " + var4.b() + " for adspace: " + var3);
               } else {
                  eo.a(4, d, "FlurryAdAction: hit cap for object: " + var4.b() + ", cache cleared for adspace: " + var3);
               }

               this.a.d().d(var3);
            }
         }
      }

   }
}
