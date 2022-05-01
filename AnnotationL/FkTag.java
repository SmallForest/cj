package AnnotationL;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(FkTags.class)
public @interface FkTag {
    //定义注解2个成员变量
    String name() default "smallForest";
    int age();
}
