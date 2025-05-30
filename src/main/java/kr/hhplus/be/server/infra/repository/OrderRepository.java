package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
            SELECT o
            FROM Order o
                     JOIN FETCH o.user JOIN FETCH o.orderItems oi JOIN FETCH oi.product
            WHERE o.id = :orderId and o.userId = :userId
            """)
    Optional<Order> findOrderWithUserAndItemsAndProduct(@Param("userId") Long userId,
                                                        @Param("orderId") Long orderId);
}
