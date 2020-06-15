package com.arcore.dependencyinjection.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
public @interface   annotation {


    // annotation are only metadata doesnot contain any business logic

    String name() default "nilesh";
    String lastName() default  "teji";



}
