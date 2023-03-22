package EE4216Lab3.springboot.repository;

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
            Movie movie = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Movie.class), id);
            return movie;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
