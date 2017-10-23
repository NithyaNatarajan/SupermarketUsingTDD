import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ArticleTest {

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
        Article pencil = getPencilWithId("Art0001");

    }

    private Article getPencilWithId(String id) {
        return new Article(id, "Pencil", 3.5);
    }
}
