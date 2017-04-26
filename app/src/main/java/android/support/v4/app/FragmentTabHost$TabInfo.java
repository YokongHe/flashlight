package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

final class FragmentTabHost$TabInfo {
   private final Bundle args;
   private final Class clss;
   private Fragment fragment;
   private final String tag;

   FragmentTabHost$TabInfo(String var1, Class var2, Bundle var3) {
      this.tag = var1;
      this.clss = var2;
      this.args = var3;
   }

   // $FF: synthetic method
   static Fragment access$100(FragmentTabHost$TabInfo var0) {
      return var0.fragment;
   }

   // $FF: synthetic method
   static Fragment access$102(FragmentTabHost$TabInfo var0, Fragment var1) {
      var0.fragment = var1;
      return var1;
   }

   // $FF: synthetic method
   static String access$200(FragmentTabHost$TabInfo var0) {
      return var0.tag;
   }

   // $FF: synthetic method
   static Class access$300(FragmentTabHost$TabInfo var0) {
      return var0.clss;
   }

   // $FF: synthetic method
   static Bundle access$400(FragmentTabHost$TabInfo var0) {
      return var0.args;
   }
}
