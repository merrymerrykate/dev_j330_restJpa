package com.example.dev_j330_restjpa.service;

import com.example.dev_j330_restjpa.entities.AddressEntity;
import com.example.dev_j330_restjpa.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public Optional<AddressEntity> getAddressById(Integer id) {
        return addressRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<AddressEntity> getAllAddresses() {
        return addressRepository.findAll();
    }
}