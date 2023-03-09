
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
@Component("zoo4_2")
public class ZooBySetter {
    
    private static final Logger LOG = LoggerFactory.getLogger(ZooBySetter.class);

    private Animal animal;
    
    public ZooBySetter() {
        LOG.info("Zoo no-arg constructor is called.");
    }

    @Autowired
    @Qualifier("dog4")
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
    
}
