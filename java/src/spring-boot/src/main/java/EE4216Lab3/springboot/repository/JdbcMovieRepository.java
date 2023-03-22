package EE4216Lab3.springboot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import EE4216Lab3.springboot.entity.Movie;

@Repository
public class JdbcMovieRepository implements MovieRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Movie findById(Integer id) {
        String sql = "SELECT * FROM MOVIES WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Movie.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Movie> findAllMovies() {
        try {
            String sql = "SELECT * FROM MOVIES";
            return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class));
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
