/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee4216.springbootweb.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vanting
 */
@RestController
@RequestMapping(path="/api")                // base URL for all handlers
public class RestfulController {

    // curl -i http://localhost/spring/web/api/status 
    @GetMapping("/status")                  // map to /api/status
    public String status() {
        return "working\n";
    }
    
    // curl -i http://localhost/spring/web/api/info1
    @GetMapping({"/info1", "/info2"})       // multiple paths           
    public String getInfo() {
        return "work for both 1&2\n";
    }
    
    // curl -i http://localhost/spring/web/api/info7
    @GetMapping("/info*")                  // wildcard
    public String getOtherInfo() {
        return "the other info\n";
    }

    // curl -i http://localhost/spring/web/api/users/10
    @GetMapping("/users/{id}")              // path variable
    public String getUser(@PathVariable String id) {
        return "HTTP Get was called - User ID: " + id + "\n";
    }
    
    // curl -i http://localhost/spring/web/api/users/mary/25
    @GetMapping("/users/{name}/{age}")
    public String getUser(@PathVariable String name, @PathVariable int age) {
        return "User Name: " + name + " Age: " + age + "\n";
    }
    
    // curl -i http://localhost/spring/web/api/customers/10
    // curl -i http://localhost/spring/web/api/customers/10?name=mary
    @GetMapping("/customers/{id}")              // path variable and request param
    public String getUser(@PathVariable int id, @RequestParam(defaultValue="John") String name) {
        return "Customer Name: " + name + " ID: " + id + "\n";
    }
    
    // curl -i http://localhost/spring/web/api/students
    @GetMapping("/${demo.resource}")        // placeholder
    public String getResource() {
        return "Check resource name from application.properties\n";
    }

    /*
     * Run postman to test the following endpoints:
     * request body : {"name":"mary", "age":30}
     */
    
    // curl -i -X POST http://localhost/spring/web/api/users
    // treat the return value as plain text if not specify produces media type
    @PostMapping(path="/users", produces="application/json")
    public String createUser() {
        return "{\"msg\":\"HTTP POST was called\"}\n";
    }
    
    // curl -v -X POST -H "Content-Type: application/json" -d '{"name":"mary", "age":30}' http://localhost/spring/web/api/users/other
    // no need to specify the produces media type
    // jackson converts the returned object to json automatically
    @PostMapping(path="/users/other")
    public User createUserOther(@RequestBody(required=false) User requestUserDetails) {
        if(requestUserDetails == null)
            requestUserDetails = new User();
        requestUserDetails.setMsg("HTTP POST was called");
        return requestUserDetails;
    }

    // curl -i -X DELETE http://localhost/spring/web/api/users/10
    // no produces media type, output is treated as plain text
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable String id) {
        return "{\"msg\":\"user " + id + " is deleted\"}\n";
    }

    // curl -i -X PUT -H "Content-Type: application/json" -d '{"name":"mary", "age":30}' http://localhost/spring/web/api/users/10
    // must provide RequestBody, default (required=true)
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User requestUserDetails) {
        return "user " + id + " is updated\n";
    }

}
