package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByStockGreaterThan(int stock);

}
