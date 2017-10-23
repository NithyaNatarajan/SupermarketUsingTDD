import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderTest {

    @Test
    public void shouldReturnTotalPrice() {
        SaleItem saleItem = mock(SaleItem.class);
        when(saleItem.getPrice()).thenReturn(60.0);
        ArrayList<SaleItem> saleItems = new ArrayList<>();
        saleItems.add(saleItem);

        Order order = new Order(saleItems);

        assertEquals(60, order.getTotalPrice(), 0);
    }

    @Test
    public void shouldReturnTotalPriceForMoreThanOneSales() {
        SaleItem pencil = mock(SaleItem.class);
        when(pencil.getPrice()).thenReturn(30.0);

        SaleItem eraser = mock(SaleItem.class);
        when(eraser.getPrice()).thenReturn(10.0);

        ArrayList<SaleItem> saleItems = new ArrayList<>();
        saleItems.add(pencil);
        saleItems.add(eraser);

        Order order = new Order(saleItems);

        assertEquals(40, order.getTotalPrice(), 0);
    }
}
