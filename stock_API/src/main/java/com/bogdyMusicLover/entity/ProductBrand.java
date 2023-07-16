package com.bogdyMusicLover.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String brandName;

    @OneToMany(mappedBy = "productBrand", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ConstructionGel> constructionGels = new ArrayList<>();
}
