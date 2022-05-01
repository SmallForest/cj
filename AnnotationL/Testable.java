package AnnotationL;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//限定只能修饰方法
@Target(ElementType.METHOD)
public @interface Testable {
}
