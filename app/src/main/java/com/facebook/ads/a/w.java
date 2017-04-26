package com.facebook.ads.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class w extends AsyncTask {
   private static final String a = com.facebook.ads.a.w.class.getSimpleName();
   private final ImageView b;
   private com.facebook.ads.a.x c;

   public w(ImageView var1) {
      this.b = var1;
   }

   protected Bitmap a(String... var1) {
      String var3 = var1[0];
      HttpClient var6 = com.facebook.ads.a.p.b();
      HttpGet var2 = new HttpGet(var3);

      Bitmap var7;
      Exception var9;
      label19: {
         HttpEntity var10;
         try {
            var10 = var6.execute(var2).getEntity();
            byte[] var8 = EntityUtils.toByteArray(var10);
            var7 = BitmapFactory.decodeByteArray(var8, 0, var8.length);
         } catch (Exception var5) {
            var9 = var5;
            var7 = null;
            break label19;
         }

         try {
            var10.consumeContent();
            return var7;
         } catch (Exception var4) {
            var9 = var4;
         }
      }

      Log.e(a, "Error downloading image: " + var3, var9);
      return var7;
   }

   public com.facebook.ads.a.w a(com.facebook.ads.a.x var1) {
      this.c = var1;
      return this;
   }

   protected void a(Bitmap var1) {
      this.b.setImageBitmap(var1);
      if(this.c != null) {
         this.c.d();
      }

   }

   // $FF: synthetic method
   protected Object doInBackground(Object[] var1) {
      return this.a((String[])var1);
   }

   // $FF: synthetic method
   protected void onPostExecute(Object var1) {
      this.a((Bitmap)var1);
   }
}
