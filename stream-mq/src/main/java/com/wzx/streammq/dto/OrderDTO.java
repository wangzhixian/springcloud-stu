package com.wzx.streammq.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDTO implements Serializable {
    private String orderId;
    private BigDecimal OrderAmount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        OrderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", OrderAmount=" + OrderAmount +
                '}';
    }
}
