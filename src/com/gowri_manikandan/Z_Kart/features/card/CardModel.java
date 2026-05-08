package com.gowri_manikandan.Z_Kart.features.card;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.CardItem;
import com.gowri_manikandan.Z_Kart.repository.dto.Product;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;
import java.util.List;

public class CardModel {
    private final CardView cardView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public CardModel(CardView cardView) {
        this.cardView = cardView;
    }

    public void addToCart(long productId, int quantity) {
        session.requireLogin();
        Product product = db.getProductById(productId);
        if (product == null || !product.isActive()) {
            cardView.displayError("Product not found or inactive.");
            return;
        }
        if (quantity <= 0) {
            cardView.displayError("Quantity must be positive.");
            return;
        }

        List<CardItem> cart = getCart();
        CardItem existing = cart.stream().filter(c -> c.getProductId() == productId).findFirst().orElse(null);
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + quantity);
            db.updateCartItem(existing);
        } else {
            CardItem item = new CardItem(0, session.getLoggedInCustomer().getId(), productId, quantity);
            db.addCartItem(item);
        }
        cardView.displaySuccess("Added to cart.");
    }

    public void removeFromCart(long productId) {
        session.requireLogin();
        List<CardItem> cart = getCart();
        CardItem item = cart.stream().filter(c -> c.getProductId() == productId).findFirst().orElse(null);
        if (item == null) {
            cardView.displayError("Item not in cart.");
            return;
        }
        db.removeCartItem(item.getId());
        cardView.displaySuccess("Removed from cart.");
    }

    public void updateCartQuantity(long productId, int quantity) {
        session.requireLogin();
        if (quantity <= 0) {
            removeFromCart(productId);
            return;
        }
        List<CardItem> cart = getCart();
        CardItem item = cart.stream().filter(c -> c.getProductId() == productId).findFirst().orElse(null);
        if (item == null) {
            cardView.displayError("Item not in cart.");
            return;
        }
        item.setQuantity(quantity);
        db.updateCartItem(item);
        cardView.displaySuccess("Quantity updated.");
    }

    public List<CardItem> getCart() {
        session.requireLogin();
        return db.getCartItemsByCustomerId(session.getLoggedInCustomer().getId());
    }

    public double getCartTotal() {
        List<CardItem> cart = getCart();
        double total = 0;
        for (CardItem item : cart) {
            Product product = db.getProductById(item.getProductId());
            if (product != null) {
                total += product.getPrice() * item.getQuantity();
            }
        }
        return total;
    }

    public void clearCart() {
        session.requireLogin();
        db.clearCart(session.getLoggedInCustomer().getId());
        cardView.displaySuccess("Cart cleared.");
    }
}
