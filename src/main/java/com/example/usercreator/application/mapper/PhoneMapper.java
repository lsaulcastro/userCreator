package com.example.usercreator.application.mapper;

import com.example.usercreator.application.service.dto.user.PhoneDto;
import com.example.usercreator.domain.model.phone.PhoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    @Mapping(source = "number", target = "phoneNumber")
    PhoneEntity phoneDtoToPhoneEntity(PhoneDto phoneDto);
}
