package ee4216.springdata.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * A DAO (Data Access Object) class to interact with the database and perform
 * CRUD operations against the 'courses' table.
 *
 * @author vanting
 */
public class CourseDao {

    private JdbcTemplate jdbcTemplate;

    /**
     * As of Spring Framework 4.3, an @Autowired annotation on such a
     * constructor is no longer necessary if the target bean only defines one
     * constructor to begin with. However, if several constructors are
     * available, at least one must be annotated to teach the container which
     * one to use.
     */
    public CourseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("teacher_id")
                );
            }
        });

        // alternately, using lambda
//        return jdbcTemplate.query(sql, (rs, rowNum) ->
//                new Course(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getInt("teacher_id")
//                ));
    }

    public Course getCourseById(int courseId) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum)
                -> new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("teacher_id")
                ),
                courseId);
    }

    public void addCourse(Course course) {
        String sql = "INSERT INTO courses (id, name, teacher_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, course.getId(), course.getName(), course.getTeacherId());
    }

    public void updateCourse(Course course) {
        String sql = "UPDATE courses SET name = ?, teacher_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, course.getName(), course.getTeacherId(), course.getId());
    }

    public void deleteCourse(int courseId) {
        String sql = "DELETE FROM courses WHERE id = ?";
        jdbcTemplate.update(sql, courseId);
    }

    // For update a large numbers of rows in a table
    public int[] batchUpdateUsingJdbcTemplate(List<Course> courses) {
        return jdbcTemplate.batchUpdate("INSERT INTO courses VALUES (?, ?, ?)",
                new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, courses.get(i).getId());
                ps.setString(2, courses.get(i).getName());
                ps.setInt(3, courses.get(i).getTeacherId());
            }

            @Override
            public int getBatchSize() {
                return 50;
            }
        });
    }

    // Establish connection every time, not efficient
    public void useManualConnection() throws SQLException {
        try (ResultSet rs = jdbcTemplate.getDataSource()
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM courses")) {

            System.out.println("The courses table:");
            while (rs.next()) {
                System.out.print(rs.getInt("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getInt("teacher_id"));
            }
        }
    }
}
