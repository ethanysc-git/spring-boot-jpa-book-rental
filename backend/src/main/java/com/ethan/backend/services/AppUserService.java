package com.ethan.backend.services;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ethan.backend.dtos.AppUserDto;
import com.ethan.backend.entities.AppUser;
import com.ethan.backend.exceptions.AppException;
import com.ethan.backend.mappers.AppUserMapper;
import com.ethan.backend.repositories.AppUserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;

    public List<AppUserDto> allAppUserDtos() {
        return appUserMapper.toAppUserDtos(appUserRepository.findAll());
    }
    public AppUserDto getAppUserDto(UUID id) {
        AppUser record = appUserRepository.findById(id)
                .orElseThrow(() -> new AppException("App User record not found", HttpStatus.NOT_FOUND));
        return appUserMapper.toAppUserDto(record);
    }
}