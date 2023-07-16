package com.bogdyMusicLover.service;

import com.bogdyMusicLover.dto.ProductBrandRequest;
import com.bogdyMusicLover.dto.ProductBrandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductBrandService implements CrudServiceOperations<ProductBrandRequest, ProductBrandResponse> {

    private final WebClient.Builder webClientBuilder;
    @Override
    public void add(ProductBrandRequest request) {

    }

    @Override
    public void update(ProductBrandRequest request) {

    }

    @Override
    public void consumed(Long id, LocalDate consumptionDate) {

    }

    @Override
    public List<ProductBrandResponse> getAll() {
        Flux<ProductBrandResponse> responseFlux = webClientBuilder.build().get()
                .uri("lb://stock-api/api/product-brand/all-brands")
                .retrieve()
                .bodyToFlux(ProductBrandResponse.class);
        return responseFlux.collectList().block();
    }

    @Override
    public List<ProductBrandResponse> getAllAvailable() {
        return null;
    }

    @Override
    public ProductBrandResponse findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
