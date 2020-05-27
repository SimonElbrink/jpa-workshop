package se.lexicon.simon.JPAworkshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductOrderTest {

    ProductOrder testObject;
    Integer id;
    LocalDateTime timeStamp;
    List<OrderItem> orderItems;
    AppUser customer;


    @BeforeEach
    void setUp() {
        id = 10;
        timeStamp = LocalDateTime.parse("2000-01-01T00:00:00");
        Product product = new Product(2,"Pen", 2.0);
        orderItems = Arrays.asList(new OrderItem(30, 30, product, null),
                new OrderItem(40, 40, product, null));
        customer = new AppUser();

        testObject = new ProductOrder(id, timeStamp, orderItems, customer);

    }

    @Test
    void successfullyCreated(){
        assertEquals(id, testObject.getProductOrderId());
        assertEquals(timeStamp, testObject.getOrderDateTime());
        assertEquals(orderItems, testObject.getOrderItems());
        assertEquals(customer, testObject.getCustomer());
    }



    @Test
    void testEquals() {
        ProductOrder copy = new ProductOrder(id, timeStamp, orderItems, customer);

        assertTrue(testObject.equals(copy));

    }

    @Test
    void testHashCode() {
        ProductOrder copy = new ProductOrder(id, timeStamp, orderItems, customer);
        assertEquals(copy.hashCode(), testObject.hashCode());
    }

    @Test
    void testToString() {
        String toString = testObject.toString();

        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains(timeStamp.toString()));
        assertTrue(toString.contains(orderItems.toString()));
        assertTrue(toString.contains(customer.toString()));

    }
}