
public class Pro9 {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            
            try {
                int result = numbers[1] / 0; 
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException caught in inner try block 1: " + e.getMessage());
            }

            try {
                System.out.println(numbers[3]); 
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException caught in inner try block 2: " + e.getMessage());
            }

            String text = null;
            System.out.println(text.length()); 
            
        
        } catch (Exception e) {
            System.out.println("General Exception caught in outer try block: " + e.getMessage());
        }
        System.out.println("Rest of the code executes...");
    }
}

