package com.bogdyMusicLover.service;

import java.time.LocalDate;
import java.util.List;

public interface CrudServiceOperations<T, R> {

    void add(T request);

    void update(T request);

    void consumed(Long id, LocalDate consumptionDate);

    List<R> getAll();

    List<R> getAllAvailable();

    R findById(Long id);

    void deleteById(Long id);

}
