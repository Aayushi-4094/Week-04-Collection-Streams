import java.util.*;
interface ProductCategory {
}

enum BookCategory implements ProductCategory {
    FICTION, NON_FICTION
}

enum ClothingCategory implements ProductCategory {
    TOPS, BOTTOMS, DRESSES
}

enum GadgetCategory implements ProductCategory {
    SMARTPHONES, LAPTOPS, TABLETS
}

abstract class Product<T extends ProductCategory> {
    private String name;
    private T category;
    private double price;

    public Product(String name, T category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public T getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Book extends Product<BookCategory> {
    public Book(String name, BookCategory category, double price) {
        super(name, category, price);
    }
}

class Clothing extends Product<ClothingCategory> {
    public Clothing(String name, ClothingCategory category, double price) {
        super(name, category, price);
    }
}

class Gadget extends Product<GadgetCategory> {
    public Gadget(String name, GadgetCategory category, double price) {
        super(name, category, price);
    }
}

class Storage<T extends Product<?>> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }
}

public class OnlineMarketplace {
    private Storage<Book> bookStorage;
    private Storage<Clothing> clothingStorage;
    private Storage<Gadget> gadgetStorage;

    public OnlineMarketplace() {
        bookStorage = new Storage<>();
        clothingStorage = new Storage<>();
        gadgetStorage = new Storage<>();
    }

    public void addBook(Book book) {
        bookStorage.addProduct(book);
    }

    public void addClothing(Clothing clothing) {
        clothingStorage.addProduct(clothing);
    }

    public void addGadget(Gadget gadget) {
        gadgetStorage.addProduct(gadget);
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) { 
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
    public static void main(String[] args) {
        OnlineMarketplace marketplace = new OnlineMarketplace();
        Book book = new Book("Example Book", BookCategory.FICTION, 20.0);
        marketplace.addBook(book);
        OnlineMarketplace.applyDiscount(book, 10);
        System.out.println("Discounted price: " + book.getPrice());
    }
}



