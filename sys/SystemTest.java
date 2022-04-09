package sys;

import java.util.Map;

public class SystemTest{
    public static void main(String[] args) {
        
        Map<String,String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name+'='+env.get(name));
        }
    }
}