package se.lexicon.simon.JPAworkshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.simon.JPAworkshop.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

    List<OrderItem> findAllByProductOrderProductOrderId(int id);

}
