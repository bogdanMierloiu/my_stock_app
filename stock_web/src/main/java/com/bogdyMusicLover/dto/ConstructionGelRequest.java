package com.bogdyMusicLover.dto;

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

    private String productBrand;

    private Integer quantity;

    private Double price;

    private LocalDate purchaseDate;

    private LocalDate consumptionDate;

    private Boolean isAvailable;


}


