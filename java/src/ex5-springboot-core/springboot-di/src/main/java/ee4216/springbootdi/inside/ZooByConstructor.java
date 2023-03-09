
package ee4216.springbootdi.inside;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author vanting
 */
@Component("zoo4_1")
public class ZooByConstructor {
    
    private static final Logger LOG = LoggerFactory.getLogger(ZooByConstructor.class);

    private Animal animal;

    @Autowired
    public ZooByConstructor(@Qualifier("dog4") Animal animal) {
        this.animal = animal;
        LOG.info("Zoo animal-arg constructor is called.");
    }

    public Animal getAnimal() {
        return animal;
    }
    
}
