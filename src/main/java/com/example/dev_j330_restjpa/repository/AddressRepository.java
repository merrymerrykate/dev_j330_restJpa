package com.example.dev_j330_restjpa.repository;

import com.example.dev_j330_restjpa.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    Optional<AddressEntity> findById(Integer id);

    List<AddressEntity> findAll();
}
