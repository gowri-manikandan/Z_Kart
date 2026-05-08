package com.gowri_manikandan.Z_Kart.features.product.search;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSearchModel {
    private final ProductSearchView productSearchView;
    private final Z_KartDB db = Z_KartDB.getInstance();

    public ProductSearchModel(ProductSearchView productSearchView) {
        this.productSearchView = productSearchView;
    }

    public List<Product> searchProducts(String query) {
        List<Product> products = db.getAllProducts();
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()) ||
                             p.getCategory().toLowerCase().contains(query.toLowerCase()) ||
                             p.getBrand().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Product> searchByPriceRange(double min, double max) {
        List<Product> products = db.getAllProducts();
        return products.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return db.getAllProducts();
    }
}
