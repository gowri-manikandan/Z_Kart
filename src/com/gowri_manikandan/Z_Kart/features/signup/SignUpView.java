package com.gowri_manikandan.Z_Kart.features.signup;

import java.util.Scanner;

public class SignUpView {
    private final SignUpModel model;


    public SignUpView() {
        model = new SignUpModel(this);
    }

    public  void init(){
        Scanner scanner = new Scanner(System.in);
    }
}
