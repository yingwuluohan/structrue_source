package com.struc.base.framework.annotation;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModelAttribute {

    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";

    boolean binding() default true;
}
/**
 *   ElementType.TYPE : 标明该注解可以用于类、接口（包括注解类型）或enum声明
     ElementType.FIELD: 标明该注解可以用于字段(域)声明，包括enum实例
     ElementType.METHOD: 标明该注解可以用于方法声明
     ElementType.PARAMETER: 标明该注解可以用于参数声明
     ElementType.CONSTRUCTOR: 标明注解可以用于构造函数声明
     ElementType.LOCAL_VARIABLE: 标明注解可以用于局部变量声明
     ElementType.PACKAGE: 标明注解可以用于包声明
 **/