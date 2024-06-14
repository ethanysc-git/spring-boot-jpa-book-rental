package com.ethan.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethan.backend.entities.AppUser;

public interface AppUserRecordsRepository extends JpaRepository<AppUser, Long> {
}