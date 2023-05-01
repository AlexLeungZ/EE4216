
package ee4216.springdata.jdbc;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller class to handle the HTTP requests and map them to the appropriate DAO methods.
 * @author vanting
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseDao courseDao;

    /** 
     * As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no 
     * longer necessary if the target bean only defines one constructor to begin with. 
     * However, if several constructors are available, at least one must be annotated to 
     * teach the container which one to use.
     */
    public CourseController(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    // curl -i http://localhost/spring/data/courses   
    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    // curl -i http://localhost/spring/data/courses/10004   
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseDao.getCourseById(id);
    }

    // curl -i -X POST -H "Content-Type: application/json" -d '{"id":10005,"name":"Informatics 200","teacherId":1234}' http://localhost/spring/data/courses
    @PostMapping("")
    public void addCourse(@RequestBody Course course) {
        courseDao.addCourse(course);
    }

    // curl -i -X PUT -H "Content-Type: application/json" -d '{"id":10004,"name":"Informatics 300","teacherId":1234}' http://localhost/spring/data/courses/10004
    @PutMapping("/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setId(id);
        courseDao.updateCourse(course);
    }
    
    // curl -i -X DELETE http://localhost/spring/data/courses/10004
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseDao.deleteCourse(id);
    }
}
