package com.gowri_manikandan.Z_Kart.features.order.search;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Order;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;
import java.util.List;
import java.util.stream.Collectors;

public class OrderSearchModel {
    private final OrderSearchView orderSearchView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public OrderSearchModel(OrderSearchView orderSearchView) {
        this.orderSearchView = orderSearchView;
    }

    public List<Order> getMyOrders() {
        session.requireLogin();
        return db.getOrdersByCustomerId(session.getLoggedInCustomer().getId());
    }

    public List<Order> getAllOrders() {
        session.requireAdminAccess();
        return db.getAllOrders();
    }

    public List<Order> searchOrdersByStatus(String status) {
        session.requireAdminAccess();
        List<Order> orders = db.getAllOrders();
        return orders.stream()
                .filter(o -> o.getStatus().name().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}
