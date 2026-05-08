package com.gowri_manikandan.Z_Kart.features.order.manage;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Order;
import com.gowri_manikandan.Z_Kart.repository.dto.OrderStatus;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;

public class OrderManageModel {
    private final OrderManageView orderManageView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public OrderManageModel(OrderManageView orderManageView) {
        this.orderManageView = orderManageView;
    }

    public void updateOrderStatus(long orderId, OrderStatus status) {
        session.requireAdminAccess();
        Order order = db.getOrderById(orderId);
        if (order == null) {
            orderManageView.displayError("Order not found.");
            return;
        }
        order.setStatus(status);
        orderManageView.displaySuccess("Order status updated.");
    }
}
