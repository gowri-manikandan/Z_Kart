package com.gowri_manikandan.Z_Kart.features.card.details;

import java.util.Scanner;

public class DetailView {
    private final DetailModel model;
    private final Scanner scanner = new Scanner(System.in);
    DetailView(){
        model = new DetailModel(this);
    }
}
