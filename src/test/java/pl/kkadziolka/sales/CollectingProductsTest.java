package pl.kkadziolka.sales;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class CollectingProductsTest {

    @Test
    void showsEmptyOffer() {
        String clientId = thereIsClient();
        Sales sales = thereIsSalesModule();

        Offer offer = sales.getCurrentOffer(clientId);

        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }
    @Test
    void itAllowToAddProduct() {
        String productId = thereIsProduct("lego", BigDecimal.valueOf(10.10));
        String clientId = thereIsClient();
        Sales sales = thereIsSalesModule();
        sales.addToCart(clientId, productId);

        Offer offer = sales.getCurrentOffer(clientId);

        assertEquals(BigDecimal.valueOf(10.10), offer.getTotal());
    }

    private String thereIsClient() {
        return null;
    }

    private String thereIsProduct(String lego, BigDecimal valueOf) {
        return null;
    }

    private Sales thereIsSalesModule() {
        return new Sales();
    }

    @Test
    void every5thProductIsFree() {
        String productId = thereIsProduct("lego", BigDecimal.valueOf(10));
        String clientId = thereIsClient();
        Sales sales = thereIsSalesModule();

        sales.addToCart(clientId, productId);
        sales.addToCart(clientId, productId);
        sales.addToCart(clientId, productId);
        sales.addToCart(clientId, productId);
        sales.addToCart(clientId, productId);

        Offer offer = sales.getCurrentOffer(clientId);

        assertEquals(BigDecimal.valueOf(40), offer.getTotal());
    }
}
