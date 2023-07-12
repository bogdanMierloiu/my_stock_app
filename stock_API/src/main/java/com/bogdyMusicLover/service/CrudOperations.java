package com.bogdyMusicLover.service;

import java.util.List;

public interface CrudOperations<T, R> {

    void add(T request);

    void update(T request);

    List<R> getAll();

    R findById(Long id);

    void deleteById(Long id);

}
