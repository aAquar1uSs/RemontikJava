package com.project.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Order implements Serializable {
    private Long id;
    private String orderName;
    private double orderPrice;
    private Date orderDate;
    private String orderStatus;
    private String paymantStatus;
    private int userid;

    public Order(Long id, String orderName, double orderPrice,
                 Date orderDate, String orderStatus, String paymantStatus) {
        this.id = id;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.paymantStatus = paymantStatus;
    }

    public Order() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
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

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
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
