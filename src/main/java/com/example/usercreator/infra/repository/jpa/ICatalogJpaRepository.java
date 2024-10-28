package com.example.usercreator.infra.repository.jpa;

import com.example.usercreator.domain.model.catalog.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface ICatalogJpaRepository  extends JpaRepository<CatalogEntity, Long> {
}
