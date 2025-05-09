import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }
}

class Problem2 {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("A", 15, 100),
            new Sale("B", 8, 200),
            new Sale("C", 20, 150),
            new Sale("D", 25, 50),
            new Sale("E", 30, 90),
            new Sale("F", 12, 300)
        );

        List<ProductSales> result = sales.stream()
            .filter(s -> s.quantity > 10)
            .map(s -> new ProductSales(s.productId, s.quantity * s.price))
            .sorted((a, b) -> Double.compare(b.totalRevenue, a.totalRevenue))
            .limit(5)
            .collect(Collectors.toList());

        result.forEach(ps -> System.out.println(ps.productId + ": " + ps.totalRevenue));
    }
}