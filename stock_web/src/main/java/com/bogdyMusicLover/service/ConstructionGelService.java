package com.bogdyMusicLover.service;

import com.bogdyMusicLover.dto.ConstructionGelRequest;
import com.bogdyMusicLover.dto.ConstructionGelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConstructionGelService implements CrudServiceOperations<ConstructionGelRequest, ConstructionGelResponse> {

    private final WebClient.Builder webClientBuilder;


    @Override
    public void add(ConstructionGelRequest request) {
        webClientBuilder.build().post()
                .uri("lb://stock-api/api/construction-gel/add")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Override
    public void update(ConstructionGelRequest request) {

    }

    @Override
    public void consumed(Long id, LocalDate consumptionDate) {

    }

    @Override
    public List<ConstructionGelResponse> getAll() {
        Flux<ConstructionGelResponse> responseFlux = webClientBuilder.build().get()
                .uri("lb://stock-api/api/construction-gel/all-gels")
                .retrieve()
                .bodyToFlux(ConstructionGelResponse.class);
        return responseFlux.collectList().block();
    }

    @Override
    public List<ConstructionGelResponse> getAllAvailable() {
        Flux<ConstructionGelResponse> responseFlux = webClientBuilder.build().get()
                .uri("lb://stock-api/api/construction-gel/all-available-gels")
                .retrieve()
                .bodyToFlux(ConstructionGelResponse.class);
        return responseFlux.collectList().block();
    }

    @Override
    public ConstructionGelResponse findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }






}

