package ee4216.springbootweb.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("visitor")
public class SessionController {

    @GetMapping("/count")
    public String count(HttpSession session, Model model) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        session.setAttribute("count", count);
        model.addAttribute("count", count);
        return "visitor";
    }
    
    @GetMapping("/reset")
    public String reset(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        
        // forward happens entirely on a server side. The Servlet container forwards 
        // the same request to the target URL; the URL won't change in the browser.
        return "forward:/web/visitor/count";        // relative to the current Servlet context path
        
        // redirect will respond with a 302 and the new URL in the Location header; 
        // the browser/client will then make another request to the new URL.
        //return "redirect:/web/visitor/count";
    }
}
