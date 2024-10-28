package com.example.usercreator.application.service.impl;

import com.example.usercreator.application.mapper.UserMapper;
import com.example.usercreator.application.service.IUserService;
import com.example.usercreator.application.service.dto.user.UserDto;
import com.example.usercreator.application.service.dto.user.UserResponseDto;
import com.example.usercreator.domain.model.user.UserEntity;
import com.example.usercreator.domain.service.IUserServiceDomain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Service
public class UserServiceImpl implements IUserService {

    private final IUserServiceDomain iUserServiceDomain;

    public UserServiceImpl(IUserServiceDomain iUserServiceDomain) {
        this.iUserServiceDomain = iUserServiceDomain;
    }

    @Override
    public UserResponseDto save(UserDto entity) {
        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(entity);
        return UserMapper.INSTANCE.userEntityToUserResponseDto(iUserServiceDomain.save(userEntity));
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return this.iUserServiceDomain.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return this.iUserServiceDomain.findAll();
    }
}
