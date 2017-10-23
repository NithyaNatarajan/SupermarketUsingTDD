import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleTest {

    @Test
    public void shouldCreateArticle() {
        Article article = new Article("Pencil", 3.5);

        assertEquals("Pencil", article.getName());
        assertEquals(3.5, article.getUnitPrice(), 0);
    }

    @Test
    public void twoSameArticlesShouldBeEquivalent() {
        Article pencil1 = new Article("Pencil", 3.5);
        Article pencil2 = new Article("Pencil", 3.5);

        assertEquals(pencil1, pencil2);
    }
}
