package com.gowri_manikandan.Z_Kart.features.card;

import java.util.Scanner;

public class CardView {
    private final CardModel cardModel;
    private final Scanner scanner = new Scanner(System.in);
    CardView(){
        cardModel = new CardModel(this);
    }
}
