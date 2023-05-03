/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee4216.springbootconsole;

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
@Order(1)       // first, execution order
public class Console1 implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Console1.class);
 
    @Override
    public void run(String... args) {

        LOG.info("Console 1 : arguments from main method:");
        
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
        
    }
}
