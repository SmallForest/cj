package AnnotationL;

public class RunTests {
    public static void main(String[] args) throws Exception{
        //处理MyTest类
        //没有写包名会报错的， AnnotationL.MyTest就可以了
        ProcessorTest.process("AnnotationL.MyTest");
    }
}
