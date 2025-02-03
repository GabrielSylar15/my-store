package com.vinhnt.api.core.application.port.oubound;

import java.util.List;

public interface BaseRepository<T, Id> {
    List<T> findAll();

    T save(T data);

    T findById(Id id);

    void delete(T data);

    List<T> saveAll(Iterable<T> data);
}
