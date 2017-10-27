import exception.InvalidArticleConfigurationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ArticleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreateArticle() {
        Article article = getPencilWithId("Art0001");

        assertEquals("Pencil", article.getName());
        assertEquals(3.50, article.getUnitPrice().doubleValue(), 0);
    }

    @Test
    public void shouldThrowErrorWhenPriceIsLessThan0() {
        exception.expect(InvalidArticleConfigurationException.class);
        exception.expectMessage("Price should be grater than 0");
        new Article("Art0001", "Pencil", new BigDecimal(-1), ZERO, ZERO);
    }

    @Test
    public void shouldReturnTrueWhenComparingTwoSameArticles() {
        Article pencil1 = getPencilWithId("Art0001");
        Article pencil2 = getPencilWithId("Art0001");

        assertEquals(pencil1, pencil2);
    }

    @Test
    public void shouldReturnFalseWhenComparingTwoDifferentArticles() {
        Article pencil1 = getPencilWithId("Art0001");
        Article pencil2 = getPencilWithId("Art0002");

        assertNotEquals(pencil1, pencil2);
    }

    @Test
    public void shouldComputeTaxWhenComputingPrice() {
        Article pen = getPenWithTax(1.0, 2.55);

        assertEquals(10.35, pen.getUnitPrice().doubleValue(), 0);
    }

    @Test
    public void shouldThrowErrorWhenCGSTIsLessThan0() {
        exception.expect(InvalidArticleConfigurationException.class);
        exception.expectMessage("TAX should be between 0 and 100");
        getPenWithTax(-1.0, 2.0);
    }

    @Test
    public void shouldThrowErrorWhenSGSTIsLessThan0() {
        exception.expect(InvalidArticleConfigurationException.class);
        exception.expectMessage("TAX should be between 0 and 100");
        getPenWithTax(1.0, -2.0);
    }

    @Test
    public void shouldThrowErrorWhenCGSTIsGreaterThan100() {
        exception.expect(InvalidArticleConfigurationException.class);
        exception.expectMessage("TAX should be between 0 and 100");
        getPenWithTax(101.0, 2.0);
    }

    @Test
    public void shouldThrowErrorWhenSGSTIsGreaterThan100() {
        exception.expect(InvalidArticleConfigurationException.class);
        exception.expectMessage("TAX should be between 0 and 100");
        getPenWithTax(1.0, 200.0);
    }

    private Article getPenWithTax(double cgst, double sgst) {
        return new Article("Art001", "Pen", new BigDecimal(10), new BigDecimal(cgst), new BigDecimal(sgst));
    }

    private Article getPencilWithId(String id) {
        return new Article(id, "Pencil", new BigDecimal(3.5), ZERO, ZERO);
    }
}
