package kr.hhplus.be.server.infra.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.PersistenceContext;
import kr.hhplus.be.server.domain.entity.OrderItem;
import kr.hhplus.be.server.domain.repository.IOrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.hhplus.be.server.domain.entity.QOrder.order;
import static kr.hhplus.be.server.domain.entity.QOrderItem.orderItem;
import static kr.hhplus.be.server.domain.entity.QProduct.product;

@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryImpl implements IOrderItemRepository {

//    @PersistenceContext
    private final JPAQueryFactory queryFactory;

    @Override
    public List<OrderItem> findAllByOrderId(Long orderId) {
        return queryFactory.select(orderItem)
                .from(orderItem)
                .join(orderItem.order, order).fetchJoin()
                .join(orderItem.product, product).fetchJoin()
                .where(orderItem.orderId.eq(orderId))
                .fetch();
    }
}
