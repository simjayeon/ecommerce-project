package kr.hhplus.be.server.domain.repository;


import kr.hhplus.be.server.domain.entity.OrderItem;
import java.util.List;

public interface IOrderItemRepository {

    List<OrderItem> findAllByOrderId(Long orderId);

}
