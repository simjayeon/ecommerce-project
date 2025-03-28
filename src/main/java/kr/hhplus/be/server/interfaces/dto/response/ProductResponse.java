package kr.hhplus.be.server.interfaces.dto.response;

import kr.hhplus.be.server.domain.entity.Product;

public record ProductResponse(
        Long id,
        String name,
        Integer price,
        Integer stock
) {
    public static ProductResponse of(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock()
        );
    }
}
