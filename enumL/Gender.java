package enumL;
//gender 性别枚举类
public enum Gender {
    //初始化传递参数
    MALE("男"),FEMALE("女");
    //是MALE FEMALE的名字。
    private String name;
    //构造器
    private Gender(String name){
        this.name = name;
    }
    // public void setName(String name){
    //     switch(this)//这里的this指的是枚举值。MALE FEMALE
    //     {
    //         case MALE:
    //             if(name.equals("男")){
    //                 this.name = name;
    //             }else{
    //                 System.out.println("参数错误");return;
    //             }
    //             break;
    //         case FEMALE:
    //             if(name.equals("女")){
    //                 this.name = name;
    //             }else{
    //                 System.out.println("参数错误");return;
    //             }
    //             break;
    //     }
    // }

    //返回姓名
    public String getName(){
        return this.name;
    }
}
