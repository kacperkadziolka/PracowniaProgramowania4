package pl.kkadziolka.productcatalog;

import java.math.BigDecimal;

public class ProductData {
    private final String id;
    private final String name;
    private BigDecimal price;
    private String imageUrl;
    private boolean online;

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void changePrice(BigDecimal newPrice) {
        price = newPrice;
    }

    public void assignImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isOnline() {
        return online;
    }

    public void publish() {
        this.online = true;
    }

    public String getId() {
        return id;
    }
}