package com.siemroyal.ownerservice.mappers;

import com.siemroyal.ownerservice.domain.Entities.Owner;
import com.siemroyal.ownerservice.dtos.OwnerRegisterRequest;
import com.siemroyal.ownerservice.dtos.OwnerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Owner toOwnerDraft(OwnerRegisterRequest request);

    OwnerResponse toResponse(Owner owner);

}

