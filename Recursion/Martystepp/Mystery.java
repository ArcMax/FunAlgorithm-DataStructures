package Recursion.Martystepp;

public class Mystery {
    public static void main(String[] args){
        System.out.print(mystery(648));
    }

    static int mystery(int n){
        if(n<10){
            return n;
        }
        int a = n/10;
        int b = n%10;
        return mystery(a+b);
    }
}
