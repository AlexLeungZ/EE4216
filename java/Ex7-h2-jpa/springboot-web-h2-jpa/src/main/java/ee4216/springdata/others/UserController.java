
package ee4216.springdata.others;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vanting
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // curl -i http://localhost/spring/data/users
    // Get all courses
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
}

