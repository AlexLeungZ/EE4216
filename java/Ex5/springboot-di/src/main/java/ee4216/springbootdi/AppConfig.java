
package ee4216.springbootdi;

import ee4216.springbootdi.inside.Animal;
import ee4216.springbootdi.inside.Dog;
import ee4216.springbootdi.inside.Zoo;
import ee4216.springbootdi.outside.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Additional configuration file for bean definition.
 * @author vanting
 */
@Configuration
public class AppConfig {
    
    @Bean
    @Scope("prototype")         // default lazy-init - not instantiate on startup until being used
    public Animal dog2() {
        return new Dog();
    }
    
    @Bean
    public Animal cat2() {
        return new Cat();
    }
    
    @Bean
    public Zoo zoo2() {
        return new Zoo(dog2());     // inject dog2 to zoo2 by constructor
    }
    
    @Bean
    public Zoo zoo2_1() {
        Zoo zoo = new Zoo();
        zoo.setAnimal(dog2());      // inject dog2 to zoo2_1 by setter
        return zoo;
    }
    
}
