package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import com.flurry.org.codehaus.jackson.annotate.JsonAnyGetter;
import com.flurry.org.codehaus.jackson.annotate.JsonAnySetter;
import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect;
import com.flurry.org.codehaus.jackson.annotate.JsonBackReference;
import com.flurry.org.codehaus.jackson.annotate.JsonCreator;
import com.flurry.org.codehaus.jackson.annotate.JsonGetter;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnore;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnoreType;
import com.flurry.org.codehaus.jackson.annotate.JsonManagedReference;
import com.flurry.org.codehaus.jackson.annotate.JsonProperty;
import com.flurry.org.codehaus.jackson.annotate.JsonPropertyOrder;
import com.flurry.org.codehaus.jackson.annotate.JsonRawValue;
import com.flurry.org.codehaus.jackson.annotate.JsonSetter;
import com.flurry.org.codehaus.jackson.annotate.JsonSubTypes;
import com.flurry.org.codehaus.jackson.annotate.JsonSubTypes$Type;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$Id;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$None;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeName;
import com.flurry.org.codehaus.jackson.annotate.JsonUnwrapped;
import com.flurry.org.codehaus.jackson.annotate.JsonValue;
import com.flurry.org.codehaus.jackson.annotate.JsonWriteNullProperties;
import com.flurry.sdk.iq;
import com.flurry.sdk.iq$a;
import com.flurry.sdk.jg$a;
import com.flurry.sdk.jk$a;
import com.flurry.sdk.jl$a;
import com.flurry.sdk.jn;
import com.flurry.sdk.ka;
import com.flurry.sdk.kc;
import com.flurry.sdk.kd;
import com.flurry.sdk.ke;
import com.flurry.sdk.kf;
import com.flurry.sdk.kg;
import com.flurry.sdk.kg$a;
import com.flurry.sdk.kg$b;
import com.flurry.sdk.kh;
import com.flurry.sdk.ki;
import com.flurry.sdk.kj;
import com.flurry.sdk.kk;
import com.flurry.sdk.kl;
import com.flurry.sdk.mm;
import com.flurry.sdk.mn;
import com.flurry.sdk.mo;
import com.flurry.sdk.mp;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.mt;
import com.flurry.sdk.ne;
import com.flurry.sdk.nf;
import com.flurry.sdk.nh;
import com.flurry.sdk.ni;
import com.flurry.sdk.nu;
import com.flurry.sdk.ps;
import com.flurry.sdk.sh;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class my extends iq {
   public iq$a a(mq var1) {
      JsonManagedReference var2 = (JsonManagedReference)var1.a(JsonManagedReference.class);
      if(var2 != null) {
         return iq$a.a(var2.value());
      } else {
         JsonBackReference var3 = (JsonBackReference)var1.a(JsonBackReference.class);
         return var3 != null?iq$a.b(var3.value()):null;
      }
   }

   public kg$a a(mm var1, kg$a var2) {
      kg var3 = (kg)var1.a(kg.class);
      if(var3 != null) {
         var2 = var3.h();
      } else {
         JsonWriteNullProperties var4 = (JsonWriteNullProperties)var1.a(JsonWriteNullProperties.class);
         if(var4 != null) {
            if(var4.value()) {
               return kg$a.a;
            }

            return kg$a.b;
         }
      }

      return var2;
   }

   public ne a(mn var1, ne var2) {
      JsonAutoDetect var3 = (JsonAutoDetect)var1.a(JsonAutoDetect.class);
      return var3 == null?var2:var2.a(var3);
   }

   protected ni a(jn var1, mm var2, sh var3) {
      Object var5 = null;
      JsonTypeInfo var6 = (JsonTypeInfo)var2.a(JsonTypeInfo.class);
      ki var4 = (ki)var2.a(ki.class);
      Object var13;
      if(var4 != null) {
         if(var6 == null) {
            return null;
         }

         var13 = var1.d(var2, var4.a());
      } else {
         if(var6 == null) {
            return null;
         }

         if(var6.use() == JsonTypeInfo$Id.NONE) {
            return this.c();
         }

         var13 = this.b();
      }

      kh var7 = (kh)var2.a(kh.class);
      nh var8;
      if(var7 == null) {
         var8 = (nh)var5;
      } else {
         var8 = var1.e(var2, var7.a());
      }

      if(var8 != null) {
         var8.a(var3);
      }

      ni var14 = ((ni)var13).a(var6.use(), var8);
      JsonTypeInfo$As var11 = var6.include();
      JsonTypeInfo$As var9 = var11;
      if(var11 == JsonTypeInfo$As.EXTERNAL_PROPERTY) {
         var9 = var11;
         if(var2 instanceof mn) {
            var9 = JsonTypeInfo$As.PROPERTY;
         }
      }

      ni var12 = var14.a(var9).a(var6.property());
      Class var10 = var6.defaultImpl();
      return var10 != JsonTypeInfo$None.class?var12.a(var10):var12;
   }

   public ni a(jn var1, mn var2, sh var3) {
      return this.a((jn)var1, (mm)var2, (sh)var3);
   }

   public ni a(jn var1, mq var2, sh var3) {
      return var3.f()?null:this.a((jn)var1, (mm)var2, (sh)var3);
   }

   public Boolean a(mn var1) {
      kc var2 = (kc)var1.a(kc.class);
      return var2 == null?null:(var2.a()?Boolean.TRUE:Boolean.FALSE);
   }

   public Class a(mm var1, sh var2) {
      kg var3 = (kg)var1.a(kg.class);
      if(var3 != null) {
         Class var4 = var3.e();
         if(var4 != kl.class) {
            return var4;
         }
      }

      return null;
   }

   public Class a(mm var1, sh var2, String var3) {
      kd var4 = (kd)var1.a(kd.class);
      if(var4 != null) {
         Class var5 = var4.d();
         if(var5 != kl.class) {
            return var5;
         }
      }

      return null;
   }

   public String a(mt var1) {
      if(var1 != null) {
         JsonProperty var2 = (JsonProperty)var1.a(JsonProperty.class);
         if(var2 != null) {
            return var2.value();
         }
      }

      return null;
   }

   public String a(Enum var1) {
      return var1.name();
   }

   public List a(mm var1) {
      JsonSubTypes var6 = (JsonSubTypes)var1.a(JsonSubTypes.class);
      ArrayList var7;
      if(var6 == null) {
         var7 = null;
      } else {
         JsonSubTypes$Type[] var5 = var6.value();
         ArrayList var4 = new ArrayList(var5.length);
         int var3 = var5.length;
         int var2 = 0;

         while(true) {
            var7 = var4;
            if(var2 >= var3) {
               break;
            }

            JsonSubTypes$Type var8 = var5[var2];
            var4.add(new nf(var8.value(), var8.name()));
            ++var2;
         }
      }

      return var7;
   }

   public boolean a(mo var1) {
      return this.m(var1);
   }

   public boolean a(mp var1) {
      return this.m(var1);
   }

   public boolean a(mr var1) {
      return this.m(var1);
   }

   public boolean a(Annotation var1) {
      return var1.annotationType().getAnnotation(JacksonAnnotation.class) != null;
   }

   public ni b(jn var1, mq var2, sh var3) {
      if(!var3.f()) {
         throw new IllegalArgumentException("Must call method with a container type (got " + var3 + ")");
      } else {
         return this.a((jn)var1, (mm)var2, (sh)var3);
      }
   }

   protected nu b() {
      return new nu();
   }

   public Boolean b(mq var1) {
      JsonUnwrapped var2 = (JsonUnwrapped)var1.a(JsonUnwrapped.class);
      return var2 != null && var2.enabled()?Boolean.TRUE:null;
   }

   public Class b(mm var1, sh var2) {
      kg var3 = (kg)var1.a(kg.class);
      if(var3 != null) {
         Class var4 = var3.f();
         if(var4 != kl.class) {
            return var4;
         }
      }

      return null;
   }

   public Class b(mm var1, sh var2, String var3) {
      kd var4 = (kd)var1.a(kd.class);
      if(var4 != null) {
         Class var5 = var4.e();
         if(var5 != kl.class) {
            return var5;
         }
      }

      return null;
   }

   public Object b(mm var1) {
      kg var2 = (kg)var1.a(kg.class);
      if(var2 != null) {
         Class var3 = var2.a();
         if(var3 != jk$a.class) {
            return var3;
         }
      }

      JsonRawValue var4 = (JsonRawValue)var1.a(JsonRawValue.class);
      return var4 != null && var4.value()?new ps(var1.d()):null;
   }

   public String b(mn var1) {
      kf var2 = (kf)var1.a(kf.class);
      return var2 == null?null:var2.a();
   }

   public String b(mp var1) {
      JsonProperty var2 = (JsonProperty)var1.a(JsonProperty.class);
      return var2 != null?var2.value():(!var1.b(kg.class) && !var1.b(kk.class)?null:"");
   }

   public String b(mr var1) {
      JsonProperty var2 = (JsonProperty)var1.a((Class)JsonProperty.class);
      if(var2 != null) {
         return var2.value();
      } else {
         JsonGetter var3 = (JsonGetter)var1.a((Class)JsonGetter.class);
         return var3 != null?var3.value():(!var1.b(kg.class) && !var1.b(kk.class)?null:"");
      }
   }

   protected nu c() {
      return nu.b();
   }

   public Class c(mm var1) {
      kg var2 = (kg)var1.a(kg.class);
      if(var2 != null) {
         Class var3 = var2.c();
         if(var3 != jk$a.class) {
            return var3;
         }
      }

      return null;
   }

   public Class c(mm var1, sh var2, String var3) {
      kd var4 = (kd)var1.a(kd.class);
      if(var4 != null) {
         Class var5 = var4.f();
         if(var5 != kl.class) {
            return var5;
         }
      }

      return null;
   }

   public String c(mp var1) {
      JsonProperty var2 = (JsonProperty)var1.a(JsonProperty.class);
      return var2 != null?var2.value():(!var1.b(kd.class) && !var1.b(kk.class) && !var1.b(JsonBackReference.class) && !var1.b(JsonManagedReference.class)?null:"");
   }

   public boolean c(mq var1) {
      return this.m(var1);
   }

   public boolean c(mr var1) {
      JsonValue var2 = (JsonValue)var1.a((Class)JsonValue.class);
      return var2 != null && var2.value();
   }

   public String[] c(mn var1) {
      JsonIgnoreProperties var2 = (JsonIgnoreProperties)var1.a(JsonIgnoreProperties.class);
      return var2 == null?null:var2.value();
   }

   public Boolean d(mn var1) {
      JsonIgnoreProperties var2 = (JsonIgnoreProperties)var1.a(JsonIgnoreProperties.class);
      return var2 == null?null:Boolean.valueOf(var2.ignoreUnknown());
   }

   public Class d(mm var1) {
      kg var2 = (kg)var1.a(kg.class);
      if(var2 != null) {
         Class var3 = var2.b();
         if(var3 != jk$a.class) {
            return var3;
         }
      }

      return null;
   }

   public Object d(mq var1) {
      ka var2 = (ka)var1.a(ka.class);
      String var4;
      if(var2 == null) {
         var4 = null;
      } else {
         String var3 = var2.a();
         var4 = var3;
         if(var3.length() == 0) {
            if(!(var1 instanceof mr)) {
               return var1.d().getName();
            }

            mr var5 = (mr)var1;
            if(var5.f() == 0) {
               return var1.d().getName();
            }

            return var5.a(0).getName();
         }
      }

      return var4;
   }

   public String d(mr var1) {
      JsonProperty var2 = (JsonProperty)var1.a((Class)JsonProperty.class);
      if(var2 != null) {
         return var2.value();
      } else {
         JsonSetter var3 = (JsonSetter)var1.a((Class)JsonSetter.class);
         return var3 != null?var3.value():(!var1.b(kd.class) && !var1.b(kk.class) && !var1.b(JsonBackReference.class) && !var1.b(JsonManagedReference.class)?null:"");
      }
   }

   public Boolean e(mn var1) {
      JsonIgnoreType var2 = (JsonIgnoreType)var1.a(JsonIgnoreType.class);
      return var2 == null?null:Boolean.valueOf(var2.value());
   }

   public Class e(mm var1) {
      kg var2 = (kg)var1.a(kg.class);
      if(var2 != null) {
         Class var3 = var2.d();
         if(var3 != kl.class) {
            return var3;
         }
      }

      return null;
   }

   public boolean e(mr var1) {
      return var1.b(JsonAnySetter.class);
   }

   public kg$b f(mm var1) {
      kg var2 = (kg)var1.a(kg.class);
      return var2 == null?null:var2.g();
   }

   public Object f(mn var1) {
      ke var2 = (ke)var1.a(ke.class);
      if(var2 != null) {
         String var3 = var2.a();
         if(var3.length() > 0) {
            return var3;
         }
      }

      return null;
   }

   public boolean f(mr var1) {
      return var1.b(JsonAnyGetter.class);
   }

   public String g(mn var1) {
      JsonTypeName var2 = (JsonTypeName)var1.a(JsonTypeName.class);
      return var2 == null?null:var2.value();
   }

   public Class[] g(mm var1) {
      kk var2 = (kk)var1.a(kk.class);
      return var2 == null?null:var2.a();
   }

   // $FF: synthetic method
   public Object h(mm var1) {
      return this.l(var1);
   }

   public String[] h(mn var1) {
      JsonPropertyOrder var2 = (JsonPropertyOrder)var1.a(JsonPropertyOrder.class);
      return var2 == null?null:var2.value();
   }

   public Boolean i(mn var1) {
      JsonPropertyOrder var2 = (JsonPropertyOrder)var1.a(JsonPropertyOrder.class);
      return var2 == null?null:Boolean.valueOf(var2.alphabetic());
   }

   public Class i(mm var1) {
      kd var2 = (kd)var1.a(kd.class);
      if(var2 != null) {
         Class var3 = var2.c();
         if(var3 != jl$a.class) {
            return var3;
         }
      }

      return null;
   }

   public Class j(mm var1) {
      kd var2 = (kd)var1.a(kd.class);
      if(var2 != null) {
         Class var3 = var2.b();
         if(var3 != jg$a.class) {
            return var3;
         }
      }

      return null;
   }

   public Object j(mn var1) {
      kj var2 = (kj)var1.a(kj.class);
      return var2 == null?null:var2.a();
   }

   public boolean k(mm var1) {
      return var1.b(JsonCreator.class);
   }

   public Class l(mm var1) {
      kd var2 = (kd)var1.a(kd.class);
      if(var2 != null) {
         Class var3 = var2.a();
         if(var3 != jg$a.class) {
            return var3;
         }
      }

      return null;
   }

   protected boolean m(mm var1) {
      JsonIgnore var2 = (JsonIgnore)var1.a(JsonIgnore.class);
      return var2 != null && var2.value();
   }
}
