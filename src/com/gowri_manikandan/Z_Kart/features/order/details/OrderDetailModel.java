package com.gowri_manikandan.Z_Kart.features.order.details;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Order;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;

public class OrderDetailModel {
    private final OrderDetailView orderDetailView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public OrderDetailModel(OrderDetailView orderDetailView) {
        this.orderDetailView = orderDetailView;
    }

    public Order getOrderDetails(long orderId) {
        session.requireLogin();
        Order order = db.getOrderById(orderId);
        if (order == null || (!session.isAdmin() && order.getCustomerId() != session.getLoggedInCustomer().getId())) {
            orderDetailView.displayError("Order not found or access denied.");
            return null;
        }
        return order;
    }
}
