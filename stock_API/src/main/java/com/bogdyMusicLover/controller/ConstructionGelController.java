package com.bogdyMusicLover.controller;

import com.bogdyMusicLover.dto.ConstructionGelRequest;
import com.bogdyMusicLover.service.ConstructionGelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/construction-gel")
public class ConstructionGelController implements CrudControllerOperations<ConstructionGelRequest> {

    private final ConstructionGelService gelService;
    @Override
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ConstructionGelRequest request) {
        try {
            gelService.add(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Construction gel added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }

    @Override
    @GetMapping("/all-gels")
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(gelService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }

    @Override
    @GetMapping("/all-available-gels")
    public ResponseEntity<?> getAllAvailable() {
        try {
            return new ResponseEntity<>(gelService.getAllAvailable(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ConstructionGelRequest gelRequest) {
        try {
            gelService.update(gelRequest);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Construction gel updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }
    @Override
    @PutMapping("/consumed/{id}/{date}")
    public ResponseEntity<?> consumed(@PathVariable("id") Long id,
                                      @PathVariable("date") LocalDate date) {
        try {
            gelService.consumed(id, date);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Construction gel updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(gelService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        try {
            gelService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Construction gel updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem: " + e.getMessage());
        }
    }

}
