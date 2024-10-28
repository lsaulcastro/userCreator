package com.example.usercreator.domain.service.impl;


import com.example.usercreator.domain.model.user.UserEntity;
import com.example.usercreator.domain.repository.user.IUserRepository;
import com.example.usercreator.domain.service.ICatalogServiceDomain;
import com.example.usercreator.domain.service.IUserServiceDomain;
import com.example.usercreator.infra.component.MessageUtil;
import com.example.usercreator.shared.exception.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Service
public class UserServiceDomainImpl implements IUserServiceDomain {

    private final IUserRepository iUserRepository;

    private final ICatalogServiceDomain iCatalogServiceDomain;

    public UserServiceDomainImpl(IUserRepository iUserRepository, ICatalogServiceDomain iCatalogServiceDomain) {
        this.iUserRepository = iUserRepository;
        this.iCatalogServiceDomain = iCatalogServiceDomain;
    }

    @Override
    public UserEntity save(UserEntity entity) {
        this.validateUser(entity);
        return iUserRepository.save(entity);
    }

    private void validateUser(UserEntity entity) {
        if (Objects.isNull(entity)) {return;}

        if (!isValidEmail(entity.getEmail())) {
            throw new GenericException(MessageUtil.getMessage("error.messages.user.email.invalid"), HttpStatus.BAD_REQUEST);
        }
        if (!isValidPassword(entity.getPassword())) {
            throw new GenericException(MessageUtil.getMessage("error.messages.user.password.invalid"), HttpStatus.BAD_REQUEST);
        }
        if (iUserRepository.existsByEmail(entity.getEmail())) {
            throw new GenericException(MessageUtil.getMessage("error.messages.user.email.exits"), HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isValidEmail(String email) {
        return Objects.nonNull(email) && email.matches(iCatalogServiceDomain.getEmailRegularExpressionByCatalogName());
    }

    private boolean isValidPassword(String password) {
        return Objects.nonNull(password) && password.matches(iCatalogServiceDomain.getPasswordRegularExpressionByCatalogName());
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return this.iUserRepository.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return this.iUserRepository.findAll();
    }

}
