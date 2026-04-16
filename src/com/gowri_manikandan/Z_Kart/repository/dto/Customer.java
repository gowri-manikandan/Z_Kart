package com.gowri_manikandan.Z_Kart.repository.dto;

public class Customer {
    private long id;
    private String name;
    private String email;
    private long pNumber;
    private String address;
    private enum role {admin,user}
    private boolean isActive ;
    private boolean ForcePasswordChange;
    private long createdAt;
}
