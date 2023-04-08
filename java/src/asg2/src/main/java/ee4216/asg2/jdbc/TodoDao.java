package ee4216.asg2.jdbc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> findAllTodo() {
        String sql = "SELECT * FROM TODO";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Todo(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getBoolean("done")));
    }

    public Todo findById(Integer id) {
        String sql = "SELECT * FROM TODO WHERE id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Todo(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getBoolean("done")),
                id);
    }

    public void addTodo(Todo todo) {
        String sql = "INSERT INTO TODO (name, done) VALUES (?, ?)";
        jdbcTemplate.update(sql, todo.getName(), todo.getDone());
    }

    public void updateById(Todo todo) {
        String sql = "UPDATE TODO SET name = ?, done = ? WHERE id = ?";
        jdbcTemplate.update(sql, todo.getName(), todo.getDone(), todo.getId());
    }

    public void deleteById(Integer id) {
        String sql = "DELETE FROM TODO WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
