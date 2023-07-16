package com.bogdyMusicLover.mapper;

import com.bogdyMusicLover.dto.ConstructionGelRequest;
import com.bogdyMusicLover.dto.ConstructionGelResponse;
import com.bogdyMusicLover.entity.ConstructionGel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConstructionGelMapper implements DtoMapper<ConstructionGelRequest,
        ConstructionGel, ConstructionGelResponse> {


    @Override
    public ConstructionGel mapEntityFromRequest(ConstructionGelRequest request) {
        return null;
    }

    @Override
    public ConstructionGelResponse mapResponseFromEntity(ConstructionGel entity) {
        return ConstructionGelResponse.builder()
                .id(entity.getId())
                .productBrand(entity.getProductBrand().getBrandName())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .purchaseDate(entity.getPurchaseDate())
                .isAvailable(entity.getIsAvailable())
                .consumptionDate(entity.getConsumptionDate())
                .build();
    }

    @Override
    public List<ConstructionGelResponse> mapListResponsesFromEntity(List<ConstructionGel> entities) {
        List<ConstructionGelResponse> responseList = new ArrayList<>();
        for (ConstructionGel constructionGel : entities) {
            ConstructionGelResponse constructionGelResponse = mapResponseFromEntity(constructionGel);
            responseList.add(constructionGelResponse);
        }
        return responseList;
    }
}
