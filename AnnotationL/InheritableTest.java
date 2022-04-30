package AnnotationL;

@Inheritable
class Base{}
//继承了Base，并未直接使用注解@Inheritable
public class InheritableTest extends Base{
    public static void main(String[] args) {
        //打印本类是否有@Inheritable修饰 涉及反射随后学习
        System.out.println(InheritableTest.class
                .isAnnotationPresent(Inheritable.class));
    }
}
