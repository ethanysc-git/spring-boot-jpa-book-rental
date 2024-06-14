package com.ethan.backend.mappers;

import org.mapstruct.Mapper;

import java.util.List;
import com.ethan.backend.dtos.AppUserDto;
import com.ethan.backend.entities.AppUser;


@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUser toAppUser(AppUserDto appUserDto);

    AppUserDto toGymRecordDto(AppUser gymRecord);

    List<AppUserDto> toAppUserDtos(List<AppUser> appUsers);

}