package za.moujtazi.multiDB.database.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import za.moujtazi.multiDB.database.dto.wiki_data;

import java.util.List;

@Service
public class MyService {
    private final JdbcTemplate rim23JdbcTemplate;
    private final JdbcTemplate wikimediaJdbcTemplate;

    public MyService(@Qualifier("rim23JdbcTemplate") JdbcTemplate rim23JdbcTemplate,
                     @Qualifier("wikimediaJdbcTemplate") JdbcTemplate wikimediaJdbcTemplate) {
        this.rim23JdbcTemplate = rim23JdbcTemplate;
        this.wikimediaJdbcTemplate = wikimediaJdbcTemplate;
    }

    public List<wiki_data> getAllEntitiesFromFirstDatabase() {
        String sql = "SELECT * FROM wikimedia.wikimedia_data limit 0,10;";
        return wikimediaJdbcTemplate.query(sql, (rs, rowNum) -> {
            wiki_data entity = new wiki_data();
            entity.setId(rs.getLong("id"));
            entity.setData(rs.getString("wiki_event_data"));
            // map other fields
            return entity;
        });
    }
}
