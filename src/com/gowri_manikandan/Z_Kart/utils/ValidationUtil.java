package com.gowri_manikandan.Z_Kart.utils;

import com.gowri_manikandan.Z_Kart.repository.dto.CardItem;
import com.gowri_manikandan.Z_Kart.repository.dto.Product;
import java.util.List;
import java.util.regex.Pattern;

public class ValidationUtil {
    private static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) return false;
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLower = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static boolean isPasswordReused(String newPassword, List<String> recentPasswords) {
        return recentPasswords.contains(newPassword);
    }

    public static boolean validateProduct(Product product) {
        return product.getName() != null && !product.getName().trim().isEmpty() &&
               product.getPrice() > 0 && product.getStock() >= 0;
    }

    public static boolean validateOrder(List<CardItem> cartItems, List<Product> products) {
        if (cartItems.isEmpty()) return false;
        for (CardItem item : cartItems) {
            Product product = products.stream().filter(p -> p.getId() == item.getProductId()).findFirst().orElse(null);
            if (product == null || product.getStock() < item.getQuantity()) return false;
        }
        return true;
    }
}