package dev.leo.movies.Service;

import dev.leo.movies.Model.Movie;
import dev.leo.movies.Model.Review;
import dev.leo.movies.Repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    //template can be used to talk to DB.
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        //create review object and pass to repo
        Review review = reviewRepository.insert(new Review(reviewBody));

        //Then, associate to a specific movie-> use mongoTemplate. Basically just adding reviews to the movie's reviewList

        // another approach is to use movieService findMovieById method and then modify that object directly before saving it back to repo.
        // which approach is better? Below seems better for more complex logic and to avoid concurrency issues.

        Query query = new Query();
        query.addCriteria(Criteria.where("imdbId").is(imdbId));

        Update update = new Update();
        update.push("reviewIds",review);

        mongoTemplate.updateFirst(query,update,Movie.class);

        return review;
    }
}
