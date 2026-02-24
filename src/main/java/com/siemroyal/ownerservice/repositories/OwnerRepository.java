package com.siemroyal.ownerservice.repositories;
import com.siemroyal.ownerservice.domain.Entities.Owner;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface OwnerRepository extends ReactiveCrudRepository<Owner, UUID> {
    Mono<Boolean> existsByEmail(String email);
    Mono<Boolean> existsByPhone(String phone);
}
