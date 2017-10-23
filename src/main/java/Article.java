import java.util.Objects;

public class Article {
    private final String id;
    private final String name;
    private final double price;

    public Article(String id, String name, double price) {
        this.id = id;
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
        return Objects.equals(id, article.id)
                && Objects.equals(name, article.name)
                && Double.compare(article.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
