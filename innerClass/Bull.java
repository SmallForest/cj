package innerClass;
//çð
public class Bull {
    private double weight;
    public Bull(){};
    public Bull(double weight){
        this.weight = weight;
    };
    //ééæåé¨ç±»ï¼no static
    //çå¤§è¿
    private class Leg{
        private double length;
        private String color;
        public Leg(){};
        public Leg(double length,String color){
            this.color = color;
            this.length = length;
        };
        //åé¨ç±»çå®ä¾æ¹æ³
        public void info(){
            System.out.println("å½åçè¿é¢è²"+color+"ï¼é«"+length);
            //ç´æ¥è®¿é®å¤é¨ç±»çåé
            System.out.println("æ¬çè¿å¨ççéé"+weight);
        }
    }
    public void test(){
        Leg l = new Leg(1.2, "çº¢è²");
        //è°ç¨åé¨ç±»å®ä¾æ¹æ³
        l.info();
    }
    public static void main(String[] args) {
        var b = new Bull(300);
        b.test();
    }

}
