package com.gowri_manikandan.Z_Kart.features.customer;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerModel {
    private final CustomerView customerView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public CustomerModel(CustomerView customerView) {
        this.customerView = customerView;
    }

    public List<Customer> getAllCustomers() {
        session.requireAdminAccess();
        return db.getAllCustomers();
    }

    public List<Customer> searchCustomers(String query) {
        session.requireAdminAccess();
        List<Customer> customers = db.getAllCustomers();
        return customers.stream()
                .filter(c -> c.getName().toLowerCase().contains(query.toLowerCase()) ||
                             c.getEmail().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
