/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee4216.springbootconsole.runner3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author vanting
 */
@Component
@Order(3)       // third, execution order
public class Console3 implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Console3.class);
    
    // custom value injected from application.properties
    @Value("${app.message}")
    private String appMessage;
 
    @Override
    public void run(String... args) {

        LOG.error("Console 3 : " + appMessage);
        
        LOG.trace("A TRACE Message");
        LOG.debug("A DEBUG Message");
        LOG.info("An INFO Message");
        LOG.warn("A WARN Message");
        LOG.error("An ERROR Message");
        
    }
}
