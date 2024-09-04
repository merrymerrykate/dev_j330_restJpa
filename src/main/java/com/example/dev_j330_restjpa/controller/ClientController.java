package com.example.dev_j330_restjpa.controller;

import com.example.dev_j330_restjpa.entities.ClientEntity;
import com.example.dev_j330_restjpa.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

//    @GetMapping(produces = "application/json")
//    public Flux<ClientEntity> getAll(){
//        return Flux.fromIterable(clientService.getAll2());
//    }

    @GetMapping(produces = "application/json")
    public Flux<ClientEntity> getAllClients() {
        List<ClientEntity> clients = clientService.getAllWithFetchJoin();
        return Flux.fromIterable(clients);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Mono<ClientEntity> getClientById(@PathVariable Integer id) {
        return Mono.justOrEmpty(clientService.getClientById(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Mono<ClientEntity> createClient(@RequestBody ClientEntity client) {
        System.out.println("createClient");
        return Mono.justOrEmpty(clientService.createClient(client));
    }






}
