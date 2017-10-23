import exception.InvalidArticleConfigurationException;

import java.util.Objects;

public class Article {
    private final String id;
    private final String name;
    private final double price;
    private final double CGST;
    private final double SGST;

    public Article(String id, String name, double price, double CGST, double SGST) {
        if (CGST < 0 || CGST > 100 || SGST < 0 || SGST > 100) {
            throw new InvalidArticleConfigurationException("TAX should be between 0 and 100");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.CGST = CGST;
        this.SGST = SGST;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return price + price * (CGST / 100) + price * (SGST / 100);
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
