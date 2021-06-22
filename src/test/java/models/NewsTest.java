//package models;
//
//public class NewsTest {
//}

package models;
import org.junit.Test;
import static org.junit.Assert.*;
public class NewsTest {
    @Test
    public void NewsInstantiatesCorrectly() throws Exception{
        News news = setupNews();
        assertTrue(news instanceof News);
    }
    @Test
    public void NewsInstantiatesCorrectlyWith_Values() throws Exception{
        News news = setupNews();
        assertEquals("Welcome to news_portal",news.getTitle());
        assertEquals("Welcome to news_portal",news.getTitle());
        assertEquals("Welcome to news_portal",news.getDetails());
    }
    @Test
    public void setId() throws Exception{
        News news = setupNews();
        news.setId(5);
        assertNotEquals(2,news.getId());
    }
    public News setupNews(){
        return new News("Welcome to news_portal","Welcome to news_portal");
    }
}