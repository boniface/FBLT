package FBLT.repositories.advert;

import FBLT.domain.advert.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Adverts
 */

public interface AdvertRepository extends MongoRepository<Advert, String> {


    /**
     * @param username The users first name
     * @return list of adverts for a given user's name
     * (Will not be unique to a specific user as many users can have the same first name)
     * <p>
     * The query uses the dot notation to access the user value object of the advert object
     */
    @Query(value = "{ 'user.name' : ?0 }")
    List<Advert> find(String username);

    /**
     * @param userId The users unique ID as stored in the database
     * @return list of adverts for a specific user.
     * <p>
     * The query uses the dot notation to access the user value object of the advert object
     */
    @Query(value = "{ 'user._id' : ?0 }")
    List<Advert> findByUserID(String userId);

    @Query(value = "{ 'user.contactDetails.emailAddress' : ?0 }")
    List<Advert> findByUserEmail(String email);

    @Query(value = "{'title' : {'$regex' : ?0 }}")
    List<Advert> findByTitle(String title);

    @Query(value = "{'product.description' : {$regex : ?0, $options : 'i' }}")
    List<Advert> findByDescription(String description);

    @Query(value = "{'product.category.categoryName' : {$regex : ?0, $options : 'i' }}")
    List<Advert> findByCategory(String category);
}
