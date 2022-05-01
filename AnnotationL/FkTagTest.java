package AnnotationL;

//@FkTags({@FkTag(age = 18),@FkTag(name = "小王", age = 30)})
@FkTag(age = 18)
@FkTag(name = "小王", age = 30)
public class FkTagTest {
    public static void main(String[] args) {
        Class<FkTagTest> clazz = FkTagTest.class;
        /*java8之后获取
        * */
        FkTag[] tags = clazz.getDeclaredAnnotationsByType(FkTag.class);
        for (var tag:tags) {
            System.out.println(tag.name()+"--->"+tag.age());
        }
        //java8之前获取
        FkTags container = clazz.getDeclaredAnnotation(FkTags.class);
        System.out.println(container);
    }
}
