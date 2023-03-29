
package ee4216.springdata.jpa;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vanting
 */
@RestController
@RequestMapping("/courses")
public class AnotherCourseController {

    @Autowired
    private CourseRepository courseRepository;

    // curl -i http://localhost/spring/data/courses   
    // Get all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // curl -i http://localhost/spring/data/courses/10004   
    // Get a course by ID
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Integer id) {
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course not found"));
    }

    // curl -i -X POST -H "Content-Type: application/json" -d '{"id":10005,"name":"Informatics 200","teacherId":1234}' http://localhost/spring/data/courses
    // Create a new course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // curl -i -X PUT -H "Content-Type: application/json" -d '{"id":10004,"name":"Informatics 300","teacherId":1234}' http://localhost/spring/data/courses/10004
    // Update a course
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Integer id, @RequestBody Course updatedCourse) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course not found"));
        course.setName(updatedCourse.getName());
        course.setTeacherId(updatedCourse.getTeacherId());
        return courseRepository.save(course);
    }

    // curl -i -X DELETE http://localhost/spring/data/courses/10004
    // Delete a course
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseRepository.deleteById(id);
    }
}

