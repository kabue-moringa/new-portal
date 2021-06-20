import org.sql2o.*;

import java.util.List;

public class GeneralNews extends News {
    public static final String DATABASE_TYPE = "General";

    public GeneralNews(String title, String content, String dName){
        this.title = title;
        this.content = content;
        this.dName = dName;
        type = DATABASE_TYPE;
    }
    public static List<GeneralNews> all() {
        String sql = "SELECT * FROM news WHERE type='General';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(GeneralNews.class);
        }
    }
    public static GeneralNews find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM news where id=:id";
            GeneralNews news = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(GeneralNews.class);
            return news;
        }
    }
}
