package ee4216.springbootdi;

import ee4216.springbootdi.inside.Dog;
import ee4216.springbootdi.inside.Zoo;
import ee4216.springbootdi.inside.ZooByConstructor;
import ee4216.springbootdi.inside.ZooByField;
import ee4216.springbootdi.inside.ZooBySetter;
import ee4216.springbootdi.outside.Cat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBootDiDemoTests {

    @Autowired
    private ApplicationContext applicationContext;
    
    // may set breakpoints to inspect the reference in runtime
    private Dog dog1;
    private Dog dog2;
    private Dog dog3;
    private Dog dog4;
    private Cat cat1;
    private Cat cat2;
    private Cat cat3;
    private Zoo zoo1;
    private Zoo zoo1_1;
    private Zoo zoo2;
    private Zoo zoo2_1;
    private Zoo zoo3;
    private Zoo zoo3_1;
    private Zoo zoo4;
    private ZooByConstructor zoo4_1;
    private ZooBySetter zoo4_2;
    private ZooByField zoo4_3;
    
    
    @BeforeEach
    void getAllDogsAndZoos() {
        dog1 = applicationContext.getBean("dog1", Dog.class);
        dog2 = applicationContext.getBean("dog2", Dog.class);
        dog3 = applicationContext.getBean("dog3", Dog.class);
        dog4 = applicationContext.getBean("dog4", Dog.class);
        cat1 = applicationContext.getBean("cat1", Cat.class);
        cat2 = applicationContext.getBean("cat2", Cat.class);
        cat3 = applicationContext.getBean("cat3", Cat.class);
        zoo1 = applicationContext.getBean("zoo1", Zoo.class);
        zoo1_1 = applicationContext.getBean("zoo1_1", Zoo.class);
        zoo2 = applicationContext.getBean("zoo2", Zoo.class);
        zoo2_1 = applicationContext.getBean("zoo2_1", Zoo.class);
        zoo3 = applicationContext.getBean("zoo3", Zoo.class);
        zoo3_1 = applicationContext.getBean("zoo3_1", Zoo.class);
        zoo4 = applicationContext.getBean("zoo4", Zoo.class);
        zoo4_1 = applicationContext.getBean("zoo4_1", ZooByConstructor.class);
        zoo4_2 = applicationContext.getBean("zoo4_2", ZooBySetter.class);
        zoo4_3 = applicationContext.getBean("zoo4_3", ZooByField.class);
    }

    @Test
    void allBeansNotNull() {
        assertNotNull(dog1);
        assertNotNull(dog2);
        assertNotNull(dog3);
        assertNotNull(dog4);

        assertNotNull(cat1);
        assertNotNull(cat2);
        assertNotNull(cat3);

        assertNotNull(zoo1);
        assertNotNull(zoo2);
        assertNotNull(zoo3);
        assertNotNull(zoo4);

        assertNotNull(zoo1_1);
        assertNotNull(zoo2_1);
        assertNotNull(zoo3_1);
        assertNotNull(zoo4_1);
        assertNotNull(zoo4_2);
        assertNotNull(zoo4_3);
    }

    @Test
    void singletonAndPrototypeDog() {
        // dog1 : singleton by default
        assertEquals(applicationContext.getBean("dog1", Dog.class), applicationContext.getBean("dog1", Dog.class));
        // dog2 : prototype
        assertNotEquals(applicationContext.getBean("dog2", Dog.class), applicationContext.getBean("dog2", Dog.class));
        // dog3 : singleton (explicitly set in xml)
        assertEquals(applicationContext.getBean("dog3", Dog.class), applicationContext.getBean("dog3", Dog.class));
    }

    @Test
    void zooHasDog() {

        // both zoo1 and zoo1_1 contain dog1
        assertEquals(dog1, zoo1.getAnimal());
        assertEquals(dog1, zoo1_1.getAnimal());

        // zoo2 and zoo2_1 have a different dog
        assertNotEquals(dog2, zoo2.getAnimal());
        assertNotEquals(dog2, zoo2_1.getAnimal());
        assertNotEquals(zoo2.getAnimal(), zoo2_1.getAnimal());

        // dog4 are autowired to these zoos
        assertEquals(dog4, zoo4_1.getAnimal());
        assertEquals(dog4, zoo4_2.getAnimal());
        assertEquals(dog4, zoo4_3.getAnimal());
        
        // zoo4 has no animal 
        assertNull(zoo4.getAnimal());
    }

}
