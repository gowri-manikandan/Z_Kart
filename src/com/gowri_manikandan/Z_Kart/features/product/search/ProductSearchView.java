package com.gowri_manikandan.Z_Kart.features.product.search;

import java.util.Scanner;

public class ProductSearchView {
    private final ProductSearchModel productSearchModel;
    ProductSearchView(){
        productSearchModel = new ProductSearchModel(this);
    }
    private final Scanner scanner = new Scanner(System.in);
}
