package com.gowri_manikandan.Z_Kart.features.customer;

import java.util.Scanner;

public class CustomerView {
    private final CustomerModel customerModel;
    CustomerView(){
        customerModel = new CustomerModel(this);
    }
    private final Scanner scanner = new Scanner(System.in);
}
