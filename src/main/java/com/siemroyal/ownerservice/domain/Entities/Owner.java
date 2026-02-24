package com.siemroyal.ownerservice.domain.Entities;

import com.siemroyal.ownerservice.domain.enums.OwnerStatus;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("owners")
public class Owner {
    @Id
    private UUID id;
    private String email;
    private String phone;
    private OwnerStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
