package com.nuance.nmdp.speechkit.util.dataupload;

import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;

public class Contact {
   private String a;
   private String b;
   private String c;
   private String d;
   private String e;
   private String f;
   private String g;
   private String h;
   private String i;

   public Contact(String var1, String var2, String var3) {
      this.a = var1;
      this.b = null;
      this.c = var3;
      this.d = null;
      this.g = var2;
      this.h = null;
      this.e = null;
      this.f = null;
      this.i = null;
   }

   final PdxValue$Dictionary a() {
      PdxValue$Dictionary var1 = new PdxValue$Dictionary();
      if(this.e != null) {
         var1.put("full_name", this.e);
      }

      if(this.a != null) {
         var1.put("first_name", this.a);
      }

      if(this.b != null) {
         var1.put("first_name_phonetic", this.b);
      }

      if(this.c != null) {
         var1.put("last_name", this.c);
      }

      if(this.d != null) {
         var1.put("last_name_phonetic", this.d);
      }

      if(this.f != null) {
         var1.put("nick_name", this.f);
      }

      if(this.g != null) {
         var1.put("middle_name", this.g);
      }

      if(this.h != null) {
         var1.put("middle_name_phonetic", this.h);
      }

      if(this.i != null) {
         var1.put("company", this.i);
      }

      return var1;
   }

   public void clearData() {
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.g = null;
      this.h = null;
      this.e = null;
      this.f = null;
      this.i = null;
   }

   public int getCheckSum() {
      int var2 = 0;
      if(this.a != null) {
         var2 = this.a.hashCode() + 0;
      }

      int var1 = var2;
      if(this.b != null) {
         var1 = var2 + this.b.hashCode();
      }

      var2 = var1;
      if(this.c != null) {
         var2 = var1 + this.c.hashCode();
      }

      var1 = var2;
      if(this.d != null) {
         var1 = var2 + this.d.hashCode();
      }

      var2 = var1;
      if(this.e != null) {
         var2 = var1 + this.e.hashCode();
      }

      var1 = var2;
      if(this.f != null) {
         var1 = var2 + this.f.hashCode();
      }

      var2 = var1;
      if(this.g != null) {
         var2 = var1 + this.g.hashCode();
      }

      var1 = var2;
      if(this.h != null) {
         var1 = var2 + this.h.hashCode();
      }

      var2 = var1;
      if(this.i != null) {
         var2 = var1 + this.i.hashCode();
      }

      return var2;
   }

   public String getCompany() {
      return this.i;
   }

   public String getFirstName() {
      return this.a;
   }

   public String getFirstNamePhonetic() {
      return this.b;
   }

   public String getFullName() {
      return this.e;
   }

   public String getLastName() {
      return this.c;
   }

   public String getLastNamePhonetic() {
      return this.d;
   }

   public String getMiddleName() {
      return this.g;
   }

   public String getMiddleNamePhonetic() {
      return this.h;
   }

   public String getNickName() {
      return this.f;
   }

   public void setCompany(String var1) {
      this.i = var1;
   }

   public void setFirstName(String var1) {
      this.a = var1;
   }

   public void setFirstNamePhonetic(String var1) {
      this.b = var1;
   }

   public void setFullName(String var1) {
      this.e = var1;
   }

   public void setLastName(String var1) {
      this.c = var1;
   }

   public void setLastNamePhonetic(String var1) {
      this.d = var1;
   }

   public void setMiddleName(String var1) {
      this.g = var1;
   }

   public void setMiddleNamePhonetic(String var1) {
      this.h = var1;
   }

   public void setNickName(String var1) {
      this.f = var1;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      if(this.a != null) {
         var1.append("firstname:" + this.a + "\n");
      }

      if(this.b != null) {
         var1.append("firstname_phonetic:" + this.b + "\n");
      }

      if(this.g != null) {
         var1.append("middlename:" + this.g + "\n");
      }

      if(this.h != null) {
         var1.append("middlename_phonetic:" + this.h + "\n");
      }

      if(this.c != null) {
         var1.append("lastname:" + this.c + "\n");
      }

      if(this.d != null) {
         var1.append("lastname_phonetic:" + this.d + "\n");
      }

      if(this.e != null) {
         var1.append("fullname:" + this.e + "\n");
      }

      if(this.f != null) {
         var1.append("nickname:" + this.f + "\n");
      }

      if(this.i != null) {
         var1.append("company:" + this.i + "\n");
      }

      return var1.toString();
   }
}
