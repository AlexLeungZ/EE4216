package ee4216.springbootweb.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vanting
 */
@Controller
@RequestMapping("student")
public class StudentController {
    
    @Autowired
    private Map<Long, Student> students;

    @GetMapping("/")
    public String getStudent(Model model) {
        List<Student> list = new ArrayList<>(students.values());
        model.addAttribute("students", list);
        return "student";
    }
 
    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("student", students.get(id));
        model.addAttribute("textColor", "text-primary");
        return "student_form";
    }
    
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("student") Student newStudent) {
        students.replace(newStudent.getId(), newStudent);
        return "redirect:/web/student/";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        students.remove(id);
        return "redirect:/web/student/";  
    }
}

