package com.ethan.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import com.ethan.backend.dtos.AppUserDto;
import com.ethan.backend.entities.AppUser;


@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);

    @Mapping(target = "password", ignore = true)
    AppUser toAppUser(AppUserDto appUserDto);

    AppUserDto toAppUserDto(AppUser appUser);

    List<AppUserDto> toAppUserDtos(List<AppUser> appUsers);

}