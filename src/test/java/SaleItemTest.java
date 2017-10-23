import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleItemTest {

    @Test
    public void ShouldAddSaleItem() {
        Article pencil = mock(Article.class);
        when(pencil.getUnitPrice()).thenReturn(new BigDecimal(3.0));
        SaleItem saleItem = new SaleItem(pencil, 10);

        assertEquals(30, saleItem.getPrice().doubleValue(), 0);
    }
}
