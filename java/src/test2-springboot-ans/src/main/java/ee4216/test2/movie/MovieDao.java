package ee4216.test2.movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * A DAO (Data Access Object) class to interact with the database and perform
 * CRUD operations against the 'movies' and 'movie_genres' tables.
 *
 * @author vanting
 */
public class MovieDao {

    private JdbcTemplate jdbcTemplate;

    public MovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM movies m, movies_genres mg WHERE m.id = mg.movie_id";
        
        List<Movie> movies;
        movies = jdbcTemplate.query(sql, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Movie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year"),
                        rs.getDouble("rank"),
                        List.of(rs.getString("genre"))
                );
            }
        });
        
        return mergeMovieGenresAndSort(movies);
    }
    
    public List<Movie> getAllMovies(String genre) {
        String sql = "SELECT * FROM movies m, movies_genres mg WHERE m.id = mg.movie_id AND genre = ?";
        
        List<Movie> movies;
        movies = jdbcTemplate.query(sql, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Movie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year"),
                        rs.getDouble("rank"),
                        List.of(rs.getString("genre"))
                );
            }
        }, genre);
        
        return movies;
    }
    
    public Movie getMovie(int id) {
        String sql = "SELECT * FROM movies m, movies_genres mg WHERE m.id = mg.movie_id AND m.id = ?";
        
        List<Movie> movies;
        movies = jdbcTemplate.query(sql, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Movie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year"),
                        rs.getDouble("rank"),
                        List.of(rs.getString("genre"))
                );
            }
        }, id);
        
        return mergeMovieGenresAndSort(movies).get(0);
    }

    public static List<Movie> mergeMovieGenresAndSort(List<Movie> movies) {
        return movies.stream()
                .collect(groupingBy(Movie::getId))              // group by id
                .values().stream()                              // to a stream of sublist of movies for each group
                .map(movs -> {                                  // map a group to a movie by merging the genres
                    List<String> genres = new ArrayList<>();    
                    for(Movie m : movs) {
                        genres.addAll(m.getGenres());
                    }
                    genres.sort(null);                          // sort genres
                    movs.get(0).setGenres(genres);
                    return movs.get(0);
                })
                .sorted((a,b) -> a.getName().compareTo(b.getName()))    // sort movies by name 
                .collect(Collectors.toList());       
    }
}
