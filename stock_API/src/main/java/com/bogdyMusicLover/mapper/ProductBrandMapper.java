package com.bogdyMusicLover.mapper;

import com.bogdyMusicLover.dto.ProductBrandRequest;
import com.bogdyMusicLover.dto.ProductBrandResponse;
import com.bogdyMusicLover.entity.ProductBrand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductBrandMapper implements DtoMapper<ProductBrandRequest,
        ProductBrand, ProductBrandResponse> {


    @Override
    public ProductBrand mapEntityFromRequest(ProductBrandRequest request) {
        return null;
    }

    @Override
    public ProductBrandResponse mapResponseFromEntity(ProductBrand entity) {
        return ProductBrandResponse.builder()
                .id(entity.getId())
                .brandName(entity.getBrandName())
                .build();
    }

    @Override
    public List<ProductBrandResponse> mapListResponsesFromEntity(List<ProductBrand> entities) {
        List<ProductBrandResponse> list = new ArrayList<>();
        for (ProductBrand productBrand : entities) {
            ProductBrandResponse productBrandResponse = mapResponseFromEntity(productBrand);
            list.add(productBrandResponse);
        }
        return list;
    }
}
