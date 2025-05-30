package kr.hhplus.be.server.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.infra.service.ProductService;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @Operation(summary = "getProducts", description = "상품 목록 조회")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<ProductResponse> products = productService.findAllByStockGreaterThan(0);
        return ResponseEntity.ok(products);
    }

//    @GetMapping("/top5")
//    @Operation(summary = "getTop5Products", description = "인기 상품 목록 조회")
//    public ResponseEntity<List<ProductResponse>> getTop5Products() {
//        return productService.getTop5Products();
//    }
}
