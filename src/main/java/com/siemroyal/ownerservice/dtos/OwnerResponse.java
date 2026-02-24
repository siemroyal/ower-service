package com.siemroyal.ownerservice.dtos;

import com.siemroyal.ownerservice.domain.enums.OwnerStatus;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public class OwnerResponse {
    UUID id;
    String email;
    String phone;
    OwnerStatus status;
    Instant createdAt;
    Instant updatedAt;
}
