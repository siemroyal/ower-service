package com.siemroyal.ownerservice.controllers;

import com.siemroyal.ownerservice.models.Owner;
import com.siemroyal.ownerservice.services.OwnerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public Owner createOwner(@RequestParam String email,
                             @RequestParam String phone,
                             @RequestParam String status) {
        return ownerService.createOwner(email, phone, status);
    }
}
