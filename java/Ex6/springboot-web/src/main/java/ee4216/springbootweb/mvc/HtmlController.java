package ee4216.springbootweb.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vanting
 *
 */
@Controller
public class HtmlController {

    // demo the use of the parameters: path and method
    // http://localhost/spring/web/welcome1
    @RequestMapping(path = "/welcome1", method = RequestMethod.GET)
    public String welcomeAsHtmlTemplate() {
        return "welcome";       // treat as the view name by default
    }

    // demo to pass multiple arguments
    // http://localhost/spring/web/welcome2
    @RequestMapping(value = {"/welcome2", "/welcome3"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody               // ask the view resolver to treat the returned text as response body
    public String welcomeAsHtmlText() {
        
        // """ (three double quote marks): text block syntax is introduced in JDK 15
        return """
               <!DOCTYPE HTML>
               <html>
                    <head>
                        <title>Welcome Page</title>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    </head>
                    <body>
                        <h1>Welcome!</h1>
                        <p>This page is generated without a HTML template.</p>
                    </body>
               </html>
               """;
    }
    
    // demo to use request params as filter
    // http://localhost/spring/web/welcome4?id=4&key=5
    @RequestMapping(
            path = "/welcome4", 
            method = RequestMethod.GET, 
            params = {"id=4", "key=5"})
    // params = {"id"}      : id must present
    // params = {"!id"}     : id must not present
    // params = {"id!=4"}   : id must not equal to 4
    @ResponseBody
    public String welcomeAsHtmlTextWithParams() {

        return """
               <!DOCTYPE HTML>
               <html>
                    <head>
                        <title>Welcome Page</title>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    </head>
                    <body>
                        <h1>Welcome!</h1>
                        <p>This page requires two HTTP request parameters: id=4 and key=5.</p>
                    </body>
               </html>
               """;
    }

}
