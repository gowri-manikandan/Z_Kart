package com.gowri_manikandan.Z_Kart.features.product.details;

import com.gowri_manikandan.Z_Kart.repository.dto.Product;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.Scanner;

public class ProductDetailView {
    private final ProductDetailModel productDetailModel;
    private final Scanner scanner = new Scanner(System.in);

    public ProductDetailView() {
        productDetailModel = new ProductDetailModel(this);
    }

    public void showProductDetails(long productId) {
        Product product = productDetailModel.getProductDetails(productId);
        if (product != null) {
            ConsoleUtil.displayHeader("Product Details");
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Stock: " + product.getStock());
            System.out.println("Model: " + product.getModel());
            System.out.println("Category: " + product.getCategory());
            System.out.println("Brand: " + product.getBrand());
            ConsoleUtil.displaySeparator();
        }
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }
}

