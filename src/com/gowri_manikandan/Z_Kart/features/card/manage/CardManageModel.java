package com.gowri_manikandan.Z_Kart.features.card.manage;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Card;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;

public class CardManageModel {
    private final CardManageView cardManageView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public CardManageModel(CardManageView cardManageView) {
        this.cardManageView = cardManageView;
    }

    public void addCard(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        session.requireLogin();
        Card card = new Card(0, session.getLoggedInCustomer().getId(), cardNumber, expiryDate, cvv, cardHolderName, System.currentTimeMillis(), System.currentTimeMillis());
        db.addCard(card);
        cardManageView.displaySuccess("Card added successfully.");
    }
}
