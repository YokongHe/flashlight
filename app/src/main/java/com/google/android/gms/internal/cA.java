package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

public final class cA {
   private static final Uri a;
   private static final Uri b;

   static {
      Uri var0 = Uri.parse("http://plus.google.com/");
      a = var0;
      b = var0.buildUpon().appendPath("circles").appendPath("find").build();
   }

   public static Intent a() {
      return new Intent("android.settings.DATE_SETTINGS");
   }

   public static Intent a(String var0) {
      Uri var2 = Uri.fromParts("package", var0, (String)null);
      Intent var1 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      var1.setData(var2);
      return var1;
   }

   public static Intent b(String var0) {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(Uri.parse("market://details").buildUpon().appendQueryParameter("id", var0).build());
      var1.setPackage("com.android.vending");
      var1.addFlags(524288);
      return var1;
   }
}
