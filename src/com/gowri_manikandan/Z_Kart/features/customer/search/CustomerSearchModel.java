package com.gowri_manikandan.Z_Kart.features.customer.search;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerSearchModel {
    private final CustomerSearchView customerSearchView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public CustomerSearchModel(CustomerSearchView customerSearchView) {
        this.customerSearchView = customerSearchView;
    }

    public List<Customer> searchCustomers(String query) {
        session.requireAdminAccess();
        List<Customer> customers = db.getAllCustomers();
        return customers.stream()
                .filter(c -> c.getName().toLowerCase().contains(query.toLowerCase()) ||
                             c.getEmail().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Customer> getAllCustomers() {
        session.requireAdminAccess();
        return db.getAllCustomers();
    }
}
