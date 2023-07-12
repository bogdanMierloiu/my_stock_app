package com.bogdyMusicLover.service;

import com.bogdyMusicLover.dto.ConstructionGelRequest;
import com.bogdyMusicLover.dto.ConstructionGelResponse;
import com.bogdyMusicLover.entity.ConstructionGel;
import com.bogdyMusicLover.mapper.ConstructionGelMapper;
import com.bogdyMusicLover.repository.ConstructionGelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConstructionGelService implements CrudOperations<ConstructionGelRequest, ConstructionGelResponse> {

    private final ConstructionGelRepo constructionGelRepo;

    private final ConstructionGelMapper constructionGelMapper;


    @Override
    @Transactional
    public void add(ConstructionGelRequest gelRequest) {
        ConstructionGel constructionGel = new ConstructionGel();
        constructionGel.setProductBrand(gelRequest.getProductBrand());
        constructionGel.setQuantity(gelRequest.getQuantity());
        constructionGel.setPrice(gelRequest.getPrice());
        constructionGel.setPurchaseDate(gelRequest.getPurchaseDate());
        constructionGel.setIsAvailable(true);

        constructionGelRepo.save(constructionGel);

    }

    @Override
    @Transactional
    public void update(ConstructionGelRequest request) {

    }

    @Override
    public List<ConstructionGelResponse> getAll() {
        return constructionGelMapper.mapListResponsesFromEntity(constructionGelRepo.findAll());
    }

    @Override
    public ConstructionGelResponse findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

    }


}
