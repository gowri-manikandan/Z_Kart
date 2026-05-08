package com.gowri_manikandan.Z_Kart.features.product.search;

import com.gowri_manikandan.Z_Kart.repository.dto.Product;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.List;
import java.util.Scanner;

public class ProductSearchView {
    private final ProductSearchModel productSearchModel;
    private final Scanner scanner = new Scanner(System.in);

    public ProductSearchView() {
        productSearchModel = new ProductSearchModel(this);
    }

    public void displaySearchMenu() {
        ConsoleUtil.displayHeader("Product Search");
        System.out.println("1. Search by Name/Category/Brand");
        System.out.println("2. Search by Price Range");
        System.out.println("3. View All Products");
        System.out.println("4. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showSearchForm() {
        String query = ConsoleUtil.readString("Enter search query: ");
        List<Product> products = productSearchModel.searchProducts(query);
        displayProducts(products);
    }

    public void showPriceRangeSearchForm() {
        double min = ConsoleUtil.readDouble("Enter min price: ");
        double max = ConsoleUtil.readDouble("Enter max price: ");
        List<Product> products = productSearchModel.searchByPriceRange(min, max);
        displayProducts(products);
    }

    public void showAllProducts() {
        List<Product> products = productSearchModel.getAllProducts();
        displayProducts(products);
    }

    private void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            ConsoleUtil.displayMessage("No products found.");
            return;
        }
        ConsoleUtil.displayHeader("Products");
        for (Product p : products) {
            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice() + ", Stock: " + p.getStock() + ", Category: " + p.getCategory() + ", Brand: " + p.getBrand());
        }
        ConsoleUtil.displaySeparator();
    }
}
