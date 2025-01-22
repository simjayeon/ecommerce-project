package kr.hhplus.be.server.interfaces.controller;

import kr.hhplus.be.server.domain.service.ProductService;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductResponse>> getProducts(@RequestParam String date) {
        return productService.getProducts(date);
    }

    @GetMapping("/top5")
    public ResponseEntity<List<ProductResponse>> getTop5Products() {
        return productService.getTop5Products();
    }
}
