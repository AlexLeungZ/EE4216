package EE4216Lab3.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import EE4216Lab3.springboot.entity.Movie;

@Repository
public class MovieDao implements MovieRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> findAllMovies() {
        String sql = "SELECT * FROM MOVIES";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("year"),
                rs.getFloat("rank")));
    }

    @Override
    public Movie findById(Integer id) {
        String sql = "SELECT * FROM MOVIES WHERE id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("year"),
                rs.getFloat("rank")),
                id);
    }

    @Override
    public void updateById(Movie movie) {
        String sql = "UPDATE MOVIES SET name = ?, \"year\" = ?, rank = ? WHERE id = ?";
        jdbcTemplate.update(sql, movie.getName(), movie.getYear(), movie.getRank(), movie.getId());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM MOVIES WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}