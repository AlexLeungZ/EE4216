package ee4216.springdata;

import ee4216.springdata.jdbc.CourseDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootDatabaseDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatabaseDemo.class, args);
    }

    @Bean
    public CourseDao courseDao(JdbcTemplate jdbcTemplate) {
        return new CourseDao(jdbcTemplate);
    }

}
