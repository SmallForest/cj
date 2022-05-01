package AnnotationL;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FkTags {
    //此处有严格的格式，类型是要存储的注解的类型的数组，字段名称必须是value.可以理解成格式固定
    //FkTag 增加注解 @Repeatable(FkTags.class) 修饰，显式声明容器
    FkTag[] value();
}
