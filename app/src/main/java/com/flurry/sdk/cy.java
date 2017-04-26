package com.flurry.sdk;

import android.content.Context;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import com.flurry.sdk.fd;
import java.io.File;
import java.util.Map;

public class cy {
   private static final String b = com.flurry.sdk.cy.class.getSimpleName();
   boolean a;
   private final com.flurry.sdk.cz c;
   private final File d;
   private String e;

   public cy() {
      this(do.a().b());
   }

   public cy(Context var1) {
      this.c = new com.flurry.sdk.cz();
      this.d = var1.getFileStreamPath(".flurryinstallreceiver.");
      eo.a(3, b, "Referrer file name if it exists:  " + this.d);
   }

   private void b() {
      if(!this.a) {
         this.a = true;
         eo.a(4, b, "Loading referrer info from file: " + this.d.getAbsolutePath());
         String var1 = fd.c(this.d);
         eo.a(b, "Referrer file contents: " + var1);
         this.b(var1);
      }
   }

   private void b(String var1) {
      if(var1 != null) {
         this.e = var1;
      }
   }

   private void c() {
      fd.a(this.d, this.e);
   }

   public Map a(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public void a() {
      synchronized(this){}

      try {
         this.d.delete();
         this.e = null;
         this.a = true;
      } finally {
         ;
      }

   }

   public void a(String var1) {
      synchronized(this){}

      try {
         this.a = true;
         this.b(var1);
         this.c();
      } finally {
         ;
      }

   }
}
