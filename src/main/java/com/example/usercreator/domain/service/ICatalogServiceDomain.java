package com.example.usercreator.domain.service;

import com.example.usercreator.domain.model.catalog.CatalogEntity;
import com.example.usercreator.shared.base.IBaseFind;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface ICatalogServiceDomain extends IBaseFind<CatalogEntity, Long> {

    String getEmailRegularExpressionByCatalogName();

    String getPasswordRegularExpressionByCatalogName();

    CatalogEntity update(Long id, String value);


}
