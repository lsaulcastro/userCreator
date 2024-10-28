package com.example.usercreator.application.service;

import com.example.usercreator.application.service.dto.user.UserDto;
import com.example.usercreator.application.service.dto.user.UserResponseDto;
import com.example.usercreator.domain.model.user.UserEntity;
import com.example.usercreator.shared.base.IBaseFind;

import java.util.UUID;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface IUserService extends IBaseFind<UserEntity, UUID> {

    UserResponseDto save(UserDto entity);
}
