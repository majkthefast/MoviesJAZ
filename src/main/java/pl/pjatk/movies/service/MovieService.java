package pl.pjatk.movies.service;

import org.springframework.stereotype.Service;
import pl.pjatk.movies.domain.Genres;
import pl.pjatk.movies.domain.Movie;
import pl.pjatk.movies.repository.MovieRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private final MovieRepository movieRepository;

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getExampleMovie() {
        Movie movie = new Movie(10, "noname", "idk", Genres.COMEDY);
        movieRepository.save(movie);
        return movie;
    }

    public Movie getMovieById(int id) {
        Optional<Movie> byId = movieRepository.findById(id);
        return byId.orElse(null);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Integer id, Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    public Movie makeAvailable(Integer id) {
        Movie movie = getMovieById(id);
        movie.setAvailable(true);
        return movieRepository.save(movie);
    }

    public Movie makeNotAvailable(Integer id) {
        Movie movie = getMovieById(id);
        movie.setAvailable(false);
        return movieRepository.save(movie);
    }
}
