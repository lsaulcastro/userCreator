package com.example.usercreator.infra.repository.impl.user;

import com.example.usercreator.domain.model.user.UserEntity;
import com.example.usercreator.domain.repository.user.IUserRepository;
import com.example.usercreator.infra.repository.jpa.IUserJpaRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Repository
public class UserRepositoryImpl implements IUserRepository {

    /**
     *
     */
    public final IUserJpaRepository userJpaRepository;

    public UserRepositoryImpl(IUserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserEntity save(UserEntity entity) {
        entity.getPhones().forEach(e -> e.setPhoneUserId(entity));
        entity.setToken(UUID.randomUUID());
        entity.setLastLogin(LocalDateTime.now());
        return userJpaRepository.save(entity);
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<UserEntity> findAll() {
        return List.of();
    }

    @Override
    public Boolean existsByEmail(String email) {
        return this.userJpaRepository.exists(Example.of(new UserEntity(email)));
    }
}
