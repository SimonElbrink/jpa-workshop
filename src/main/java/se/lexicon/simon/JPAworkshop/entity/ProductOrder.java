package se.lexicon.simon.JPAworkshop.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ProductOrder {

    private int ProductOrderId;
    private LocalDateTime orderDateTime;
    private List<OrderItem> orderItems;
    private AppUser customer;

    public ProductOrder() {
    }

    public ProductOrder(LocalDateTime orderDateTime, List<OrderItem> orderItems, AppUser customer) {
        setOrderDateTime(orderDateTime);
        setOrderItems(orderItems);
        setCustomer(customer);
    }

    public ProductOrder(int productOrderId, LocalDateTime orderDateTime, List<OrderItem> orderItems, AppUser customer) {
        this(orderDateTime, orderItems, customer);
        ProductOrderId = productOrderId;

    }

    public int getProductOrderId() {
        return ProductOrderId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return ProductOrderId == that.ProductOrderId &&
                Objects.equals(orderDateTime, that.orderDateTime) &&
                Objects.equals(orderItems, that.orderItems) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductOrderId, orderDateTime, orderItems, customer);
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "ProductOrderId=" + ProductOrderId +
                ", orderDateTime=" + orderDateTime +
                ", orderItems=" + orderItems +
                ", customer=" + customer +
                '}';
    }
}
