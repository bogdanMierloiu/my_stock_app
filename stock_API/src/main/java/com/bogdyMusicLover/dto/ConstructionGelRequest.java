package com.bogdyMusicLover.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionGelRequest {

    private Long id;

    @NotNull
    private String productBrand;

    @NotNull
    private Double quantity;

    @NotNull
    private Double price;

    @NotNull
    private LocalDate purchaseDate;

    private LocalDate consumptionDate;

    private Boolean isAvailable;


}


