package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.Product;
import kr.hhplus.be.server.domain.repository.IProductRepository;
import kr.hhplus.be.server.infra.jpa.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements IProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> findAllByStockGreaterThan(int stock) {
        return productJpaRepository.findAllByStockGreaterThan(stock);
    }

}
