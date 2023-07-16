package com.bogdyMusicLover.controller;

import com.bogdyMusicLover.dto.ProductBrandRequest;
import com.bogdyMusicLover.service.ProductBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-brand")
public class ProductBrandController implements CrudControllerOperations<ProductBrandRequest> {


    private final ProductBrandService productBrandService;

    @Override
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ProductBrandRequest request) {
        try {
            productBrandService.add(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product brand added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }

    @Override
    @GetMapping("/all-brands")
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(productBrandService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getAllAvailable() {
        return null;
    }

    @Override
    public ResponseEntity<?> update(ProductBrandRequest requesst) {
        return null;
    }

    @Override
    public ResponseEntity<?> consumed(Long id, LocalDate date) {
        return null;
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
