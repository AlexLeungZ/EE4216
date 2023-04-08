package ee4216.asg2.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api")
public class TodoController {
    @Autowired
    TodoDao todoDao;
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/status")
    public String status() {
        return "API is up";
    }

    @ResponseBody
    @GetMapping(path = "/todo", produces = "application/json")
    public List<Todo> getTodo() {
        return todoDao.findAllTodo();
    }

    @ResponseBody
    @GetMapping(path = "/todo/{id}", produces = "application/json")
    public Todo getTodoById(@PathVariable("id") Integer id) {
        return todoDao.findById(id);
    }

    @PostMapping("/todo")
    public void addTodo(@RequestBody Todo todo) {
        todoDao.addTodo(todo);
    }

    @PutMapping("/todo/{id}")
    public void updateMovie(@PathVariable("id") Integer id, @RequestBody Todo todo) {
        todo.setId(id);
        todoDao.updateById(todo);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        todoDao.deleteById(id);
    }

}
