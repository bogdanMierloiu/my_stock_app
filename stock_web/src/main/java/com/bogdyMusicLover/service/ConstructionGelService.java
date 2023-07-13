package com.bogdyMusicLover.service;

import com.bogdyMusicLover.dto.ConstructionGelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConstructionGelService {

    private final WebClient.Builder webClientBuilder;


    public List<ConstructionGelResponse> getAll() {
        Flux<ConstructionGelResponse> responseFlux = webClientBuilder.build().get()
                .uri("lb://stock-api/api/construction-gel/all-gels")
                .retrieve()
                .bodyToFlux(ConstructionGelResponse.class);
        return responseFlux.collectList().block();
    }
}

