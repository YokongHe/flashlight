package com.ihs.a.e;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

final class k extends DefaultHandler {
   private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd\'T\'hh:mm:ss\'Z\'", Locale.getDefault());
   Object a;
   private String c;
   private int d = 0;
   private int e = 0;
   private Object f;
   private ArrayList g = new ArrayList();
   private StringBuilder h = new StringBuilder();

   private void a(Object var1) {
      this.f = var1;
      if(var1 == null) {
         this.e = 0;
      } else if(var1 instanceof HashMap) {
         this.e = 1;
      } else {
         this.e = 2;
      }
   }

   private void b(Object var1) {
      this.c(var1);
      this.g.add(var1);
      this.a(var1);
   }

   private void c(Object var1) {
      switch(this.e) {
      case 0:
         this.a = var1;
         return;
      case 1:
         ((HashMap)this.f).put(this.c, var1);
         return;
      case 2:
         ((ArrayList)this.f).add(var1);
         return;
      default:
      }
   }

   public final void characters(char[] var1, int var2, int var3) {
      this.h.append(var1, var2, var3);
   }

   public final void endElement(String var1, String var2, String var3) {
      switch(this.d) {
      case 1:
         this.c = this.h.toString().trim();
         break;
      case 2:
         this.c(this.h.toString());
         break;
      case 3:
         this.c(Integer.valueOf(this.h.toString().trim()));
         break;
      case 4:
         this.c(com.ihs.a.e.a.a((String)this.h.toString().trim(), 0));
         break;
      case 5:
         try {
            this.c(b.parse(this.h.toString().trim()));
         } catch (ParseException var5) {
            (new StringBuilder("Error parsing Date. key=")).append(this.c).toString();
         }
         break;
      case 6:
         this.c(Double.valueOf(this.h.toString().trim()));
      }

      this.d = 0;
      this.h.setLength(0);
      if(var2.equals("dict") || var2.equals("array")) {
         int var4 = this.g.size();
         if(var4 > 0) {
            this.g.remove(var4 - 1);
            Object var6 = null;
            if(var4 > 1) {
               var6 = this.g.get(var4 - 2);
            }

            this.a(var6);
         }
      }

   }

   public final void startElement(String var1, String var2, String var3, Attributes var4) {
      if(var2.equals("key")) {
         this.d = 1;
      } else if(var2.equals("string")) {
         this.d = 2;
      } else if(var2.equals("integer")) {
         this.d = 3;
      } else if(var2.equals("real")) {
         this.d = 6;
      } else if(var2.equals("data")) {
         this.d = 4;
      } else if(var2.equals("date")) {
         this.d = 5;
      } else if(var2.equals("true")) {
         this.c(Boolean.valueOf(true));
      } else if(var2.equals("false")) {
         this.c(Boolean.valueOf(false));
      } else if(var2.equals("dict")) {
         this.b(new HashMap());
      } else if(var2.equals("array")) {
         this.b(new ArrayList());
      }

      this.h.setLength(0);
   }
}
