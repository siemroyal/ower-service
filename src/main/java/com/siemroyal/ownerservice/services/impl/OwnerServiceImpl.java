package com.siemroyal.ownerservice.services.impl;

import com.siemroyal.ownerservice.domain.Entities.Owner;
import com.siemroyal.ownerservice.dtos.OwnerResponse;
import com.siemroyal.ownerservice.dtos.OwnerRegisterRequest;
import com.siemroyal.ownerservice.factory.OwnerFactory;
import com.siemroyal.ownerservice.mappers.OwnerMapper;
import com.siemroyal.ownerservice.normalizer.OwnerRegisterRequestNormalizer;
import com.siemroyal.ownerservice.repositories.OwnerRepository;
import com.siemroyal.ownerservice.services.OwnerService;
import com.siemroyal.ownerservice.validation.OwnerRegistrationValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;
    private final OwnerFactory ownerFactory;
    private final OwnerRegistrationValidator registrationValidator;
    private final OwnerRegisterRequestNormalizer normalizer;

    @Override
    public Mono<OwnerResponse> register(OwnerRegisterRequest request) {
        //log.info("Owner registration requested");

        OwnerRegisterRequest normalized = normalizer.normalize(request);

        Owner draft = ownerMapper.toOwnerDraft(normalized);
        Owner pending = ownerFactory.newPendingOwner(draft);

        return registrationValidator.validate(normalized)
                .then(ownerRepository.save(pending))
                //.doOnSuccess(saved -> log.info("Owner registered successfully. ownerId={}", saved.getId()))
                .map(ownerMapper::toResponse);
    }
}
