package com.gowri_manikandan.Z_Kart.features.signup;

import java.util.Scanner;

public class SignUpView {
    private final SignUpModel model;
    private final Scanner scanner = new Scanner(System.in);

    public SignUpView() {
        model = new SignUpModel(this);
    }
}
