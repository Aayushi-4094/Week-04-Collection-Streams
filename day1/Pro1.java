import java.util.*;

public class Pro1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        ArrayList<Integer> arrayList = new ArrayList<>(linkedList);

        System.out.println("The original list using linkedList is " + linkedList);
        System.out.println("The original list using ArrayList is " + arrayList);

        reverseLinkedList(linkedList);
        reverseArrayList(arrayList);

        System.out.println("Reverse of the list using linkedList: " + linkedList);
        System.out.println("Reverse of the list using ArrayList: " + arrayList);
    }

    public static void reverseArrayList(ArrayList<Integer> arrayList) {
        int left = 0;
        int right = arrayList.size() - 1;
        while (left < right) {
            int temp = arrayList.get(left);
            arrayList.set(left, arrayList.get(right));
            arrayList.set(right, temp);
            left++;
            right--;
        }
    }

    public static void reverseLinkedList(LinkedList<Integer> linkedList) {
        int left = 0;
        int right = linkedList.size() - 1;
        while (left < right) {
            int temp = linkedList.get(left);
            linkedList.set(left, linkedList.get(right));
            linkedList.set(right, temp);
            left++;
            right--;
        }
    }
}


