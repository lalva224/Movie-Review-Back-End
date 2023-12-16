package dev.leo.movies.Service;

import dev.leo.movies.Model.Movie;
import dev.leo.movies.Repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired // to instantiate for us
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
    return movieRepository.findAll();
    }
    // optional because it may or may not find a movie. If it does not find a movie it is Null, therefore needs to be optional.
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
