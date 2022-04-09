package oop;

public class Recursive {
    public static int f(int n){
        if(n==0){
            return 1;
        }else if(n==1){
            return 4;
        }else{
            return 2*f(n-1)+f(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.println(f(10));
    }
}
