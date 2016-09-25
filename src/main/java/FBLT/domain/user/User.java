package FBLT.domain.user;


import FBLT.factories.rank.RankFactory;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;


/**
 *
 * This class deals with the user who refers to both the buyer and seller
 *
 */

public class User {

    private Long userId;
    private ContactDetails contactDetails;
    private String name;
    private Location location;
    private int rating;

    private String ranking;

    private User(){}

    private User(Builder builder) {
        this.userId = builder.userId;
        this.contactDetails = builder.contactDetails;
        this.name = builder.name;
        this.location = builder.location;
        this.rating = builder.rating;
        this.ranking = builder.ranking;
    }

    /* returns ranking based on user average rating */
    public String rank(){
        return RankFactory.getRanking(rating);
    }

    public Long getUserId() {
        return userId;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public int getRating() {
        return rating;

    }

    public static class Builder{
        private Long userId;
        private ContactDetails contactDetails;
        private String name;
        private Location location;
        private String ranking;
        private int rating;

        public Builder userId(Long userId){
            this.userId = userId;
            return this;
        }

        public Builder contactDetails(ContactDetails contactDetails){
            this.contactDetails = contactDetails;
            return  this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder location(Location location){
            this.location = location;
            return  this;
        }

        public Builder ranking(String ranking){
            this.ranking = ranking;
            return this;
        }

        public Builder rating(int rating){
            this.rating = rating;
            return this;
        }

        public Builder copy(User user){
            this.userId = user.userId;
            this.contactDetails = user.contactDetails;
            this.name = user.name;
            this.location = user.location;
            this.rating = user.rating;
            this.ranking = user.ranking;

            return  this;
        }

        public User build(){
            return new User(this);
        }

    }


}
