package arraysL;

public class san {
    public static void main(String[] args) {
        var max = 4;
        for (var i = 0; i < max; i++) {
            if((max-1-i)>0){
                System.out.print(" ".repeat(max-1-i));
            }
            System.out.print("*".repeat(2*i+1));
            System.out.print("\n");
        }
    }
}
