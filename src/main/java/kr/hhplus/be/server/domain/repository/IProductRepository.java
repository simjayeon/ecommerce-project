package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAllByStockGreaterThan(int stock);

}
