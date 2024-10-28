package com.example.usercreator.application.service.impl;

import com.example.usercreator.application.service.ICatalogService;
import com.example.usercreator.domain.model.catalog.CatalogEntity;
import com.example.usercreator.domain.repository.catalog.ICatalogRepository;
import com.example.usercreator.domain.service.ICatalogServiceDomain;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Service
public class CatalogServiceImpl implements ICatalogService {

    private final ICatalogServiceDomain iCatalogServiceDomain;

    public CatalogServiceImpl(ICatalogServiceDomain iCatalogServiceDomain) {
        this.iCatalogServiceDomain = iCatalogServiceDomain;
    }

    @Override
    public CatalogEntity update(Long id, String value) {
        return iCatalogServiceDomain.update(id, value);
    }

    @Override
    public List<CatalogEntity> findAll() {
        return this.iCatalogServiceDomain.findAll();
    }

}
