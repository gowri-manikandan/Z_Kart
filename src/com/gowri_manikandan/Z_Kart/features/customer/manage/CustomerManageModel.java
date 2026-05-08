package com.gowri_manikandan.Z_Kart.features.customer.manage;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;

public class CustomerManageModel {
    private final CustomerManageView customerManageView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public CustomerManageModel(CustomerManageView customerManageView) {
        this.customerManageView = customerManageView;
    }

    public void deactivateCustomer(long customerId) {
        session.requireAdminAccess();
        Customer customer = db.getCustomerById(customerId);
        if (customer == null) {
            customerManageView.displayError("Customer not found.");
            return;
        }
        customer.setActive(false);
        db.updateCustomer(customer);
        customerManageView.displaySuccess("Customer deactivated.");
    }

    public void activateCustomer(long customerId) {
        session.requireAdminAccess();
        Customer customer = db.getCustomerById(customerId);
        if (customer == null) {
            customerManageView.displayError("Customer not found.");
            return;
        }
        customer.setActive(true);
        db.updateCustomer(customer);
        customerManageView.displaySuccess("Customer activated.");
    }
}
