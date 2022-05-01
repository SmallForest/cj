package AnnotationL;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class ActionListenerInstaller {
    public static void processAnnotations(Object obj) {
        try {
            //获取obj的对象的类
            Class c1 = obj.getClass();
            //获取指定obj对象的所有成员变量，并遍历
            for (Field f : c1.getDeclaredFields()) {
                //将该成员变量设置成可自由访问的
                f.setAccessible(true);
                //获取该成员变量上的 ActionListenerFor类型的注解
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                //获取成员变量f的值
                Object fObj = f.get(obj);
                if (a != null && fObj != null && fObj instanceof AbstractButton) {
                    //获取a注解里的listener元数据（一个监听器类）
                    Class<? extends ActionListener> listenerClazz = a.listener();
                    //使用反射创建listener类的对象
                    ActionListener al = listenerClazz.getDeclaredConstructor().newInstance();
                    var ab = (AbstractButton) fObj;
                    ab.addActionListener(al);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
