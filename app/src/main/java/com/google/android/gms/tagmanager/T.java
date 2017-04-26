package com.google.android.gms.tagmanager;

final class T {
   private com.google.android.gms.tagmanager.a a;
   private com.google.android.gms.tagmanager.U b;
   private boolean c;

   public final void a() {
      synchronized(this){}

      try {
         if(this.c) {
            com.google.android.gms.tagmanager.n.a("Refreshing a released ContainerHolder.");
         } else {
            com.google.android.gms.tagmanager.U var1 = this.b;
         }
      } finally {
         ;
      }

   }

   public final void a(String param1) {
      // $FF: Couldn't be decompiled
   }

   final String b() {
      if(this.c) {
         com.google.android.gms.tagmanager.n.a("getContainerId called on a released ContainerHolder.");
         return "";
      } else {
         return this.a.a();
      }
   }

   final void b(String var1) {
      if(this.c) {
         com.google.android.gms.tagmanager.n.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      } else {
         com.google.android.gms.tagmanager.U var2 = this.b;
      }
   }

   final String c() {
      if(this.c) {
         com.google.android.gms.tagmanager.n.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
         return "";
      } else {
         return this.b.a();
      }
   }
}
