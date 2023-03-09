/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee4216.springbootconsole.runner2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author vanting
 */
@Component
@Order(2)       // second, execution order
public class Console2 implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Console2.class);
    
    private String appMessage;
 
    @Override
    public void run(String... args) {

        LOG.error("Console 2 : " + appMessage);
        
        LOG.trace("A TRACE Message");
        LOG.debug("A DEBUG Message");
        LOG.info("An INFO Message");
        LOG.warn("A WARN Message");
        LOG.error("An ERROR Message");
        
    }
}
