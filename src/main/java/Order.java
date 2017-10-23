import java.util.List;

public class Order {
    private List<SaleItem> saleItems;

    public Order(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    public double getTotalPrice() {
        return saleItems.stream()
                .map(SaleItem::getPrice)
                .reduce(0.0, (a, b) -> a + b);
    }
}
