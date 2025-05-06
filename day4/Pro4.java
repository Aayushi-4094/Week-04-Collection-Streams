import java.util.Scanner;

public class Pro4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to initialize the array? (yes/no)");
        String choice = sc.next();
        int[] arr = null;
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the size of the array");
            int size = sc.nextInt();
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Enter element " + (i + 1));
                arr[i] = sc.nextInt();
            }
        }
        System.out.println("Enter the index whose value you want to retrieve");
        int index = sc.nextInt();
        try {
            System.out.println("Value at index " + index + ": " + getValueAtIndex(arr, index));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException Array is not initialized!");
        }
    }

    public static int getValueAtIndex(int[] arr, int index) {
        if (arr == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }
}

