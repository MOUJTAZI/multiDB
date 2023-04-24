package za.moujtazi.multiDB.database.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


import org.springframework.boot.context.properties.ConfigurationProperties;


@Configuration
public class DatabaseConfig {
    @Bean
    @ConfigurationProperties("rim23.datasource")
    public DataSource rim23DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("wikimedia.datasource")
    public DataSource wikimediaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate rim23JdbcTemplate(DataSource rim23DataSource) {
        return new JdbcTemplate(rim23DataSource);
    }

    @Bean
    public JdbcTemplate wikimediaJdbcTemplate(DataSource wikimediaDataSource) {
        return new JdbcTemplate(wikimediaDataSource);
    }
}
