package ee4216.springbootweb;

import ee4216.springbootweb.mvc.Student;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }

    @Bean
    public Map<Long, Student> students() {
        Map<Long, Student> students = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            students.put((long)i, new Student(i, "First Name " + i, "Last Name " + i, i % 2 == 0 ? "Male" : "Female"));
        }
        return students;
    }

}
