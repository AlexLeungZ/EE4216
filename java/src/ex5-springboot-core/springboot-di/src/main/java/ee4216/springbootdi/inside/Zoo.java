
package ee4216.springbootdi.inside;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author vanting
 */
@Component("zoo4")
public class Zoo {
    
    private static final Logger LOG = LoggerFactory.getLogger(Zoo.class);

    private Animal animal;
    
    public Zoo() {
        LOG.info("Zoo no-arg constructor is called.");
    }

    public Zoo(Animal animal) {
        this.animal = animal;
        LOG.info("Zoo animal-arg constructor is called.");
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
    
}
