package com.siemroyal.ownerservice.controllers;

import com.siemroyal.ownerservice.dtos.OwnerRegisterRequest;
import com.siemroyal.ownerservice.dtos.OwnerResponse;
import com.siemroyal.ownerservice.services.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/owners")
public class OwnerController {
    private final OwnerService ownerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OwnerResponse> register(@Valid @RequestBody OwnerRegisterRequest request) {
        return ownerService.register(request);
    }
}
