package com.nexage.android.d;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

final class c {
   private static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");

   public static String a(Context var0) {
      Cursor var1 = var0.getContentResolver().query(a, new String[]{"aid"}, (String)null, (String[])null, (String)null);
      return var1 != null && var1.moveToFirst()?var1.getString(var1.getColumnIndex("aid")):null;
   }
}
