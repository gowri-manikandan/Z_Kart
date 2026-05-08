package com.gowri_manikandan.Z_Kart.features.card.details;

import com.gowri_manikandan.Z_Kart.repository.dto.Card;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.List;
import java.util.Scanner;

public class CardDetailView {
    private final CardDetailModel cardDetailModel;
    private final Scanner scanner = new Scanner(System.in);

    public CardDetailView() {
        cardDetailModel = new CardDetailModel(this);
    }

    public void showMyCards() {
        List<Card> cards = cardDetailModel.getMyCards();
        if (cards.isEmpty()) {
            ConsoleUtil.displayMessage("No cards found.");
            return;
        }
        ConsoleUtil.displayHeader("My Cards");
        for (Card c : cards) {
            System.out.println("Card Number: **** **** **** " + c.getCardNumber().substring(c.getCardNumber().length() - 4));
            System.out.println("Expiry: " + c.getExpiryDate());
            System.out.println("Holder: " + c.getCardHolderName());
        }
        ConsoleUtil.displaySeparator();
    }
}

