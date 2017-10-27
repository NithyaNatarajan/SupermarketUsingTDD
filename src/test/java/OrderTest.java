import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    @Test
    public void shouldReturnTotalPrice() {
        SaleItem saleItem = new DummySaleItem(60.1002);
        ArrayList<SaleItem> saleItems = new ArrayList<>();
        saleItems.add(saleItem);

        Order order = new Order(saleItems);

        assertEquals(60.10, order.getTotalPrice().doubleValue(), 0);
    }

    @Test
    public void shouldReturnTotalPriceForMoreThanOneSales() {
        SaleItem pencil = new DummySaleItem(30.0);
        SaleItem eraser = new DummySaleItem(10.0);

        ArrayList<SaleItem> saleItems = new ArrayList<>();
        saleItems.add(pencil);
        saleItems.add(eraser);

        Order order = new Order(saleItems);

        assertEquals(40, order.getTotalPrice().doubleValue(), 0);
    }


    class DummySaleItem extends SaleItem {
        private BigDecimal price;

        public DummySaleItem(double price) {
            super(null, 1);
            this.price = new BigDecimal(price);
        }

        public BigDecimal getPrice() {
            return price;
        }
    }
}
