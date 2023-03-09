
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
@Component("zoo4_3")
public class ZooByField {
    
    private static final Logger LOG = LoggerFactory.getLogger(ZooByField.class);

    @Autowired
    @Qualifier("dog4")
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }
    
}
