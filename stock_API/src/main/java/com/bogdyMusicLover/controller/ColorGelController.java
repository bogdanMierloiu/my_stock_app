package com.bogdyMusicLover.controller;

import com.bogdyMusicLover.dto.ColorGelRequest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public class ColorGelController implements CrudControllerOperations<ColorGelRequest>{
    @Override
    public ResponseEntity<?> add(ColorGelRequest requesst) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllAvailable() {
        return null;
    }

    @Override
    public ResponseEntity<?> update(ColorGelRequest requesst) {
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
