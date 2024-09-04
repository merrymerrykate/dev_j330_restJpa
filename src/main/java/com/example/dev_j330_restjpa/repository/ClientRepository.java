package com.example.dev_j330_restjpa.repository;

import com.example.dev_j330_restjpa.entities.ClientEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

//    @Query("select p from ClientEntity p left join fetch p.addressEntities")
//    List<ClientEntity> findAll2();
//
    @Query("select p from ClientEntity p left join fetch p.addressEntities")
    List<ClientEntity> findAllWithAddresses();

    @Query("select c from ClientEntity c left join fetch c.addressEntities where c.clientId = :id")
    Optional<ClientEntity> findByIdWithAddresses(Integer id);



}
