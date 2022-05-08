package pl.kkadziolka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kkadziolka.productcatalog.MapProductStorage;
import pl.kkadziolka.productcatalog.ProductCatalog;
import pl.kkadziolka.productcatalog.ProductStorage;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Hello");
    }

    @Bean
    ProductStorage createMyProductStorage() {
        return new MapProductStorage();
    }

    @Bean
    ProductCatalog createMyProductCatalog(ProductStorage productStorage) {
        ProductCatalog productCatalog = new ProductCatalog(productStorage);

        fillWithExampleProducts(productCatalog);

        return productCatalog;
    }

    private void fillWithExampleProducts(ProductCatalog productCatalog) {
        String productId1 = productCatalog.addProduct("lego-1", "Nice set");
        productCatalog.changePrice(productId1, BigDecimal.TEN);
        productCatalog.assignImage(productId1, "https://picsum.photos/id/237/200/300");
        productCatalog.publish(productId1);

        String productId2 = productCatalog.addProduct("lego-2", "Event nicer");
        productCatalog.changePrice(productId2, BigDecimal.TEN);
        productCatalog.assignImage(productId2, "https://picsum.photos/id/238/200/300");
        productCatalog.publish(productId2);

        String productId3 = productCatalog.addProduct("lego-3", "Bad one");
        productCatalog.changePrice(productId3, BigDecimal.TEN);
        productCatalog.assignImage(productId3, "https://picsum.photos/id/239/200/300");
        productCatalog.publish(productId3);
    }
}