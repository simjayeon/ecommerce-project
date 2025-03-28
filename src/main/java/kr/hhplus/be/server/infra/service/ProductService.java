package kr.hhplus.be.server.infra.service;

import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findAllByStockGreaterThan(int stock);
}
