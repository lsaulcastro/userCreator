package com.example.usercreator.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/26/2024
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified", nullable = false)
    private LocalDateTime modified;

    @Column(name = "active", nullable = false)
    private Boolean active = Boolean.TRUE;

    @PrePersist
    public void prePersist() {
        setCreated(LocalDateTime.now());
        setModified(LocalDateTime.now());
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }
}
