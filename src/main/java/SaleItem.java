public class SaleItem {

    private Article article;
    private int quantity;

    public SaleItem(Article article, int quantity) {
        this.article = article;
        this.quantity = quantity;
    }

    public double getPrice() {
        return article.getUnitPrice() * quantity;
    }
}
