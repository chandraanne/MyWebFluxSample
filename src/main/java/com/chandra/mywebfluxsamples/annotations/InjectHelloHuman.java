package com.chandra.mywebfluxsamples.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectHelloHuman {
    String messageString() default "Hello Human";
}
