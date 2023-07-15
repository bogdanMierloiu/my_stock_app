package com.bogdyMusicLover.service;

import com.bogdyMusicLover.dto.ConstructionGelRequest;
import com.bogdyMusicLover.dto.ConstructionGelResponse;
import com.bogdyMusicLover.entity.ConstructionGel;
import com.bogdyMusicLover.exception.NotFoundException;
import com.bogdyMusicLover.mapper.ConstructionGelMapper;
import com.bogdyMusicLover.repository.ConstructionGelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConstructionGelService implements CrudServiceOperations<ConstructionGelRequest, ConstructionGelResponse> {

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
    public void update(ConstructionGelRequest request) throws NotFoundException {
        ConstructionGel constructionGel = getGelById(request.getId());

        constructionGel.setProductBrand(request.getProductBrand() != null ?
                request.getProductBrand() : constructionGel.getProductBrand());
        constructionGel.setQuantity(request.getQuantity() != null ?
                request.getQuantity() : constructionGel.getQuantity());
        constructionGel.setPrice(request.getPrice() != null ?
                request.getPrice() : constructionGel.getPrice());
        constructionGel.setPurchaseDate(request.getPurchaseDate() != null ?
                request.getPurchaseDate() : constructionGel.getPurchaseDate());
        constructionGelRepo.save(constructionGel);
    }

    @Override
    public List<ConstructionGelResponse> getAll() {
        return constructionGelMapper.mapListResponsesFromEntity(constructionGelRepo.findAll());
    }

    @Override
    public List<ConstructionGelResponse> getAllAvailable() {
        return constructionGelMapper.mapListResponsesFromEntity(constructionGelRepo.getConstructionGelsAvailable());
    }

    @Transactional
    @Override
    public void consumed(Long gelId, LocalDate consumptionDate) throws NotFoundException {
        ConstructionGel constructionGel = getGelById(gelId);
        constructionGel.setConsumptionDate(consumptionDate);
        constructionGel.setIsAvailable(false);
        constructionGelRepo.save(constructionGel);
    }

    @Override
    public ConstructionGelResponse findById(Long id) throws NotFoundException {
        return constructionGelMapper.mapResponseFromEntity(getGelById(id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) throws NotFoundException {
        ConstructionGel constructionGel = getGelById(id);
        constructionGelRepo.delete(constructionGel);
    }

    private ConstructionGel getGelById(Long id) throws NotFoundException {
        return constructionGelRepo.findById(id).orElseThrow(
                () -> new NotFoundException("Construction gel not found!"));
    }


}
