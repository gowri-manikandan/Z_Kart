package com.gowri_manikandan.Z_Kart.features.card.manage;

import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.Scanner;

public class CardManageView {
    private final CardManageModel cardManageModel;
    private final Scanner scanner = new Scanner(System.in);

    public CardManageView() {
        cardManageModel = new CardManageModel(this);
    }

    public void displayManageMenu() {
        ConsoleUtil.displayHeader("Card Management");
        System.out.println("1. Add Card");
        System.out.println("2. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showAddCardForm() {
        String cardNumber = ConsoleUtil.readString("Enter card number: ");
        String expiryDate = ConsoleUtil.readString("Enter expiry date (MM/YY): ");
        String cvv = ConsoleUtil.readString("Enter CVV: ");
        String cardHolderName = ConsoleUtil.readString("Enter card holder name: ");
        cardManageModel.addCard(cardNumber, expiryDate, cvv, cardHolderName);
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }

    public void displaySuccess(String success) {
        ConsoleUtil.displaySuccess(success);
    }
}

