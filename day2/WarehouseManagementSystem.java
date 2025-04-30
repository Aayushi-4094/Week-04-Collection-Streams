import java.util.*;
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

public class WarehouseManagementSystem {
    private Storage<Electronics> electronicsStorage;
    private Storage<Groceries> groceriesStorage;
    private Storage<Furniture> furnitureStorage;

    public WarehouseManagementSystem() {
        this.electronicsStorage = new Storage<>();
        this.groceriesStorage = new Storage<>();
        this.furnitureStorage = new Storage<>();
    }

    public void addItem(String type, String name) {
        switch (type.toLowerCase()) {
            case "electronics":
                electronicsStorage.addItem(new Electronics(name));
                break;
            case "groceries":
                groceriesStorage.addItem(new Groceries(name));
                break;
            case "furniture":
                furnitureStorage.addItem(new Furniture(name));
                break;
            default:
                System.out.println("Invalid type!");
        }
    }

    public void displayItems() {
        System.out.println("Electronics:");
        displayItems(electronicsStorage.getItems());
        System.out.println("\nGroceries:");
        displayItems(groceriesStorage.getItems());
        System.out.println("\nFurniture:");
        displayItems(furnitureStorage.getItems());
    }

    private void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName());
        }
    }

    public static void main(String[] args) {
        WarehouseManagementSystem system = new WarehouseManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add item");
            System.out.println("2. Display items");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter type (Electronics, Groceries, Furniture): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    system.addItem(type, name);
                    break;
                case 2:
                    system.displayItems();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

