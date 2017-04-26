package com.ihs.app.alerts.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import java.util.List;
import java.util.Map;

public final class a {
   private static final Map c;
   private Activity a;
   private boolean b;

   static {
      ArrayMap var0 = new ArrayMap();
      c = var0;
      var0.put("0", "ActionOK");
      c.put("1", "ActionCancel");
      c.put("2", "ActionURL");
      c.put("3", "ActionRate");
      c.put("4", "ActionNotRate");
      c.put("5", "ActionDownload");
      c.put("6", "ActionMailTo");
      c.put("7", "ActionOpen");
   }

   public a(Activity var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   private OnClickListener a(final String var1, final Bundle var2) {
      return new OnClickListener() {
         public final void onClick(DialogInterface var1x, int var2x) {
            a.this.b(var1, var2);
         }
      };
   }

   private OnClickListener a(final String var1, final Map var2) {
      return new OnClickListener() {
         public final void onClick(DialogInterface var1x, int var2x) {
            String var5 = "HS" + var1;
            String var3 = com.ihs.a.e.g.a(var2, "", new String[]{"Type"});
            if("2".equals(var3)) {
               com.ihs.app.a.b.a(var5 + "_GoToURLButton_Clicked");
               a.this.a(String.valueOf(var2.get("URL")));
            } else if("3".equals(var3)) {
               var3 = com.ihs.a.e.g.a(var2, (String)null, new String[]{"EngagementID"});
               (new StringBuilder("engagement id is ")).append(var3).toString();
               if(TextUtils.isEmpty(var3)) {
                  com.ihs.app.a.b.a(var5 + "_RateButton_Clicked");
               } else {
                  com.ihs.a.e.e var4 = new com.ihs.a.e.e();
                  var4.a("ENGAGEMENTID_STRING", var3);
                  com.ihs.app.alerts.impl.b.a().c.a("hs.app.alerts.RATE_CLICKED", var4);
                  com.ihs.app.a.b.a(var5 + "_RateButton_Clicked", new String[]{"EngagementID", var3});
               }

               com.ihs.app.b.b.c();
               com.ihs.app.alerts.impl.i.f();
            } else if("4".equals(var3)) {
               com.ihs.app.alerts.impl.i.f();
            } else if("5".equals(var3)) {
               com.ihs.app.a.b.a(var5 + "_DownloadButton_Clicked");
               com.ihs.app.b.b.a((String)var2.get("Market"), (String)var2.get("URLScheme"));
            } else if("6".equals(var3)) {
               com.ihs.app.a.b.a(var5 + "_HateAndEmailToButton_Clicked");
               a.this.a((String)var2.get("Mailto"), (String)var2.get("MailSubject"), (String)var2.get("MailBody"));
               com.ihs.app.alerts.impl.i.f();
            }

            if(a.this.b) {
               a.this.a.finish();
            }

         }
      };
   }

   private void a(String var1) {
      try {
         Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         this.a.startActivity(var3);
      } catch (Exception var2) {
         var2.getLocalizedMessage();
      }
   }

   private void a(String var1, String var2, String var3) {
      if(!TextUtils.isEmpty(var1)) {
         try {
            Uri var6 = Uri.parse("mailto:" + var1);
            Intent var4 = new Intent("android.intent.action.SENDTO", var6);
            var4.putExtra("android.intent.extra.SUBJECT", var2);
            var4.putExtra("android.intent.extra.TEXT", var3);
            (new StringBuilder("emailTo(url) email to is ")).append(var6.toString()).toString();
            var4.setFlags(335544320);
            this.a.startActivity(var4);
         } catch (Exception var5) {
            var5.getLocalizedMessage();
         }
      }
   }

   private void b(String var1, Bundle var2) {
      if("2".equals(var1)) {
         com.ihs.app.a.b.a("HSPushAlert_Message_GotoUrl_Clicked");
         this.a(String.valueOf(var2.getString("URL")));
      } else if("3".equals(var1)) {
         com.ihs.app.alerts.impl.i.f();
      } else if("4".equals(var1)) {
         com.ihs.app.b.b.c();
         com.ihs.app.alerts.impl.i.f();
      } else if("5".equals(var1)) {
         com.ihs.app.b.b.a(var2.getString("Market"), var2.getString("Package"));
      } else {
         String var3;
         String var7;
         if("6".equals(var1)) {
            com.ihs.app.a.b.a("HSPushAlert_Message_SendEmail_Clicked");
            var1 = var2.getString("Mailto");
            var3 = var2.getString("MailSubject");
            var7 = var2.getString("MailBody");
            StringBuffer var4 = new StringBuffer();
            if(var7 != null) {
               var4.append("\n\n\n").append(var7);
            }

            this.a(var1, var3, var4.toString());
         } else if("7".equals(var1)) {
            com.ihs.app.a.b.a("HSPushAlert_Message_StartActivity_Clicked");
            var1 = var2.getString("Package");
            var3 = var2.getString("Activity");
            var7 = var2.getString("IntentFilter");

            try {
               if(!TextUtils.isEmpty(var1) && !TextUtils.isEmpty(var3)) {
                  Intent var8 = new Intent();
                  var8.setClassName(var1, var3);
                  var8.setFlags(335544320);
                  this.a.startActivity(var8);
               } else if(!TextUtils.isEmpty(var7)) {
                  Intent var6 = new Intent();
                  var6.setAction(var7);
                  this.a.startActivity(var6);
               }
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }
      }

      if(this.b) {
         this.a.finish();
      }

   }

   @SuppressLint({"NewApi"})
   public final AlertDialog a(String var1, int var2, Bundle var3) {
      int var4 = 0;
      this.a.toString();
      Builder var6;
      if(VERSION.SDK_INT >= 11) {
         var6 = new Builder(this.a, 2);
      } else {
         var6 = new Builder(this.a);
      }

      var6.setCancelable(false);
      var6.setIcon(this.a.getPackageManager().getApplicationIcon(this.a.getApplicationInfo()));
      (new StringBuilder("AlertName: ")).append(var1).toString();
      if("PushAlert".equals(var1)) {
         var1 = var3.getString("Actions");
         String[] var9;
         if(var2 == 2) {
            var9 = var1.split(",");
            if(var9.length > 0) {
               this.b(var9[0], var3);
            }

            if(this.b) {
               this.a.finish();
            }

            return null;
         }

         var6.setTitle(var3.getString("Title"));
         var6.setMessage(var3.getString("Body"));
         var9 = var1.split(",");
         int var5 = var9.length;

         for(var2 = 0; var4 < var5; ++var4) {
            String var7 = var9[var4];
            String var8 = (String)c.get(var7);
            if(!TextUtils.isEmpty(var8)) {
               if(var2 == 0) {
                  var6.setPositiveButton(var3.getString(var8), this.a(var7, var3));
               } else if(var2 == 1) {
                  var6.setNeutralButton(var3.getString(var8), this.a(var7, var3));
               } else {
                  if(var2 != 2) {
                     break;
                  }

                  var6.setNegativeButton(var3.getString(var8), this.a(var7, var3));
               }

               ++var2;
            }
         }
      } else {
         com.ihs.app.alerts.impl.c var10 = com.ihs.app.alerts.impl.b.a().a(var1);
         if(var10 == null) {
            return null;
         }

         var6.setTitle(com.ihs.app.alerts.impl.b.a(var10.d, "Title"));
         var6.setMessage(com.ihs.app.alerts.impl.b.a(var10.d, "Body"));
         List var11 = com.ihs.a.e.g.d(var10.d, new String[]{"Actions"});
         if(var11 != null) {
            if(var11.size() > 0) {
               var6.setPositiveButton(com.ihs.app.alerts.impl.b.a((Map)var11.get(0), "Text"), this.a(var10.a, (Map)var11.get(0)));
            }

            if(var11.size() > 1) {
               var6.setNeutralButton(com.ihs.app.alerts.impl.b.a((Map)var11.get(1), "Text"), this.a(var10.a, (Map)var11.get(1)));
            }

            if(var11.size() > 2) {
               var6.setNegativeButton(com.ihs.app.alerts.impl.b.a((Map)var11.get(2), "Text"), this.a(var10.a, (Map)var11.get(2)));
            }
         }
      }

      return var6.create();
   }
}
