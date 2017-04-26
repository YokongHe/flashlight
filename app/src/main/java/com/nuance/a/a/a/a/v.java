package com.nuance.a.a.a.a;

import java.util.Vector;

final class v extends Thread {
   private String a;
   private int b;
   private .an c;
   private .ak d;
   private .am e;
   private boolean f;
   private Vector g;
   private .cj h;
   private boolean i;
   // $FF: synthetic field
   private com.nuance.a.a.a.a.s j;

   public v(com.nuance.a.a.a.a.s var1, String var2, int var3, .an var4, .ak var5) {
      this.j = var1;
      super();
      this.a = null;
      this.c = null;
      this.d = null;
      this.e = .am.a;
      this.f = false;
      this.g = null;
      this.h = null;
      this.i = false;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.g = new Vector();
   }

   public v(com.nuance.a.a.a.a.s var1, String var2, int var3, .cj var4, .an var5, .ak var6) {
      this.j = var1;
      super();
      this.a = null;
      this.c = null;
      this.d = null;
      this.e = .am.a;
      this.f = false;
      this.g = null;
      this.h = null;
      this.i = false;
      this.a = var2;
      this.b = var3;
      this.c = var5;
      this.d = var6;
      this.g = new Vector();
      this.i = true;
      this.h = var4;
   }

   // $FF: synthetic method
   static boolean a(com.nuance.a.a.a.a.v var0) {
      return var0.f;
   }

   public final .am a(com.nuance.a.a.a.a.u param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a() {
      Object var1 = com.nuance.a.a.a.a.s.a(this.j);
      synchronized(var1) {
         this.f = true;
         this.g.removeAllElements();
         this.g = null;
         com.nuance.a.a.a.a.s.a(this.j).notify();
      }
   }

   public final void b() {
      // $FF: Couldn't be decompiled
   }

   public final void run() {
      // $FF: Couldn't be decompiled
   }
}
