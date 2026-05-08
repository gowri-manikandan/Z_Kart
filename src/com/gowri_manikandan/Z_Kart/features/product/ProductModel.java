package com.gowri_manikandan.Z_Kart.features.product;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Product;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;
import com.gowri_manikandan.Z_Kart.utils.ValidationUtil;
import java.util.List;
import java.util.stream.Collectors;

public class ProductModel {
    private final ProductView productView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public ProductModel(ProductView productView) {
        this.productView = productView;
    }

    public void addProduct(String name, double price, int stock, String model, String category, String brand) {
        session.requireAdminAccess();
        Product product = new Product(0, name, price, stock, model, category, brand, true, System.currentTimeMillis());
        if (!ValidationUtil.validateProduct(product)) {
            productView.displayError("Invalid product data.");
            return;
        }
        db.addProduct(product);
        productView.displaySuccess("Product added successfully.");
    }

    public void updateProduct(long id, String name, double price, int stock, String model, String category, String brand) {
        session.requireAdminAccess();
        Product product = db.getProductById(id);
        if (product == null) {
            productView.displayError("Product not found.");
            return;
        }
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        product.setModel(model);
        product.setCategory(category);
        product.setBrand(brand);
        if (!ValidationUtil.validateProduct(product)) {
            productView.displayError("Invalid product data.");
            return;
        }
        db.updateProduct(product);
        productView.displaySuccess("Product updated successfully.");
    }

    public void deleteProduct(long id) {
        session.requireAdminAccess();
        Product product = db.getProductById(id);
        if (product == null) {
            productView.displayError("Product not found.");
            return;
        }
        db.deleteProduct(id);
        productView.displaySuccess("Product deleted successfully.");
    }

    public void changeStock(long id, int newStock) {
        session.requireAdminAccess();
        Product product = db.getProductById(id);
        if (product == null) {
            productView.displayError("Product not found.");
            return;
        }
        if (newStock < 0) {
            productView.displayError("Stock cannot be negative.");
            return;
        }
        product.setStock(newStock);
        db.updateProduct(product);
        productView.displaySuccess("Stock updated successfully.");
    }

    public List<Product> getAllProducts() {
        return db.getAllProducts();
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
}
