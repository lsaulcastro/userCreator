package com.example.usercreator.infra.repository.impl.catalog;

import com.example.usercreator.domain.model.catalog.CatalogEntity;
import com.example.usercreator.domain.repository.catalog.ICatalogRepository;
import com.example.usercreator.infra.repository.jpa.ICatalogJpaRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Repository
public class CatalogRepositoryImpl implements ICatalogRepository {

    /**
     *
     */
    private final ICatalogJpaRepository catalogJpaRepository;

    public CatalogRepositoryImpl(ICatalogJpaRepository catalogJpaRepository) {
        this.catalogJpaRepository = catalogJpaRepository;
    }

    @Override
    public Optional<CatalogEntity> findById(Long id) {
        return catalogJpaRepository.findById(id);
    }

    @Override
    public List<CatalogEntity> findAll() {
        return catalogJpaRepository.findAll();
    }

    @Override
    public String getRegularExpressionByCatalogName(String name) {
        Optional<CatalogEntity> catalogEntity = this.catalogJpaRepository.findOne(Example.of(new CatalogEntity(name)));
        return catalogEntity.map(CatalogEntity::getConfigValue).orElse(null);
    }

    @Override
    public CatalogEntity update(CatalogEntity entity) {
        return this.catalogJpaRepository.save(entity);
    }
}
