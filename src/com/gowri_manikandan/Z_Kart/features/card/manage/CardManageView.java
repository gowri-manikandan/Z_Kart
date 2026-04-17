package com.gowri_manikandan.Z_Kart.features.card.manage;

import java.util.Scanner;

public class CardManageView {
    private final CardManageModel cardManageModel;
    CardManageView(){
        cardManageModel = new CardManageModel(this);
    }
    private final Scanner scanner = new Scanner(System.in);

}
