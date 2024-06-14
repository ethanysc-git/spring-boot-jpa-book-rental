package com.ethan.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ethan.backend.dtos.AppUserDto;
import com.ethan.backend.mappers.AppUserMapper;
import com.ethan.backend.repositories.AppUserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;

    public List<AppUserDto> allAppUserDtos() {
        return appUserMapper.toAppUserDtos(appUserRepository.findAll());
    }

}