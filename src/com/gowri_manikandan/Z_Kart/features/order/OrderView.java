package com.gowri_manikandan.Z_Kart.features.order;

import java.util.Scanner;

public class OrderView {
    private final OrderModel orderModel;
    OrderView(){
        orderModel = new OrderModel(this);
    }
    private final Scanner scanner = new Scanner(System.in);
}
