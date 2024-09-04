package com.example.dev_j330_restjpa.controller;

import com.example.dev_j330_restjpa.entities.AddressEntity;
import com.example.dev_j330_restjpa.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Mono<AddressEntity> getAddressById(@PathVariable Integer id) {
        return Mono.justOrEmpty(addressService.getAddressById(id));
    }

    @GetMapping(produces = "application/json")
    public Flux<AddressEntity> getAllAddresses() {
        List<AddressEntity> addresses = addressService.getAllAddresses();
        return Flux.fromIterable(addresses);
    }
}
