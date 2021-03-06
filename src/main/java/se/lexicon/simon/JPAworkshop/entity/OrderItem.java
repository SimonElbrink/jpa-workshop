package se.lexicon.simon.JPAworkshop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    private int quantity;

    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "productOrder_id")
    private ProductOrder productOrder;

    public OrderItem() {
    }

    public OrderItem(int quantity, Product product, ProductOrder productOrder) {
        setQuantity(quantity);
        setProduct(product);
        setProductOrder(productOrder);
    }

    public OrderItem(int orderItemId, int quantity, Product product, ProductOrder productOrder) {
        this(quantity, product, productOrder);
        this.orderItemId = orderItemId;

    }

    /**
     * Calculates Quantity multiplied Product Price.
     * @return result of calculation
     */
    public double calculateOrderItems(){

        double result = 0;

        if (product.getPrice() != 0 || getQuantity() != 0) {
            result = product.getPrice() * getQuantity();
        }

        return result;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderItemId == orderItem.orderItemId &&
                quantity == orderItem.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, quantity);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
