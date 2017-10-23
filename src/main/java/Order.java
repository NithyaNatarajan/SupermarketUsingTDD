import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;

public class Order {
    private List<SaleItem> saleItems;

    public Order(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    public BigDecimal getTotalPrice() {
        return saleItems.stream()
                .map(SaleItem::getPrice)
                .reduce(ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
