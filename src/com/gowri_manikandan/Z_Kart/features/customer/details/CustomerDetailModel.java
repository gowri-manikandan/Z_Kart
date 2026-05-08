package com.gowri_manikandan.Z_Kart.features.customer.details;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;

public class CustomerDetailModel {
    private final CustomerDetailView customerDetailView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public CustomerDetailModel(CustomerDetailView customerDetailView) {
        this.customerDetailView = customerDetailView;
    }

    public Customer getCustomerDetails(long customerId) {
        session.requireAdminAccess();
        Customer customer = db.getCustomerById(customerId);
        if (customer == null) {
            customerDetailView.displayError("Customer not found.");
            return null;
        }
        return customer;
    }
}
