
package ee4216.springbootdi.inside;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author vanting
 */
@Component("dog4")
public class Dog implements Animal {
    
    private static final Logger LOG = LoggerFactory.getLogger(Dog.class);
    
    public Dog() {
        LOG.info("A dog is created.");
    }
    
}
