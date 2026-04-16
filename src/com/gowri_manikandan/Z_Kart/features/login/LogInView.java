package com.gowri_manikandan.Z_Kart.features.login;

import java.util.Scanner;

public class LogInView {
    private final LogInModel model;
    private final Scanner scanner = new Scanner(System.in);

    public LogInView() {
        model = new LogInModel(this);
    }
}
