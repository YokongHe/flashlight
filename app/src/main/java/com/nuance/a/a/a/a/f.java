package com.nuance.a.a.a.a;

import java.util.Vector;

public final class f {
   private .ae a = .bh.a(this.getClass());
   private boolean b = false;
   private com.nuance.a.a.a.a.h c = new com.nuance.a.a.a.a.h((byte)0);

   private static native void a(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

   private static native int c();

   private static native int d();

   public final com.nuance.a.a.a.a.g a() {
      return this.b?com.nuance.a.a.a.a.g.a(c()):com.nuance.a.a.a.a.g.a;
   }

   public final void a(Vector var1) {
      boolean var3 = false;
      this.c.a = 0;
      this.c.b = 0;
      this.c.c = 50;
      this.c.d = 15;
      this.c.e = 7;
      this.c.g = 50;
      this.c.h = 5;
      this.c.i = 35;
      this.c.f = 0;
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            .bf var4 = (.bf)var1.get(var2);
            String var5 = var4.a();
            if(var5.equals("ep.enable")) {
               if((new String(var4.b())).equalsIgnoreCase("TRUE")) {
                  if(this.a.b()) {
                     this.a.b((Object)"Stop on end of speech is activated.");
                  }

                  this.c.a = 1;
               }
            } else if(var5.equals("ep.VadLongUtterance")) {
               if((new String(var4.b())).equalsIgnoreCase("TRUE")) {
                  this.c.b = 1;
               }
            } else {
               String var6;
               if(var5.equals("ep.VadHistoryLength")) {
                  var6 = new String(var4.b());
                  this.c.c = Integer.parseInt(var6);
               } else if(var5.equals("ep.VadBeginLength")) {
                  var6 = new String(var4.b());
                  this.c.d = Integer.parseInt(var6);
               } else if(var5.equals("ep.VadBeginThreshold")) {
                  var6 = new String(var4.b());
                  this.c.e = Integer.parseInt(var6);
               } else if(var5.equals("ep.VadEndLength")) {
                  var6 = new String(var4.b());
                  this.c.g = Integer.parseInt(var6);
               } else if(var5.equals("ep.VadEndThreshold")) {
                  var6 = new String(var4.b());
                  this.c.h = Integer.parseInt(var6);
               } else if(var5.equals("ep.VadInterSpeechLength")) {
                  var6 = new String(var4.b());
                  this.c.i = Integer.parseInt(var6);
               } else if(var5.equals("ep.VadBeginDelay")) {
                  var6 = new String(var4.b());
                  this.c.f = Integer.parseInt(var6);
               }
            }
         }
      }

      if(this.c.a == 1) {
         var3 = true;
      }

      this.b = var3;
      if(this.b) {
         a(this.c.a, this.c.b, this.c.c, this.c.d, this.c.e, this.c.f, this.c.g, this.c.h, this.c.i);
         this.b();
      }

   }

   public final void b() {
      if(this.b) {
         d();
      }

   }
}
