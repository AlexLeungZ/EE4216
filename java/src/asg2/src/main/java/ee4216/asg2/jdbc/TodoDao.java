package ee4216.asg2.jdbc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all todo list items
    public List<Todo> findAllTodo() {
        String sql = "SELECT * FROM TODO";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Todo(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getBoolean("done"),
                rs.getInt("timer")));
    }

    // Get todo list item by id
    public Todo findById(Integer id) {
        String sql = "SELECT * FROM TODO WHERE id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Todo(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getBoolean("done"),
                rs.getInt("timer")),
                id);
    }

    // Add new todo list item
    public void addTodo(Todo todo) {
        String sql = "INSERT INTO TODO (name, done) VALUES (?, ?)";
        jdbcTemplate.update(sql, todo.getName(), false);
    }

    // Update todo list item by id
    public void updateById(Todo todo) {
        String sql = "UPDATE TODO SET name = ?, done = ?, timer = ? WHERE id = ?";
        jdbcTemplate.update(sql, todo.getName(), todo.getDone(), todo.getTimer(), todo.getId());
    }

    // Delete todo list item by id
    public void deleteById(Integer id) {
        String sql = "DELETE FROM TODO WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
