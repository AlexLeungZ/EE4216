package ee4216.test2.movie;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vanting
 */
@Controller
@RequestMapping("movie")
public class MovieController {

    @Value("${ee4216.student.id}")
    String studentId;

    private MovieDao movieDao;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @GetMapping("/task1")
    public String getAllMovies1(Model model) {
        List<Movie> list = movieDao.getAllMovies();
        model.addAttribute("movies", list);
        model.addAttribute("studentId", studentId);
        return "task1";
    }

    @GetMapping("/task2")
    public String getAllMovies2(Model model) {
        List<Movie> list = movieDao.getAllMovies();
        model.addAttribute("movies", list);
        model.addAttribute("studentId", studentId);
        return "task2";
    }

    @GetMapping("/task3")
    public String getAllMovies3(Model model) {
        List<Movie> list = movieDao.getAllMovies();
        model.addAttribute("movies", list);
        model.addAttribute("studentId", studentId);
        return "task3";
    }

    @GetMapping(path = "/json", produces = "application/json")
    @ResponseBody
    public Movie getMovieAsJson(@RequestParam int id) {
        return movieDao.getMovie(id);
    }

    @GetMapping(path = "/xml", produces = "application/xml")
    @ResponseBody
    public Movie getMovieAsXml(@RequestParam int id) {
        return movieDao.getMovie(id);
    }

    @GetMapping("/{genre}")
    public String getAllMovies(@PathVariable String genre, Model model) {
        List<Movie> list = movieDao.getAllMovies(genre);
        model.addAttribute("movies", list);
        model.addAttribute("studentId", studentId);
        return "task3";
    }

}
