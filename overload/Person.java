package overload;

public class Person {
    private String name;
    private int age;
    public void setName(String name){
        if(name.length()<2 || name.length()>6){
            System.out.println("姓名字符2-6之间");
            return;
        }
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        if(age>100 || age<0){
            System.out.println("age非法");
            return;
        }
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
}
