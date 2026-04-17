package com.gowri_manikandan.Z_Kart.features.product.details;

import java.util.Scanner;

public class ProductDetailView {
    private final ProductDetailModel productDetailModel;
    ProductDetailView(){
        productDetailModel = new ProductDetailModel(this);
    }
    private final Scanner scanner = new Scanner(System.in);
}
