package ee4216.springbootweb.mvc;

import ee4216.springbootweb.rest.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vanting
 */
@Controller
@RequestMapping("/home")
public class ModelController {

    @Value("${spring.application.name}")
    String appName;

    // http://localhost/spring/web/home/page1
    @GetMapping("/page1")   
    public String homePage1(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("message", "This message is added using the Model interface.");
        return "home";
    }

    // http://localhost/spring/web/home/page2
    @GetMapping("/page2")   
    public String homePage2(ModelMap model) {       // use Map type also works!
        // we can process the model as a map
        model.put("appName", appName);
        model.put("message", "This message is added using the ModelMap class.");
        model.forEach((key, value) -> { model.put(key, "**" + value + "**"); });
        return "home";
    }

    // http://localhost/spring/web/home/page3
    @GetMapping("/page3")   
    public ModelAndView homePage3() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.getModel().put("appName", "EE4216");
        mv.getModel().put("message", "This message is added using the ModelAndView class.");
        return mv;
    }
    
    // http://localhost/spring/web/home/page4?name=Van&msg=This%20message%20is%20mapped%20using%20%40ModelAttribute.
    // use @ModelAttribute to map multiple parameters into a domain object
    @GetMapping("/page4")   
    public String homePage4(@ModelAttribute User user, Model model) {
        model.addAttribute("appName", user.getName());
        model.addAttribute("message", user.getMsg());
        return "home";
    }
    
    
}
