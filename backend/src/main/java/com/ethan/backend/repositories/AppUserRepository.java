package com.ethan.backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethan.backend.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}
