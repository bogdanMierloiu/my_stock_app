package com.bogdyMusicLover.controller;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface CrudControllerOperations<T> {

    ResponseEntity<?> add(T requesst);

    ResponseEntity<?> getAll();

    ResponseEntity<?> getAllAvailable();

    ResponseEntity<?> update(T requesst);

    ResponseEntity<?> consumed(Long id, LocalDate date);

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> deleteById(Long id);
}
