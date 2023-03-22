package EE4216Lab3.springboot.repository;

import java.util.List;

import EE4216Lab3.springboot.entity.Movie;

public interface MovieRepository {
    Movie findById(Integer id);

    List<Movie> findAllMovies();

}