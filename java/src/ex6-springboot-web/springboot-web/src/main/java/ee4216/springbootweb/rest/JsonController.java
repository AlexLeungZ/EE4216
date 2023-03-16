
package ee4216.springbootweb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vanting
 */
@Controller
@RequestMapping("/json")
public class JsonController {
    
    // curl --header "Accept: application/xml" http://localhost/spring/web/json/user1
    // curl --header "Accept: application/json" http://localhost/spring/web/json/user1
    @GetMapping(path="/user1")
    @ResponseBody
    public User helloUser() {
        User user = new User();
        user.setName("Tom");
        user.setAge(15);
        user.setMsg("Hello, " + user.getName() + "!");
        return user;
    }
    
    // curl -i -X POST -H "Content-Type: application/json" -d '{"name":"Mary", "age":40}' http://localhost/spring/web/json/user2     
    // curl -i -X POST -H "Content-Type: application/json" -H "Accept: application/xml" -d '{"name":"Mary", "age":40}' http://localhost/spring/web/json/user2     
    @PostMapping(path="/user2")
    @ResponseBody
    public User helloUserPostWithJsonBody(@RequestBody User user) {
        user.setMsg("Hello, " + user.getName() + "!");
        return user;
    }
    
}
