package com.gowri_manikandan.Z_Kart.features.product.manage;

import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.Scanner;

public class ProductManageView {
    private final ProductManageModel productManageModel;
    private final Scanner scanner = new Scanner(System.in);

    public ProductManageView() {
        productManageModel = new ProductManageModel(this);
    }

    public void displayManageMenu() {
        ConsoleUtil.displayHeader("Product Management");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Change Stock");
        System.out.println("5. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showAddProductForm() {
        String name = ConsoleUtil.readString("Enter product name: ");
        double price = ConsoleUtil.readDouble("Enter price: ");
        int stock = ConsoleUtil.readInt("Enter stock: ");
        String model = ConsoleUtil.readString("Enter model: ");
        String category = ConsoleUtil.readString("Enter category: ");
        String brand = ConsoleUtil.readString("Enter brand: ");
        productManageModel.addProduct(name, price, stock, model, category, brand);
    }

    public void showUpdateProductForm() {
        long id = ConsoleUtil.readLong("Enter product ID: ");
        String name = ConsoleUtil.readString("Enter new name: ");
        double price = ConsoleUtil.readDouble("Enter new price: ");
        int stock = ConsoleUtil.readInt("Enter new stock: ");
        String model = ConsoleUtil.readString("Enter new model: ");
        String category = ConsoleUtil.readString("Enter new category: ");
        String brand = ConsoleUtil.readString("Enter new brand: ");
        productManageModel.updateProduct(id, name, price, stock, model, category, brand);
    }

    public void showDeleteProductForm() {
        long id = ConsoleUtil.readLong("Enter product ID to delete: ");
        productManageModel.deleteProduct(id);
    }

    public void showChangeStockForm() {
        long id = ConsoleUtil.readLong("Enter product ID: ");
        int stock = ConsoleUtil.readInt("Enter new stock: ");
        productManageModel.changeStock(id, stock);
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }

    public void displaySuccess(String success) {
        ConsoleUtil.displaySuccess(success);
    }
}
