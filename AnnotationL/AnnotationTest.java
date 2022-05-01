package AnnotationL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnnotationTest {
    private JFrame mainWin = new JFrame("使用注解绑定事件监听器");
    //使用注解
    @ActionListenerFor(listener = OkListener.class)
    private JButton ok = new JButton("确定");
    @ActionListenerFor(listener = CancelListener.class)
    private JButton cancel = new JButton("取消");

    //初始化
    public void init() {
        //初始化界面
        var jp = new JPanel();
        jp.add(ok);
        jp.add(cancel);
        mainWin.add(jp);
        //注解处理工具
        ActionListenerInstaller.processAnnotations(this);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new AnnotationTest().init();
    }
}

//定义ok按钮的事件监听器实现类
class OkListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "单击了确认按钮");
    }
}

//定义cancel按钮的事件监听器实现类
class CancelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "单击了取消按钮");
    }
}