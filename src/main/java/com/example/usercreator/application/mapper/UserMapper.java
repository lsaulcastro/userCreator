package com.example.usercreator.application.mapper;

import com.example.usercreator.application.service.dto.user.UserDto;
import com.example.usercreator.application.service.dto.user.UserResponseDto;
import com.example.usercreator.domain.model.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Mapper(uses = {PhoneMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userId", target = "id")
    UserResponseDto userEntityToUserResponseDto(UserEntity user);

    @Mapping(source = "name", target = "fullName")
    UserEntity userDtoToUserEntity(UserDto userDto);


}
