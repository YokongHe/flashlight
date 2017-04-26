package com.flurry.org.codehaus.jackson.annotate;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$Id;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$None;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface JsonTypeInfo {
   Class defaultImpl() default JsonTypeInfo$None.class;

   JsonTypeInfo$As include() default JsonTypeInfo$As.PROPERTY;

   String property() default "";

   JsonTypeInfo$Id use();
}
