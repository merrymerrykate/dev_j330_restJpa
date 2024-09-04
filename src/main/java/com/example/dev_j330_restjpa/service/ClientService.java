package com.example.dev_j330_restjpa.service;

import com.example.dev_j330_restjpa.entities.ClientEntity;
import com.example.dev_j330_restjpa.repository.AddressRepository;
import com.example.dev_j330_restjpa.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public List<ClientEntity> getAll(){
        List<ClientEntity> clients = clientRepository.findAll();
         clients.forEach(client -> {
             if(client.getAddressEntities() != null && !client.getAddressEntities().isEmpty()){
                 client.getAddressEntities().forEach(Hibernate::initialize);
             }
         });

         return clients;
    }

//    @Transactional(readOnly = true)
//    public List<ClientEntity> getAll2(){
//        return clientRepository.findAll2();
//    }
//
    @Transactional(readOnly = true)
    public List<ClientEntity> getAllWithFetchJoin() {
        return clientRepository.findAllWithAddresses();
    }

    @Transactional(readOnly = true)
    public Optional<ClientEntity> getClientById(Integer id) {
        return clientRepository.findByIdWithAddresses(id);
    }

    @Transactional
    public Optional<ClientEntity> createClient(ClientEntity client) {
        ClientEntity temp = clientRepository.save(client);
        if(client.getAddressEntities()!=null && temp!=null) {
            client.getAddressEntities().forEach(addr -> addr.setClient(temp));
            addressRepository.saveAll(client.getAddressEntities());
        }
        return findById(temp.getClientId());
    }

    @Transactional(readOnly = true)
    public Optional<ClientEntity> findById(Integer id){
        return clientRepository.findById(id).map(e -> {
            if(e.getAddressEntities() != null){
                e.getAddressEntities().forEach(Hibernate::initialize);
            }
            return e;
        });
    }



}
