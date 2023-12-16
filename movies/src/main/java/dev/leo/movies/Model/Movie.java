package dev.leo.movies.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data // equivalent of using getters and setters
@AllArgsConstructor //create constructor for al fields
@NoArgsConstructor // constructor w/ no params
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String trailerLink;
    private String releaseDate;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference //foreign key. Keep referential integrity!!
    private List<Review> reviewIds;
}
