import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SaleItemTest {

    @Test
    public void ShouldAddSaleItem() {
        Article pencil = new DummyArticle(3.0);
        SaleItem saleItem = new SaleItem(pencil, 10);

        assertEquals(30, saleItem.getPrice().doubleValue(), 0);
    }

    class DummyArticle extends Article {
        private BigDecimal totalPrice;

        public DummyArticle(double price) {
            super(null, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
            this.totalPrice = new BigDecimal(price);
        }

        public BigDecimal getUnitPrice() {
            return totalPrice;
        }
    }
}
