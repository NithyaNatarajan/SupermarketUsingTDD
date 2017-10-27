import exception.InvalidArticleConfigurationException;

import java.math.BigDecimal;
import java.util.Objects;

import static java.math.BigDecimal.ZERO;

public class Article {
    private final String id;
    private final String name;
    private final BigDecimal price;
    private final BigDecimal CGST;
    private final BigDecimal SGST;

    private static final BigDecimal HUNDRED = new BigDecimal(100);

    public Article(String id, String name, BigDecimal price, BigDecimal CGST, BigDecimal SGST) {
        if (price.compareTo(ZERO) < 0) {
            throw new InvalidArticleConfigurationException("Price should be grater than 0");
        }

        if (CGST.compareTo(ZERO) < 0 || CGST.compareTo(HUNDRED) > 0 || SGST.compareTo(ZERO) < 0 || SGST.compareTo(HUNDRED) > 0) {
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

    public BigDecimal getUnitPrice() {
        BigDecimal cgst = price.multiply(CGST.divide(HUNDRED));
        BigDecimal sgst = price.multiply(SGST.divide(HUNDRED));
        return price.add(cgst).add(sgst).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id)
                && Objects.equals(name, article.name)
                && Objects.equals(article.price, price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
