package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public ResponseEntity<List<ProductResponse>> getProducts(String date) {
        return ResponseEntity.ok(List.of(
                ProductResponse.builder()
                        .id(1L)
                        .name("상품1")
                        .price(1000)
                        .stock(10)
                        .build(),
                ProductResponse.builder()
                        .id(2L)
                        .name("상품2")
                        .price(2000)
                        .stock(20)
                        .build()
        ));
    }

    public ResponseEntity<List<ProductResponse>> getTop5Products() {
        return ResponseEntity.ok(List.of(
                ProductResponse.builder()
                        .id(1L)
                        .name("상품1")
                        .price(1000)
                        .stock(10)
                        .build(),
                ProductResponse.builder()
                        .id(2L)
                        .name("상품2")
                        .price(2000)
                        .stock(20)
                        .build()
        ));
    }
}
