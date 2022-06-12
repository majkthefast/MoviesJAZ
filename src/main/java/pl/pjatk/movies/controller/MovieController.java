package pl.pjatk.movies.controller;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.movies.domain.Movie;
import pl.pjatk.movies.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/db_movies")
@Api("/api/tasks")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Return all movies", notes = "info about all movies")
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAll());
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Get example movie", notes = "get info about example movie")
    @GetMapping("/getexample")
    public ResponseEntity<Movie> getExampleMovie() {
        return ResponseEntity.ok(movieService.getExampleMovie());
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Get movie by id",notes = "get info about movie by id")
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@ApiParam(value = "unique id of movie", example = "123") @PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Add movie",notes = "add movie info")
    @PostMapping("/addmovies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Update movie", notes = "update movie info")
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@ApiParam(value = "unique id of movie", example = "123")@PathVariable Integer id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Delete movie by id",notes = "delete movie info by id")
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@ApiParam(value = "unique id of movie", example = "123")@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Return movie", notes = "Make movie available after rental")
    @PutMapping("/makeAvailable/{id}")
    public ResponseEntity<Movie> makeAvailable(@ApiParam(value = "unique id of movie", example = "123")@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.makeAvailable(id));
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Rent movie", notes = "Rent movie")
    @PutMapping("/makeNotAvailable/{id}")
    public ResponseEntity<Movie> makeNotAvailable(@ApiParam(value = "unique id of movie", example = "123")@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.makeNotAvailable(id));
    }
}

