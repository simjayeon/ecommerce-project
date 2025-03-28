package kr.hhplus.be.server.infra.service;

import kr.hhplus.be.server.infra.repository.ProductRepository;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> findAllByStockGreaterThan(int stock) {
        return productRepository.findAllByStockGreaterThan(stock)  // 반환 타입이 List<Product>인지 확인
                .stream()
                .map(ProductResponse::of)  // Product -> ProductResponse 변환
                .collect(Collectors.toList());
    }

}
