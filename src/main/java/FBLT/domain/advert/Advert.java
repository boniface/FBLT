package FBLT.domain.advert;

import FBLT.domain.product.Product;
import FBLT.domain.user.User;
import FBLT.utils.genericvalueobjects.Location;

/**
 * Created by Brandonhome on 2016/09/20.
 */
public class Advert implements IAdvert {

    private Long advertID;
    private User user;
    private Product product;
    private boolean buyOrSell;
    private double price;
    private Location location;

    private Advert() {
    }

    private Advert(Builder builder) {
        this.advertID = builder.advertID;
        this.user = builder.user;
        this.product = builder.product;
        this.buyOrSell = builder.buyOrSell;
        this.price = builder.price;
        this.location = builder.location;
    }



    public Long getAdvertID() {
        return advertID;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isBuyOrSell() {
        return buyOrSell;
    }

    public double getPrice() {
        return price;
    }

    public Location getLocation() {
        return location;
    }

    public static class Builder {

        private Long advertID;
        private User user;
        private Product product;
        private boolean buyOrSell;
        private double price;
        private Location location;

        public Builder() {

        }

        public Builder copy(Advert advert) {
            this.advertID = advert.advertID;
            this.user = advert.user;
            this.product = advert.product;
            this.buyOrSell = advert.buyOrSell;
            this.price = advert.price;
            this.location = advert.location;
            return this;

        }

        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        public Builder advertID(Long advertID) {
            this.advertID = advertID;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder product(Product product) {
            this.product = product;
            return this;

        }

        public Builder buyOrSell(boolean buyOrSell) {
            this.buyOrSell = buyOrSell;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;

        }

        public Advert build() {
            return new Advert(this);
        }


    }


}
