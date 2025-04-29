import java.util.Scanner;

public class Pro14 {
    private int[] buffer;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Pro14(int capacity) {
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    public void enqueue(int element) {
        buffer[rear] = element;
        rear = (rear + 1) % capacity;
        if (size == capacity) {
            front = (front + 1) % capacity;
        } else {
            size++;
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("Buffer is empty");
            return;
        }

        int tempFront = front;
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[tempFront] + " ");
            tempFront = (tempFront + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter buffer size: ");
        int capacity = scanner.nextInt();

        Pro14 buffer = new Pro14(capacity);

        while (true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Display");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter element: ");
                    int element = scanner.nextInt();
                    buffer.enqueue(element);
                    break;
                case 2:
                    buffer.display();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
     }
}
}
