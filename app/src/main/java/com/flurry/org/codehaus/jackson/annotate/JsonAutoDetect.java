package com.flurry.org.codehaus.jackson.annotate;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect$Visibility;
import com.flurry.org.codehaus.jackson.annotate.JsonMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface JsonAutoDetect {
   JsonAutoDetect$Visibility creatorVisibility() default JsonAutoDetect$Visibility.DEFAULT;

   JsonAutoDetect$Visibility fieldVisibility() default JsonAutoDetect$Visibility.DEFAULT;

   JsonAutoDetect$Visibility getterVisibility() default JsonAutoDetect$Visibility.DEFAULT;

   JsonAutoDetect$Visibility isGetterVisibility() default JsonAutoDetect$Visibility.DEFAULT;

   JsonAutoDetect$Visibility setterVisibility() default JsonAutoDetect$Visibility.DEFAULT;

   JsonMethod[] value() default {JsonMethod.ALL};
}
