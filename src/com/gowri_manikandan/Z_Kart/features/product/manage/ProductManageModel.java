package com.gowri_manikandan.Z_Kart.features.product.manage;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Product;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;
import com.gowri_manikandan.Z_Kart.utils.ValidationUtil;

public class ProductManageModel {
    private final ProductManageView productManageView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public ProductManageModel(ProductManageView productManageView) {
        this.productManageView = productManageView;
    }

    public void addProduct(String name, double price, int stock, String model, String category, String brand) {
        session.requireAdminAccess();
        Product product = new Product(0, name, price, stock, model, category, brand, true, System.currentTimeMillis());
        if (!ValidationUtil.validateProduct(product)) {
            productManageView.displayError("Invalid product data.");
            return;
        }
        db.addProduct(product);
        productManageView.displaySuccess("Product added successfully.");
    }

    public void updateProduct(long id, String name, double price, int stock, String model, String category, String brand) {
        session.requireAdminAccess();
        Product product = db.getProductById(id);
        if (product == null) {
            productManageView.displayError("Product not found.");
            return;
        }
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        product.setModel(model);
        product.setCategory(category);
        product.setBrand(brand);
        if (!ValidationUtil.validateProduct(product)) {
            productManageView.displayError("Invalid product data.");
            return;
        }
        db.updateProduct(product);
        productManageView.displaySuccess("Product updated successfully.");
    }

    public void deleteProduct(long id) {
        session.requireAdminAccess();
        Product product = db.getProductById(id);
        if (product == null) {
            productManageView.displayError("Product not found.");
            return;
        }
        db.deleteProduct(id);
        productManageView.displaySuccess("Product deleted successfully.");
    }

    public void changeStock(long id, int newStock) {
        session.requireAdminAccess();
        Product product = db.getProductById(id);
        if (product == null) {
            productManageView.displayError("Product not found.");
            return;
        }
        if (newStock < 0) {
            productManageView.displayError("Stock cannot be negative.");
            return;
        }
        product.setStock(newStock);
        db.updateProduct(product);
        productManageView.displaySuccess("Stock updated successfully.");
    }
}
