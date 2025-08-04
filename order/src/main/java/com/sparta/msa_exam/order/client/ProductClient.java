package com.sparta.msa_exam.order.client;

import com.sparta.msa_exam.order.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {
    @GetMapping("/products")
    List<ProductResponse> getProductByIds(@RequestParam("ids") List<Long> ids);

    @GetMapping("/products/error-path")
    boolean fallbackTest();
}
