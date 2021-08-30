package com.project.entity;

import java.util.Objects;

public class Order {
    private int id;
    private String orderName;
    private double orderPrice;
    private String orderDate;
    private String orderStatus;
    private String paymantStatus;

    public Order(int id, String orderName, double orderPrice,
                 String orderDate, String orderStatus, String paymantStatus) {
        this.id = id;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.paymantStatus = paymantStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setPaymantStatus(String paymantStatus) {
        this.paymantStatus = paymantStatus;
    }

    public String getPaymantStatus() {
        return paymantStatus;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("id=").append(id);
        sb.append(", order name='").append(orderName).append('\'');
        sb.append(", order price='").append(orderPrice).append('\'');
        sb.append(", order date='").append(orderDate).append('\'');
        sb.append(", order status='").append(orderStatus).append('\'');
        sb.append(", paymant status='").append(paymantStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        Order order = (Order) o;
        return id == order.id &&
                orderName.equals(order.orderName) &&
                orderPrice == order.orderPrice &&
                orderDate.equals(order.orderDate) &&
                orderStatus.equals(order.orderStatus) &&
                paymantStatus.equals(order.paymantStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderName, orderPrice, orderDate, orderStatus, paymantStatus);
    }
}
