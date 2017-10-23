import exception.InvalidArticleConfigurationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ArticleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreateArticle() {
        Article article = getPencilWithId("Art0001");

        assertEquals("Pencil", article.getName());
        assertEquals(3.5, article.getUnitPrice(), 0);
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
        Article pen = new Article("Art001", "Pen", 10, 1.0, 2.0);

        assertEquals(10.3, pen.getUnitPrice(), 0.00000001);
    }

    @Test
    public void shouldThrowErrorWhenCGSTIsLessThan0() {
        exception.expect(InvalidArticleConfigurationException.class);
        exception.expectMessage("TAX should be between 0 and 100");
        new Article("Art001", "Pen", 10, -1.0, 2.0);
    }

    @Test
    public void shouldThrowErrorWhenSGSTIsLessThan0() {
        exception.expect(InvalidArticleConfigurationException.class);
        exception.expectMessage("TAX should be between 0 and 100");
        new Article("Art001", "Pen", 10, 1.0, -2.0);
    }

    @Test
    public void shouldThrowErrorWhenCGSTIsGreaterThan100() {
        exception.expect(InvalidArticleConfigurationException.class);
        exception.expectMessage("TAX should be between 0 and 100");
        new Article("Art001", "Pen", 10, 101.0, 2.0);
    }

    @Test
    public void shouldThrowErrorWhenSGSTIsGreaterThan100() {
        exception.expect(InvalidArticleConfigurationException.class);
        exception.expectMessage("TAX should be between 0 and 100");
        new Article("Art001", "Pen", 10, 1.0, 200.0);
    }

    private Article getPencilWithId(String id) {
        return new Article(id, "Pencil", 3.5, 0, 0);
    }
}
