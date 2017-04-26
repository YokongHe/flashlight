package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import com.flurry.sdk.jg$a;
import com.flurry.sdk.jl$a;
import com.flurry.sdk.kl;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
public @interface kd {
   Class a() default jg$a.class;

   Class b() default jg$a.class;

   Class c() default jl$a.class;

   Class d() default kl.class;

   Class e() default kl.class;

   Class f() default kl.class;
}
