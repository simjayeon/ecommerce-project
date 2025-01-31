package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.domain.entity.Product;
import kr.hhplus.be.server.domain.repository.IProductRepository;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productRepository;

    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<Product> products = productRepository.findAllByStockGreaterThan(0);

        return ResponseEntity.ok(products.stream()
                .map(ProductResponse::of)
                .toList());
    }

    public ResponseEntity<List<ProductResponse>> getTop5Products() {
        return null;
    }
}
