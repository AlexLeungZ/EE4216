package ee4216.springbootconsole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleDemo {

    // create a logger
    private static final Logger LOG = LoggerFactory.getLogger(SpringBootConsoleDemo.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");

        // args can be entered from command line
        args = new String[] { "Hello", "Spring", "Boot" };

        // start Spring's container to run this main class with input arguments
        // 1. scan classpath and configure beans
        // 2. apply spring boot default configuration
        // SpringApplication.run(SpringApp.class, args);

        SpringApplication app = new SpringApplication(SpringBootConsoleDemo.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);

        LOG.info("APPLICATION FINISHED");
    }

}