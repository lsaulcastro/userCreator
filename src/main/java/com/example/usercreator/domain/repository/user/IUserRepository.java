package com.example.usercreator.domain.repository.user;

import com.example.usercreator.domain.model.user.UserEntity;
import com.example.usercreator.shared.base.IBaseCreate;
import com.example.usercreator.shared.base.IBaseFind;

import java.util.UUID;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface IUserRepository extends IBaseCreate<UserEntity>, IBaseFind<UserEntity, UUID> {

    Boolean existsByEmail(String email);
}
