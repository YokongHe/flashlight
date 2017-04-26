package com.millennialmedia.android;

import android.location.Location;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class MMRequest {
   public static final String EDUCATION_ASSOCIATES = "associates";
   public static final String EDUCATION_BACHELORS = "bachelors";
   public static final String EDUCATION_DOCTORATE = "doctorate";
   public static final String EDUCATION_HIGH_SCHOOL = "highschool";
   public static final String EDUCATION_IN_COLLEGE = "incollege";
   public static final String EDUCATION_MASTERS = "masters";
   public static final String EDUCATION_OTHER = "other";
   public static final String EDUCATION_SOME_COLLEGE = "somecollege";
   public static final String ETHNICITY_ASIAN = "asian";
   public static final String ETHNICITY_BLACK = "black";
   public static final String ETHNICITY_HISPANIC = "hispanic";
   public static final String ETHNICITY_INDIAN = "indian";
   public static final String ETHNICITY_MIDDLE_EASTERN = "middleeastern";
   public static final String ETHNICITY_NATIVE_AMERICAN = "nativeamerican";
   public static final String ETHNICITY_OTHER = "other";
   public static final String ETHNICITY_PACIFIC_ISLANDER = "pacificislander";
   public static final String ETHNICITY_WHITE = "white";
   public static final String GENDER_FEMALE = "female";
   public static final String GENDER_MALE = "male";
   public static final String GENDER_OTHER = "other";
   public static final String KEY_AGE = "age";
   public static final String KEY_CHILDREN = "children";
   public static final String KEY_EDUCATION = "education";
   public static final String KEY_ETHNICITY = "ethnicity";
   public static final String KEY_GENDER = "gender";
   public static final String KEY_HEIGHT = "hsht";
   public static final String KEY_INCOME = "income";
   public static final String KEY_KEYWORDS = "keywords";
   public static final String KEY_MARITAL_STATUS = "marital";
   public static final String KEY_POLITICS = "politics";
   public static final String KEY_VENDOR = "vendor";
   public static final String KEY_WIDTH = "hswd";
   public static final String KEY_ZIP_CODE = "zip";
   public static final String MARITAL_DIVORCED = "divorced";
   public static final String MARITAL_ENGAGED = "engaged";
   public static final String MARITAL_MARRIED = "married";
   public static final String MARITAL_OTHER = "other";
   public static final String MARITAL_RELATIONSHIP = "relationship";
   public static final String MARITAL_SINGLE = "single";
   static Location location;
   String age = null;
   String children = null;
   String education = null;
   String ethnicity = null;
   String gender = null;
   String income = null;
   String keywords = null;
   String marital = null;
   String politics = null;
   private Map values = new HashMap();
   String vendor = null;
   String zip = null;

   public static Location getUserLocation() {
      return location;
   }

   static void insertLocation(Map var0) {
      if(location != null) {
         var0.put("lat", Double.toString(location.getLatitude()));
         var0.put("long", Double.toString(location.getLongitude()));
         if(location.hasAccuracy()) {
            var0.put("ha", Float.toString(location.getAccuracy()));
            var0.put("va", Float.toString(location.getAccuracy()));
         }

         if(location.hasSpeed()) {
            var0.put("spd", Float.toString(location.getSpeed()));
         }

         if(location.hasBearing()) {
            var0.put("brg", Float.toString(location.getBearing()));
         }

         if(location.hasAltitude()) {
            var0.put("alt", Double.toString(location.getAltitude()));
         }

         var0.put("tslr", Long.toString(location.getTime()));
         var0.put("loc", "true");
         var0.put("lsrc", location.getProvider());
      } else {
         var0.put("loc", "false");
      }
   }

   public static void setUserLocation(Location var0) {
      if(var0 != null) {
         location = var0;
      }
   }

   final void getUrlParams(Map var1) {
      Iterator var2 = this.values.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(var3.getKey(), var3.getValue());
      }

      if(this.age != null) {
         var1.put("age", this.age);
      }

      if(this.children != null) {
         var1.put("children", this.children);
      }

      if(this.education != null) {
         var1.put("education", this.education);
      }

      if(this.ethnicity != null) {
         var1.put("ethnicity", this.ethnicity);
      }

      if(this.gender != null) {
         var1.put("gender", this.gender);
      }

      if(this.income != null) {
         var1.put("income", this.income);
      }

      if(this.keywords != null) {
         var1.put("keywords", this.keywords);
      }

      if(this.marital != null) {
         var1.put("marital", this.marital);
      }

      if(this.politics != null) {
         var1.put("politics", this.politics);
      }

      if(this.vendor != null) {
         var1.put("vendor", this.vendor);
      }

      if(this.zip != null) {
         var1.put("zip", this.zip);
      }

   }

   public final MMRequest put(String var1, String var2) {
      if(var1.equals("age")) {
         this.age = var2;
         return this;
      } else if(var1.equals("children")) {
         this.children = var2;
         return this;
      } else if(var1.equals("education")) {
         this.education = var2;
         return this;
      } else if(var1.equals("ethnicity")) {
         this.ethnicity = var2;
         return this;
      } else if(var1.equals("gender")) {
         this.gender = var2;
         return this;
      } else if(var1.equals("income")) {
         this.income = var2;
         return this;
      } else if(var1.equals("keywords")) {
         this.keywords = var2;
         return this;
      } else if(var1.equals("marital")) {
         this.marital = var2;
         return this;
      } else if(var1.equals("politics")) {
         this.politics = var2;
         return this;
      } else if(var1.equals("vendor")) {
         this.vendor = var2;
         return this;
      } else if(var1.equals("zip")) {
         this.zip = var2;
         return this;
      } else if(var2 != null) {
         this.values.put(var1, var2);
         return this;
      } else {
         this.values.remove(var1);
         return this;
      }
   }

   public final void setAge(String var1) {
      this.age = var1;
   }

   public final void setChildren(String var1) {
      this.children = var1;
   }

   public final void setEducation(String var1) {
      this.education = var1;
   }

   public final void setEthnicity(String var1) {
      this.ethnicity = var1;
   }

   public final void setGender(String var1) {
      this.gender = var1;
   }

   public final void setIncome(String var1) {
      this.income = var1;
   }

   public final void setKeywords(String var1) {
      this.keywords = var1;
   }

   public final void setMarital(String var1) {
      this.marital = var1;
   }

   public final void setMetaValues(Map var1) {
      if(var1 != null) {
         Iterator var3 = var1.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var2 = (Entry)var3.next();
            this.put((String)var2.getKey(), (String)var2.getValue());
         }
      }

   }

   public final void setPolitics(String var1) {
      this.politics = var1;
   }

   public final void setVendor(String var1) {
      this.vendor = var1;
   }

   public final void setZip(String var1) {
      this.zip = var1;
   }
}
