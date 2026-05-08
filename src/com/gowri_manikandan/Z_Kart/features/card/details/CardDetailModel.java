package com.gowri_manikandan.Z_Kart.features.card.details;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Card;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;
import java.util.List;

public class CardDetailModel {
    private final CardDetailView cardDetailView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public CardDetailModel(CardDetailView cardDetailView) {
        this.cardDetailView = cardDetailView;
    }

    public List<Card> getMyCards() {
        session.requireLogin();
        return db.getCardsByCustomerId(session.getLoggedInCustomer().getId());
    }
}
