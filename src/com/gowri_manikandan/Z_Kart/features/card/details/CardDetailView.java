package com.gowri_manikandan.Z_Kart.features.card.details;

import java.util.Scanner;

public class CardDetailView {
    private final CardDetailModel cardDetailModel;
    private final Scanner scanner = new Scanner(System.in);
    CardDetailView(){
        cardDetailModel = new CardDetailModel(this);
    }

}
