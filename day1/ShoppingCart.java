import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingCart {
    private Map<String, Integer> productPrices;
    private Map<String, Integer> cart;

    public ShoppingCart() {
        this.productPrices = new HashMap<>();
        this.cart = new LinkedHashMap<>();

        productPrices.put("Apple", 10);
        productPrices.put("Banana", 5);
        productPrices.put("Orange", 15);
    }

    public void addItemToCart(String productName) {
        if (productPrices.containsKey(productName)) {
            cart.put(productName, cart.getOrDefault(productName, 0) + 1);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void displayResults() {
        System.out.println("Products Order:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " products");
        }

        Map<String, Integer> sortedProducts = new TreeMap<>((a, b) -> productPrices.get(b).compareTo(productPrices.get(a)));
        sortedProducts.putAll(cart);
        System.out.println("\nProducts Sorted by Price:");
        for (Map.Entry<String, Integer> entry : sortedProducts.entrySet()) {
            System.out.println(entry.getKey() + ": " + productPrices.get(entry.getKey()) + " per unit, Quantity: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add item to cart");
            System.out.println("2. Display cart");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Enter product name (Apple, Banana, Orange): ");
                    String productName = scanner.nextLine();
                    cart.addItemToCart(productName);
                    break;
                case 2:
                    cart.displayResults();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
