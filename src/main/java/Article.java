import java.util.Objects;

public class Article {
    private final String name;
    private final double price;

    public Article(String name, double price) {

        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Double.compare(article.price, price) == 0 && Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
