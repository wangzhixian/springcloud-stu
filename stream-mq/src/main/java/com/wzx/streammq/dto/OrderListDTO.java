package com.wzx.streammq.dto;

import java.io.Serializable;
import java.util.List;

public class OrderListDTO implements Serializable {
    private String id;
    private String desc;
    private List<OrderDTO> orderDTOList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<OrderDTO> getOrderDTOList() {
        return orderDTOList;
    }

    public void setOrderDTOList(List<OrderDTO> orderDTOList) {
        this.orderDTOList = orderDTOList;
    }

    @Override
    public String toString() {
        return "OrderListDTO{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", orderDTOList=" + orderDTOList +
                '}';
    }
}
