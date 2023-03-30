package EE4216Lab3.springboot.dao;

import java.util.List;

import EE4216Lab3.springboot.entity.Movie;

public interface MovieRepository {
    List<Movie> findAllMovies();

    Movie findById(Integer id);

    void updateById(Movie movie);

    void deleteById(Integer id);
}