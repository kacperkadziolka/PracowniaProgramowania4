package pl.kkadziolka.sales.product;

import pl.kkadziolka.productcatalog.ProductCatalog;
import pl.kkadziolka.productcatalog.ProductData;

import java.util.Optional;

public class ProductCatalogProductDetailsProvuder implements ProductDetailsProvider{
    ProductCatalog productCatalog;

    public ProductCatalogProductDetailsProvuder(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public Optional<ProductDetails> getById(String productId) {
        ProductData data = productCatalog.findById(productId);

        if (data == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(new ProductDetails(productId, data.getName(), data.getPrice()));
    }
}