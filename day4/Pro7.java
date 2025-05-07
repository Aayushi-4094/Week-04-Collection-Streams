import java.util.Scanner;

public class Pro7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a  = sc.nextInt();
        System.out.println("Enter the second number");
        int b = sc.nextInt();
        try {
            division(a,b);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception " + e.getMessage());
        }
        finally{
            System.out.println("Operation completed");
        }

    }
    public static void division(int a, int b)throws ArithmeticException{
        int div;
    if(b==0){
        throw new ArithmeticException("Enter a valid number denominator cannot be 0");
    }
    else{
        div = a/b;
    }
    System.out.println("Result of division is " + div);
}
}
