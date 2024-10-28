package com.example.usercreator.domain.service;

import com.example.usercreator.domain.model.catalog.CatalogEntity;
import com.example.usercreator.domain.model.user.UserEntity;
import com.example.usercreator.shared.base.IBaseCreate;
import com.example.usercreator.shared.base.IBaseFind;

import java.util.UUID;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public interface IUserServiceDomain extends IBaseCreate<UserEntity> , IBaseFind<UserEntity, UUID> {

}
