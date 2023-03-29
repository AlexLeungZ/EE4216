/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee4216.springdata.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author vanting
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    public List<Student> findByEmail(String email);
    
    public List<Student> findFirst2ByOrderByNameAsc();

    public long countDistinctEmailBy();
    
    @Query(value = """
                   SELECT DISTINCT s.* FROM STUDENTS s, GRADES g
                   WHERE s.ID = g.STUDENT_ID 
                   AND g.GRADE LIKE ?1
                   """,
            nativeQuery = true)
    public List<Student> findDistinctStudentWithAGrade(String gradeWithPercentile);
    
}
