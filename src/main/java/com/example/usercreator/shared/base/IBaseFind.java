package com.example.usercreator.shared.base;

import java.util.List;
import java.util.Optional;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface IBaseFind<T, I> {

    Optional<T> findById(I id);

    List<T> findAll();
}
