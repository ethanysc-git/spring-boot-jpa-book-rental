package com.ethan.backend.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class InventoryDto {
    private UUID id;
    private UUID book_id;
    private UUID user_id;
    private LocalDateTime loan_date;
}

