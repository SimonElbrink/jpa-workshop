package se.lexicon.simon.JPAworkshop.data;

import se.lexicon.simon.JPAworkshop.entity.Product;

import java.util.Collection;

public interface ProductDAO {

    Product create(Product product);
    Product findById(int productId);
    Collection<Product>findAll();
    Collection<Product>findByName(String productName);
    Product update(Product product);
    boolean delete(Product product);

}
