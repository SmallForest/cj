package AnnotationL;

public @interface MyTag {
    //该注解定义两个成员变量
    //格式：类型 变量名() default 默认值（当然默认值不是必须）
    String name() default "smallForest";
    int age();
}
