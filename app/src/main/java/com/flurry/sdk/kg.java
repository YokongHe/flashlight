package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import com.flurry.sdk.jk$a;
import com.flurry.sdk.kg$a;
import com.flurry.sdk.kg$b;
import com.flurry.sdk.kl;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
public @interface kg {
   Class a() default jk$a.class;

   Class b() default jk$a.class;

   Class c() default jk$a.class;

   Class d() default kl.class;

   Class e() default kl.class;

   Class f() default kl.class;

   kg$b g() default kg$b.DYNAMIC;

   kg$a h() default kg$a.ALWAYS;
}
