package com.example.usercreator.domain.service.impl;

import com.example.usercreator.domain.model.catalog.CatalogEntity;
import com.example.usercreator.domain.repository.catalog.ICatalogRepository;
import com.example.usercreator.domain.service.ICatalogServiceDomain;
import com.example.usercreator.infra.component.MessageUtil;
import com.example.usercreator.shared.exception.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Service
public class CatalogServiceDomainImpl implements ICatalogServiceDomain {

    private final ICatalogRepository catalogRepository;

    public CatalogServiceDomainImpl(ICatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Optional<CatalogEntity> findById(Long id) {
        return catalogRepository.findById(id);
    }

    @Override
    public List<CatalogEntity> findAll() {
        return catalogRepository.findAll();
    }


    @Override
    public String getEmailRegularExpressionByCatalogName() {
        String emailRegularExpression = catalogRepository.getRegularExpressionByCatalogName("email.regular.expression");
        return Optional.ofNullable(emailRegularExpression).orElse("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

    @Override
    public String getPasswordRegularExpressionByCatalogName() {
        String passwordRegularExp = catalogRepository.getRegularExpressionByCatalogName("password.regular.expression");
        return Optional.ofNullable(passwordRegularExp).orElse("^(?=.*\\d).{3,}$");
    }

    @Override
    public CatalogEntity update(Long id, String valueConfig) {
        Optional<CatalogEntity> catalogEntity = this.findById(id);
        CatalogEntity catalogTemp = null;

        if (catalogEntity.isPresent()) {
            catalogTemp = catalogEntity.get();
            catalogTemp.setConfigValue(valueConfig);
            return this.catalogRepository.update(catalogTemp);
        }

        throw new GenericException(MessageUtil.getMessage("error.notFound.catalog"), HttpStatus.BAD_REQUEST);
    }


}
