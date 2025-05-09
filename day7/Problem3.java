import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Book {
    String title, author, genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
}

class Problem3 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book1", "Author1", "Science Fiction", 4.5),
            new Book("Book2", "Author2", "Romance", 3.8),
            new Book("Book3", "Author3", "Science Fiction", 4.8),
            new Book("Book4", "Author4", "Science Fiction", 4.1)
        );

        List<BookRecommendation> recommendations = books.stream()
            .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
            .map(b -> new BookRecommendation(b.title, b.rating))
            .sorted((a, b) -> Double.compare(b.rating, a.rating))
            .limit(10)
            .collect(Collectors.toList());

        recommendations.forEach(r -> System.out.println(r.title + " - " + r.rating));
    }
}