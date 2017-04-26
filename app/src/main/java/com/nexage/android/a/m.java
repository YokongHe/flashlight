package com.nexage.android.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public abstract class m {
   private static com.nexage.android.a.n a;
   public static Context b;
   public static volatile String c;
   public static float d;
   public static int e;
   public static int f;

   public static String i() {
      if(a == null) {
         a = new com.nexage.android.a.n((byte)0);
      }

      return a.a;
   }

   public static int j() {
      // $FF: Couldn't be decompiled
   }

   public abstract boolean a();

   public abstract boolean a(com.nexage.android.a.a var1);

   public abstract Activity c();

   public abstract void d();

   public abstract void e();

   public abstract com.nexage.android.b.a f();

   public abstract boolean g();

   public abstract View h();
}
