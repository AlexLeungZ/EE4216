package ee4216.springbootdi;

import ee4216.springbootdi.inside.Animal;
import ee4216.springbootdi.outside.Cat;
import ee4216.springbootdi.inside.Zoo;
import ee4216.springbootdi.inside.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/*

This example includes four sets of beans:
Set 1: this class using @Bean
Set 2: AppConfig using @Bean
Set 3: applicationContext.xml
Set 4: Dog and Zoo using @Component

@SpringBootApplication is a meta annotation which includes @Configuration - the
default place of Spring Boot Application to define beans.

*/
@SpringBootApplication
@ImportResource("applicationContext.xml")
public class SpringBootDiDemo {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootDiDemo.class);

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootDiDemo.class, args);

    }
    
    @Bean
    //@Scope(value = "singleton")           // default singleton, can be omitted
    public Animal dog1() {
        return new Dog();
    }
    
    @Bean
    public Animal cat1() {
        return new Cat();
    }
    
    @Bean
    public Zoo zoo1() {
        /* 
           using new Dog() below will create a new Dog instance instead of 
           getting the singleton bean dog1 from container 
        */
        //return new Zoo(new Dog());        
        return new Zoo(dog1());             // inject dog1 to zoo1 by constructor
    }
    
    @Bean
    public Zoo zoo1_1() {
        Zoo zoo = new Zoo();
        zoo.setAnimal(dog1());              // inject dog1 to zoo1_1 by setter
        return zoo;
    }

}
