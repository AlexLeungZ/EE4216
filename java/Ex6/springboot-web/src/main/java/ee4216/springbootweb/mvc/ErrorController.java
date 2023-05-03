package ee4216.springbootweb.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author vanting
 */
@Controller
public class ErrorController {

    @GetMapping("/exception")
    public String getStudents(Model model) throws Exception {
        throw new Exception("Ooops! Something went wrong!");
    }
}

