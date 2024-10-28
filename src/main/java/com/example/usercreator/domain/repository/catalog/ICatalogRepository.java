package com.example.usercreator.domain.repository.catalog;

import com.example.usercreator.domain.model.catalog.CatalogEntity;
import com.example.usercreator.shared.base.IBaseFind;
import com.example.usercreator.shared.base.IBaseUpdate;


/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface ICatalogRepository extends  IBaseFind<CatalogEntity, Long>, IBaseUpdate<CatalogEntity, Long> {

    String getRegularExpressionByCatalogName(String name);
}
