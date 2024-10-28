package com.example.usercreator.infra.repository.jpa;

import com.example.usercreator.domain.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface IUserJpaRepository extends JpaRepository<UserEntity, UUID> {

}
