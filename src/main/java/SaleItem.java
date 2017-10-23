import java.math.BigDecimal;

public class SaleItem {

    private Article article;
    private int quantity;

    public SaleItem(Article article, int quantity) {
        this.article = article;
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return article.getUnitPrice()
                .multiply(new BigDecimal(quantity))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
