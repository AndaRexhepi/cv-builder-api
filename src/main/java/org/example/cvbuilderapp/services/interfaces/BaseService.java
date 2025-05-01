package org.example.cvbuilderapp.services.interfaces;

import java.util.List;

public interface BaseService<T, R, A, Long> {
    List<T> findAll();

    T findById(Long id);

    T create(R request);

    void update(Long id, A request);

    void delete(Long id);
}
