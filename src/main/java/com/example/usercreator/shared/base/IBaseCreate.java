package com.example.usercreator.shared.base;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface IBaseCreate<T> {

    T save(T entity);
}
