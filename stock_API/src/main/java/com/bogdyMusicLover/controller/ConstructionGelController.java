package com.bogdyMusicLover.controller;

import com.bogdyMusicLover.dto.ConstructionGelRequest;
import com.bogdyMusicLover.service.ConstructionGelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/construction-gel")
public class ConstructionGelController {

    private final ConstructionGelService gelService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ConstructionGelRequest gelRequest) {
        try {
            gelService.add(gelRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Construction gel added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }

    @GetMapping("/all-gels")
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(gelService.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("There was a problem: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
