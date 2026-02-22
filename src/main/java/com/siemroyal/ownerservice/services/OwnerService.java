package com.siemroyal.ownerservice.services;

import com.siemroyal.ownerservice.models.Owner;
import com.siemroyal.ownerservice.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
    public Owner createOwner(String email, String phone, String status) {

        Owner owner = new Owner();
        owner.setEmail(email);
        owner.setPhone(phone);
        owner.setStatus(status);
        owner.setCreatedAt(OffsetDateTime.now());
        owner.setUpdatedAt(OffsetDateTime.now());

        return ownerRepository.save(owner);
    }
}
