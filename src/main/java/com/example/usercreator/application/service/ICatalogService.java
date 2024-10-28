package com.example.usercreator.application.service;

import com.example.usercreator.domain.model.catalog.CatalogEntity;

import java.util.List;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface ICatalogService {

    CatalogEntity update(Long id, String value);

    List<CatalogEntity> findAll();
}
