package ee4216.springdata;

import ee4216.springdata.jpa.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDatabaseDemoTests {
    
    @Autowired
    private StudentRepository studentRepository;

	@Test
	void autoQueriesWithMethodKeywords() {
            
            System.out.println(studentRepository.findByEmail("lisa@fox.com"));
            System.out.println(studentRepository.countDistinctEmailBy());
            System.out.println(studentRepository.findFirst2ByOrderByNameAsc());
            
            
	}
        
        

}
