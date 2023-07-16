package com.bogdyMusicLover.service;

import com.bogdyMusicLover.dto.ProductBrandRequest;
import com.bogdyMusicLover.dto.ProductBrandResponse;
import com.bogdyMusicLover.entity.ProductBrand;
import com.bogdyMusicLover.mapper.ProductBrandMapper;
import com.bogdyMusicLover.repository.ProductBrandRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductBrandService implements CrudServiceOperations<ProductBrandRequest, ProductBrandResponse> {

    private final ProductBrandRepo productBrandRepo;

    private final ProductBrandMapper productBrandMapper;

    @Override
    public void add(ProductBrandRequest request) {
        ProductBrand productBrandToSave = ProductBrand.builder()
                .brandName(request.getBrandName())
                .build();

        productBrandRepo.save(productBrandToSave);
    }

    @Override
    public void update(ProductBrandRequest request) {

    }

    @Override
    public void consumed(Long id, LocalDate consumptionDate) {

    }

    @Override
    public List<ProductBrandResponse> getAll() {
        return productBrandMapper.mapListResponsesFromEntity(productBrandRepo.findAll());
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
