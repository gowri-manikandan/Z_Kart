package com.gowri_manikandan.Z_Kart.features.order.search;

import java.util.Scanner;

public class OrderSearchView {
    private final OrderSearchModel orderSearchModel;
    OrderSearchView(){
        orderSearchModel = new OrderSearchModel(this);
    }
    private final Scanner scanner = new Scanner(System.in);
}
