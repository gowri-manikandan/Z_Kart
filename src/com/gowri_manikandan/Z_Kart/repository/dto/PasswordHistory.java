package com.gowri_manikandan.Z_Kart.repository.dto;

public class PasswordHistory {
    private long id;
    private long CustomerId;
    private String passWord;
    private long leastChange;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public long getLeastChange() {
        return leastChange;
    }

    public void setLeastChange(long leastChange) {
        this.leastChange = leastChange;
    }
}
