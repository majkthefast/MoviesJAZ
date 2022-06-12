package pl.pjatk.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.movies.domain.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAll();
    Movie save(Movie movie);
    Optional<Movie> findById(Integer id);
    void deleteById(Integer id);
}
