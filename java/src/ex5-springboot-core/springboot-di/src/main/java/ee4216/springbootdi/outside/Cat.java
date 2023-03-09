
package ee4216.springbootdi.outside;

import ee4216.springbootdi.inside.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Assume this class is outside our project scope and we have no access to its 
 * source code. Therefore, we cannot use @Component here.
 * 
 * @author vanting
 */
public class Cat implements Animal {
    
    private static final Logger LOG = LoggerFactory.getLogger(Cat.class);
    
    public Cat() {
        LOG.info("A cat is created.");
    }
    
}
