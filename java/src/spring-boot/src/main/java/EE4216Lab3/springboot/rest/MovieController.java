package EE4216Lab3.springboot.rest;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import EE4216Lab3.springboot.repository.*;
import EE4216Lab3.springboot.entity.*;;

@RestController
@RequestMapping(path = "/api")
public class MovieController {
    @Autowired
    MovieRepository repository;
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/status")
    public String status() {
        return "working\n";
    }

    private ResponseEntity<String> jsonWrapper(Object obj) {
        try {
            String json = objectMapper.writeValueAsString(obj);
            return new ResponseEntity<>(json, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/movies")
    public ResponseEntity<String> getMovie() {
        return jsonWrapper(repository.findAllMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<String> getMovieById(@PathVariable("id") Integer id) {
        return jsonWrapper(repository.findById(id));
    }

}
