package com.gowri_manikandan.Z_Kart.features.product.details;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Product;

public class ProductDetailModel {
    private final ProductDetailView productDetailView;
    private final Z_KartDB db = Z_KartDB.getInstance();

    public ProductDetailModel(ProductDetailView productDetailView) {
        this.productDetailView = productDetailView;
    }

    public Product getProductDetails(long productId) {
        Product product = db.getProductById(productId);
        if (product == null) {
            productDetailView.displayError("Product not found.");
            return null;
        }
        return product;
    }
}
