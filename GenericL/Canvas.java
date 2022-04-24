package GenericL;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Canvas {
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw(this);
        }
    }

    @Override
    public String toString() {
        return "`白色画布`";
    }

    public static void main(String[] args) {
        List<Shape> l = new ArrayList<>();
        l.add(new Rectangle());
        l.add(new Circle());
        var c = new Canvas();
        c.drawAll(l);

        //通配符泛型集合不能写入元素,只能读取元素
        List<? extends Shape> s = new ArrayList<>();
        //s.add(1);
    }
}
