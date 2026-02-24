package com.siemroyal.ownerservice.normalizer;

import com.siemroyal.ownerservice.dtos.OwnerRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerRegisterRequestNormalizer {
    private final EmailNormalizer emailNormalizer;
    private final PhoneNormalizer phoneNormalizer;

    public OwnerRegisterRequest normalize(OwnerRegisterRequest request) {

        request.setEmail(emailNormalizer.normalize(request.getEmail()));
        request.setPhone(phoneNormalizer.normalize(request.getPhone()));

        return request;
    }

    //@TODO don't mutate parameter (create new object)
}
