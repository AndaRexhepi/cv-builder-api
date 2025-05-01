package org.example.cvbuilderapp.mappers;

import java.util.List;

public interface BaseMapper<T, A, R>{
    A toDto(T t);
    T toEntity(R request);
    List<A> toDto(List<T> entities);
}
