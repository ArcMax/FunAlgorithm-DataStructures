package Recursion.MartyStepp;

public class PrintStars {
    public static void main(String[] args){
        printStars(5);
    }
    static void printStars(int n){
        if(n==1){
            System.out.print("*");
            return ;
        }
        System.out.print("*");
        printStars(n-1);
        return;

    }
}
