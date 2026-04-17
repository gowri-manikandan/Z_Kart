package com.gowri_manikandan.Z_Kart.features.customer.details;

import java.util.Scanner;

public class CustomerDetailView {
    private final CustomerDetailModel customerDetailModel;
    private final Scanner scanner = new Scanner(System.in);
    CustomerDetailView(){
        customerDetailModel = new CustomerDetailModel(this);
    }
}
