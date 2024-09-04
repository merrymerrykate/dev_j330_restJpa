package com.example.dev_j330_restjpa.entities;


import com.example.dev_j330_restjpa.util.ClientTypeConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="Client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientid")
    private int clientId;

    @Column(name = "client_name",nullable = false, length = 100)
    private String clientName;


    @Column(name = "type", nullable = false, length = 20)
    @Convert(converter = ClientTypeConverter.class)
    //@Enumerated(EnumType.STRING)
    private ClientType type;

    @Column(name = "added", nullable = false)
    private LocalDateTime added;

   // @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @JsonManagedReference

  // private Set<AddressEntity> addressEntities = new LinkedHashSet<>();
   private List<AddressEntity> addressEntities = new LinkedList<>();



}

