package com.siemroyal.ownerservice.services;

import com.siemroyal.ownerservice.dtos.OwnerResponse;
import com.siemroyal.ownerservice.dtos.OwnerRegisterRequest;
import reactor.core.publisher.Mono;

public interface OwnerService {
    Mono<OwnerResponse> register(OwnerRegisterRequest request);
}
