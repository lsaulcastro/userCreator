package com.example.usercreator.domain.model.catalog;

import com.example.usercreator.domain.model.BaseEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/26/2024
 */
@Table
@Entity(name = "CATALOG")
public class CatalogEntity extends BaseEntity implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 67890123456789012L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "catalog_id", nullable = false)
    private Long catalogId;

    @Column(name = "name", nullable = false, length = 60)
    private String configName;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "value", nullable = false, length = 120)
    private String configValue;

    public CatalogEntity(String configName) {
        this.configName = configName;
    }

    public CatalogEntity() {
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

}
