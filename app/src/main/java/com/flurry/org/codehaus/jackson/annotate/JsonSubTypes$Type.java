package com.flurry.org.codehaus.jackson.annotate;

public @interface JsonSubTypes$Type {
   String name() default "";

   Class value();
}
