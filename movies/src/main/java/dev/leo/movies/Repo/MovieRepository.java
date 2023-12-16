package dev.leo.movies.Repo;

import dev.leo.movies.Model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    // implement a new method to find by custom id (imdbID), this way the ObjectId is protected from public
    // spring data mongo db already understands what we want to do with the below command
    Optional<Movie> findMovieByImdbId(String imdbId);
}
