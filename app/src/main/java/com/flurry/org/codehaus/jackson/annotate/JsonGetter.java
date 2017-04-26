package com.flurry.org.codehaus.jackson.annotate;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface JsonGetter {
   String value() default "";
}
