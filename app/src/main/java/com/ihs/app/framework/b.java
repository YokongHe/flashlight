package com.ihs.app.framework;

import android.app.Activity;

public final class b {
   public static void a(Activity var0) {
      synchronized(com.ihs.app.framework.b.class){}

      try {
         com.ihs.app.framework.a.b.a().b();
      } finally {
         ;
      }

   }

   public static void a(Activity var0, boolean var1) {
      synchronized(com.ihs.app.framework.b.class){}

      try {
         com.ihs.app.framework.a.b.a().a(var1);
      } finally {
         ;
      }

   }

   public static void b(Activity var0) {
      synchronized(com.ihs.app.framework.b.class){}

      try {
         com.ihs.app.framework.a.b.a().c();
      } finally {
         ;
      }

   }

   public static void c(Activity var0) {
      synchronized(com.ihs.app.framework.b.class){}

      try {
         com.ihs.app.framework.a.b.a().a(var0);
      } finally {
         ;
      }

   }
}
