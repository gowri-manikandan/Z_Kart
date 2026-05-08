package com.gowri_manikandan.Z_Kart.features.card;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.CardItem;
import com.gowri_manikandan.Z_Kart.repository.dto.Product;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.List;
import java.util.Scanner;

public class CardView {
    private final CardModel cardModel;
    private final Scanner scanner = new Scanner(System.in);
    private final Z_KartDB db = Z_KartDB.getInstance();

    public CardView() {
        cardModel = new CardModel(this);
    }

    public void displayCartMenu() {
        ConsoleUtil.displayHeader("Cart Management");
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove from Cart");
        System.out.println("3. Update Quantity");
        System.out.println("4. View Cart");
        System.out.println("5. Clear Cart");
        System.out.println("6. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showAddToCartForm() {
        long productId = ConsoleUtil.readLong("Enter product ID: ");
        int quantity = ConsoleUtil.readInt("Enter quantity: ");
        cardModel.addToCart(productId, quantity);
    }

    public void showRemoveFromCartForm() {
        long productId = ConsoleUtil.readLong("Enter product ID to remove: ");
        cardModel.removeFromCart(productId);
    }

    public void showUpdateQuantityForm() {
        long productId = ConsoleUtil.readLong("Enter product ID: ");
        int quantity = ConsoleUtil.readInt("Enter new quantity: ");
        cardModel.updateCartQuantity(productId, quantity);
    }

    public void showCart() {
        List<CardItem> cart = cardModel.getCart();
        if (cart.isEmpty()) {
            ConsoleUtil.displayMessage("Cart is empty.");
            return;
        }
        ConsoleUtil.displayHeader("Your Cart");
        double total = 0;
        for (CardItem item : cart) {
            Product product = db.getProductById(item.getProductId());
            if (product != null) {
                double itemTotal = product.getPrice() * item.getQuantity();
                total += itemTotal;
                System.out.println("Product: " + product.getName() + ", Quantity: " + item.getQuantity() + ", Price: " + product.getPrice() + ", Total: " + itemTotal);
            }
        }
        System.out.println("Grand Total: " + total);
        ConsoleUtil.displaySeparator();
    }

    public void showClearCart() {
        cardModel.clearCart();
    }

    public double getCartTotal() {
        return cardModel.getCartTotal();
    }

    public List<CardItem> getCartItems() {
        return cardModel.getCart();
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }

    public void displaySuccess(String success) {
        ConsoleUtil.displaySuccess(success);
    }
}
