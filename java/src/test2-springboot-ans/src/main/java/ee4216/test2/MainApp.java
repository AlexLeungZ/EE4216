package ee4216.test2;

import ee4216.test2.movie.MovieDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
    
    @Bean
    public MovieDao movieDao(JdbcTemplate jdbcTemplate) {
        return new MovieDao(jdbcTemplate);
    }

}
