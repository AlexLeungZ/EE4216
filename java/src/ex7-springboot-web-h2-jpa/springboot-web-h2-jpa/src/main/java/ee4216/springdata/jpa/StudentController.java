
package ee4216.springdata.jpa;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vanting
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // curl -i http://localhost/spring/data/students   
    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // curl -i http://localhost/spring/data/students/123   
    // Get a student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }
    
    // =================  BELOW ARE CUSTOM QUERIES
    
    // curl -i http://localhost/spring/data/students/email/milhouse@fox.com
    // Get a student by ID
    @GetMapping("/email/{email}")
    public List<Student> getStudentByEmail(@PathVariable String email) {
        return studentRepository.findByEmail(email);
    }
    
    // curl -i http://localhost/spring/data/students/first2
    // Get first two students ordered by name ascendingly
    @GetMapping("/first2")
    public List<Student> getFirst2StudentOrderByNameAscending() {
        return studentRepository.findFirst2ByOrderByNameAsc();
    }
    
    // curl -i http://localhost/spring/data/students/count
    // Count no. of distinct email addresses
    @GetMapping("/count")
    public Entry<String, Long> countByDistinctEmail() {
        return Map.entry("count", studentRepository.countDistinctEmailBy());
    }

    // curl -i http://localhost/spring/data/students/grade/d
    // Get students with grade D
    @GetMapping("/grade/{grade}")
    public List<Student> findDistinctStudentWithAGrade(@PathVariable String grade) {
        return studentRepository.findDistinctStudentWithAGrade(grade.toUpperCase() + '%');
    }
   
}

