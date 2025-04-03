
package Midterm;

public class Fibonacci {
    
    public static void main(String[] args) {
        int n = 10;
        
        for (int i = 0; i < n; i++) {
            System.out.print(Fibonacci(i) + ",");
                }
    }
    public static int Fibonacci(int n) {
        if (n <=1) {
            return n;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
