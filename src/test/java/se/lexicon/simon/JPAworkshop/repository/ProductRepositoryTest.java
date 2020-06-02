package se.lexicon.simon.JPAworkshop.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.simon.JPAworkshop.entity.Product;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    Product testObject;

    @BeforeEach
    void setUp() {
        testObject = new Product("Boots", 1999.0);
        testObject = productRepository.save(testObject);
    }

    @Test
    void findByNameIgnoreCase() {
        //Arrange
        Product p = productRepository.save(new Product("Boots", 19.0));
        List<Product> expected = Arrays.asList(testObject, p);
        final String B_O_OT_S = "bOOtS";

        //Act
        List<Product> actual = productRepository.findByNameIgnoreCase(B_O_OT_S);

        //Assert
        assertEquals(expected, actual);
    }
}