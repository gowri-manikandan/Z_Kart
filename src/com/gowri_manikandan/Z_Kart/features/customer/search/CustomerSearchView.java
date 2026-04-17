package com.gowri_manikandan.Z_Kart.features.customer.search;

import java.util.Scanner;

public class CustomerSearchView {
    private final CustomerSearchModel customerSearchModel;
    CustomerSearchView(){
        customerSearchModel = new CustomerSearchModel(this);
    }
    private final Scanner scanner = new Scanner(System.in);
}
