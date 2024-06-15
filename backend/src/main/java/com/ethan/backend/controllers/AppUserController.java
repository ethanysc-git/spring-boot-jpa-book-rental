package com.ethan.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethan.backend.dtos.AppUserDto;
import com.ethan.backend.services.AppUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping("/records")
    public ResponseEntity<List<AppUserDto>> allAppUserDtos() {
        return ResponseEntity.ok(appUserService.allAppUserDtos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDto> getAppUserDto(@PathVariable UUID id) {
        return ResponseEntity.ok(appUserService.getAppUserDto(id));
    }
}