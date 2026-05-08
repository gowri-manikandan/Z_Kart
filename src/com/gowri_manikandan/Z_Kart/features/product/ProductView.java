package com.gowri_manikandan.Z_Kart.features.product;

import com.gowri_manikandan.Z_Kart.repository.dto.Product;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private final ProductModel productModel;
    private final Scanner scanner = new Scanner(System.in);

    public ProductView() {
        productModel = new ProductModel(this);
    }

    public void displayProductMenu() {
        ConsoleUtil.displayHeader("Product Management");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Change Stock");
        System.out.println("5. View All Products");
        System.out.println("6. Back");
        ConsoleUtil.displaySeparator();
    }

    public void displayProductSearchMenu() {
        ConsoleUtil.displayHeader("Product Search");
        System.out.println("1. Search by Name/Category/Brand");
        System.out.println("2. Search by Price Range");
        System.out.println("3. View All Products");
        System.out.println("4. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showAddProductForm() {
        String name = ConsoleUtil.readString("Enter product name: ");
        double price = ConsoleUtil.readDouble("Enter price: ");
        int stock = ConsoleUtil.readInt("Enter stock: ");
        String model = ConsoleUtil.readString("Enter model: ");
        String category = ConsoleUtil.readString("Enter category: ");
        String brand = ConsoleUtil.readString("Enter brand: ");
        productModel.addProduct(name, price, stock, model, category, brand);
    }

    public void showUpdateProductForm() {
        long id = ConsoleUtil.readLong("Enter product ID: ");
        String name = ConsoleUtil.readString("Enter new name: ");
        double price = ConsoleUtil.readDouble("Enter new price: ");
        int stock = ConsoleUtil.readInt("Enter new stock: ");
        String model = ConsoleUtil.readString("Enter new model: ");
        String category = ConsoleUtil.readString("Enter new category: ");
        String brand = ConsoleUtil.readString("Enter new brand: ");
        productModel.updateProduct(id, name, price, stock, model, category, brand);
    }

    public void showDeleteProductForm() {
        long id = ConsoleUtil.readLong("Enter product ID to delete: ");
        productModel.deleteProduct(id);
    }

    public void showChangeStockForm() {
        long id = ConsoleUtil.readLong("Enter product ID: ");
        int stock = ConsoleUtil.readInt("Enter new stock: ");
        productModel.changeStock(id, stock);
    }

    public void showAllProducts() {
        List<Product> products = productModel.getAllProducts();
        displayProducts(products);
    }

    public void showSearchForm() {
        String query = ConsoleUtil.readString("Enter search query: ");
        List<Product> products = productModel.searchProducts(query);
        displayProducts(products);
    }

    public void showPriceRangeSearchForm() {
        double min = ConsoleUtil.readDouble("Enter min price: ");
        double max = ConsoleUtil.readDouble("Enter max price: ");
        List<Product> products = productModel.searchByPriceRange(min, max);
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

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }

    public void displaySuccess(String success) {
        ConsoleUtil.displaySuccess(success);
    }
}
